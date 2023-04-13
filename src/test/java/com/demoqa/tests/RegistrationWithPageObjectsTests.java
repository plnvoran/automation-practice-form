package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("John")
                .setLastName("Smith")
                .setUserEmail("JohnSmith76@gmail.com")
                .setGender("Other")
                .setNumber("9221234567")
                .setBirthDate("15", "July", "2005")
                .setSubjects("Math")
                .setHobbies("Music")
                .uploadPicture("src/test/resources/","CharlesBukowski.jpg")
                .setCurrentAddress("Address India 04")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "John Smith")
                .verifyResult("Student Email", "JohnSmith76@gmail.com")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "9221234567")
                .verifyResult("Date of Birth", "15 July,2005")
                .verifyResult("Subjects", "Math")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "CharlesBukowski.jpg")
                .verifyResult("Address", "Address India 04")
                .verifyResult("State and City", "NCR Delhi");
    }
}
