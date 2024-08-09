package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PageWithPracticeForm;

@Tag("regression")
class PracticeFormTests extends TestBase {

    PageWithPracticeForm pageWithPracticeForm = new PageWithPracticeForm();

    @Test

    public void checkFillingAllFieldsTest() { //Успешное заполнение всех полей формы
        pageWithPracticeForm.openPage();


        pageWithPracticeForm.setFirstNameInput("Evgeny")
                            .setLastNameInput("Mihailov")
                            .setEmailInput("jekkka23@mail.ru")
                            .setGender("Female")
                            .setUserNumber("1111111111")
                            .setDateOfBirth("23", "February", "1995")
                            .setSubject("History")
                            .setHobbies("Sports")
                            .setUpload("testsPhoto.png")
                            .setCurrentAddress("Russia")
                            .setState("NCR")
                            .setCity("Delhi")
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", "Evgeny Mihailov")
                            .setTableCheck("Student Email", "jekkka23@mail.ru")
                            .setTableCheck("Gender", "Female")
                            .setTableCheck("Mobile", "1111111111")
                            .setTableCheck("Date of Birth", "23 February,1995")
                            .setTableCheck("Subjects", "History")
                            .setTableCheck("Hobbies", "Sports")
                            .setTableCheck("Picture", "testsPhoto.png")
                            .setTableCheck("Address", "Russia")
                            .setTableCheck("State and City", "NCR Delhi");
    }

    @Test
    public void FormSubmissionWithoutFileUploadTest() { //Успешное заполнение формы без загрузки файла
        pageWithPracticeForm.openPage();

        pageWithPracticeForm.setFirstNameInput("Anna")
                            .setLastNameInput("Ivanova")
                            .setEmailInput("anna@mail.ru")
                            .setGender("Female")
                            .setUserNumber("2222222222")
                            .setDateOfBirth("15", "March", "1990")
                            .setSubject("Math")
                            .setHobbies("Reading")
                            .setCurrentAddress("Russia")
                            .setState("NCR")
                            .setCity("Delhi")
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", "Anna Ivanova")
                            .setTableCheck("Student Email", "anna@mail.ru")
                            .setTableCheck("Gender", "Female")
                            .setTableCheck("Mobile", "2222222222")
                            .setTableCheck("Date of Birth", "15 March,1990")
                            .setTableCheck("Subjects", "Math")
                            .setTableCheck("Hobbies", "Reading")
                            .setTableCheck("Address", "Russia")
                            .setTableCheck("State and City", "NCR Delhi");
    }

    @Test
    public void FormSubmissionWithMinimalDataTest() { //Успешное заполнение формы с минимальными данными
        pageWithPracticeForm.openPage();

        pageWithPracticeForm.setFirstNameInput("John")
                            .setLastNameInput("Doe")
                            .setEmailInput("john.doe@mail.com")
                            .setGender("Male")
                            .setUserNumber("3333333333")
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", "John Doe")
                            .setTableCheck("Student Email", "john.doe@mail.com")
                            .setTableCheck("Gender", "Male")
                            .setTableCheck("Mobile", "3333333333");
    }

    @Test
    public void FormSubmissionWithoutFirstNameTest() { //Ошибка при отсутствии обязательного поля "Имя"
        pageWithPracticeForm.openPage();

        pageWithPracticeForm.setLastNameInput("Doe")
                            .setEmailInput("john.doe@mail.com")
                            .setGender("Male")
                            .setUserNumber("3333333333")
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", "John Doe")
                            .setTableCheck("Student Email", "john.doe@mail.com")
                            .setTableCheck("Gender", "Male")
                            .setTableCheck("Mobile", "3333333333");
    }

    @Test
    public void FormSubmissionWithInvalidEmailTest() { //Ошибка при некорректном формате email
        pageWithPracticeForm.openPage();

        pageWithPracticeForm.setFirstNameInput("John")
                            .setLastNameInput("Doe")
                            .setEmailInput("john.doe@mail")
                            .setGender("Male")
                            .setUserNumber("3333333333")
                            .setSubmit()
                            .setModalDialog()
                            .setTableHeaderCheck("Thanks for submitting the form")
                            .setTableCheck("Student Name", "John Doe")
                            .setTableCheck("Student Email", "john.doe@mail.com")
                            .setTableCheck("Gender", "Male")
                            .setTableCheck("Mobile", "3333333333");


    }
}
