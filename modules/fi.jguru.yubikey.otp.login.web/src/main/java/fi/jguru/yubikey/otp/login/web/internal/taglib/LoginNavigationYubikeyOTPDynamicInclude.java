package fi.jguru.yubikey.otp.login.web.internal.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fi.jguru.yubikey.otp.login.web.configuration.YubikeyAuthenticationConfigurationHelper;

@Component(immediate = true, service = DynamicInclude.class)
public class LoginNavigationYubikeyOTPDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		String mvcRenderCommandName = ParamUtil.getString(
			request, "mvcRenderCommandName");

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (mvcRenderCommandName.equals("/login/yubikey_otp") ||
			!_configurationHelper.isEnabled(themeDisplay.getCompanyId())) {

			return;
		}

		RequestDispatcher requestDispatcher =
				_servletContext.getRequestDispatcher(_JSP_PATH);

		try {
			requestDispatcher.include(request, response);
		}
		catch (ServletException se) {
			_log.error("Unable to include JSP " + _JSP_PATH, se);

			throw new IOException("Unable to include JSP " + _JSP_PATH, se);
		}
	}

	@Override
	public void register(
		DynamicInclude.DynamicIncludeRegistry dynamicIncludeRegistry) {

		dynamicIncludeRegistry.register(
			"com.liferay.login.web#/navigation.jsp#pre");
	}

	@Reference(
		target = "(osgi.web.symbolicname=fi.jguru.yubikey.otp.login.web)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static final String _JSP_PATH =
		"/com.liferay.login.web/navigation/yubikey_otp.jsp";

	private static final Log _log = LogFactoryUtil.getLog(
		LoginNavigationYubikeyOTPDynamicInclude.class);

	private ServletContext _servletContext;

	@Reference
	private volatile YubikeyAuthenticationConfigurationHelper _configurationHelper;

}
