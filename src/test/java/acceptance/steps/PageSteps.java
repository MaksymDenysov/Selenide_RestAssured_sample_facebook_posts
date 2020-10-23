package acceptance.steps;

import acceptance.pages.FacebookPage;
import acceptance.pages.dialogs.ChatDirectlyWithCustomersDlg;
import acceptance.pages.dialogs.CreateEditPostDialog;
import acceptance.pages.dialogs.DeletePostDlg;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class PageSteps {
    @When("user navigated to the test page")
    public void userNavigatedToTheTestPage() {
        FacebookPage.open();
    }

    @Then("{string}, {string} posts are shown")
    public void postsAreShown(String post1, String post2) {
        for (String s : Arrays.asList(post1, post2)) {
            FacebookPage.getPostByText(s).shouldBe(visible);
        }
    }

    @When("user clicks on Create Post button")
    public void userClicksOnCreatePostButton() {
        FacebookPage.getCreatePostBtn().click();
    }

    @Then("Create Post dialog is shown")
    public void createPostDialogIsShown() {
        CreateEditPostDialog.getCreatePostLabel().shouldBe(visible);
    }

    @When("user enters {string} post text")
    public void userEntersPostText(String postText) {
        Selenide.getFocusedElement().sendKeys(postText);
    }

    @And("user presses publish Post button")
    public void userPressesPublishPostButton() {
        CreateEditPostDialog.getPublishPostBtn().click();
    }

    @Then("{string} post is shown on the page")
    public void postIsShownOnThePage(String postText) {
        FacebookPage.getPostByText(postText).shouldBe(visible);
    }

    @And("user opens Edit post dialog")
    public void userOpensEditPostDialog() {
        FacebookPage.getPostActionsMenuBtn().click();
        FacebookPage.getEditPostBtn().click();
    }

    @And("users enters {string} as new text for the post")
    public void usersEntersAsNewTextForThePost(String newText) {
        CreateEditPostDialog.getPostText().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        CreateEditPostDialog.getPostText().sendKeys(Keys.DELETE);
        Selenide.getFocusedElement().sendKeys(newText);
    }

    @And("user saves the post")
    public void userSavesThePost() {
        CreateEditPostDialog.getSavePostBtn().click();
        ChatDirectlyWithCustomersDlg.getCloseDialogBtn().click();
    }

    @And("user deletes post number {int}")
    public void userDeletesPostNumber(int postNumber) {
        FacebookPage.getPostActionsMenuButtons().get(postNumber - 1).click();
        FacebookPage.getDeletePostBtn().click();
        DeletePostDlg.getDeleteBtn().click();

    }

    @Then("amount of posts is {int}")
    public void amountOfPostsIs(int expextedPostsAmount) {
        FacebookPage.getPostActionsMenuButtons().shouldHave(CollectionCondition.size(expextedPostsAmount));
    }
}
