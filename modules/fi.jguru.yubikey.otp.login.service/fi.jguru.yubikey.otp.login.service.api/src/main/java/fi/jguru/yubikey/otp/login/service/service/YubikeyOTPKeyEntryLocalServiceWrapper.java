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

package fi.jguru.yubikey.otp.login.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link YubikeyOTPKeyEntryLocalService}.
 *
 * @author Mika Koivisto
 * @see YubikeyOTPKeyEntryLocalService
 * @generated
 */
@ProviderType
public class YubikeyOTPKeyEntryLocalServiceWrapper
	implements YubikeyOTPKeyEntryLocalService,
		ServiceWrapper<YubikeyOTPKeyEntryLocalService> {
	public YubikeyOTPKeyEntryLocalServiceWrapper(
		YubikeyOTPKeyEntryLocalService yubikeyOTPKeyEntryLocalService) {
		_yubikeyOTPKeyEntryLocalService = yubikeyOTPKeyEntryLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _yubikeyOTPKeyEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _yubikeyOTPKeyEntryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _yubikeyOTPKeyEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _yubikeyOTPKeyEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _yubikeyOTPKeyEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the yubikey o t p key entry to the database. Also notifies the appropriate model listeners.
	*
	* @param yubikeyOTPKeyEntry the yubikey o t p key entry
	* @return the yubikey o t p key entry that was added
	*/
	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry addYubikeyOTPKeyEntry(
		fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		return _yubikeyOTPKeyEntryLocalService.addYubikeyOTPKeyEntry(yubikeyOTPKeyEntry);
	}

	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry addYubikeyOTPKeyEntry(
		long companyId, long userId, java.lang.String publicId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _yubikeyOTPKeyEntryLocalService.addYubikeyOTPKeyEntry(companyId,
			userId, publicId, name);
	}

	/**
	* Creates a new yubikey o t p key entry with the primary key. Does not add the yubikey o t p key entry to the database.
	*
	* @param keyId the primary key for the new yubikey o t p key entry
	* @return the new yubikey o t p key entry
	*/
	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry createYubikeyOTPKeyEntry(
		long keyId) {
		return _yubikeyOTPKeyEntryLocalService.createYubikeyOTPKeyEntry(keyId);
	}

	/**
	* Deletes the yubikey o t p key entry from the database. Also notifies the appropriate model listeners.
	*
	* @param yubikeyOTPKeyEntry the yubikey o t p key entry
	* @return the yubikey o t p key entry that was removed
	*/
	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry deleteYubikeyOTPKeyEntry(
		fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		return _yubikeyOTPKeyEntryLocalService.deleteYubikeyOTPKeyEntry(yubikeyOTPKeyEntry);
	}

	/**
	* Deletes the yubikey o t p key entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keyId the primary key of the yubikey o t p key entry
	* @return the yubikey o t p key entry that was removed
	* @throws PortalException if a yubikey o t p key entry with the primary key could not be found
	*/
	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry deleteYubikeyOTPKeyEntry(
		long keyId) throws com.liferay.portal.kernel.exception.PortalException {
		return _yubikeyOTPKeyEntryLocalService.deleteYubikeyOTPKeyEntry(keyId);
	}

	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry fetchYubikeyOTPKeyEntry(
		java.lang.String publicId) {
		return _yubikeyOTPKeyEntryLocalService.fetchYubikeyOTPKeyEntry(publicId);
	}

	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry fetchYubikeyOTPKeyEntry(
		long keyId) {
		return _yubikeyOTPKeyEntryLocalService.fetchYubikeyOTPKeyEntry(keyId);
	}

	/**
	* Returns the yubikey o t p key entry with the primary key.
	*
	* @param keyId the primary key of the yubikey o t p key entry
	* @return the yubikey o t p key entry
	* @throws PortalException if a yubikey o t p key entry with the primary key could not be found
	*/
	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry getYubikeyOTPKeyEntry(
		long keyId) throws com.liferay.portal.kernel.exception.PortalException {
		return _yubikeyOTPKeyEntryLocalService.getYubikeyOTPKeyEntry(keyId);
	}

	/**
	* Updates the yubikey o t p key entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param yubikeyOTPKeyEntry the yubikey o t p key entry
	* @return the yubikey o t p key entry that was updated
	*/
	@Override
	public fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry updateYubikeyOTPKeyEntry(
		fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		return _yubikeyOTPKeyEntryLocalService.updateYubikeyOTPKeyEntry(yubikeyOTPKeyEntry);
	}

	/**
	* Returns the number of yubikey o t p key entries.
	*
	* @return the number of yubikey o t p key entries
	*/
	@Override
	public int getYubikeyOTPKeyEntriesCount() {
		return _yubikeyOTPKeyEntryLocalService.getYubikeyOTPKeyEntriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _yubikeyOTPKeyEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _yubikeyOTPKeyEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _yubikeyOTPKeyEntryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _yubikeyOTPKeyEntryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry> findByUserId(
		long userId) {
		return _yubikeyOTPKeyEntryLocalService.findByUserId(userId);
	}

	/**
	* Returns a range of all the yubikey o t p key entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of yubikey o t p key entries
	* @param end the upper bound of the range of yubikey o t p key entries (not inclusive)
	* @return the range of yubikey o t p key entries
	*/
	@Override
	public java.util.List<fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry> getYubikeyOTPKeyEntries(
		int start, int end) {
		return _yubikeyOTPKeyEntryLocalService.getYubikeyOTPKeyEntries(start,
			end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _yubikeyOTPKeyEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _yubikeyOTPKeyEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public YubikeyOTPKeyEntryLocalService getWrappedService() {
		return _yubikeyOTPKeyEntryLocalService;
	}

	@Override
	public void setWrappedService(
		YubikeyOTPKeyEntryLocalService yubikeyOTPKeyEntryLocalService) {
		_yubikeyOTPKeyEntryLocalService = yubikeyOTPKeyEntryLocalService;
	}

	private YubikeyOTPKeyEntryLocalService _yubikeyOTPKeyEntryLocalService;
}