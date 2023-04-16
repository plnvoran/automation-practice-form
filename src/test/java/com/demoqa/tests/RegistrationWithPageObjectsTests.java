package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import static com.demoqa.data.ValuesForRegistrationsTest.*;
import static com.demoqa.data.FieldsForRegistrationTestResult.*;
public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(nameValue)
                .setLastName(lastNameValue)
                .setUserEmail(emailValue)
                .setGender(genderValue)
                .setNumber(numberValue)
                .setBirthDate (dayValue, monthValue, yearValue)
                .setSubjects(subjectValue)
                .setHobbies(hobbyValue)
                .uploadPicture(pathValue, fileValue)
                .setCurrentAddress(addressValue)
                .setState(stateValue)
                .setCity(cityValue)
                .clickSubmit();

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
    }
}
