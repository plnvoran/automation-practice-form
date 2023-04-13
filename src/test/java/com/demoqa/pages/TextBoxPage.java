package com.demoqa.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    // Locator
    SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            output = $("#output");

    // Actions
    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public TextBoxPage verifyResult(String key, String value) {
        output.$(byText(key)).shouldHave(text(value));

        return this;
    }

}

