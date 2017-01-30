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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mika Koivisto
 * @generated
 */
@ProviderType
public class YubikeyOTPKeyEntrySoap implements Serializable {
	public static YubikeyOTPKeyEntrySoap toSoapModel(YubikeyOTPKeyEntry model) {
		YubikeyOTPKeyEntrySoap soapModel = new YubikeyOTPKeyEntrySoap();

		soapModel.setKeyId(model.getKeyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPublicId(model.getPublicId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static YubikeyOTPKeyEntrySoap[] toSoapModels(
		YubikeyOTPKeyEntry[] models) {
		YubikeyOTPKeyEntrySoap[] soapModels = new YubikeyOTPKeyEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YubikeyOTPKeyEntrySoap[][] toSoapModels(
		YubikeyOTPKeyEntry[][] models) {
		YubikeyOTPKeyEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YubikeyOTPKeyEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new YubikeyOTPKeyEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YubikeyOTPKeyEntrySoap[] toSoapModels(
		List<YubikeyOTPKeyEntry> models) {
		List<YubikeyOTPKeyEntrySoap> soapModels = new ArrayList<YubikeyOTPKeyEntrySoap>(models.size());

		for (YubikeyOTPKeyEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YubikeyOTPKeyEntrySoap[soapModels.size()]);
	}

	public YubikeyOTPKeyEntrySoap() {
	}

	public long getPrimaryKey() {
		return _keyId;
	}

	public void setPrimaryKey(long pk) {
		setKeyId(pk);
	}

	public long getKeyId() {
		return _keyId;
	}

	public void setKeyId(long keyId) {
		_keyId = keyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getPublicId() {
		return _publicId;
	}

	public void setPublicId(String publicId) {
		_publicId = publicId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _keyId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _publicId;
	private String _name;
}