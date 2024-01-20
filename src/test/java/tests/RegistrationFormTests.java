package tests;

import org.junit.jupiter.api.Test;
import testData.*;
import pages.RegistrationPage;

public class RegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .submit()
                .checkSubmitResult(registrationPage.tableName, testData.fullName)
                .checkSubmitResult(registrationPage.tableGender, testData.gender)
                .checkSubmitResult(registrationPage.tableMobile, testData.phone);
    }

    @Test
    void fullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .setPicture(testData.picture)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit()
                .checkSubmitResult(registrationPage.tableName, testData.fullName)
                .checkSubmitResult(registrationPage.tableEmail, testData.email)
                .checkSubmitResult(registrationPage.tableGender, testData.gender)
                .checkSubmitResult(registrationPage.tableMobile, testData.phone)
                .checkSubmitResult(registrationPage.tableDateOfBirth, testData.birthFull)
                .checkSubmitResult(registrationPage.tableSubjects, testData.subject)
                .checkSubmitResult(registrationPage.tableHobbies, testData.hobby)
                .checkSubmitResult(registrationPage.tablePicture, testData.picture)
                .checkSubmitResult(registrationPage.tableAddress, testData.address)
                .checkSubmitResult(registrationPage.tableStateAndCity, testData.stateAndCity);
    }

    @Test
    void emptySubmitTest() {
        registrationPage.openPage().submit().checkValidation();
    }

}