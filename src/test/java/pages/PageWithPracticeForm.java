package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageWithPracticeForm {

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    //private final SelenideElement yearDateInput = $(".react-datepicker__year-select"); //убрал в календарь компонент
    //private final SelenideElement monthDateInput = $(".react-datepicker__month-select"); //убрал в календарь компонент
    //private final SelenideElement dayDateInput = $(".react-datepicker__day--023"); //убрал в календарь компонент
    private final SelenideElement subjectInput = $("#subjectsContainer input");
    private final SelenideElement hobbiesInput = $("#hobbiesWrapper");
    private final SelenideElement uploadFileInput = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement selectCityAndStateInput = $("#stateCity-wrapper");
    private final SelenideElement submitInput = $("#submit");
    private final SelenideElement assertModalDialogInput = $(".modal-dialog");
    private final SelenideElement assertExampleModalSizeInput = $("#example-modal-sizes-title-lg");
    private final SelenideElement assertTableCheckInput = $(".table-responsive");

    @Step("Открыть страницу с формой")
    public void openPage() {
        open("/automation-practice-form"); //всегда выше чем перекрытие баннера
        removeBannersAndFooter();
    }

    @Step("Заполнить поле 'Имя': {value}")
    public PageWithPracticeForm setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить поле 'Фамилия': {value}")
    public PageWithPracticeForm setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить поле 'Email': {value}")
    public PageWithPracticeForm setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбрать пол: {value}")
    public PageWithPracticeForm setGender(String value) {
        genderInput.$(byText(value)).click(); //добавить $(byText(value))
        return this;
    }

    @Step("Заполнить поле 'Номер телефона': {value}")
    public PageWithPracticeForm setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Установить дату рождения: {day}/{month}/{year}")
    public PageWithPracticeForm setDateOfBirth(String day, String month, String year) { //для даты создал отдельный компонент
        dateOfBirthInput.click();
        CalendarComponent.setBirthDate(day, month, year);
        return this;
    }

    @Step("Заполнить поле 'Предметы': {value}")
    public PageWithPracticeForm setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать хобби: {value}")
    public PageWithPracticeForm setHobbies(String value) {
        hobbiesInput.$(byText(value)).click(); //добавить $(byText(value))
        return this;
    }

    @Step("Загрузить файл: {value}")
    public PageWithPracticeForm setUpload(String value) {
        uploadFileInput.uploadFromClasspath(value); //работает везде, где есть загрузчик файлов
        return this;
    }

    @Step("Заполнить поле 'Адрес': {value}")
    public PageWithPracticeForm setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Выбрать штат: {value}")
    public PageWithPracticeForm setState(String value) {
        removeBannersAndFooter();
        Selenide.executeJavaScript("window.scrollBy(0,500);"); //делаем прокрутку ОБЯЗАТЕЛЬНО
        stateInput.click();
        selectCityAndStateInput.$(byText(value)).click(); //добавить $(byText(value))
        return this;
    }

    @Step("Выбрать город: {value}")
    public PageWithPracticeForm setCity(String value) {
        removeBannersAndFooter();
        cityInput.click();
        selectCityAndStateInput.$(byText(value)).click(); //добавить $(byText(value))
        return this;
    }

    @Step("Отправить форму")
    public PageWithPracticeForm setSubmit() {
        removeBannersAndFooter();
        Selenide.executeJavaScript("arguments[0].click();", submitInput); //Если прокрутка не помогает, можно использовать JavaScript для выполнения клика. Это обойдет любые проблемы с перекрытием.
        //submitInput.click();
        return this;
    }

    @Step("Проверить, что модальное окно появилось")
    public PageWithPracticeForm setModalDialog() { //проверка, что таблица появилась
        assertModalDialogInput.should(appear);
        return this;
    }

    @Step("Проверить заголовок таблицы: {value}")
    public PageWithPracticeForm setTableHeaderCheck(String value) { //проверка заголовка
        assertExampleModalSizeInput.shouldHave(text(value));
        return this;
    }

    @Step("Проверить строку таблицы: {key} имеет значение: {value}")
    public PageWithPracticeForm setTableCheck(String key, String value) { //проверка заполненности строк в таблице
        assertTableCheckInput.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    private void removeBannersAndFooter() { //МЕТОД, КОТОРЫЙ УБИРАЕТ ВСЕ БАННЕРЫ, НУЖНО СВЫВОДИТЬ В ОТДЕЛЬНЫЙ КЛАСС И ДОБАЛЯТЬ В OPEN
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
    }
}