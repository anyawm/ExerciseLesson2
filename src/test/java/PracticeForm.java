import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {


    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test

    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Lola");
        $("#lastName").setValue("Manola");
        $("#userEmail").setValue("email@domain.com");
        $("#gender-radio-2").doubleClick();
        $("#userNumber").setValue("9998989789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__day--018").click();
        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").setValue("a");
        $("#react-select-2-option-2").click();
        //$x("//label[text()='Reading']").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/kote.jpg"));
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //$x("//td[text()='Lola Manola']");
        $(".table-responsive").shouldHave(text("email@domain.com")
        ,text("Female")
        ,text("9998989789")
        ,text("18 June,1987")
        ,text("Arts")
        ,text("Picture")
        ,text("Russia")
        ,text("NCR Gurgaon")
        );
    }
}
