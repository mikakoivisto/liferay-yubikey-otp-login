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

<%@ include file="/com.liferay.login.web/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
String iconURL = "/o/yubikey-otp-login-web/com.liferay.login.web/navigation/yubico-16x16.png";
%>
<portlet:renderURL var="yubikeyOTPLoginURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/login/yubikey_otp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<liferay-ui:icon
	iconCssClass="icon-yubikey"
	message="yubikey-otp"
	src="<%= iconURL %>"
	url="<%= yubikeyOTPLoginURL %>"
/>