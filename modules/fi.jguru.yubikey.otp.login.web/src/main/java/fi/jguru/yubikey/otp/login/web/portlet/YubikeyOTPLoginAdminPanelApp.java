package fi.jguru.yubikey.otp.login.web.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"panel.category.key=" + PanelCategoryKeys.USER_MY_ACCOUNT,
				"service.ranking:Integer=100"
		},
		service = PanelApp.class
)
public class YubikeyOTPLoginAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return "fi_jguru_yubikey_otp_login_web_portlet_YubikeyOTPLoginAdminPortlet";
	}

	@Override
	@Reference(
			target = "(javax.portlet.name=fi_jguru_yubikey_otp_login_web_portlet_YubikeyOTPLoginAdminPortlet)",
			unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
