package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationWithPageObjectsTests extends TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void successfulRegistrationTest() {
        String userName = "Alex";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setPhone("1234567890")
                .setBirthDay( "30", "July", "2008")
                .setSubject("Math")
                .setHobbies("Sports")
                .setAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .setPhoto("img/kote.jpg")
                .submitButton()
                .registrationResultsModalAppears()
                .verifyResults("Student name", userName + " Egorov")
                .verifyResults("Student email", "alex@egorov.com")
                .verifyResults("Gender", "Other")
                .verifyResults("Mobile", "1234567890");
    }

   // @Test
   // void successfulRegistrationTestVer0() {
       // String userName = "Alex";

       // registrationPage.openPage();

       // registrationPage.setFirstName(userName);
       // registrationPage.setLastName("Егоров");
       // registrationPage.setLastName("alex@egorov.com");
      //  registrationPage.setGender("Other");
      //  registrationPage.setPhone("1234567890");

     //   $("#dateOfBirthInput").click();
// ...
   // }
}