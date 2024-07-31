package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PageWithPracticeForm {

    public static SelenideElement firstNameInput = $("#firstName");
    public static SelenideElement lastNameInput = $("#lastName");
    public static SelenideElement emailInput = $("#userEmail");
    public static SelenideElement genderInput = $("#genterWrapper");
    public static SelenideElement userNumberInput = $("#userNumber");
    public static SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    //public static SelenideElement yearDateInput = $(".react-datepicker__year-select"); //убрал в календарь компонент
    //public static SelenideElement monthDateInput = $(".react-datepicker__month-select"); //убрал в календарь компонент
    //public static SelenideElement dayDateInput = $(".react-datepicker__day--023"); //убрал в календарь компонент
    public static SelenideElement subjectInput = $("#subjectsContainer input");
    public static SelenideElement hobbiesInput = $("#hobbiesWrapper");
    public static SelenideElement uploadFileInput = $("#uploadPicture");
    public static SelenideElement currentAddressInput = $("#currentAddress");
    public static SelenideElement stateInput = $("#state");
    public static SelenideElement cityInput = $("#city");
    public static SelenideElement selectCityAndStateInput = $("#stateCity-wrapper");
    public static SelenideElement submitInput = $("#submit");
    public static SelenideElement assertModalDialogInput = $(".modal-dialog");
    public static SelenideElement assertExampleModalSizeInput = $("#example-modal-sizes-title-lg");
    public static SelenideElement assertTableResponsiveInput = $(".table-responsive");

public void openPage() {
    open("/automation-practice-form");
}

public PageWithPracticeForm setFirstNameInput(String value) {
    firstNameInput.setValue(value);
    return this;
}

public PageWithPracticeForm setLastNameInput(String value) {
    lastNameInput.setValue(value);
    return this;
}

public PageWithPracticeForm setEmailInput(String value) {
    emailInput.setValue(value);
    return this;
}

public PageWithPracticeForm setGender(String value) {
    genderInput.$(byText(value)).click(); //добавить $(byText(value))
    return this;
}

public PageWithPracticeForm setUserNumber(String value) {
    userNumberInput.setValue(value);
    return this;
}

public PageWithPracticeForm setDateOfBirth(String day, String month, String year) { //для даты создал отдельный компонент
    dateOfBirthInput.click();
    CalendarComponent.setBirthDate(day, month, year);
    return this;
}

public PageWithPracticeForm setSubject (String value) {
    subjectInput.setValue(value).pressEnter();
    return this;
}

public PageWithPracticeForm setHobbies(String value) {
    hobbiesInput.$(byText(value)).click(); //добавить $(byText(value))
    return this;
}

public PageWithPracticeForm setUpload(String value) {
    //File file = new File("/Users/evgenymikhailov/Downloads/testsPhoto.png");
    uploadFileInput.uploadFromClasspath(value);
    return this;
}

public PageWithPracticeForm setCurrentAddress(String value) {
    currentAddressInput.setValue(value);
    return this;
}

public PageWithPracticeForm setState(String value) {
    stateInput.click();
    selectCityAndStateInput.$(byText(value)).click(); //добавить $(byText(value))
    return this;
}

public PageWithPracticeForm setCity(String value) {
     cityInput.click();
     selectCityAndStateInput.$(byText(value)).click(); //добавить $(byText(value))
     return this;
}

public PageWithPracticeForm setSubmit() {
    submitInput.click();
    return this;
}









}
