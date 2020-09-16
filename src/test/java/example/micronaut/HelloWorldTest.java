package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldTest {

    @Before
    public void setUp() {

        Map<String, Object> properties = new HashMap<>();
        properties.put("micronaut.server.idle-timeout", "3s");

        final ApplicationContext context = ApplicationContext
            .build()
            .properties(properties)
            .mainClass(EmbeddedServer.class)
            .start();

        RestAssured.port = context.getBean(EmbeddedServer.class).start().getPort();
    }

    @Test
    public void HelloWorld() {
        RestAssured.given()
            .get("/hello")
            .then()
            .statusCode(200);
    }
}
