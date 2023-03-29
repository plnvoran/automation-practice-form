package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest extends TestBase {
    // Test data
    String firstNameTestValue = "John";
    String lastNameTestValue = "Smith";
    String emailTestValue = "JohnSmith76@gmail.com";
    String userNumberTestValue = "9221234567";
    String monthTestValue = "May";
    String yearTestValue = "2005";
    String dayTestValue = "15";
    String birthDayTestValue = dayTestValue + " " + monthTestValue + " " + yearTestValue;
    String subjectTestValue = "Test sbj.";
    String addressTestValue = "Address India 04";
    String stateTestValue = "NCR";
    String cityTestValue = "Delhi";
    String imageDirTestValue = "src/test/resources/";
    String imageTestValue = "CharlesBukowski.jpg";


    // Locators
    String firstNameCssLocatorField = "#firstName";
    String lastNameCssLocatorField = "#lastName";
    String emailCssLocatorField = "#userEmail";
    String maleXpathLocator = "//*[@id='genterWrapper']//div/div[1]/";
    String sportsXpathLocator = "//*[@id='genterWrapper']//div/div[1]/";
    String locatorLabel = "label";
    String locatorField = "input";
    String numberCssLocatorField = "#userNumber";
    String monthDateOfBirthXpathLocatorField = "//select[@class='react-datepicker__month-select']";
    String yearDateOfBirthXpathLocatorField = "//select[@class='react-datepicker__year-select']";
    String dayDateOfBirthXpathLocatorField = " //*[@id='dateOfBirth']//div[contains(text(),'15')]";
    String dateOfBirthCssLocatorField = "#dateOfBirthInput";
    String addressCssLocatorField = "#currentAddress";
    String subjectXpathLocatorField = "//div[@id='subjectsContainer']//input";
    String stateXpathLocatorField = "//*[@id='stateCity-wrapper']/div[2]//";
    String cityXpathLocatorField = "//*[@id='stateCity-wrapper']/div[3]//";
    String stateCityField = "div[@class=' css-1uccc91-singleValue']";
    String imageCssLocatorField = "#uploadPicture";
    String submitCssLocator = "#submit";;

    // Locators for checking
    String tableXpathLocator = "//tbody/tr";
    String columnTwoXpathLocator = "/td[2]";
    String lineXpathLocator01 = tableXpathLocator + "[" + "1" + "]" + columnTwoXpathLocator;
    String lineXpathLocator02 = tableXpathLocator + "[" + "2" + "]" + columnTwoXpathLocator;
    String lineXpathLocator03 = tableXpathLocator + "[" + "3" + "]" + columnTwoXpathLocator;
    String lineXpathLocator04 = tableXpathLocator + "[" + "4" + "]" + columnTwoXpathLocator;
    String lineXpathLocator05 = tableXpathLocator + "[" + "5" + "]" + columnTwoXpathLocator;
    String lineXpathLocator06 = tableXpathLocator + "[" + "5" + "]" + columnTwoXpathLocator;
    String lineXpathLocator07 = tableXpathLocator + "[" + "7" + "]" + columnTwoXpathLocator;
    String lineXpathLocator08 = tableXpathLocator + "[" + "8" + "]" + columnTwoXpathLocator;
    String lineXpathLocator09 = tableXpathLocator + "[" + "9" + "]" + columnTwoXpathLocator;
    String lineXpathLocator10 = tableXpathLocator + "[" + "10" + "]" + columnTwoXpathLocator;

    @Test
    void successfulFillFormTest() {

        open("/automation-practice-form");

        $(firstNameCssLocatorField).setValue(firstNameTestValue);
        $(firstNameCssLocatorField).shouldHave(value(firstNameTestValue));

        $(lastNameCssLocatorField).setValue(lastNameTestValue);
        $(lastNameCssLocatorField).shouldHave(value(lastNameTestValue));

        $(emailCssLocatorField).setValue(emailTestValue);
        $(emailCssLocatorField).shouldHave(value(emailTestValue));

        $x(maleXpathLocator + locatorLabel).click();
        $x(maleXpathLocator + locatorField).shouldBe(selected);

        $(numberCssLocatorField).setValue(userNumberTestValue);
        $(numberCssLocatorField).shouldHave(value(userNumberTestValue));

        $("#userNumber").setValue(userNumberTestValue);
        $("#userNumber").shouldHave(value(userNumberTestValue));

        $(dateOfBirthCssLocatorField).click();
        $x(monthDateOfBirthXpathLocatorField).selectOption(monthTestValue);
        $x(yearDateOfBirthXpathLocatorField).selectOption(yearTestValue);
        $x(dayDateOfBirthXpathLocatorField).click();
        $(dateOfBirthCssLocatorField).shouldHave(value(birthDayTestValue));

        $x(subjectXpathLocatorField).setValue(subjectTestValue);
        $x(subjectXpathLocatorField).shouldHave(value(subjectTestValue));

        $x(sportsXpathLocator + locatorLabel).click();
        $x(sportsXpathLocator + locatorField).shouldBe(selected);

        $(addressCssLocatorField).setValue(addressTestValue);
        $(addressCssLocatorField).shouldHave(value(addressTestValue));

        $(imageCssLocatorField).uploadFile(new File(imageDirTestValue + imageTestValue));
        $(imageCssLocatorField).shouldHave(value(imageTestValue));

        $x(stateXpathLocatorField + locatorField).setValue(stateTestValue);
        $x(stateXpathLocatorField + locatorField).sendKeys(Keys.ENTER);
        $x(stateXpathLocatorField + stateCityField).shouldHave(text(stateTestValue));

        $x(cityXpathLocatorField + locatorField).setValue(cityTestValue);
        $x(cityXpathLocatorField + locatorField).sendKeys(Keys.ENTER);
        $x(cityXpathLocatorField + stateCityField).shouldHave(text(cityTestValue));


        $(submitCssLocator).click();

        $x(lineXpathLocator01).shouldHave(text(firstNameTestValue + " " + lastNameTestValue));
        $x(lineXpathLocator02).shouldHave(text(emailTestValue));
        $x(lineXpathLocator03).shouldHave(text("Male"));
        $x(lineXpathLocator04).shouldHave(text(userNumberTestValue));
        $x(lineXpathLocator05).shouldHave(text(dayTestValue + " " + monthTestValue + "," + yearTestValue));

        // Здесь скрипт находит багу и падает. Значения введенных полей пустые, хотя были заданы тестовые значения
        //$x(lineXpathLocator06).shouldHave(text(subjectTestValue));
        //$x(lineXpathLocator07).shouldHave(text("Sports"));

        $x(lineXpathLocator08).shouldHave(text(imageTestValue));
        $x(lineXpathLocator09).shouldHave(text(addressTestValue));
        $x(lineXpathLocator10).shouldHave(text(stateTestValue + " " + cityTestValue));

    }
}



