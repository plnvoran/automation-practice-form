package com.demoqa.utils;

import com.demoqa.data.enums.*;
import com.demoqa.data.enums.cities.CitiesHaryanaEnum;
import com.demoqa.data.enums.cities.CitiesNCREnum;
import com.demoqa.data.enums.cities.CitiesRajasthanEnum;
import com.demoqa.data.enums.cities.CitiesUttarProdeshEnum;
import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static int getRandomIndex(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static <T extends Enum<?>> T getRandomFromEnum(Class<T> enumClass) {
        return enumClass.getEnumConstants()[getRandomIndex(0,enumClass.getEnumConstants().length - 1)];
    }

    public static String generateRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String generateRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String generateRandomEmail() {
        return new Faker().internet().emailAddress("en");
    }

    public static String generateRandomGender()  {
        return getRandomFromEnum(GendersEnum.class).getName();
    }


    public static String generateRandomPhone() {
        return new Faker().numerify("##########");
    }

    public static String generateRandomMonth()  {
        return getRandomFromEnum(MonthsEnum.class).getName();
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

    public static String generateRandomSubject()
        {
            return getRandomFromEnum(SubjectsEnum.class).getName();
        }


    public static String generateRandomHobby() {
        return getRandomFromEnum(HobbiesEnum.class).getName();
    }

    public static String generateRandomAddress() {
        return new Faker().address().fullAddress();
    }


    public static String generateRandomState() {
        return getRandomFromEnum(StatesEnum.class).getName();
    }

    public static String generateRandomCity(String indianState) {
        switch (indianState) {
            case "NCR": {
                return getRandomFromEnum(CitiesNCREnum.class).getName();
            }
            case "Uttar Pradesh": {
                return getRandomFromEnum(CitiesUttarProdeshEnum.class).getName();
            }
            case "Haryana": {
                return getRandomFromEnum(CitiesHaryanaEnum.class).getName();
            }
            case "Rajasthan": {
            return getRandomFromEnum(CitiesRajasthanEnum.class).getName();
            }
        }
        return null;
    }

}