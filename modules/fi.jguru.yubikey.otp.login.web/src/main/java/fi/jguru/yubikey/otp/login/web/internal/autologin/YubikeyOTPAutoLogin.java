package fi.jguru.yubikey.otp.login.web.internal.autologin;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fi.jguru.yubikey.otp.login.web.configuration.YubikeyAuthenticationConfigurationHelper;
import fi.jguru.yubikey.otp.login.web.constants.WebKeys;

@Component(immediate = true, service = AutoLogin.class)
public class YubikeyOTPAutoLogin extends BaseAutoLogin {

	@Override
	protected String[] doLogin(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);

		if (!_configurationHelper.isEnabled(companyId)) {
			return null;
		}

		HttpSession session = request.getSession();

		Long userId = (Long)session.getAttribute(WebKeys.YUBIKEY_LOGIN_USERID);

		if (userId == null) {
			return null;
		}

		session.removeAttribute(WebKeys.YUBIKEY_LOGIN_USERID);

		User user = _userLocalService.getUserById(userId);

		String[] credentials = new String[3];

		credentials[0] = String.valueOf(user.getUserId());
		credentials[1] = user.getPassword();
		credentials[2] = Boolean.TRUE.toString();

		return credentials;
	}

	@Reference
	private volatile UserLocalService _userLocalService;

	@Reference
	private volatile YubikeyAuthenticationConfigurationHelper _configurationHelper;
}
