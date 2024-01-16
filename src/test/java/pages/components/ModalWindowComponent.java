package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponent {
    public void checkSubmitForm (String fieldName, String value) {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").$(byText(fieldName)).parent().shouldHave(text(value));
    }

    public void closeWindow() {
        $(".modal-footer").$("#closeLargeModal").click();
    }

}