package fi.jguru.yubico.client.configuration;

import aQute.bnd.annotation.metatype.Meta;
//import org.osgi.service.metatype.annotations.AttributeDefinition;
//import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Meta.OCD(localization = "content/Language", name = "yubico.client")
public interface YubicoClientConfiguration {

	@Meta.AD()
	public int clientId();

	@Meta.AD()
	public String key();

	@Meta.AD(required = false)
	public String[] wsapiUrls();
}
