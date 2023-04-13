package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {
    @Test
    void successfulFillFormTest() {

        textBoxPage.openPage()
                .setFullName("John Smith")
                .setEmail("JohnSmith76@gmail.com")
                .setCurrentAddress("123000 India Delhi Rajpath 10")
                .setPermanentAddress("678000 India Bangalore Gandy 55")
                .clickSubmit();

        textBoxPage
                .verifyResult("Name:", "John Smith")
                .verifyResult("Email:", "JohnSmith76@gmail.com")
                .verifyResult("Current Address :", "123000 India Delhi Rajpath 10")
                .verifyResult("Permananet Address :", "678000 India Bangalore Gandy 55");

    }
}