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

package fi.jguru.yubikey.otp.login.service.service.impl;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import fi.jguru.yubikey.otp.login.service.exception.DuplicateYubikeyOTPKeyEntryException;
import fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry;
import fi.jguru.yubikey.otp.login.service.service.base.YubikeyOTPKeyEntryLocalServiceBaseImpl;

/**
 * The implementation of the yubikey o t p key entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.jguru.yubikey.otp.login.service.service.YubikeyOTPKeyEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mika Koivisto
 * @see YubikeyOTPKeyEntryLocalServiceBaseImpl
 * @see fi.jguru.yubikey.otp.login.service.service.YubikeyOTPKeyEntryLocalServiceUtil
 */
@ProviderType
public class YubikeyOTPKeyEntryLocalServiceImpl
	extends YubikeyOTPKeyEntryLocalServiceBaseImpl {

	public YubikeyOTPKeyEntry addYubikeyOTPKeyEntry(
			long companyId, long userId, String publicId, String name)
		throws PortalException {

		if (yubikeyOTPKeyEntryPersistence.fetchByPublicId(publicId) != null) {
			throw new DuplicateYubikeyOTPKeyEntryException();
		}

		long keyId = counterLocalService.increment(YubikeyOTPKeyEntry.class.getName());

		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = yubikeyOTPKeyEntryPersistence.create(keyId);
		
		Date now = new Date();

		yubikeyOTPKeyEntry.setCompanyId(companyId);
		yubikeyOTPKeyEntry.setUserId(userId);
		yubikeyOTPKeyEntry.setCreateDate(now);
		yubikeyOTPKeyEntry.setModifiedDate(now);
		yubikeyOTPKeyEntry.setName(name);
		yubikeyOTPKeyEntry.setPublicId(publicId);

		yubikeyOTPKeyEntryPersistence.update(yubikeyOTPKeyEntry);

		return yubikeyOTPKeyEntry;
	}

	public YubikeyOTPKeyEntry fetchYubikeyOTPKeyEntry(String publicId) {
		return yubikeyOTPKeyEntryPersistence.fetchByPublicId(publicId);
	}

	public List<YubikeyOTPKeyEntry> findByUserId(long userId) {
		return yubikeyOTPKeyEntryPersistence.findByUserId(userId);
	}
}