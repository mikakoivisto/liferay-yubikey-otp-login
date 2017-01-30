package fi.jguru.yubikey.otp.login.web.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

import fi.jguru.yubikey.otp.login.web.configuration.YubikeyAuthenticationConfiguration;

@Component
public class YubikeyAuthenticationCompanyServiceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return YubikeyAuthenticationConfiguration.class;
	}

}
