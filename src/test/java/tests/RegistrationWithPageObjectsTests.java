package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String userName = "Alex";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Егоров")
                .setLastName("alex@egorov.com")
                .setGender("Other")
                .setPhone("1234567890")
                .setBirthDay(day: "30", month: "July", year: "2008");

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Egorov"),
                text("alex@egorov.com"), text("1234567890"));
    }

    @Test
    void successfulRegistrationTestVer0() {
        String userName = "Alex";

        registrationPage.openPage();

        registrationPage.setFirstName(userName);
        registrationPage.setLastName("Егоров");
        registrationPage.setLastName("alex@egorov.com");
        registrationPage.setGender("Other");
        registrationPage.setPhone("1234567890");

        $("#dateOfBirthInput").click();
// ...
    }
}