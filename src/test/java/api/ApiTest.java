package api;

import com.github.javafaker.Faker;
import helper.Auth;
import helper.TestData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;


public abstract class ApiTest {
    public static RequestSpecification requestSpecification;
    public static RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    public static Faker faker = new Faker();


    static {
        requestSpecification = requestSpecBuilder.setAuth(oauth2(Auth.getPageAccessToken()))
                .setBaseUri("https://graph.facebook.com/v8.0")
                .build();
    }

    @BeforeEach
    void before() {
        TestData.deleteAllPosts();
    }
}
