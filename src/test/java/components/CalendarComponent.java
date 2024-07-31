package components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public static void setBirthDate(String day, String month, String year) { //говорю, что дату буду передавать с помощью строк дня месяца и года
        String dayDateInput = ".react-datepicker__day--0" + day;
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(dayDateInput).click();

    }
}
