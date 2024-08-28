package homework_30.week_days.week_days;

public class WeekDaysAppl{
    public static void main(String[] args) {

        WeekDays[] weekDays = WeekDays.values();

        System.out.println("----------------- values ---------------------");
        for (int i = 0; i < weekDays.length; i++) {
            System.out.println(weekDays[i].getNumber() + " : " + weekDays[i].getName());
        }
        for (WeekDays w : weekDays) {
            System.out.println(w.getName());
        }

        System.out.println("----------------- toString ---------------------");
        String str = WeekDays.FRIDAY.toString();
        System.out.println(str);

        System.out.println("----------------- ordinal ---------------------");
        int d = WeekDays.FRIDAY.ordinal();
        System.out.println(d);

        int m = WeekDays.SATURDAY.getNumber();
        System.out.println(m);

        System.out.println("----------------- valueOf ---------------------");
        WeekDays w = WeekDays.valueOf("Sunday");
        System.out.println(w);
    }
}
