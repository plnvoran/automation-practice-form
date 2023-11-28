package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "///E:/_Profession/HH/%D0%9E%D1%82%D0%BA%D0%BB%D0%B8%D0%BA%D0%B8%20%D0%B8%20%D0%BF%D1%80%D0%B8%D0%B3%D0%BB%D0%B0%D1%88%D0%B5%D0%BD%D0%B8%D1%8F.html";
        Configuration.browserSize = "1920x1080";
    }
}
