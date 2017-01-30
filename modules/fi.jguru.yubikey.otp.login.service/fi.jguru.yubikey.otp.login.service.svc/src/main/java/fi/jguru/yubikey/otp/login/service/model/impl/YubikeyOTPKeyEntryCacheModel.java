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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing YubikeyOTPKeyEntry in entity cache.
 *
 * @author Mika Koivisto
 * @see YubikeyOTPKeyEntry
 * @generated
 */
@ProviderType
public class YubikeyOTPKeyEntryCacheModel implements CacheModel<YubikeyOTPKeyEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof YubikeyOTPKeyEntryCacheModel)) {
			return false;
		}

		YubikeyOTPKeyEntryCacheModel yubikeyOTPKeyEntryCacheModel = (YubikeyOTPKeyEntryCacheModel)obj;

		if (keyId == yubikeyOTPKeyEntryCacheModel.keyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, keyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{keyId=");
		sb.append(keyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", publicId=");
		sb.append(publicId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public YubikeyOTPKeyEntry toEntityModel() {
		YubikeyOTPKeyEntryImpl yubikeyOTPKeyEntryImpl = new YubikeyOTPKeyEntryImpl();

		yubikeyOTPKeyEntryImpl.setKeyId(keyId);
		yubikeyOTPKeyEntryImpl.setCompanyId(companyId);
		yubikeyOTPKeyEntryImpl.setUserId(userId);

		if (userName == null) {
			yubikeyOTPKeyEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			yubikeyOTPKeyEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			yubikeyOTPKeyEntryImpl.setCreateDate(null);
		}
		else {
			yubikeyOTPKeyEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			yubikeyOTPKeyEntryImpl.setModifiedDate(null);
		}
		else {
			yubikeyOTPKeyEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (publicId == null) {
			yubikeyOTPKeyEntryImpl.setPublicId(StringPool.BLANK);
		}
		else {
			yubikeyOTPKeyEntryImpl.setPublicId(publicId);
		}

		if (name == null) {
			yubikeyOTPKeyEntryImpl.setName(StringPool.BLANK);
		}
		else {
			yubikeyOTPKeyEntryImpl.setName(name);
		}

		yubikeyOTPKeyEntryImpl.resetOriginalValues();

		return yubikeyOTPKeyEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		keyId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		publicId = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(keyId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (publicId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publicId);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long keyId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String publicId;
	public String name;
}