package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;
//import static tests.TestData.*;

public class RegistrationWithFakerTests extends TestBase { //наследуем TestBase

    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker(new Locale("ru"));


       String userName = faker.name().firstName();
       String lastName = faker.name().lastName();
       String userEmail = faker.internet().emailAddress();
       String userNumber = faker.phoneNumber().subscriberNumber(10);
       String currentAddress = faker.lebowski().quote();


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()"); //удаление конкретной рекламы
        executeJavaScript("$('footer').remove()"); //удаление футера

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click(); // best
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); //если в зоне видимости две одинаковые даты разных месяцев
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text(lastName),
                text(userEmail), text(userNumber), text(currentAddress));
    }

}