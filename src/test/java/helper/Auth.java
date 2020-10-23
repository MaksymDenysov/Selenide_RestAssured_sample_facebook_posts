package helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static io.restassured.RestAssured.given;

public class Auth {
    private static final Properties properties;

    static {
        properties = new Properties();
        InputStream inputStream = Auth.class.getClassLoader().getResourceAsStream("credentials.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static String getPageAccessToken() {
        return given()
                .param("access_token", getUserAccessToken())
                .param("fields", "access_token")
                .when().get("https://graph.facebook.com/" + getPageId())
                .then().log().all().extract().path("access_token");
    }

    public static String getUserEmail() {
        return properties.getProperty("facebook_email");
    }

    public static String getUserPassword() {
        return properties.getProperty("facebook_password");
    }

    public static String getPageId() {
        return properties.getProperty("page_id");
    }

    public static String getPageUrl() {
        return "TestPage-" + getPageId();
    }

    public static String getUserAccessToken() {
        return properties.getProperty("long_term_user_access_token");
    }
}
