package fi.jguru.yubikey.otp.login.web.internal.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseJSPDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {"portal.settings.authentication.tabs.name=Yubikey"},
		service = DynamicInclude.class
	)
public class PortalSettingsYubikeyAuthenticationDynamicInclude extends BaseJSPDynamicInclude {

	@Override
	protected String getJspPath() {
		return "/com.liferay.portal.settings.web/yubikey.jsp";
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=fi.jguru.yubikey.otp.login.web)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PortalSettingsYubikeyAuthenticationDynamicInclude.class);
}
