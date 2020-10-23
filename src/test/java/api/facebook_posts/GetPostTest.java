package api.facebook_posts;

import api.ApiTest;
import helper.Auth;
import helper.TestData;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class GetPostTest extends ApiTest {

    @Test
    void getTwoPostsTest() {
        String message1 = faker.harryPotter().character();
        String message2 = faker.harryPotter().character();
        String postId1 = TestData.createPost(message1);
        String postId2 = TestData.createPost(message2);

        given().spec(requestSpecification)
                .when().get(Auth.getPageId() + "/feed")
                .then().statusCode(200)
                .body("data.size()", is(2))
                .body("data[0]", hasKey("created_time"))
                .body("data[0]", hasEntry("id", postId2))
                .body("data[0]", hasEntry("message", message2))
                .body("data[1]", hasKey("created_time"))
                .body("data[1]", hasEntry("id", postId1))
                .body("data[1]", hasEntry("message", message1));

    }
}