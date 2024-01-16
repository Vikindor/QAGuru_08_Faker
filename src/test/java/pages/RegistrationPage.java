package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalWindowComponent;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement userForm = $("#userForm"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ModalWindowComponent modalWindowComponent = new ModalWindowComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String filename) {
        pictureInput.uploadFromClasspath("img/"+filename);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkSubmitResult(String fieldName, String value) {
        modalWindowComponent.checkSubmitForm(fieldName, value);
        return this;
    }

    public RegistrationPage checkValidation() {
        String valueName = "border-color";
        String colorRed = "rgb(220, 53, 69)";
        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue(valueName,colorRed));
        lastNameInput.shouldHave(cssValue(valueName,colorRed));
        genderInput.$("label[for='gender-radio-1']").shouldHave(cssValue(valueName,colorRed)); //Male
        genderInput.$("label[for='gender-radio-2']").shouldHave(cssValue(valueName,colorRed)); //Female
        genderInput.$("label[for='gender-radio-3']").shouldHave(cssValue(valueName,colorRed)); //Other
        numberInput.shouldHave(cssValue(valueName,colorRed));
        return this;
    }

}