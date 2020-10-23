package api.facebook_posts;

import api.ApiTest;
import helper.Auth;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

class CreatePostTest extends ApiTest {

    @Test
    void createSinglePostTest() {
        String message = faker.harryPotter().character();
        String postId = given().spec(requestSpecification)
                .param("message", message)
                .when().post(Auth.getPageId() + "/feed")
                .then().statusCode(200)
                .extract().path("id");

        given().spec(requestSpecification)
                .when().get(Auth.getPageId() + "/feed")
                .then().statusCode(200)
                .body("data[0]", hasEntry("id", postId));

    }
}