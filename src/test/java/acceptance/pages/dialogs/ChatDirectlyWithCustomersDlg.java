package acceptance.pages.dialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ChatDirectlyWithCustomersDlg {
    private final static SelenideElement closeDialogBtn = $$("[aria-label='Not Now']").get(1);

    public static SelenideElement getCloseDialogBtn() {
        return closeDialogBtn;
    }
}
