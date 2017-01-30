package fi.jguru.yubikey.otp.login.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.yubico.client.v2.VerificationResponse;
import com.yubico.client.v2.YubicoClient;
import com.yubico.client.v2.exceptions.YubicoVerificationException;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry;
import fi.jguru.yubikey.otp.login.service.service.YubikeyOTPKeyEntryLocalService;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=portlet-controlpanel",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Yubikey",
		"javax.portlet.icon=/icon.png",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/my_account/view.jsp",
		"javax.portlet.name=fi_jguru_yubikey_otp_login_web_portlet_YubikeyOTPLoginAdminPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=user"
	},
	service = Portlet.class
)
public class YubikeyOTPLoginAdminPortlet extends MVCPortlet {

	public void addKey(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		try {
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(actionRequest);

			String otp = ParamUtil.getString(actionRequest, "otp");
			String name = ParamUtil.getString(actionRequest, "name");

			VerificationResponse response = _yubicoClient.verify(otp);

			if (!response.isOk()) {
				actionResponse.setRenderParameter("mvcPath", "/my_account/add.jsp");

				SessionErrors.add(actionRequest, YubicoVerificationException.class);

				return;
			}

			String publicId = response.getPublicId();

			_yubikeyOTPKeyEntryLocalService.addYubikeyOTPKeyEntry(
					serviceContext.getCompanyId(), serviceContext.getUserId(), publicId, name);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/my_account/add.jsp");
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	public void deleteKey(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		long keyId = ParamUtil.getLong(actionRequest, "keyId");

		try {
			YubikeyOTPKeyEntry yubikeyOTPKeyEntry = _yubikeyOTPKeyEntryLocalService.getYubikeyOTPKeyEntry(keyId);

			if (yubikeyOTPKeyEntry.getUserId() == themeDisplay.getUserId()) {
				_yubikeyOTPKeyEntryLocalService.deleteYubikeyOTPKeyEntry(yubikeyOTPKeyEntry);
			}

			String redirect = ParamUtil.getString(actionRequest, "redirect");

			redirect = PortalUtil.escapeRedirect(redirect);

			actionResponse.sendRedirect(redirect);
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

	}

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		List<YubikeyOTPKeyEntry> keyEntries = _yubikeyOTPKeyEntryLocalService.findByUserId(themeDisplay.getUserId());

		renderRequest.setAttribute("keyEntries", keyEntries);

		super.doView(renderRequest, renderResponse);
	}	

	@Reference
	private volatile YubicoClient _yubicoClient;

	@Reference
	private volatile YubikeyOTPKeyEntryLocalService _yubikeyOTPKeyEntryLocalService;
}