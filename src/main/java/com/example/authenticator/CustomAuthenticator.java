package com.example.authenticator;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

public class CustomAuthenticator implements Authenticator {

	private static final String TPL_CODE = "login-template.ftl";

	@Override
	public void authenticate(AuthenticationFlowContext context) {
		context.challenge(context.form().setAttribute("realm", context.getRealm()).createForm(TPL_CODE));

	}

	@Override
	public void action(AuthenticationFlowContext context) {

	}

	@Override
	public boolean requiresUser() {
		return true; // Define if user is required for the authentication flow
	}

	@Override
	public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
		return true; // Define any configuration check for the user
	}

	@Override
	public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
		// Optional: Define required actions for the user
	}

	@Override
	public void close() {
		// Clean-up resources if needed
	}

}
