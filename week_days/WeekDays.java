package homework_30.week_days;

public enum WeekDays {
    MONDAY("Monday",1),TUESDAY("Tuesday",2),WEDNESDAY("Wednesday",3),
    THURSDAY("Thursday",4),FRIDAY("Friday",5),SATURDAY("Saturday",6),
    SUNDAY("Sunday",7);

    // fields
    private String name;
    private int number;

    WeekDays(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeekDays{");
        sb.append("name='").append(name).append('\'');
        sb.append(", number=").append(number);
        sb.append('}');
        return sb.toString();
    }
}
