package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    Faker faker = new Faker();
    public String getFakerFirstName() {
        return faker.name().firstName();
    }

    public String getFakerLastName() {
        return faker.name().lastName();
    }

    public String getFakerEmail() {
        return faker.internet().emailAddress();
    }

    public String getFakerGender() {
        String[] genders = {"Male", "Female", "Other"};
        return new Faker().options().option(genders);
    }

    public String getFakerMobile() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getFakerSubjects() {
        String[] subjects = {"Maths", "Arts", "English", "Biology", "Hindi", "Commerce"};
        return new Faker().options().option(subjects);
    }

    public String getFakerHobbie() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobbies);
    }

    public String getFakerStreetAddress() {
        return faker.address().streetAddress();
    }

    //State and City
    private static final Map<String, String[]> citiesByState = new HashMap<>();

    static {
        citiesByState.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        citiesByState.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        citiesByState.put("Haryana", new String[]{"Karnal", "Panipat"});
        citiesByState.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }
    public static String randomState = getFakerState();
    private static String getFakerState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return new Faker().options().option(states);
    }

    public static String getFakerCity() {
        String[] cities = citiesByState.get(randomState);
        return new Faker().options().option(cities);
    }

    // Random generators
    public static void main(String[] args) { //Method to test random generators locally
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(111, 999_999_999));
        System.out.println(getRandomEmail());
        System.out.println(getRandomAddress());
        System.out.println(getRandomMobile());
        System.out.println(getRandomGender());
    }

    public static String getRandomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@" + getRandomString(10) + "." + getRandomString(3);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomMobile() { //+463 (223) 367-8872
        return String.format("+%s (%s) %s-%s", getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(111, 999),
                getRandomInt(1111, 9999));
    }

    public static String getRandomAddress() {
        return getRandomString(10) + " " + getRandomString(10) + ", "
                + getRandomInt(1, 99) + getRandomString(1);
    }

    public static String getRandomDay() {
        return String.valueOf(getRandomInt(1, 28));
    }

    public static String getRandomMonth() {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
            int index = getRandomInt(0, monthNames.length - 1);
            return monthNames[index];
    }

    public static String getRandomYear() {
        return String.valueOf(getRandomInt(1900, 2100));
    }

}