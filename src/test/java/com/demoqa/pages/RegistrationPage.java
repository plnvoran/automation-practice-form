package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.data.ValuesForRegistrationsTest;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModalComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModalComponent resultsModal = new ResultsModalComponent();

    public static String
            studentNameField = "Student Name",
            studentEmailField = "Student Email",
            genderField = "Gender",
            mobileField = "Mobile",
            dateBirthField = "Date of Birth",
            subjectsField = "Subjects",
            hobbiesField = "Hobbies",
            pictureField = "Picture",
            addressField = "Address",
            stateCityField = "State and City",
            sizesTitleField = "Thanks for submitting the form";
    // Locators
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            pictureUploadInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateAndCity = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    // Actions
    public RegistrationPage openPage() {

        open("/automation-practice-form");

        formHeaderText.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }


    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String path, String value) {
        pictureUploadInput.uploadFile(new File(path + value));
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateAndCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateAndCity.$(byText(value)).click();

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);

        return this;
    }

    public void verifyResult(ValuesForRegistrationsTest student) {
        resultsModal.verifyResult(studentNameField, student.nameValue + " " + student.lastNameValue);
        resultsModal.verifyResult(studentEmailField, student.emailValue);
        resultsModal.verifyResult(genderField, student.genderValue);
        resultsModal.verifyResult(mobileField, student.numberValue);
        resultsModal.verifyResult(dateBirthField, student.dayValue + " " + student.monthValue + "," + student.yearValue);
        resultsModal.verifyResult(subjectsField, student.subjectValue);
        resultsModal.verifyResult(hobbiesField, student.hobbyValue);
        resultsModal.verifyResult(pictureField, student.fileValue);
        resultsModal.verifyResult(addressField, student.addressValue);
        resultsModal.verifyResult(stateCityField, student.stateValue + " " + student.cityValue);

    }


}