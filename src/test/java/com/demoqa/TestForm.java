package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {
    String firstName = "Anvar";
    String lastName = "Shamsutdinov";
    String Name = "Anvar Shamsutdinov";
    String email = "a.shams@gmail.com";
    String mobile = "0123456789";
    String subjects = "English";
    String currentAddress = "Lenin str.1";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkFormTest(){
        open("/automation-practice-form");
        //executeJavaScript("document.body.style.zoom='75%'");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(mobile);

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day--013").click();

        $("#subjectsInput").setValue(subjects).pressEnter();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("fun.jpg");
        $("#currentAddress").setValue(currentAddress);

        //State and City
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        //Submit
        executeJavaScript("$('footer').remove()");
        $("[id=submit]").pressEnter();

        //Check
        $(".table-responsive").shouldHave(text(Name),
                text(email),
                text("Male"),
                text(mobile),
                text("13 August,1987"),
                text("English"),
                text("Sports, Reading, Music"),
                text("fun.jpg"),
                text("Lenin str.1"),
                text("NCR Noida"));

        $ ("#closeLargeModal").click();
    }

}