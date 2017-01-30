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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException;
import fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry;

/**
 * The persistence interface for the yubikey o t p key entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto
 * @see fi.jguru.yubikey.otp.login.service.service.persistence.impl.YubikeyOTPKeyEntryPersistenceImpl
 * @see YubikeyOTPKeyEntryUtil
 * @generated
 */
@ProviderType
public interface YubikeyOTPKeyEntryPersistence extends BasePersistence<YubikeyOTPKeyEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YubikeyOTPKeyEntryUtil} to access the yubikey o t p key entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the yubikey o t p key entry where publicId = &#63; or throws a {@link NoSuchYubikeyOTPKeyEntryException} if it could not be found.
	*
	* @param publicId the public ID
	* @return the matching yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	*/
	public YubikeyOTPKeyEntry findByPublicId(java.lang.String publicId)
		throws NoSuchYubikeyOTPKeyEntryException;

	/**
	* Returns the yubikey o t p key entry where publicId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publicId the public ID
	* @return the matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	*/
	public YubikeyOTPKeyEntry fetchByPublicId(java.lang.String publicId);

	/**
	* Returns the yubikey o t p key entry where publicId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publicId the public ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	*/
	public YubikeyOTPKeyEntry fetchByPublicId(java.lang.String publicId,
		boolean retrieveFromCache);

	/**
	* Removes the yubikey o t p key entry where publicId = &#63; from the database.
	*
	* @param publicId the public ID
	* @return the yubikey o t p key entry that was removed
	*/
	public YubikeyOTPKeyEntry removeByPublicId(java.lang.String publicId)
		throws NoSuchYubikeyOTPKeyEntryException;

	/**
	* Returns the number of yubikey o t p key entries where publicId = &#63;.
	*
	* @param publicId the public ID
	* @return the number of matching yubikey o t p key entries
	*/
	public int countByPublicId(java.lang.String publicId);

	/**
	* Returns all the yubikey o t p key entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching yubikey o t p key entries
	*/
	public java.util.List<YubikeyOTPKeyEntry> findByUserId(long userId);

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
	public java.util.List<YubikeyOTPKeyEntry> findByUserId(long userId,
		int start, int end);

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
	public java.util.List<YubikeyOTPKeyEntry> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator);

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
	public java.util.List<YubikeyOTPKeyEntry> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	*/
	public YubikeyOTPKeyEntry findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws NoSuchYubikeyOTPKeyEntryException;

	/**
	* Returns the first yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	*/
	public YubikeyOTPKeyEntry fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator);

	/**
	* Returns the last yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	*/
	public YubikeyOTPKeyEntry findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws NoSuchYubikeyOTPKeyEntryException;

	/**
	* Returns the last yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	*/
	public YubikeyOTPKeyEntry fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator);

	/**
	* Returns the yubikey o t p key entries before and after the current yubikey o t p key entry in the ordered set where userId = &#63;.
	*
	* @param keyId the primary key of the current yubikey o t p key entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	*/
	public YubikeyOTPKeyEntry[] findByUserId_PrevAndNext(long keyId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws NoSuchYubikeyOTPKeyEntryException;

	/**
	* Removes all the yubikey o t p key entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of yubikey o t p key entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching yubikey o t p key entries
	*/
	public int countByUserId(long userId);

	/**
	* Caches the yubikey o t p key entry in the entity cache if it is enabled.
	*
	* @param yubikeyOTPKeyEntry the yubikey o t p key entry
	*/
	public void cacheResult(YubikeyOTPKeyEntry yubikeyOTPKeyEntry);

	/**
	* Caches the yubikey o t p key entries in the entity cache if it is enabled.
	*
	* @param yubikeyOTPKeyEntries the yubikey o t p key entries
	*/
	public void cacheResult(
		java.util.List<YubikeyOTPKeyEntry> yubikeyOTPKeyEntries);

	/**
	* Creates a new yubikey o t p key entry with the primary key. Does not add the yubikey o t p key entry to the database.
	*
	* @param keyId the primary key for the new yubikey o t p key entry
	* @return the new yubikey o t p key entry
	*/
	public YubikeyOTPKeyEntry create(long keyId);

	/**
	* Removes the yubikey o t p key entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keyId the primary key of the yubikey o t p key entry
	* @return the yubikey o t p key entry that was removed
	* @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	*/
	public YubikeyOTPKeyEntry remove(long keyId)
		throws NoSuchYubikeyOTPKeyEntryException;

	public YubikeyOTPKeyEntry updateImpl(YubikeyOTPKeyEntry yubikeyOTPKeyEntry);

	/**
	* Returns the yubikey o t p key entry with the primary key or throws a {@link NoSuchYubikeyOTPKeyEntryException} if it could not be found.
	*
	* @param keyId the primary key of the yubikey o t p key entry
	* @return the yubikey o t p key entry
	* @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	*/
	public YubikeyOTPKeyEntry findByPrimaryKey(long keyId)
		throws NoSuchYubikeyOTPKeyEntryException;

	/**
	* Returns the yubikey o t p key entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param keyId the primary key of the yubikey o t p key entry
	* @return the yubikey o t p key entry, or <code>null</code> if a yubikey o t p key entry with the primary key could not be found
	*/
	public YubikeyOTPKeyEntry fetchByPrimaryKey(long keyId);

	@Override
	public java.util.Map<java.io.Serializable, YubikeyOTPKeyEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the yubikey o t p key entries.
	*
	* @return the yubikey o t p key entries
	*/
	public java.util.List<YubikeyOTPKeyEntry> findAll();

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
	public java.util.List<YubikeyOTPKeyEntry> findAll(int start, int end);

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
	public java.util.List<YubikeyOTPKeyEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator);

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
	public java.util.List<YubikeyOTPKeyEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<YubikeyOTPKeyEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the yubikey o t p key entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of yubikey o t p key entries.
	*
	* @return the number of yubikey o t p key entries
	*/
	public int countAll();
}