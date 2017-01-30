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
%>
<portlet:actionURL var="yubikeyLoginURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="/login/yubikey_otp" />
</portlet:actionURL>

<aui:form action="<%= yubikeyLoginURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<liferay-ui:error exception="<%= YubicoInvalidResponse.class %>" message="failure-in-verifying-otp" />
	<liferay-ui:error exception="<%= YubicoSignatureException.class %>" message="failure-in-verifying-otp" />
	<liferay-ui:error exception="<%= YubicoValidationFailure.class %>" message="failure-in-verifying-otp" />
	<liferay-ui:error exception="<%= YubicoVerificationException.class %>" message="failure-in-verifying-otp" />

	<aui:fieldset>
		<aui:input autoComplete="off" autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" cssClass="yubikey-otp" label="yubikey-otp" name="otp" title="yubikey-otp" type="text" value="" />

		<aui:button-row>
			<aui:button cssClass="btn-lg" type="submit" value="sign-in" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>