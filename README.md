This repository contains an example for developing a Keycloak extension locally.

**Learn more about Keycloak:**  
Explore Keycloak with **Keycloak Academy** and **try it for free** through the [Keycloak Training](https://www.keycloak.academy/).

### Developing custom Keycloak extension

* Implement the Provider Interface: Define the specific behavior you want to add or override.
* Implement the ProviderFactory Interface: Create a factory that knows how to instantiate your Provider.
* Package and deploy the JAR : To easily iterate without having to restart the server every time, load keycloak using `start-dev` with the included docker-compose file caching off: `docker compose up`

### Testing your extension

* Login to the admin console at `http://localhost:8080/auth/admin` with `admin:admin`

### Packaging the extension for deployment

* Run ` ./mvnw clean package` to build a jar that can be placed in the `provider` (Quarkus) or `standalone/deployments` (Wildfly) directory of your Keycloak installation.