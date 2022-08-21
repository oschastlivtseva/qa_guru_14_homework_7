package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstTest {
    Faker faker = new Faker();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String genderValue = "Other";
    int randomNum = faker.number().numberBetween(100000, 999999);
    String phoneNumber = "7888" + randomNum;
    String birthday = "03 September,1948";
    String year = "1948";
    String month = "8";
    String day = "003";
    String firstSubject = "Arts";
    String secondSubject = "Social Studies";
    String firstHobby = "Sports";
    String secondHobby = "Reading";
    String filename = "image-for-autotest.jpg";
    String currentAddress = faker.address().fullAddress();
    String state = "Haryana";
    String city = "Panipat";

    @BeforeEach
    void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "770x1024";
    }

    @Test
    void fillAutomationPracticeForm() {
        // fill all fields
        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(genderValue)
                .setPhoneNumber(phoneNumber)
                .setBirthdayDate(day, month, year)
                .selectSubject(firstSubject)
                .selectSubject(secondSubject)
                .selectHobby(firstHobby)
                .selectHobby(secondHobby)
                .uploadPicture(filename)
                .setAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        // check results
        registrationFormPage
                .checkResultsTableIsVisible()
                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", email)
                .checkResults("Gender", genderValue)
                .checkResults("Mobile", phoneNumber)
                .checkResults("Date of Birth", birthday)
                .checkResults("Subjects", firstSubject + ", " + secondSubject)
                .checkResults("Hobbies", firstHobby + ", " + secondHobby)
                .checkResults("Picture", filename)
                .checkResults("Address", currentAddress)
                .checkResults("State and City", state + " " + city);
    }
}
