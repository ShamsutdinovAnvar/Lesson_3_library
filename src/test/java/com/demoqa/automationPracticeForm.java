package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        $("#firstName").setValue("Anvar");
        $("#lastName").setValue("Shamsutdinov");
        $("#userEmail").setValue("a.shams@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7924485030");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Radio").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("fun.jpg");

        $("#currentAddress").setValue("Address, Street, Building");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
/*
        $(".table-responsive").shouldHave(text("Anvar Shamsutdinov"),
                text("a.shams@mail.com"),
                text("Male"),
                text("7924485030"),
                text("13 August,1987"),
                text("Radio"),
                text("Sports"),
                text("fun.jpeg"),
                text("Address, Street, Building"),
                text("NCR Delhi"));

 */
    }
}
