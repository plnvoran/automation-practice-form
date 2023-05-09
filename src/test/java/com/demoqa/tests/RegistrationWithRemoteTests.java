package com.demoqa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.data.FieldsForRegistrationTestResult.*;
import static com.demoqa.data.ValuesForRegistrationsTest.*;
import static io.qameta.allure.Allure.step;

@Tag("practice_form")
public class RegistrationWithRemoteTests extends RemoteTestBase {

    @Test
    @Tag("smoke") @Tag("blocker")
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {
        step("Open the page with the form", () -> {
            registrationPage.openPage();
        });

        step("Filling the form", () -> {
            registrationPage.removeBanners()
                    .setFirstName(nameValue)
                    .setLastName(lastNameValue)
                    .setUserEmail(emailValue)
                    .setGender(genderValue)
                    .setNumber(numberValue)
                    .setBirthDate(dayValue, monthValue, yearValue)
                    .setSubjects(subjectValue)
                    .setHobbies(hobbyValue)
                    .uploadPicture(pathValue, fileValue)
                    .setCurrentAddress(addressValue)
                    .setState(stateValue)
                    .setCity(cityValue)
                    .clickSubmit();
        });

        step("Check the test results", () -> {
            registrationPage.verifyRegistrationResultsModalAppears()
                    .verifyResult(studentNameField, nameValue + " " + lastNameValue)
                    .verifyResult(studentEmailField, emailValue)
                    .verifyResult(genderField, genderValue)
                    .verifyResult(mobileField, numberValue)
                    .verifyResult(dateBirthField, dayValue + " " + monthValue + "," + yearValue)
                    .verifyResult(subjectsField, subjectValue)
                    .verifyResult(hobbiesField, hobbyValue)
                    .verifyResult(pictureField, fileValue)
                    .verifyResult(addressField, addressValue)
                    .verifyResult(stateCityField, stateValue + " " + cityValue);
        });
    }

}








