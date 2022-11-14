import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

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
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("9998989789"); //10 цифр
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__day--018").click();
        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").setValue("a");
        $("#react-select-2-option-2").click();
        $x("//label[text()='Reading']").click(); //не смогла сделать через CSS
        //$("#uploadPicture").click();
        //$("[id=uploadPicture]").uploadFile(new File("src/picture/kote.jpg"));
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $x("//td[text()='Lola Manola']");
        $(".modal-content").shouldHave(Condition.text("email@domain.com"));
        /* "email@domain.com"
                ("Female"),
                ("9998989789"));
         $x("//td[text()='18 June,1987']");
         $x("//td[text()='Arts']");
         $x("//td[text()='Reading']");
         $x("//td[text()='Russia']");
         $x("//td[text()='NCR Gurgaon']");
        */

    }
}
