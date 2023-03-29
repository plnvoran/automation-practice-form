package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest extends TestBase {

    String firstNameTestValue = "John";
    String lastNameTestValue = "Smith";
    String emailTestValue = "JohnSmith76@gmail.com";
    String genderTestValue = "Male";
    String userNumberTestValue = "9221234567";
    String hobbiesTestValue = "Sports";
    String monthTestValue = "May";
    String yearTestValue = "2005";
    String dayTestValue = "15";
    String subjectTestValue = "Maths";
    String addressTestValue = "Address India 04";
    String stateTestValue = "NCR";
    String cityTestValue = "Delhi";
    String imageDirTestValue = "src/test/resources/";
    String imageTestValue = "CharlesBukowski.jpg";

    @Test
    void successfulFillFormTest() {

        open("/automation-practice-form");

        $("#firstName").setValue(firstNameTestValue);
        $("#lastName").setValue(lastNameTestValue);
        $("#userEmail").setValue(emailTestValue);
        $("#genterWrapper").$(byText(genderTestValue)).click();
        $("#userNumber").setValue(userNumberTestValue);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(monthTestValue)).click();
        $(".react-datepicker__year-select").$(byText(yearTestValue)).click();
        $x("//*[@id='dateOfBirth']//div[contains(text(),'15')]").click();
        $("#subjectsContainer input").setValue(subjectTestValue).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbiesTestValue)).click();
        $("#uploadPicture").uploadFile(new File(imageDirTestValue + imageTestValue));
        $("#currentAddress").setValue(addressTestValue);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(stateTestValue)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(cityTestValue)).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(visible);
        $(".table-responsive").shouldHave(
                text(firstNameTestValue),
                text(lastNameTestValue),
                text(emailTestValue),
                text(genderTestValue),
                text(userNumberTestValue),
                text(dayTestValue + " " + monthTestValue + "," + yearTestValue),
                text(subjectTestValue),
                text(hobbiesTestValue),
                text(imageTestValue),
                text(addressTestValue),
                text(stateTestValue + " " + cityTestValue)
        );
    }
}



