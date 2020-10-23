package helper;

import api.ApiTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class TestData extends ApiTest {

    @Test
    public static void deleteAllPosts() {
        ArrayList<String> postIds = given().spec(requestSpecification)
                .when().get(Auth.getPageId() + "/feed")
                .then().extract().path("data.id");
        if (postIds != null) {
            postIds.forEach(id -> given().spec(requestSpecification)
                    .when().delete(id).then().log().all().statusCode(200));
        }
    }

    @Test
    public static String createPost(String postText) {
        return given().spec(requestSpecification)
                .param("message", postText)
                .when().post(Auth.getPageId() + "/feed")
                .then().statusCode(200).extract().path("id");
    }
}
