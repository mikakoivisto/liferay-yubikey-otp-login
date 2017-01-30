package fi.jguru.yubikey.otp.login.web.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "foundation")
@Meta.OCD(
	id = "fi.jguru.yubikey.otp.login.configuration.YubikeyAuthenticationConfiguration",
	localization = "content/Language", name = "yubikey-authentication"
)
public interface YubikeyAuthenticationConfiguration {
	
	@Meta.AD(
		deflt = "false",
		description = "Set this to true to enable Yubikey authentication.",
		required = false
	)
	public boolean enabled();
}
