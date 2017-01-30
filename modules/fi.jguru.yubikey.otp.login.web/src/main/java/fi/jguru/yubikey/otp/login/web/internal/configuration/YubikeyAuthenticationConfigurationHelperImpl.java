package fi.jguru.yubikey.otp.login.web.internal.configuration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fi.jguru.yubikey.otp.login.web.configuration.YubikeyAuthenticationConfiguration;
import fi.jguru.yubikey.otp.login.web.configuration.YubikeyAuthenticationConfigurationHelper;
import fi.jguru.yubikey.otp.login.web.constants.YubikeyConstants;

@Component
public class YubikeyAuthenticationConfigurationHelperImpl implements YubikeyAuthenticationConfigurationHelper {

	@Override
	public boolean isEnabled(long companyId) {
		try {
			YubikeyAuthenticationConfiguration configuration =
				_configurationProvider.getConfiguration(
					YubikeyAuthenticationConfiguration.class,
					new CompanyServiceSettingsLocator(
						companyId, YubikeyConstants.SERVICE_NAME));

			return configuration.enabled();
		}
		catch (ConfigurationException ce) {
			_log.error("Unable to get Yubikey authentication configuration", ce);
		}

		return false;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		YubikeyAuthenticationConfigurationHelperImpl.class);

	@Reference
	private ConfigurationProvider _configurationProvider;

}
