package com.example.authenticator;

import com.google.auto.service.AutoService;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ServerInfoAwareProviderFactory;

import java.util.LinkedList;
import java.util.Map;
import java.util.List;

@AutoService(AuthenticatorFactory.class)
public class CustomAuthenticatorFactory implements AuthenticatorFactory, ServerInfoAwareProviderFactory{

	public static final String PROVIDER_ID = "custom-authenticator";

	private static final CustomAuthenticator SINGLETON = new CustomAuthenticator();

	@Override
	public String getId() {
		return PROVIDER_ID;
	}

	@Override
	public String getDisplayType() {
		return "Custom Authentication";
	}

	@Override
	public String getHelpText() {
		return "Custom Authentication description.";
	}

	@Override
	public String getReferenceCategory() {
		return "authenticator";
	}

	@Override
	public boolean isConfigurable() {
		return true;
	}

	@Override
	public boolean isUserSetupAllowed() {
		return true;
	}

	@Override
	public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
		return REQUIREMENT_CHOICES;
	}

	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		// Example of adding different types of configuration properties
		return List.of(
				new ProviderConfigProperty("exampleString", "Example String", "Description for the string property.", ProviderConfigProperty.STRING_TYPE, "Default value"),
				new ProviderConfigProperty("exampleBoolean", "Example Boolean", "Description for the boolean property.", ProviderConfigProperty.BOOLEAN_TYPE, true),
				new ProviderConfigProperty("exampleList", "Example List", "Description for the list property.", ProviderConfigProperty.LIST_TYPE, new LinkedList<>(List.of("Item 1", "Item 2")))
		);
	}


	@Override
	public Authenticator create(KeycloakSession session) {
		return SINGLETON;
	}

	@Override
	public Map<String, String> getOperationalInfo() {
		// Include the version in Admin Console UI
		return OperationalInfo.get();
	}

	@Override
	public void init(Config.Scope config) {
		// Initialization logic if required
	}

	@Override
	public void postInit(KeycloakSessionFactory factory) {
		// Post-initialization logic if required

	}

	@Override
	public void close() {
		// Clean-up logic if needed

	}

}
