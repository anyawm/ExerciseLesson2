import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CSSXpathExamples {

    void CSSXpathExamples() {
        // <input type = "email" class = "inputText login _form_input_box" name = "email" id = "email" data-testid = "email"
        // data-testid - идеальный вариант, если он есть, его добавляют разработчики специально для тестов
        $("[data-testid=email]").setValue("1"); //или
        $(by("data-testid", "email")).setValue("1");

        // если data-testid нет
        // <input type = "email" class = "inputText login _form_input_box" name = "email" id = "email"
        $("[id=email]").setValue("1"); //или
        $("#email").setValue("1"); //# сокращение для id  или
        $x("//*[@id=email]").setValue("1");

        //если нет id
        // <input type = "email" class = "inputText login_form_input_box" name = "email"
        $("[name=email]").setValue("1"); //или
        $(byName("email")).setValue("1");

        // <input type = "email" class = "inputText login _form_input_box"
        $("[class = login_form_input_box]").setValue("1"); //или
        $(".login_form_input_box").setValue("1"); //. сокращение для class или
        $(".login_form_input_box.inputText").setValue("1"); //или
        $("input.login_form_input_box.inputText").setValue("1"); //или
        $x("//input[@class='login_form_input_box'][@class=inputText']").setValue("1");

        /*
        <div class="inputText">
            <input type = "email" class = "login _form_input_box"
        </div>
         */
        $(".login_form_input_box .inputText").setValue("1"); //пробел означает что ищем новый элемент //или
        $(".login_form_input_box").$(".inputText").setValue("1");

        // <div>Hello qa.guru </div>
        $x("//div[text()='Hello qa.guru']");
        $(withText("Hello qa.guru"));
        $(byText("Hello qa.guru"));

    }

}

