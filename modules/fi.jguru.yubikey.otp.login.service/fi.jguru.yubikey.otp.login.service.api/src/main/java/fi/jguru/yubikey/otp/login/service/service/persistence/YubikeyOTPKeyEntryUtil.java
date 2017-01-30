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

package fi.jguru.yubikey.otp.login.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the yubikey o t p key entry service. This utility wraps {@link fi.jguru.yubikey.otp.login.service.service.persistence.impl.YubikeyOTPKeyEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto
 * @see YubikeyOTPKeyEntryPersistence
 * @see fi.jguru.yubikey.otp.login.service.service.persistence.impl.YubikeyOTPKeyEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class YubikeyOTPKeyEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		getPersistence().clearCache(yubikeyOTPKeyEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<YubikeyOTPKeyEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YubikeyOTPKeyEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YubikeyOTPKeyEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static YubikeyOTPKeyEntry update(
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		return getPersistence().update(yubikeyOTPKeyEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static YubikeyOTPKeyEntry update(
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry, ServiceContext serviceContext) {
		return getPersistence().update(yubikeyOTPKeyEntry, serviceContext);
	}

	/**
	* Returns the yubikey o t p key entry where publicId = &#63; or throws a {@link NoSuchYubikeyOTPKeyEntryException} if it could not be found.
	*
	* @param publicId the public ID
	* @return the matching yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	*/
	public static YubikeyOTPKeyEntry findByPublicId(java.lang.String publicId)
		throws fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException {
		return getPersistence().findByPublicId(publicId);
	}

	/**
	* Returns the yubikey o t p key entry where publicId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publicId the public ID
	* @return the matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	*/
	public static YubikeyOTPKeyEntry fetchByPublicId(java.lang.String publicId) {
		return getPersistence().fetchByPublicId(publicId);
	}

	/**
	* Returns the yubikey o t p key entry where publicId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publicId the public ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	*/
	public static YubikeyOTPKeyEntry fetchByPublicId(
		java.lang.String publicId, boolean retrieveFromCache) {
		return getPersistence().fetchByPublicId(publicId, retrieveFromCache);
	}

	/**
	* Removes the yubikey o t p key entry where publicId = &#63; from the database.
	*
	* @param publicId the public ID
	* @return the yubikey o t p key entry that was removed
	*/
	public static YubikeyOTPKeyEntry removeByPublicId(java.lang.String publicId)
		throws fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException {
		return getPersistence().removeByPublicId(publicId);
	}

	/**
	* Returns the number of yubikey o t p key entries where publicId = &#63;.
	*
	* @param publicId the public ID
	* @return the number of matching yubikey o t p key entries
	*/
	public static int countByPublicId(java.lang.String publicId) {
		return getPersistence().countByPublicId(publicId);
	}

	/**
	* Returns all the yubikey o t p key entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching yubikey o t p key entries
	*/
	public static List<YubikeyOTPKeyEntry> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the yubikey o t p key entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of yubikey o t p key entries
	* @param end the upper bound of the range of yubikey o t p key entries (not inclusive)
	* @return the range of matching yubikey o t p key entries
	*/
	public static List<YubikeyOTPKeyEntry> findByUserId(long userId, int start,
		int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the yubikey o t p key entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of yubikey o t p key entries
	* @param end the upper bound of the range of yubikey o t p key entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching yubikey o t p key entries
	*/
	public static List<YubikeyOTPKeyEntry> findByUserId(long userId, int start,
		int end, OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the yubikey o t p key entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of yubikey o t p key entries
	* @param end the upper bound of the range of yubikey o t p key entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching yubikey o t p key entries
	*/
	public static List<YubikeyOTPKeyEntry> findByUserId(long userId, int start,
		int end, OrderByComparator<YubikeyOTPKeyEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	*/
	public static YubikeyOTPKeyEntry findByUserId_First(long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	*/
	public static YubikeyOTPKeyEntry fetchByUserId_First(long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	*/
	public static YubikeyOTPKeyEntry findByUserId_Last(long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	*/
	public static YubikeyOTPKeyEntry fetchByUserId_Last(long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the yubikey o t p key entries before and after the current yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param keyId the primary key of the current yubikey o t p key entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	*/
	public static YubikeyOTPKeyEntry[] findByUserId_PrevAndNext(long keyId,
		long userId, OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(keyId, userId, orderByComparator);
	}

	/**
	* Removes all the yubikey o t p key entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of yubikey o t p key entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching yubikey o t p key entries
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the yubikey o t p key entry in the entity cache if it is enabled.
	*
	* @param yubikeyOTPKeyEntry the yubikey o t p key entry
	*/
	public static void cacheResult(YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		getPersistence().cacheResult(yubikeyOTPKeyEntry);
	}

	/**
	* Caches the yubikey o t p key entries in the entity cache if it is enabled.
	*
	* @param yubikeyOTPKeyEntries the yubikey o t p key entries
	*/
	public static void cacheResult(
		List<YubikeyOTPKeyEntry> yubikeyOTPKeyEntries) {
		getPersistence().cacheResult(yubikeyOTPKeyEntries);
	}

	/**
	* Creates a new yubikey o t p key entry with the primary key. Does not add the yubikey o t p key entry to the database.
	*
	* @param keyId the primary key for the new yubikey o t p key entry
	* @return the new yubikey o t p key entry
	*/
	public static YubikeyOTPKeyEntry create(long keyId) {
		return getPersistence().create(keyId);
	}

	/**
	* Removes the yubikey o t p key entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keyId the primary key of the yubikey o t p key entry
	* @return the yubikey o t p key entry that was removed
	* @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	*/
	public static YubikeyOTPKeyEntry remove(long keyId)
		throws fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException {
		return getPersistence().remove(keyId);
	}

	public static YubikeyOTPKeyEntry updateImpl(
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		return getPersistence().updateImpl(yubikeyOTPKeyEntry);
	}

	/**
	* Returns the yubikey o t p key entry with the primary key or throws a {@link NoSuchYubikeyOTPKeyEntryException} if it could not be found.
	*
	* @param keyId the primary key of the yubikey o t p key entry
	* @return the yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	*/
	public static YubikeyOTPKeyEntry findByPrimaryKey(long keyId)
		throws fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException {
		return getPersistence().findByPrimaryKey(keyId);
	}

	/**
	* Returns the yubikey o t p key entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param keyId the primary key of the yubikey o t p key entry
	* @return the yubikey o t p key entry, or <code>null</code> if a yubikey o t p key entry with the primary key could not be found
	*/
	public static YubikeyOTPKeyEntry fetchByPrimaryKey(long keyId) {
		return getPersistence().fetchByPrimaryKey(keyId);
	}

	public static java.util.Map<java.io.Serializable, YubikeyOTPKeyEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the yubikey o t p key entries.
	*
	* @return the yubikey o t p key entries
	*/
	public static List<YubikeyOTPKeyEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the yubikey o t p key entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of yubikey o t p key entries
	* @param end the upper bound of the range of yubikey o t p key entries (not inclusive)
	* @return the range of yubikey o t p key entries
	*/
	public static List<YubikeyOTPKeyEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the yubikey o t p key entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of yubikey o t p key entries
	* @param end the upper bound of the range of yubikey o t p key entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of yubikey o t p key entries
	*/
	public static List<YubikeyOTPKeyEntry> findAll(int start, int end,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the yubikey o t p key entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YubikeyOTPKeyEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of yubikey o t p key entries
	* @param end the upper bound of the range of yubikey o t p key entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of yubikey o t p key entries
	*/
	public static List<YubikeyOTPKeyEntry> findAll(int start, int end,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the yubikey o t p key entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of yubikey o t p key entries.
	*
	* @return the number of yubikey o t p key entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static YubikeyOTPKeyEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<YubikeyOTPKeyEntryPersistence, YubikeyOTPKeyEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(YubikeyOTPKeyEntryPersistence.class);
}