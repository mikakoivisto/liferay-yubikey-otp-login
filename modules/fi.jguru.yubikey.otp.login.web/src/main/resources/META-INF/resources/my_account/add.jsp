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

<portlet:renderURL var="cancelURL">
</portlet:renderURL>
<portlet:actionURL name="addKey" var="addKeyURL" />

<aui:form action="<%= addKeyURL %>" method="post" name="fm" cssClass="container-fluid-1280 form">
	<liferay-ui:error exception="<%= YubicoInvalidResponse.class %>" message="failure-in-verifying-otp" />
	<liferay-ui:error exception="<%= YubicoSignatureException.class %>" message="failure-in-verifying-otp" />
	<liferay-ui:error exception="<%= YubicoValidationFailure.class %>" message="failure-in-verifying-otp" />
	<liferay-ui:error exception="<%= YubicoVerificationException.class %>" message="failure-in-verifying-otp" />
	<liferay-ui:error exception="<%= DuplicateYubikeyOTPKeyEntryException.class %>" message="this-key-is-already-associated-with-an-account" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<liferay-util:buffer var="requiredMark">
				<span class="icon-asterisk text-warning">
        			<span class="hide-accessible"><liferay-ui:message key="required" /></span>
				</span>
			</liferay-util:buffer>

			<label class="required-warning">
				<liferay-ui:message arguments="<%= requiredMark %>" key="all-fields-marked-with-x-are-required" translateArguments="<%= false %>" />
			</label>

			<aui:input autoFocus="<%= Boolean.TRUE %>" label="name" name="name" placeholder="enter-a-name-for-the-key" title="name" type="text" value="">
				<aui:validator name="required" />
			</aui:input>
	
			<aui:input autocomplete="off" cssClass="yubikey-otp" label="yubikey-otp" name="otp" placeholder="press-the-otp-generation-button" title="yubikey-otp" type="text" value="">
				<aui:validator name="required" />
			</aui:input>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" value="add" />
		<aui:button cssClass="btn-lg" href="<%= cancelURL %>" type="cancel" />
	</aui:button-row>
</aui:form>