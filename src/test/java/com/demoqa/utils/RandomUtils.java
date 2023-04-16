package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static String[] genders = {"Male", "Female", "Other"};
    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static String[] hobbies = {"Sports", "Reading", "Music"};
    private static String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    private static String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Biology", "Computer Science", "Commerce", "Accounting",
                                                  "Economics", "Arts", "Social Studies", "History", "Civics"};
    public static String[] citiesInNCR = new String[] {"Delhi", "Gurgaon", "Noida"};
    public static String[] citiesInUttarPradesh = new String[] {"Agra", "Lucknow", "Merrut"};
    public static String[] citiesInHaryana = new String[] { "Karnal", "Panipat"};
    public static String[] citiesInRajasthan = new String[] {"Jaipur", "Jaiselmer"};

    public static String generateRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String generateRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String generateRandomEmail() {
        return new Faker().internet().emailAddress("en");
    }

    public static String generateRandomGender() {
        return getRandomItemFromArray(genders);
    }

    public static String generateRandomPhone() {
        return new Faker().numerify("##########");
    }

    public static String generateRandomMonth() {
        return getRandomItemFromArray(months);
    }

    public static String generateRandomYear() {
        return Integer.toString(ThreadLocalRandom.current().nextInt(1923, 2023));
    }

    public static String generateRandomDay() {
        int day = ThreadLocalRandom.current().nextInt(1, 27);
        if (day < 10) {
            return "0" + day;
        } else {
            return  String.valueOf(day);
        }
    }

    public static String generateRandomSubject() {
        return getRandomItemFromArray(subjects);
    }

    public static String generateRandomHobby() {
        return getRandomItemFromArray(hobbies);
    }

    public static String generateRandomAddress() {
        return new Faker().address().fullAddress();
    }

    public static String generateRandomState() {
        return getRandomItemFromArray(states);
    }

    public static String generateRandomCity(String indianState) {
        switch (indianState) {
            case "NCR": {
                return getRandomItemFromArray(citiesInNCR);
            }
            case "Uttar Pradesh": {
                return getRandomItemFromArray(citiesInUttarPradesh);
            }
            case "Haryana": {
                return getRandomItemFromArray(citiesInHaryana);
            }
            case "Rajasthan": {
            return getRandomItemFromArray(citiesInRajasthan);
            }
        }
        return null;
    }
    public static String getRandomItemFromArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}