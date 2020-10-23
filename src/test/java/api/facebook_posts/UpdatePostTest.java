package api.facebook_posts;

import api.ApiTest;
import helper.Auth;
import helper.TestData;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class UpdatePostTest extends ApiTest {

    @Test
    void updatePostMessageTest() {
        String oldMessage = faker.harryPotter().character();
        String newMessage = faker.harryPotter().character();
        String postId = TestData.createPost(oldMessage);

        given().spec(requestSpecification)
                .param("message", newMessage)
                .when().post(postId).then().statusCode(200)
                .body(is("{\"success\":true}"));

        given().spec(requestSpecification)
                .when().get(Auth.getPageId() + "/feed")
                .then().statusCode(200)
                .body("data.size()", is(1))
                .body("data[0]", hasKey("created_time"))
                .body("data[0]", hasEntry("id", postId))
                .body("data[0]", hasEntry("message", newMessage));

    }
}