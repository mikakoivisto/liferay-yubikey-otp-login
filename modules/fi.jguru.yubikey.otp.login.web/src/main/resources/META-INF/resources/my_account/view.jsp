<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/my_account/init.jsp" %>

<%
List<YubikeyOTPKeyEntry> keyEntries = (List<YubikeyOTPKeyEntry>)request.getAttribute("keyEntries");
%>
<div class="container-fluid-1280">
<aui:button-row>

    <portlet:renderURL var="addKeyEntryURL">
        <portlet:param name="mvcPath" value="/my_account/add.jsp" />
    </portlet:renderURL>

    <aui:button onClick="<%= addKeyEntryURL %>" value="add-key" />

</aui:button-row>
<liferay-ui:search-container>
    <liferay-ui:search-container-results
        results="<%= keyEntries %>" />

    <liferay-ui:search-container-row
        className="fi.jguru.yubikey.otp.login.service.model.YubikeyOTPKeyEntry" modelVar="entry">
		<portlet:actionURL name="deleteKey" var="deleteURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="keyId" value="<%= String.valueOf(entry.getKeyId()) %>" />
		</portlet:actionURL>

        <liferay-ui:search-container-column-text property="name" />

		<liferay-ui:search-container-column-text>

			<liferay-ui:icon-menu><liferay-ui:icon-delete url="<%= deleteURL %>" /></liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
</div>