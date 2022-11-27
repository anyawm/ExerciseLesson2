package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class RegistrationWithPOAndFakerTests extends TestBase {


    @Test
    void successfulRegistrationTest() {

        Faker faker = new Faker();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String[] birthday = dateFormat.format(faker.date().birthday()).split(" ");

        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userPhone = faker.phoneNumber().subscriberNumber(10),
                userBirthDay = birthday[0],
                userBirthMonth = birthday[1],
                userBirthYear = birthday[2],
                userAddress = faker.address().fullAddress();


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Other")
                .setPhone(userPhone)
                .setBirthDay(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject("Math")
                .setHobbies("Sports")
                .setAddress(userAddress)
                .setState("NCR")
                .setCity("Delhi")
                .setPhoto("img/kote.jpg")
                .submitButton()
                .registrationResultsModalAppears()
                .verifyResults("Student name", userName + " " + lastName)
                .verifyResults("Student email", userEmail)
                .verifyResults("Gender", "Other")
                .verifyResults("Mobile", userPhone)
                .verifyResults("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResults("Subjects", "Maths")
                .verifyResults("Hobbies", "Sports")
                .verifyResults("Picture", "kote.jpg")
                .verifyResults("Address", userAddress)
                .verifyResults("State and City", "NCR Delhi");
    }
}

