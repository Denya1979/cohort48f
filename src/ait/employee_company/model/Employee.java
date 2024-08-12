package ait.employee_company.model;

import java.util.Objects;

//- создать дочерние классы practice.model.Manager, practice.model.SalesManager и Worker, реализовать в них методы начисления зарплаты:
//    - practice.model.Manager: base + grade*hours
//    - practice.model.SalesManager: salesValue * percent
//    - Worker: grade*hours
public abstract class Employee {
    protected static double minWage = 13; // 13 euro/hour
    protected final  int id;
    protected String firstNAME;
    protected String lastNAME;
    protected double hours;
    protected int age;

    public Employee(int id, String firstNAME, String lastNAME, double hours, int age) {
        this.id = id;
        this.firstNAME = firstNAME;
        this.lastNAME = lastNAME;
        this.hours = hours;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static double getMinWage() {
        return minWage;
    }

    public int getId() {
        return id;
    }

    public String getFirstNAME() {
        return firstNAME;
    }

    public void setFirstNAME(String firstNAME) {
        this.firstNAME = firstNAME;
    }

    public String getLastNAME() {
        return lastNAME;
    }

    public void setLastNAME(String lastNAME) {
        this.lastNAME = lastNAME;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    // protect from mistake in salary department
    protected double ensureSalary(double salary){
        if (salary < hours * minWage){
            salary = hours * minWage;
        }
        return salary;
    }



    public static void setMinWage(double minWage) {
        if (minWage >= Employee.getMinWage()) {
            Employee.minWage = minWage;
        }
    }

    public abstract double salary(); // абстрактный метод, требует реализации в дочернем классе

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstNAME='").append(firstNAME).append('\'');
        sb.append(", lastNAME='").append(lastNAME).append('\'');
        sb.append(", hours=").append(hours);
        sb.append('}');
        return sb.toString();
    }
}
