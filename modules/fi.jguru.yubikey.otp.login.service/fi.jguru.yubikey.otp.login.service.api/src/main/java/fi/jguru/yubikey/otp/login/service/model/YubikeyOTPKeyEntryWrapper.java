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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link YubikeyOTPKeyEntry}.
 * </p>
 *
 * @author Mika Koivisto
 * @see YubikeyOTPKeyEntry
 * @generated
 */
@ProviderType
public class YubikeyOTPKeyEntryWrapper implements YubikeyOTPKeyEntry,
	ModelWrapper<YubikeyOTPKeyEntry> {
	public YubikeyOTPKeyEntryWrapper(YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		_yubikeyOTPKeyEntry = yubikeyOTPKeyEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return YubikeyOTPKeyEntry.class;
	}

	@Override
	public String getModelClassName() {
		return YubikeyOTPKeyEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("keyId", getKeyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publicId", getPublicId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long keyId = (Long)attributes.get("keyId");

		if (keyId != null) {
			setKeyId(keyId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String publicId = (String)attributes.get("publicId");

		if (publicId != null) {
			setPublicId(publicId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _yubikeyOTPKeyEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _yubikeyOTPKeyEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _yubikeyOTPKeyEntry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _yubikeyOTPKeyEntry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry> toCacheModel() {
		return _yubikeyOTPKeyEntry.toCacheModel();
	}

	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry toEscapedModel() {
		return new YubikeyOTPKeyEntryWrapper(_yubikeyOTPKeyEntry.toEscapedModel());
	}

	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry toUnescapedModel() {
		return new YubikeyOTPKeyEntryWrapper(_yubikeyOTPKeyEntry.toUnescapedModel());
	}

	@Override
	public int compareTo(
		fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		return _yubikeyOTPKeyEntry.compareTo(yubikeyOTPKeyEntry);
	}

	@Override
	public int hashCode() {
		return _yubikeyOTPKeyEntry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _yubikeyOTPKeyEntry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new YubikeyOTPKeyEntryWrapper((YubikeyOTPKeyEntry)_yubikeyOTPKeyEntry.clone());
	}

	/**
	* Returns the name of this yubikey o t p key entry.
	*
	* @return the name of this yubikey o t p key entry
	*/
	@Override
	public java.lang.String getName() {
		return _yubikeyOTPKeyEntry.getName();
	}

	/**
	* Returns the public ID of this yubikey o t p key entry.
	*
	* @return the public ID of this yubikey o t p key entry
	*/
	@Override
	public java.lang.String getPublicId() {
		return _yubikeyOTPKeyEntry.getPublicId();
	}

	/**
	* Returns the user name of this yubikey o t p key entry.
	*
	* @return the user name of this yubikey o t p key entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _yubikeyOTPKeyEntry.getUserName();
	}

	/**
	* Returns the user uuid of this yubikey o t p key entry.
	*
	* @return the user uuid of this yubikey o t p key entry
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _yubikeyOTPKeyEntry.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _yubikeyOTPKeyEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _yubikeyOTPKeyEntry.toXmlString();
	}

	/**
	* Returns the create date of this yubikey o t p key entry.
	*
	* @return the create date of this yubikey o t p key entry
	*/
	@Override
	public Date getCreateDate() {
		return _yubikeyOTPKeyEntry.getCreateDate();
	}

	/**
	* Returns the modified date of this yubikey o t p key entry.
	*
	* @return the modified date of this yubikey o t p key entry
	*/
	@Override
	public Date getModifiedDate() {
		return _yubikeyOTPKeyEntry.getModifiedDate();
	}

	/**
	* Returns the company ID of this yubikey o t p key entry.
	*
	* @return the company ID of this yubikey o t p key entry
	*/
	@Override
	public long getCompanyId() {
		return _yubikeyOTPKeyEntry.getCompanyId();
	}

	/**
	* Returns the key ID of this yubikey o t p key entry.
	*
	* @return the key ID of this yubikey o t p key entry
	*/
	@Override
	public long getKeyId() {
		return _yubikeyOTPKeyEntry.getKeyId();
	}

	/**
	* Returns the primary key of this yubikey o t p key entry.
	*
	* @return the primary key of this yubikey o t p key entry
	*/
	@Override
	public long getPrimaryKey() {
		return _yubikeyOTPKeyEntry.getPrimaryKey();
	}

	/**
	* Returns the user ID of this yubikey o t p key entry.
	*
	* @return the user ID of this yubikey o t p key entry
	*/
	@Override
	public long getUserId() {
		return _yubikeyOTPKeyEntry.getUserId();
	}

	@Override
	public void persist() {
		_yubikeyOTPKeyEntry.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_yubikeyOTPKeyEntry.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this yubikey o t p key entry.
	*
	* @param companyId the company ID of this yubikey o t p key entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_yubikeyOTPKeyEntry.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this yubikey o t p key entry.
	*
	* @param createDate the create date of this yubikey o t p key entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_yubikeyOTPKeyEntry.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_yubikeyOTPKeyEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_yubikeyOTPKeyEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_yubikeyOTPKeyEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the key ID of this yubikey o t p key entry.
	*
	* @param keyId the key ID of this yubikey o t p key entry
	*/
	@Override
	public void setKeyId(long keyId) {
		_yubikeyOTPKeyEntry.setKeyId(keyId);
	}

	/**
	* Sets the modified date of this yubikey o t p key entry.
	*
	* @param modifiedDate the modified date of this yubikey o t p key entry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_yubikeyOTPKeyEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this yubikey o t p key entry.
	*
	* @param name the name of this yubikey o t p key entry
	*/
	@Override
	public void setName(java.lang.String name) {
		_yubikeyOTPKeyEntry.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_yubikeyOTPKeyEntry.setNew(n);
	}

	/**
	* Sets the primary key of this yubikey o t p key entry.
	*
	* @param primaryKey the primary key of this yubikey o t p key entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_yubikeyOTPKeyEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_yubikeyOTPKeyEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the public ID of this yubikey o t p key entry.
	*
	* @param publicId the public ID of this yubikey o t p key entry
	*/
	@Override
	public void setPublicId(java.lang.String publicId) {
		_yubikeyOTPKeyEntry.setPublicId(publicId);
	}

	/**
	* Sets the user ID of this yubikey o t p key entry.
	*
	* @param userId the user ID of this yubikey o t p key entry
	*/
	@Override
	public void setUserId(long userId) {
		_yubikeyOTPKeyEntry.setUserId(userId);
	}

	/**
	* Sets the user name of this yubikey o t p key entry.
	*
	* @param userName the user name of this yubikey o t p key entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_yubikeyOTPKeyEntry.setUserName(userName);
	}

	/**
	* Sets the user uuid of this yubikey o t p key entry.
	*
	* @param userUuid the user uuid of this yubikey o t p key entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_yubikeyOTPKeyEntry.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof YubikeyOTPKeyEntryWrapper)) {
			return false;
		}

		YubikeyOTPKeyEntryWrapper yubikeyOTPKeyEntryWrapper = (YubikeyOTPKeyEntryWrapper)obj;

		if (Objects.equals(_yubikeyOTPKeyEntry,
					yubikeyOTPKeyEntryWrapper._yubikeyOTPKeyEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public YubikeyOTPKeyEntry getWrappedModel() {
		return _yubikeyOTPKeyEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _yubikeyOTPKeyEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _yubikeyOTPKeyEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_yubikeyOTPKeyEntry.resetOriginalValues();
	}

	private final YubikeyOTPKeyEntry _yubikeyOTPKeyEntry;
}