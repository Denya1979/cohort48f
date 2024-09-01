package classwork_31.ait.time.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateOperation {
    public static int getAge(String birthDate) {
        // TODO Homework
        LocalDate date = mapStringToLocalDate(birthDate);
        return (int) ChronoUnit.YEARS.between(date, LocalDate.now());
    }

    public static String[] sortStringDates(String[] dates) {
        // Homework
        String[] res = Arrays.copyOf(dates, dates.length); // копируем массив строк dates в массив строк res
        Arrays.sort(res, (d1, d2) -> mapStringToLocalDate(d1).compareTo(mapStringToLocalDate(d2))); // сортируем массив
        return res; // возвращяем отсортированный массив строк
    }

    // метод перегоняет массив строк в массив дат
    public static LocalDate[] mapStringsToDates(String[] dates){
        LocalDate[] res = new LocalDate[dates.length];
        for (int i = 0; i < dates.length; i++) {
            res[i] = mapStringToLocalDate(dates[i]);
        }
        return res;
    }

    private static LocalDate mapStringToLocalDate(String stringDate) {
        LocalDate res = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd][dd.MM.yyyy]"));

//		if (stringDate.contains("-")) {
//			res = LocalDate.parse(stringDate, DateTimeFormatter.ISO_LOCAL_DATE);
//		} else {
//			res = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		}

        return res;

    }
}
