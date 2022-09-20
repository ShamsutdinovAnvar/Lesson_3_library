package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class automationPracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $("[id=\"firstName\"]").setValue("Anvar");
        $("[id = \"lastName\"]").setValue("Shamsutdinov");
        $("[id = \"userEmail\"]").setValue("user@mail.com");
        $("[for=\"gender-radio-1\"]").click();
        $("[id = \"userNumber\"]").setValue("89244850000");
        $("[id = \"dateOfBirthInput\"]").click();

    }
}
