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

<%@ include file="/com.liferay.portal.settings.web/init.jsp" %>

<%
YubikeyAuthenticationConfiguration configuration = ConfigurationProviderUtil.getConfiguration(YubikeyAuthenticationConfiguration.class, new ParameterMapSettingsLocator(request.getParameterMap(), "yubikey--", new CompanyServiceSettingsLocator(company.getCompanyId(), YubikeyConstants.SERVICE_NAME)));

boolean enabled = configuration.enabled();
%>

<aui:input name="<%= ActionRequest.ACTION_NAME %>" type="hidden" value="/portal_settings/yubikey" />

<aui:fieldset>
	<aui:input label="enabled" name="yubikey--enabled" type="checkbox" value="<%= enabled %>" />
</aui:fieldset>