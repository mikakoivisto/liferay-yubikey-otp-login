package fi.jguru.yubikey.otp.login.web.portlet.command;

import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.Validator;

import com.yubico.client.v2.VerificationResponse;
import com.yubico.client.v2.YubicoClient;
import com.yubico.client.v2.exceptions.YubicoVerificationException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry;
import fi.jguru.yubikey.otp.login.service.service.YubikeyOTPKeyEntryLocalService;
import fi.jguru.yubikey.otp.login.web.configuration.YubikeyAuthenticationConfiguration;
import fi.jguru.yubikey.otp.login.web.configuration.YubikeyAuthenticationConfigurationHelper;
import fi.jguru.yubikey.otp.login.web.constants.WebKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.FAST_LOGIN,
		"javax.portlet.name=" + PortletKeys.LOGIN,
		"mvc.command.name=/login/yubikey_otp"
	},
	service = MVCActionCommand.class

)
public class YubikeyOTPLoginMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

		if (!_configurationHelper.isEnabled(themeDisplay.getCompanyId())) {
			throw new PrincipalException.MustBeEnabled(
				themeDisplay.getCompanyId(), YubikeyAuthenticationConfiguration.class.getName());
		}

		if (actionRequest.getRemoteUser() != null) {
			actionResponse.sendRedirect(themeDisplay.getPathMain());

			return;
		}
		HttpServletRequest request = PortalUtil.getHttpServletRequest(
				actionRequest);

		request = PortalUtil.getOriginalServletRequest(request);

		String otp = ParamUtil.getString(actionRequest, "otp");

		try {
			VerificationResponse response = _yubicoClient.verify(otp);

			if (!response.isOk()) {
				SessionErrors.add(actionRequest, YubicoVerificationException.class);

				return;
			}

			String publicId = response.getPublicId();

			YubikeyOTPKeyEntry yubikeyOTPKeyEntry = _yubikeyOTPKeyEntryLocalService.fetchYubikeyOTPKeyEntry(publicId);

			User user = null;
	
			if (yubikeyOTPKeyEntry != null) {
				user = _userLocalService.fetchUser(yubikeyOTPKeyEntry.getUserId());
			}

			if (user == null || !user.isActive()) {
				SessionErrors.add(actionRequest, AuthException.class);

				return;
			}

			HttpSession session = request.getSession();

			session.setAttribute(WebKeys.YUBIKEY_LOGIN_USERID, user.getUserId());

			String redirect = ParamUtil.getString(actionRequest, "redirect");

			if (Validator.isNull(redirect)) {
				redirect = themeDisplay.getPathMain();
			}

			redirect = PortalUtil.escapeRedirect(redirect);

			actionResponse.sendRedirect(redirect);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Yubikey login failed", e);
			}

			SessionErrors.add(actionRequest, e.getClass());

			actionResponse.setRenderParameter("mvcRenderCommandName", "/login/yubikey_otp");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
			YubikeyOTPLoginMVCActionCommand.class);


	@Reference
	private volatile UserLocalService _userLocalService;

	@Reference
	private volatile YubicoClient _yubicoClient;

	@Reference
	private volatile YubikeyOTPKeyEntryLocalService _yubikeyOTPKeyEntryLocalService;

	@Reference
	private volatile YubikeyAuthenticationConfigurationHelper _configurationHelper;

}
