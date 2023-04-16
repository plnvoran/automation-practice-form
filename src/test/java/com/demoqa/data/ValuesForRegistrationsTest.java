package com.demoqa.data;

import static com.demoqa.utils.RandomUtils.*;

public class ValuesForRegistrationsTest {

    public static String
            nameValue = generateRandomFirstName(),
            lastNameValue = generateRandomLastName(),
            emailValue = generateRandomEmail(),
            genderValue = generateRandomGender(),
            numberValue = generateRandomPhone(),
            monthValue = generateRandomMonth(),
            yearValue = generateRandomYear(),
            dayValue = generateRandomDay(),
            subjectValue = generateRandomSubject(),
            hobbyValue = generateRandomHobby(),
            pathValue = "src/test/resources/",
            fileValue = "CharlesBukowski.jpg",
            addressValue = generateRandomAddress(),
            stateValue = generateRandomState(),
            cityValue = generateRandomCity(stateValue);
}