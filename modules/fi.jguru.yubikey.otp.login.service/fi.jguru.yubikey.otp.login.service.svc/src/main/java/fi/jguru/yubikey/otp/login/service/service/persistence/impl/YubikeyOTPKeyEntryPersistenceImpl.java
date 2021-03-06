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

package fi.jguru.yubikey.otp.login.service.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import fi.jguru.yubikey.otp.login.service.exception.NoSuchYubikeyOTPKeyEntryException;
import fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry;
import fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryImpl;
import fi.jguru.yubikey.otp.login.service.model.impl.YubikeyOTPKeyEntryModelImpl;
import fi.jguru.yubikey.otp.login.service.service.persistence.YubikeyOTPKeyEntryPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the yubikey o t p key entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto
 * @see YubikeyOTPKeyEntryPersistence
 * @see fi.jguru.yubikey.otp.login.service.service.persistence.YubikeyOTPKeyEntryUtil
 * @generated
 */
@ProviderType
public class YubikeyOTPKeyEntryPersistenceImpl extends BasePersistenceImpl<YubikeyOTPKeyEntry>
	implements YubikeyOTPKeyEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YubikeyOTPKeyEntryUtil} to access the yubikey o t p key entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YubikeyOTPKeyEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryModelImpl.FINDER_CACHE_ENABLED,
			YubikeyOTPKeyEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryModelImpl.FINDER_CACHE_ENABLED,
			YubikeyOTPKeyEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLICID = new FinderPath(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryModelImpl.FINDER_CACHE_ENABLED,
			YubikeyOTPKeyEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPublicId", new String[] { String.class.getName() },
			YubikeyOTPKeyEntryModelImpl.PUBLICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLICID = new FinderPath(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublicId",
			new String[] { String.class.getName() });

	/**
	 * Returns the yubikey o t p key entry where publicId = &#63; or throws a {@link NoSuchYubikeyOTPKeyEntryException} if it could not be found.
	 *
	 * @param publicId the public ID
	 * @return the matching yubikey o t p key entry
	 * @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry findByPublicId(String publicId)
		throws NoSuchYubikeyOTPKeyEntryException {
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = fetchByPublicId(publicId);

		if (yubikeyOTPKeyEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publicId=");
			msg.append(publicId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchYubikeyOTPKeyEntryException(msg.toString());
		}

		return yubikeyOTPKeyEntry;
	}

	/**
	 * Returns the yubikey o t p key entry where publicId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publicId the public ID
	 * @return the matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry fetchByPublicId(String publicId) {
		return fetchByPublicId(publicId, true);
	}

	/**
	 * Returns the yubikey o t p key entry where publicId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publicId the public ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry fetchByPublicId(String publicId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { publicId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PUBLICID,
					finderArgs, this);
		}

		if (result instanceof YubikeyOTPKeyEntry) {
			YubikeyOTPKeyEntry yubikeyOTPKeyEntry = (YubikeyOTPKeyEntry)result;

			if (!Objects.equals(publicId, yubikeyOTPKeyEntry.getPublicId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_YUBIKEYOTPKEYENTRY_WHERE);

			boolean bindPublicId = false;

			if (publicId == null) {
				query.append(_FINDER_COLUMN_PUBLICID_PUBLICID_1);
			}
			else if (publicId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLICID_PUBLICID_3);
			}
			else {
				bindPublicId = true;

				query.append(_FINDER_COLUMN_PUBLICID_PUBLICID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublicId) {
					qPos.add(publicId);
				}

				List<YubikeyOTPKeyEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PUBLICID,
						finderArgs, list);
				}
				else {
					YubikeyOTPKeyEntry yubikeyOTPKeyEntry = list.get(0);

					result = yubikeyOTPKeyEntry;

					cacheResult(yubikeyOTPKeyEntry);

					if ((yubikeyOTPKeyEntry.getPublicId() == null) ||
							!yubikeyOTPKeyEntry.getPublicId().equals(publicId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_PUBLICID,
							finderArgs, yubikeyOTPKeyEntry);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PUBLICID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (YubikeyOTPKeyEntry)result;
		}
	}

	/**
	 * Removes the yubikey o t p key entry where publicId = &#63; from the database.
	 *
	 * @param publicId the public ID
	 * @return the yubikey o t p key entry that was removed
	 */
	@Override
	public YubikeyOTPKeyEntry removeByPublicId(String publicId)
		throws NoSuchYubikeyOTPKeyEntryException {
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = findByPublicId(publicId);

		return remove(yubikeyOTPKeyEntry);
	}

	/**
	 * Returns the number of yubikey o t p key entries where publicId = &#63;.
	 *
	 * @param publicId the public ID
	 * @return the number of matching yubikey o t p key entries
	 */
	@Override
	public int countByPublicId(String publicId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLICID;

		Object[] finderArgs = new Object[] { publicId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YUBIKEYOTPKEYENTRY_WHERE);

			boolean bindPublicId = false;

			if (publicId == null) {
				query.append(_FINDER_COLUMN_PUBLICID_PUBLICID_1);
			}
			else if (publicId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLICID_PUBLICID_3);
			}
			else {
				bindPublicId = true;

				query.append(_FINDER_COLUMN_PUBLICID_PUBLICID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublicId) {
					qPos.add(publicId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PUBLICID_PUBLICID_1 = "yubikeyOTPKeyEntry.publicId IS NULL";
	private static final String _FINDER_COLUMN_PUBLICID_PUBLICID_2 = "yubikeyOTPKeyEntry.publicId = ?";
	private static final String _FINDER_COLUMN_PUBLICID_PUBLICID_3 = "(yubikeyOTPKeyEntry.publicId IS NULL OR yubikeyOTPKeyEntry.publicId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryModelImpl.FINDER_CACHE_ENABLED,
			YubikeyOTPKeyEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryModelImpl.FINDER_CACHE_ENABLED,
			YubikeyOTPKeyEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			YubikeyOTPKeyEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the yubikey o t p key entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching yubikey o t p key entries
	 */
	@Override
	public List<YubikeyOTPKeyEntry> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<YubikeyOTPKeyEntry> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<YubikeyOTPKeyEntry> findByUserId(long userId, int start,
		int end, OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<YubikeyOTPKeyEntry> findByUserId(long userId, int start,
		int end, OrderByComparator<YubikeyOTPKeyEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<YubikeyOTPKeyEntry> list = null;

		if (retrieveFromCache) {
			list = (List<YubikeyOTPKeyEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (YubikeyOTPKeyEntry yubikeyOTPKeyEntry : list) {
					if ((userId != yubikeyOTPKeyEntry.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_YUBIKEYOTPKEYENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(YubikeyOTPKeyEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<YubikeyOTPKeyEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<YubikeyOTPKeyEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first yubikey o t p key entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching yubikey o t p key entry
	 * @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry findByUserId_First(long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws NoSuchYubikeyOTPKeyEntryException {
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = fetchByUserId_First(userId,
				orderByComparator);

		if (yubikeyOTPKeyEntry != null) {
			return yubikeyOTPKeyEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYubikeyOTPKeyEntryException(msg.toString());
	}

	/**
	 * Returns the first yubikey o t p key entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry fetchByUserId_First(long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		List<YubikeyOTPKeyEntry> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last yubikey o t p key entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching yubikey o t p key entry
	 * @throws NoSuchYubikeyOTPKeyEntryException if a matching yubikey o t p key entry could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry findByUserId_Last(long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws NoSuchYubikeyOTPKeyEntryException {
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = fetchByUserId_Last(userId,
				orderByComparator);

		if (yubikeyOTPKeyEntry != null) {
			return yubikeyOTPKeyEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchYubikeyOTPKeyEntryException(msg.toString());
	}

	/**
	 * Returns the last yubikey o t p key entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching yubikey o t p key entry, or <code>null</code> if a matching yubikey o t p key entry could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry fetchByUserId_Last(long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<YubikeyOTPKeyEntry> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public YubikeyOTPKeyEntry[] findByUserId_PrevAndNext(long keyId,
		long userId, OrderByComparator<YubikeyOTPKeyEntry> orderByComparator)
		throws NoSuchYubikeyOTPKeyEntryException {
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = findByPrimaryKey(keyId);

		Session session = null;

		try {
			session = openSession();

			YubikeyOTPKeyEntry[] array = new YubikeyOTPKeyEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session, yubikeyOTPKeyEntry,
					userId, orderByComparator, true);

			array[1] = yubikeyOTPKeyEntry;

			array[2] = getByUserId_PrevAndNext(session, yubikeyOTPKeyEntry,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected YubikeyOTPKeyEntry getByUserId_PrevAndNext(Session session,
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry, long userId,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_YUBIKEYOTPKEYENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(YubikeyOTPKeyEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(yubikeyOTPKeyEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<YubikeyOTPKeyEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the yubikey o t p key entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (YubikeyOTPKeyEntry yubikeyOTPKeyEntry : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(yubikeyOTPKeyEntry);
		}
	}

	/**
	 * Returns the number of yubikey o t p key entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching yubikey o t p key entries
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YUBIKEYOTPKEYENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "yubikeyOTPKeyEntry.userId = ?";

	public YubikeyOTPKeyEntryPersistenceImpl() {
		setModelClass(YubikeyOTPKeyEntry.class);
	}

	/**
	 * Caches the yubikey o t p key entry in the entity cache if it is enabled.
	 *
	 * @param yubikeyOTPKeyEntry the yubikey o t p key entry
	 */
	@Override
	public void cacheResult(YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		entityCache.putResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryImpl.class, yubikeyOTPKeyEntry.getPrimaryKey(),
			yubikeyOTPKeyEntry);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PUBLICID,
			new Object[] { yubikeyOTPKeyEntry.getPublicId() },
			yubikeyOTPKeyEntry);

		yubikeyOTPKeyEntry.resetOriginalValues();
	}

	/**
	 * Caches the yubikey o t p key entries in the entity cache if it is enabled.
	 *
	 * @param yubikeyOTPKeyEntries the yubikey o t p key entries
	 */
	@Override
	public void cacheResult(List<YubikeyOTPKeyEntry> yubikeyOTPKeyEntries) {
		for (YubikeyOTPKeyEntry yubikeyOTPKeyEntry : yubikeyOTPKeyEntries) {
			if (entityCache.getResult(
						YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
						YubikeyOTPKeyEntryImpl.class,
						yubikeyOTPKeyEntry.getPrimaryKey()) == null) {
				cacheResult(yubikeyOTPKeyEntry);
			}
			else {
				yubikeyOTPKeyEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all yubikey o t p key entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(YubikeyOTPKeyEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the yubikey o t p key entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		entityCache.removeResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryImpl.class, yubikeyOTPKeyEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((YubikeyOTPKeyEntryModelImpl)yubikeyOTPKeyEntry);
	}

	@Override
	public void clearCache(List<YubikeyOTPKeyEntry> yubikeyOTPKeyEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YubikeyOTPKeyEntry yubikeyOTPKeyEntry : yubikeyOTPKeyEntries) {
			entityCache.removeResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
				YubikeyOTPKeyEntryImpl.class, yubikeyOTPKeyEntry.getPrimaryKey());

			clearUniqueFindersCache((YubikeyOTPKeyEntryModelImpl)yubikeyOTPKeyEntry);
		}
	}

	protected void cacheUniqueFindersCache(
		YubikeyOTPKeyEntryModelImpl yubikeyOTPKeyEntryModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					yubikeyOTPKeyEntryModelImpl.getPublicId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_PUBLICID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_PUBLICID, args,
				yubikeyOTPKeyEntryModelImpl);
		}
		else {
			if ((yubikeyOTPKeyEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						yubikeyOTPKeyEntryModelImpl.getPublicId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_PUBLICID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_PUBLICID, args,
					yubikeyOTPKeyEntryModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		YubikeyOTPKeyEntryModelImpl yubikeyOTPKeyEntryModelImpl) {
		Object[] args = new Object[] { yubikeyOTPKeyEntryModelImpl.getPublicId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_PUBLICID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_PUBLICID, args);

		if ((yubikeyOTPKeyEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLICID.getColumnBitmask()) != 0) {
			args = new Object[] {
					yubikeyOTPKeyEntryModelImpl.getOriginalPublicId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PUBLICID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PUBLICID, args);
		}
	}

	/**
	 * Creates a new yubikey o t p key entry with the primary key. Does not add the yubikey o t p key entry to the database.
	 *
	 * @param keyId the primary key for the new yubikey o t p key entry
	 * @return the new yubikey o t p key entry
	 */
	@Override
	public YubikeyOTPKeyEntry create(long keyId) {
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = new YubikeyOTPKeyEntryImpl();

		yubikeyOTPKeyEntry.setNew(true);
		yubikeyOTPKeyEntry.setPrimaryKey(keyId);

		yubikeyOTPKeyEntry.setCompanyId(companyProvider.getCompanyId());

		return yubikeyOTPKeyEntry;
	}

	/**
	 * Removes the yubikey o t p key entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keyId the primary key of the yubikey o t p key entry
	 * @return the yubikey o t p key entry that was removed
	 * @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry remove(long keyId)
		throws NoSuchYubikeyOTPKeyEntryException {
		return remove((Serializable)keyId);
	}

	/**
	 * Removes the yubikey o t p key entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the yubikey o t p key entry
	 * @return the yubikey o t p key entry that was removed
	 * @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry remove(Serializable primaryKey)
		throws NoSuchYubikeyOTPKeyEntryException {
		Session session = null;

		try {
			session = openSession();

			YubikeyOTPKeyEntry yubikeyOTPKeyEntry = (YubikeyOTPKeyEntry)session.get(YubikeyOTPKeyEntryImpl.class,
					primaryKey);

			if (yubikeyOTPKeyEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYubikeyOTPKeyEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(yubikeyOTPKeyEntry);
		}
		catch (NoSuchYubikeyOTPKeyEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected YubikeyOTPKeyEntry removeImpl(
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		yubikeyOTPKeyEntry = toUnwrappedModel(yubikeyOTPKeyEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(yubikeyOTPKeyEntry)) {
				yubikeyOTPKeyEntry = (YubikeyOTPKeyEntry)session.get(YubikeyOTPKeyEntryImpl.class,
						yubikeyOTPKeyEntry.getPrimaryKeyObj());
			}

			if (yubikeyOTPKeyEntry != null) {
				session.delete(yubikeyOTPKeyEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (yubikeyOTPKeyEntry != null) {
			clearCache(yubikeyOTPKeyEntry);
		}

		return yubikeyOTPKeyEntry;
	}

	@Override
	public YubikeyOTPKeyEntry updateImpl(YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		yubikeyOTPKeyEntry = toUnwrappedModel(yubikeyOTPKeyEntry);

		boolean isNew = yubikeyOTPKeyEntry.isNew();

		YubikeyOTPKeyEntryModelImpl yubikeyOTPKeyEntryModelImpl = (YubikeyOTPKeyEntryModelImpl)yubikeyOTPKeyEntry;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (yubikeyOTPKeyEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				yubikeyOTPKeyEntry.setCreateDate(now);
			}
			else {
				yubikeyOTPKeyEntry.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!yubikeyOTPKeyEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				yubikeyOTPKeyEntry.setModifiedDate(now);
			}
			else {
				yubikeyOTPKeyEntry.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (yubikeyOTPKeyEntry.isNew()) {
				session.save(yubikeyOTPKeyEntry);

				yubikeyOTPKeyEntry.setNew(false);
			}
			else {
				yubikeyOTPKeyEntry = (YubikeyOTPKeyEntry)session.merge(yubikeyOTPKeyEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !YubikeyOTPKeyEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((yubikeyOTPKeyEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						yubikeyOTPKeyEntryModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { yubikeyOTPKeyEntryModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		entityCache.putResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
			YubikeyOTPKeyEntryImpl.class, yubikeyOTPKeyEntry.getPrimaryKey(),
			yubikeyOTPKeyEntry, false);

		clearUniqueFindersCache(yubikeyOTPKeyEntryModelImpl);
		cacheUniqueFindersCache(yubikeyOTPKeyEntryModelImpl, isNew);

		yubikeyOTPKeyEntry.resetOriginalValues();

		return yubikeyOTPKeyEntry;
	}

	protected YubikeyOTPKeyEntry toUnwrappedModel(
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry) {
		if (yubikeyOTPKeyEntry instanceof YubikeyOTPKeyEntryImpl) {
			return yubikeyOTPKeyEntry;
		}

		YubikeyOTPKeyEntryImpl yubikeyOTPKeyEntryImpl = new YubikeyOTPKeyEntryImpl();

		yubikeyOTPKeyEntryImpl.setNew(yubikeyOTPKeyEntry.isNew());
		yubikeyOTPKeyEntryImpl.setPrimaryKey(yubikeyOTPKeyEntry.getPrimaryKey());

		yubikeyOTPKeyEntryImpl.setKeyId(yubikeyOTPKeyEntry.getKeyId());
		yubikeyOTPKeyEntryImpl.setCompanyId(yubikeyOTPKeyEntry.getCompanyId());
		yubikeyOTPKeyEntryImpl.setUserId(yubikeyOTPKeyEntry.getUserId());
		yubikeyOTPKeyEntryImpl.setUserName(yubikeyOTPKeyEntry.getUserName());
		yubikeyOTPKeyEntryImpl.setCreateDate(yubikeyOTPKeyEntry.getCreateDate());
		yubikeyOTPKeyEntryImpl.setModifiedDate(yubikeyOTPKeyEntry.getModifiedDate());
		yubikeyOTPKeyEntryImpl.setPublicId(yubikeyOTPKeyEntry.getPublicId());
		yubikeyOTPKeyEntryImpl.setName(yubikeyOTPKeyEntry.getName());

		return yubikeyOTPKeyEntryImpl;
	}

	/**
	 * Returns the yubikey o t p key entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the yubikey o t p key entry
	 * @return the yubikey o t p key entry
	 * @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchYubikeyOTPKeyEntryException {
		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = fetchByPrimaryKey(primaryKey);

		if (yubikeyOTPKeyEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchYubikeyOTPKeyEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return yubikeyOTPKeyEntry;
	}

	/**
	 * Returns the yubikey o t p key entry with the primary key or throws a {@link NoSuchYubikeyOTPKeyEntryException} if it could not be found.
	 *
	 * @param keyId the primary key of the yubikey o t p key entry
	 * @return the yubikey o t p key entry
	 * @throws NoSuchYubikeyOTPKeyEntryException if a yubikey o t p key entry with the primary key could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry findByPrimaryKey(long keyId)
		throws NoSuchYubikeyOTPKeyEntryException {
		return findByPrimaryKey((Serializable)keyId);
	}

	/**
	 * Returns the yubikey o t p key entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the yubikey o t p key entry
	 * @return the yubikey o t p key entry, or <code>null</code> if a yubikey o t p key entry with the primary key could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
				YubikeyOTPKeyEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		YubikeyOTPKeyEntry yubikeyOTPKeyEntry = (YubikeyOTPKeyEntry)serializable;

		if (yubikeyOTPKeyEntry == null) {
			Session session = null;

			try {
				session = openSession();

				yubikeyOTPKeyEntry = (YubikeyOTPKeyEntry)session.get(YubikeyOTPKeyEntryImpl.class,
						primaryKey);

				if (yubikeyOTPKeyEntry != null) {
					cacheResult(yubikeyOTPKeyEntry);
				}
				else {
					entityCache.putResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
						YubikeyOTPKeyEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
					YubikeyOTPKeyEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return yubikeyOTPKeyEntry;
	}

	/**
	 * Returns the yubikey o t p key entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param keyId the primary key of the yubikey o t p key entry
	 * @return the yubikey o t p key entry, or <code>null</code> if a yubikey o t p key entry with the primary key could not be found
	 */
	@Override
	public YubikeyOTPKeyEntry fetchByPrimaryKey(long keyId) {
		return fetchByPrimaryKey((Serializable)keyId);
	}

	@Override
	public Map<Serializable, YubikeyOTPKeyEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, YubikeyOTPKeyEntry> map = new HashMap<Serializable, YubikeyOTPKeyEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			YubikeyOTPKeyEntry yubikeyOTPKeyEntry = fetchByPrimaryKey(primaryKey);

			if (yubikeyOTPKeyEntry != null) {
				map.put(primaryKey, yubikeyOTPKeyEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
					YubikeyOTPKeyEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (YubikeyOTPKeyEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_YUBIKEYOTPKEYENTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (YubikeyOTPKeyEntry yubikeyOTPKeyEntry : (List<YubikeyOTPKeyEntry>)q.list()) {
				map.put(yubikeyOTPKeyEntry.getPrimaryKeyObj(),
					yubikeyOTPKeyEntry);

				cacheResult(yubikeyOTPKeyEntry);

				uncachedPrimaryKeys.remove(yubikeyOTPKeyEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(YubikeyOTPKeyEntryModelImpl.ENTITY_CACHE_ENABLED,
					YubikeyOTPKeyEntryImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the yubikey o t p key entries.
	 *
	 * @return the yubikey o t p key entries
	 */
	@Override
	public List<YubikeyOTPKeyEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<YubikeyOTPKeyEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<YubikeyOTPKeyEntry> findAll(int start, int end,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<YubikeyOTPKeyEntry> findAll(int start, int end,
		OrderByComparator<YubikeyOTPKeyEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<YubikeyOTPKeyEntry> list = null;

		if (retrieveFromCache) {
			list = (List<YubikeyOTPKeyEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_YUBIKEYOTPKEYENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YUBIKEYOTPKEYENTRY;

				if (pagination) {
					sql = sql.concat(YubikeyOTPKeyEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<YubikeyOTPKeyEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<YubikeyOTPKeyEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the yubikey o t p key entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (YubikeyOTPKeyEntry yubikeyOTPKeyEntry : findAll()) {
			remove(yubikeyOTPKeyEntry);
		}
	}

	/**
	 * Returns the number of yubikey o t p key entries.
	 *
	 * @return the number of yubikey o t p key entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YUBIKEYOTPKEYENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return YubikeyOTPKeyEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the yubikey o t p key entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(YubikeyOTPKeyEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_YUBIKEYOTPKEYENTRY = "SELECT yubikeyOTPKeyEntry FROM YubikeyOTPKeyEntry yubikeyOTPKeyEntry";
	private static final String _SQL_SELECT_YUBIKEYOTPKEYENTRY_WHERE_PKS_IN = "SELECT yubikeyOTPKeyEntry FROM YubikeyOTPKeyEntry yubikeyOTPKeyEntry WHERE keyId IN (";
	private static final String _SQL_SELECT_YUBIKEYOTPKEYENTRY_WHERE = "SELECT yubikeyOTPKeyEntry FROM YubikeyOTPKeyEntry yubikeyOTPKeyEntry WHERE ";
	private static final String _SQL_COUNT_YUBIKEYOTPKEYENTRY = "SELECT COUNT(yubikeyOTPKeyEntry) FROM YubikeyOTPKeyEntry yubikeyOTPKeyEntry";
	private static final String _SQL_COUNT_YUBIKEYOTPKEYENTRY_WHERE = "SELECT COUNT(yubikeyOTPKeyEntry) FROM YubikeyOTPKeyEntry yubikeyOTPKeyEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "yubikeyOTPKeyEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YubikeyOTPKeyEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No YubikeyOTPKeyEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(YubikeyOTPKeyEntryPersistenceImpl.class);
}