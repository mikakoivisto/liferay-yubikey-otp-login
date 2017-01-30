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

package fi.jguru.yubikey.otp.login.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the YubikeyOTPKeyEntry service. Represents a row in the &quot;JGURU_YubikeyOTPKeyEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mika Koivisto
 * @see YubikeyOTPKeyEntryModel
 * @see fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryImpl
 * @see fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryModelImpl
 * @generated
 */
@ImplementationClassName("fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryImpl")
@ProviderType
public interface YubikeyOTPKeyEntry extends YubikeyOTPKeyEntryModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<YubikeyOTPKeyEntry, Long> KEY_ID_ACCESSOR = new Accessor<YubikeyOTPKeyEntry, Long>() {
			@Override
			public Long get(YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
				return yubikeyOTPKeyEntry.getKeyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<YubikeyOTPKeyEntry> getTypeClass() {
				return YubikeyOTPKeyEntry.class;
			}
		};
}