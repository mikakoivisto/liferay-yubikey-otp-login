package fi.jguru.yubico.client.internal;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.yubico.client.v2.YubicoClient;

import fi.jguru.yubico.client.configuration.YubicoClientConfiguration;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Mika Koivisto
 *
 */
@Component(
		configurationPid = "fi.jguru.yubico.client.configuration.YubicoClientConfiguration",
		configurationPolicy = ConfigurationPolicy.REQUIRE,
		immediate = true)
public class YubicoClientRegistrator {

	@Activate
	@Modified
	public void activate(BundleContext bundleContext, Map<String, Object> properties) {
		YubicoClientConfiguration configuration = ConfigurableUtil.createConfigurable(
				YubicoClientConfiguration.class, properties);

		YubicoClient client = YubicoClient.getClient(configuration.clientId(), configuration.key());

		if (configuration.wsapiUrls() != null && configuration.wsapiUrls().length > 0 && Validator.isNotNull(configuration.wsapiUrls()[0])) {
			client.setWsapiUrls(configuration.wsapiUrls());
		}

		_yubicoClientServiceRegistration = bundleContext.registerService(YubicoClient.class.getName(), client, null);

		if (_log.isDebugEnabled()) {
			_log.debug("Registered YubicoClient with clientId: " + client.getClientId());
		}
	}

	@Deactivate
	public void deactivate(BundleContext bundleContext) {
		if (_log.isDebugEnabled()) {
			_log.debug("Unregistering YubicoClient");
		}
		_yubicoClientServiceRegistration.unregister();
	}

	private static final Log _log = LogFactoryUtil.getLog(YubicoClientRegistrator.class);

	private volatile ServiceRegistration<?> _yubicoClientServiceRegistration;
	
}
