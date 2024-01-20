package testData;

import com.github.javafaker.Faker;
import java.util.HashMap;

public class TestData {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName = String.format("%s %s", firstName, lastName),
            email = faker.internet().emailAddress(firstName.toLowerCase() + "." + lastName.toLowerCase()),
            gender = getGender(),
            phone = faker.phoneNumber().subscriberNumber(10),
            birthDay = String.valueOf(faker.number().numberBetween(1, 28)),
            birthMonth = getMonth(),
            birthYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            birthFull = String.format("%s %s,%s", birthDay, birthMonth, birthYear),
            subject = getSubject(),
            hobby = getHobbie(),
            picture = "file_example_JPG_100kB.jpg",
            address = faker.address().fullAddress(),
            city = getCity(),
            state = getStateByCity(city),
            stateAndCity = String.format("%s %s", state, city);

    private String getMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    private String getHobbie() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    private String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    private String getSubject() {
        return faker.options().option("Maths", "Arts", "English", "Biology", "Hindi", "Commerce");
    }

    private String getCity() {
        return faker.options().option("Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat",
                "Jaipur", "Jaiselmer");
    }

    private String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }

}