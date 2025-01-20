<#import "template.ftl" as layout>
<@layout.registrationLayout displayInfo=true; section>
	<#if section == "header">
		Welcome to ${msg("extensionName")} !
	</#if>
</@layout.registrationLayout>
