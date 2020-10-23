package acceptance.steps;

import acceptance.pages.LoginPage;
import com.codeborne.selenide.Selenide;
import helper.Auth;
import helper.TestData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class LoginSteps {
    @Given("user is logged in to Facebook")
    public void userIsLoggedInToFacebook() {
        LoginPage.open();
        LoginPage.getEmailInput().sendKeys(Auth.getUserEmail());
        LoginPage.getPasswordInput().sendKeys(Auth.getUserPassword());
        LoginPage.getLoginBtn().click();
    }

    @Before
    public void cleanUp() {
        TestData.deleteAllPosts();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
