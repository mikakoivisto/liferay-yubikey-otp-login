<%--
/**
 * Copyright (c) 2017 Mika Koivisto <mika@javaguru.fi>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
--%>

<%@ include file="/init.jsp" %>

<%
Group scopeGroup = themeDisplay.getScopeGroup();

if (scopeGroup.isStagingGroup()) {
	scopeGroup = scopeGroup.getLiveGroup();
}

UnicodeProperties typeSettingsProperties = scopeGroup.getTypeSettingsProperties();

boolean liferayEnabled = GetterUtil.getBoolean(typeSettingsProperties.getProperty("social-comments-liferay-enabled"), true);

String disqusShortName = typeSettingsProperties.getProperty("social-comments-disqus-short-name");
boolean disqusEnabled = GetterUtil.getBoolean(typeSettingsProperties.getProperty("social-comments-disqus-enabled"));

String livefyreSiteId = typeSettingsProperties.getProperty("social-comments-livefyre-site-id");
String livefyreSiteSecret = typeSettingsProperties.getProperty("social-comments-livefyre-site-secret");
boolean livefyreEnabled = GetterUtil.getBoolean(typeSettingsProperties.getProperty("social-comments-livefyre-enabled"));

boolean gplusEnabled = GetterUtil.getBoolean(typeSettingsProperties.getProperty("social-comments-gplus-enabled"));
int gplusWidth = GetterUtil.getInteger(typeSettingsProperties.getProperty("social-comments-gplus-width", "642"));

boolean fbEnabled = GetterUtil.getBoolean(typeSettingsProperties.getProperty("social-comments-facebook-enabled"));
String fbAppId = GetterUtil.getString(typeSettingsProperties.getProperty("social-comments-facebook-app-id"), "");
String fbColorScheme = GetterUtil.getString(typeSettingsProperties.getProperty("social-comments-facebook-color-scheme"), "light");
int fbNumPosts = GetterUtil.getInteger(typeSettingsProperties.getProperty("social-comments-facebook-numPosts", "10"));
String fbWidth = GetterUtil.getString(typeSettingsProperties.getProperty("social-comments-facebook-width", "550"));

%>
<portlet:actionURL name="updateConfiguration" var="updateConfigurationURL" />

<aui:form action="<%= updateConfigurationURL %>" cssClass="container-fluid-1280">

	<aui:fieldset label="liferay">
		<aui:input label="enabled" name="settings--social-comments-liferay-enabled--" type="checkbox" value="<%= String.valueOf(liferayEnabled) %>"/>
	</aui:fieldset>

	<aui:fieldset label="disqus">
		<aui:input label="enabled" name="settings--social-comments-disqus-enabled--" type="checkbox" value="<%= String.valueOf(disqusEnabled) %>"/>

		<aui:input label="short-name" name="settings--social-comments-disqus-short-name--" value="<%= disqusShortName %>"/>
	</aui:fieldset>

	<aui:fieldset label="gplus">
		<aui:input label="enabled" name="settings--social-comments-gplus-enabled--" type="checkbox" value="<%= String.valueOf(gplusEnabled) %>"/>
		<aui:input label="width" name="settings--social-comments-gplus-width--" value="<%= gplusWidth %>">
			<aui:validator name="digits"/>
		</aui:input>
	</aui:fieldset>

	<aui:fieldset label="facebook">
		<aui:input label="enabled" name="settings--social-comments-facebook-enabled--" type="checkbox" value="<%= String.valueOf(fbEnabled) %>"/>
		<aui:input label="app-id" name="settings--social-comments-facebook-app-id--" value="<%= fbAppId %>" />
		<aui:input label="width" name="settings--social-comments-facebook-width--" value="<%= fbWidth %>" />
		<aui:input label="number-of-posts" name="settings--social-comments-facebook-numPosts--" value="<%= fbNumPosts %>">
			<aui:validator name="digits"/>
		</aui:input>
		<aui:select label="color-scheme" name="settings--social-comments-facebook-color-scheme--">
			<aui:option label="light" selected='<%= fbColorScheme.equals("light") %>' value="light" />
			<aui:option label="dark" selected='<%= fbColorScheme.equals("dark") %>' value="dark" />
		</aui:select>
	</aui:fieldset>
	<aui:button-row>
		<aui:button label="save" type="submit" />
	</aui:button-row>
</aui:form>