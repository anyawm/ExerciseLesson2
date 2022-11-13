import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true; //чтобы браузер не закрывался
        Configuration.browserSize = "1920x1080"; // браузер определенного размера
        Configuration.baseUrl = "https://demoqa.com"; //?
    }
    @Test

    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Lola");
        $("#lastName").setValue("Manola");
        $("#userEmail").setValue("email@domain.com");
        //$("#gender-radio-2").click(); не работает
        $("#userNumber").setValue("9998989789"); //10 цифр
        //Date of Birth
        //Subjects
        //Hobbies
        //Picture
        $("#currentAddress").setValue("Russia");
        //State and City

        //$("#output").shouldBe(Condition.visible); новое окно

    }
}
