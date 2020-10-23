package acceptance.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final static SelenideElement loginBtn = $("button[name='login']");
    private final static SelenideElement emailInput = $("#email");
    private final static SelenideElement passwordInput = $("#pass");
    static String url = "";

    public static void open() {
        Selenide.open(url);
    }

    public static SelenideElement getLoginBtn() {
        return loginBtn;
    }

    public static SelenideElement getEmailInput() {
        return emailInput;
    }

    public static SelenideElement getPasswordInput() {
        return passwordInput;
    }
}
