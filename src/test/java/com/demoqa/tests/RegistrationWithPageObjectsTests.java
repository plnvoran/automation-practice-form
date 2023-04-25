package com.demoqa.tests;

import com.demoqa.data.ValuesForRegistrationsTest;
import org.junit.jupiter.api.Test;
import static com.demoqa.data.ValuesForRegistrationsTest.*;

public class RegistrationWithPageObjectsTests extends TestBase {
    ValuesForRegistrationsTest     valuesForRegistrationsTest = new ValuesForRegistrationsTest();

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

        registrationPage.verifyRegistrationResultsModalAppears();
        registrationPage.verifyResult(valuesForRegistrationsTest);

    }
}
