package fi.jguru.yubikey.otp.login.web.portlet.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.settings.portlet.action.BasePortalSettingsFormMVCActionCommand;
import com.liferay.portal.settings.web.constants.PortalSettingsPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import fi.jguru.yubikey.otp.login.web.constants.YubikeyConstants;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + PortalSettingsPortletKeys.PORTAL_SETTINGS,
			"mvc.command.name=/portal_settings/yubikey"
		},
		service = MVCActionCommand.class
	)
public class PortalSettingsYubikeyFormMVCActionCommand extends BasePortalSettingsFormMVCActionCommand {

	@Override
	protected void doValidateForm(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	}

	@Override
	protected String getParameterNamespace() {
		return "yubikey--";
	}

	@Override
	protected String getSettingsId() {
		return YubikeyConstants.SERVICE_NAME;
	}

}
