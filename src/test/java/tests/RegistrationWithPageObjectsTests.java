package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjectsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true; //чтобы браузер не закрывался
        Configuration.browserSize = "1920x1080"; // браузер определенного размера
        Configuration.baseUrl = "https://demoqa.com"; //?
    }

    @Test

     void fillFormTest() {

        String userName = "Anna";

        open("https://demoqa.com/text-box");

        // $("[id=userName]").setValue("Anna") # заменяет id=
        $("#userName").setValue(userName);
        $("#userEmail").setValue("email@domain.com");
        $("#currentAddress").setValue("Russia, Y");
        $("#permanentAddress").setValue("Russia, SP");
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(Condition.text(userName));
        $("#output #email").shouldHave(Condition.text("email@domain.com"));
        $("#output #currentAddress").shouldHave(Condition.text("Russia, Y"));
        $("#output #permanentAddress").shouldHave(Condition.text("Russia, SP"));
    }
}
