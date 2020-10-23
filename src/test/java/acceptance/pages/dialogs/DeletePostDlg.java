package acceptance.pages.dialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DeletePostDlg {
    private final static SelenideElement deleteBtn = $("[aria-label='Delete']");

    public static SelenideElement getDeleteBtn() {
        return deleteBtn;
    }
}
