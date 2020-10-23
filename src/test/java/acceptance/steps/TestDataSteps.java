package acceptance.steps;

import helper.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.Arrays;

public class TestDataSteps {
    @And("posts {string},{string} were created")
    public void postsWereCreated(String post1, String post2) {
        Arrays.asList(post1, post2).forEach(TestData::createPost);
    }

    @Given("post {string} was created")
    public void postWasCreated(String postText) {
        TestData.createPost(postText);
    }
}
