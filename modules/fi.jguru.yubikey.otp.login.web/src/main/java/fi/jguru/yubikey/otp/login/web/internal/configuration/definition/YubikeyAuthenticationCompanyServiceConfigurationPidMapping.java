package fi.jguru.yubikey.otp.login.web.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

import fi.jguru.yubikey.otp.login.web.configuration.YubikeyAuthenticationConfiguration;
import fi.jguru.yubikey.otp.login.web.constants.YubikeyConstants;

@Component
public class YubikeyAuthenticationCompanyServiceConfigurationPidMapping implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return YubikeyAuthenticationConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return YubikeyConstants.SERVICE_NAME;
	}

}
