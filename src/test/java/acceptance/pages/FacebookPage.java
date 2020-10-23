package acceptance.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helper.Auth;
import helper.TestData;

import static com.codeborne.selenide.Selenide.*;

public class FacebookPage {
//    static String url = "TestPage-104616181413840";
    private static final SelenideElement createPostBtn = $("[aria-label='Create Post']");
    private static final SelenideElement postActionsMenuBtn = $("div[aria-haspopup='menu'][aria-label='Actions for this post']");
    private static final ElementsCollection postActionsMenuButtons = $$("div[aria-haspopup='menu'][aria-label='Actions for this post']");
    private static final SelenideElement editPostBtn = $x("//span[contains(text(), 'Edit post')]");
    private static final SelenideElement deletePostBtn = $x("//span[contains(text(), 'Delete post')]");

    private FacebookPage() {
        throw new IllegalStateException("Utility class");
    }

    public static void open() {
        Selenide.open(Auth.getPageUrl());
    }

    public static SelenideElement getPostByText(String text) {
        return $x("//div[contains(text(),'" + text + "')]");
    }

    public static SelenideElement getCreatePostBtn() {
        return createPostBtn;
    }

    public static SelenideElement getPostActionsMenuBtn() {
        return postActionsMenuBtn;
    }

    public static SelenideElement getEditPostBtn() {
        return editPostBtn;
    }

    public static ElementsCollection getPostActionsMenuButtons() {
        return postActionsMenuButtons;
    }

    public static SelenideElement getDeletePostBtn() {
        return deletePostBtn;
    }
}
