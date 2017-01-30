/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package fi.jguru.yubikey.otp.login.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry;
import fi.jguru.yubikey.otp.login.service.service.YubikeyOTPKeyEntryLocalServiceUtil;

/**
 * The extended model base implementation for the YubikeyOTPKeyEntry service. Represents a row in the &quot;JGURU_YubikeyOTPKeyEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link YubikeyOTPKeyEntryImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see YubikeyOTPKeyEntryImpl
 * @see YubikeyOTPKeyEntry
 * @generated
 */
@ProviderType
public abstract class YubikeyOTPKeyEntryBaseImpl
	extends YubikeyOTPKeyEntryModelImpl implements YubikeyOTPKeyEntry {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a yubikey o t p key entry model instance should use the {@link YubikeyOTPKeyEntry} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			YubikeyOTPKeyEntryLocalServiceUtil.addYubikeyOTPKeyEntry(this);
		}
		else {
			YubikeyOTPKeyEntryLocalServiceUtil.updateYubikeyOTPKeyEntry(this);
		}
	}
}