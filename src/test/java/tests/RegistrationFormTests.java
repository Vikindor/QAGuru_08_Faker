package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    String randomFirstname = randomUtils.getFakerFirstName(),
            randomLastName = randomUtils.getFakerLastName(),
            fullName = String.format("%s %s", randomFirstname, randomLastName),
            randomEmail = randomUtils.getFakerEmail(),
            randomGender = randomUtils.getFakerGender(),
            randomMobile = randomUtils.getFakerMobile(),
            randomDay = RandomUtils.getRandomDay(),
            randomMonth = RandomUtils.getRandomMonth(),
            randomYear = RandomUtils.getRandomYear(),
            birthDay = String.format("%s %s,%s", randomDay, randomMonth, randomYear),
            randomSubject = randomUtils.getFakerSubjects(),
            randomHobbie = randomUtils.getFakerHobbie(),
            randomAddress = randomUtils.getFakerStreetAddress(),
            randomState = RandomUtils.randomState,
            randomCity = RandomUtils.getFakerCity(),
            stateAndCity = String.format("%s %s", randomState, randomCity),
            picture = "file_example_JPG_100kB.jpg",
            tableName = "Student Name",
            tableEmail = "Student Email",
            tableGender = "Gender",
            tableMobile = "Mobile",
            tableDateOfBirth = "Date of Birth",
            tableSubjects = "Subjects",
            tableHobbies = "Hobbies",
            tablePicture = "Picture",
            tableAddress = "Address",
            tableStateAndCity = "State and City";

    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(randomFirstname)
                .setLastName(randomLastName)
                .setGender(randomGender)
                .setNumber(randomMobile)
                .submit()
                .checkSubmitResult(tableName, fullName)
                .checkSubmitResult(tableGender, randomGender)
                .checkSubmitResult(tableMobile, randomMobile);
    }

    @Test
    void fullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(randomFirstname)
                .setLastName(randomLastName)
                .setEmail(randomEmail)
                .setGender(randomGender)
                .setNumber(randomMobile)
                .setDateOfBirth(randomDay, randomMonth, randomYear)
                .setSubject(randomSubject)
                .setHobbies(randomHobbie)
                .setPicture(picture)
                .setAddress(randomAddress)
                .setState(randomState)
                .setCity(randomCity)
                .submit()
                .checkSubmitResult(tableName, fullName)
                .checkSubmitResult(tableEmail, randomEmail)
                .checkSubmitResult(tableGender, randomGender)
                .checkSubmitResult(tableMobile, randomMobile)
                .checkSubmitResult(tableDateOfBirth, birthDay)
                .checkSubmitResult(tableSubjects, randomSubject)
                .checkSubmitResult(tableHobbies, randomHobbie)
                .checkSubmitResult(tablePicture, picture)
                .checkSubmitResult(tableAddress, randomAddress)
                .checkSubmitResult(tableStateAndCity, stateAndCity);
    }

    @Test
    void emptySubmitTest() {
        registrationPage.openPage().submit().checkValidation();
    }

}