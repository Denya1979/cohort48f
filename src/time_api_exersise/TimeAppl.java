package time_api_exersise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TimeAppl {

    public static void main(String[] args) { // current date
        LocalDate localDate = LocalDate.now(); // ISO-format
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("-----------------------------------------");

        LocalDate gagarin =  LocalDate.of(1961, 04, 12);
        System.out.println(gagarin);
        // What day of the week is it
        System.out.println(gagarin.getDayOfWeek());
        // What day of the year is it
        System.out.println(gagarin.getDayOfYear());
        // Checking if a year is a leap year
        int year = 2024;
        System.out.println("Is year" + year + "leap: " + Year.isLeap(year));
        System.out.println("----------------------------------");
        System.out.println(gagarin.isBefore(localDate)); // true
        System.out.println(gagarin.isAfter(localDate)); // false
        System.out.println("-----------------------------------");
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfWeek());
        System.out.println("-----------------------------------");
        LocalDate event = LocalDate.of(1961, 01, 01);
        System.out.println(localDate.compareTo(gagarin)); // years
        System.out.println(event.compareTo(gagarin)); // month
        event = LocalDate.of(1961, 04, 15);
        System.out.println(event.compareTo(gagarin)); //

        // travel in time
        LocalDate newDate = localDate.plusDays(10);
        System.out.println(newDate);

        newDate = localDate.minusDays(10);
        System.out.println(newDate);

        // ChronoUnits
        newDate = localDate.plus(12, ChronoUnit.DECADES);
        System.out.println(newDate);

        localDateTime = localDateTime.plus(10, ChronoUnit.MINUTES);
        System.out.println(localDateTime);

        localDateTime = localDateTime.plus(1, ChronoUnit.HALF_DAYS);


        System.out.println("------------------------PERIOD-----------------------------");

        long period = ChronoUnit.DAYS.between(gagarin,localDate);
        System.out.println(period);

        period = ChronoUnit.MONTHS.between(gagarin, localDate);
        System.out.println(period);

        LocalDate lenin = LocalDate.of(1870, 04, 22);

        period = ChronoUnit.DAYS.between(lenin, gagarin);
        System.out.println(period);

        System.out.println("------------------------DateTimeFormatter-----------------------------");
        DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;

        String date = gagarin.format(df);
        System.out.println(date);

        // выбрали другой формат
        df = DateTimeFormatter.ISO_LOCAL_DATE;
        date = gagarin.format(df);
        System.out.println(date);

        // задаем другой (собственный) формат
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date = gagarin.format(df);
        System.out.println(date);

        // задаем еще другой формат
        df = DateTimeFormatter.ofPattern("dd/M/yyyy");
        date = gagarin.format(df);
        System.out.println(date);

        // задаем еще другой формат
        df = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        date = gagarin.format(df);
        System.out.println(date);

        // задаем еще другой формат
        df = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRANCE);
        date = gagarin.format(df);
        System.out.println(date);

        System.out.println("--------------------------------");
        date = "27/08/2024"; // String
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        newDate = LocalDate.parse(date, df);
        System.out.println(newDate.toString());
        System.out.println(newDate.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.forLanguageTag("lv"))));

        System.out.println("//////////////////////////////////////////");

        // calculate years between dates
        LocalDate day = LocalDate.of(1979, 04, 24);
        int years = (int)ChronoUnit.YEARS.between(day, localDate);
        System.out.println(years);

        // parsing date from string
        System.out.println("------//////////////////////////////////////////------");
        String stringDate = "27:08:2024";
        LocalDate res = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd-MM-yyyy][dd:MM:yyyy]"));
        System.out.println(res);

    }
}
