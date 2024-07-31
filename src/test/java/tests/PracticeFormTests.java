package tests;

import org.junit.jupiter.api.Test;
import pages.PageWithPracticeForm;

public class PracticeFormTests extends TestBase {

    PageWithPracticeForm pageWithPracticeForm = new PageWithPracticeForm();

    @Test
void checkAllFields() {
        pageWithPracticeForm.openPage();
        pageWithPracticeForm.setFirstNameInput("Evgeny");
        pageWithPracticeForm.setLastNameInput("Mihailov");
        pageWithPracticeForm.setEmailInput("jekkka23@mail.ru");
        pageWithPracticeForm.setGender("Female");
        pageWithPracticeForm.setUserNumber("1111111111");
        pageWithPracticeForm.setDateOfBirth("23", "February", "1995");
        pageWithPracticeForm.setSubject("History");
        pageWithPracticeForm.setHobbies("Sports");
        pageWithPracticeForm.setUpload("testsPhoto.png");
        pageWithPracticeForm.setCurrentAddress("Russia");
        pageWithPracticeForm.setState("NCR");
        pageWithPracticeForm.setCity("Delhi");
        pageWithPracticeForm.setSubmit();
    }


}
