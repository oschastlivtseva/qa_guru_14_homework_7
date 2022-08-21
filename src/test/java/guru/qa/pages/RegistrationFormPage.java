package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.GeneralElementsComponent;
import guru.qa.pages.components.ResultsModalComponent;
import guru.qa.pages.components.UploadComponent;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private GeneralElementsComponent generalElementsComponent = new GeneralElementsComponent();
    private CalendarComponent calendarComponent = new CalendarComponent();
    private UploadComponent uploadComponent = new UploadComponent();
    private ResultsModalComponent resultsModalComponent = new ResultsModalComponent();

    private SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        genderSelection = $("#genterWrapper"),
        phoneNumberInput = $("#userNumber"),
        dateOfBirthInput = $("#dateOfBirthInput"),
        subjectsInput = $("#subjectsInput"),
        addressInput = $("#currentAddress"),
        stateSelection = $("#state"),
        citySelection = $("#city");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').hide()");

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        generalElementsComponent.inputInField(firstNameInput, firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        generalElementsComponent.inputInField(lastNameInput, lastName);

        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        generalElementsComponent.inputInField(emailInput, email);

        return this;
    }

    public RegistrationFormPage selectGender(String genderValue) {
        generalElementsComponent.clickRadioButton(genderSelection, genderValue);

        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        generalElementsComponent.inputInField(phoneNumberInput, phoneNumber);

        return this;
    }

    public RegistrationFormPage setBirthdayDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage selectSubject(String subjectValue) {
        generalElementsComponent.inputInAutoCompleteField(subjectsInput, subjectValue);

        return this;
    }

    public RegistrationFormPage selectHobby (String hobbyValue) {
        generalElementsComponent.clickCheckBox(hobbyValue);

        return this;
    }

    public RegistrationFormPage uploadPicture (String pictureName) {
        uploadComponent.uploadPicture(pictureName);

        return this;
    }

    public RegistrationFormPage setAddress (String address) {
        generalElementsComponent.inputInField(addressInput, address);

        return this;
    }

    public RegistrationFormPage selectState(String state) {
        stateSelection.scrollTo();
        generalElementsComponent.selectDropdownValue(stateSelection, state);

        return this;
    }

    public RegistrationFormPage selectCity(String city) {
        generalElementsComponent.selectDropdownValue(citySelection, city);

        return this;
    }

    public RegistrationFormPage submitForm() {
        generalElementsComponent.clickSubmitButton();

        return this;
    }

    public RegistrationFormPage checkResultsTableIsVisible() {
        resultsModalComponent.checkIsVisible();

        return this;
    }

    public RegistrationFormPage checkResults(String fieldName, String fieldValue) {
        resultsModalComponent.checkResult(fieldName, fieldValue);

        return this;
    }
}
