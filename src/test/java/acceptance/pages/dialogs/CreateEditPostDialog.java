package acceptance.pages.dialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateEditPostDialog {
    private final static SelenideElement createPostLabel = $x("//form[@method='POST']//span[contains(text(), 'Create Post')]");
    private final static SelenideElement publishPostBtn = $x("//div[contains(text(), 'Post')]");
    private final static SelenideElement savePostBtn = $x("//div[contains(text(), 'Save')]");
    private final static SelenideElement postText = $("span[data-text]");

    public static SelenideElement getCreatePostLabel() {
        return createPostLabel;
    }

    public static SelenideElement getPublishPostBtn() {
        return publishPostBtn;
    }

    public static SelenideElement getSavePostBtn() {
        return savePostBtn;
    }

    public static SelenideElement getPostText() {
        return postText;
    }
}
