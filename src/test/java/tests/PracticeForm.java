package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
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

        executeJavaScript("$('footer').remove()"); // удаление футера
        executeJavaScript("$('#fixedban').remove()"); //удаление рекламы конкретной


        $("#firstName").setValue("Lola");
        $("#lastName").setValue("Manola");
        $("#userEmail").setValue("email@domain.com");
        //$("#gender-radio-2").doubleClick();
        //$("#gender-radio-2").parent().click();
        //$(byText("Female")).click();
        //$("[for = gender-radio-2]").click(); //very good
        $("#genterWrapper").$(byText("Female")).click(); // best
        $("#userNumber").setValue("9998989789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("June");
        //$(".react-datepicker__month-select").selectOptionByValue("6");
        //$(".react-datepicker__day--018").click();
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); //если видно две одинаковые даты разных месяцев
        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").setValue("a");
        $("#react-select-2-option-2").doubleClick();
        //$("#subjectsInput").setValue("Arts").pressEnter();
        //$x("//label[text()='Reading']").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        //$("[id=uploadPicture]").uploadFile(new File("src/test/resources/kote.jpg"));
        $("#uploadPicture").uploadFromClasspath("img/kote.jpg"); //работает только для эелемента у которго есть type = "file"
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();


         $(".table-responsive").shouldHave(text("email@domain.com")
        ,text("Female")
        ,text("9998989789")
        ,text("30 June,1987")
        ,text("Arts")
        ,text("Picture")
        ,text("Russia")
        ,text("NCR Gurgaon")
        );
    }
}
