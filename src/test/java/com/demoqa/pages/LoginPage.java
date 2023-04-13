package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    // Selenide elements
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement  gender = $("#genterWrapper");

    SelenideElement formHeaderText = $(".practice-form-wrapper");
    //Actions
    public LoginPage openPage() {
        open("/automation-practice-form");


        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public LoginPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public LoginPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public LoginPage setUserEmail(String value)
        {
            userEmailInput.setValue(value);
            return this;
        }

    public LoginPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }
}
