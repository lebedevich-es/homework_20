package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.api.authorization.AuthApi;
import guru.qa.config.AppConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());
    String login = config.getLogin();
    String password = config.getPassword();
    AuthApi authApi = new AuthApi();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = config.getBaseUrl();
        RestAssured.baseURI = config.getBaseUrl();
    }
}
