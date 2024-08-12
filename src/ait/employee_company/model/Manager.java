package ait.employee_company.model;

public class Manager extends Employee {

    private double baseSalary;
    private int grade;

    public Manager(int id, String firstNAME, String lastNAME, double hours, int age, double baseSalary, int grade) {
        super(id, firstNAME, lastNAME, hours, age);
        this.baseSalary = baseSalary;
        this.grade = grade;
    }

    public double getBaseSalsry() {
        return baseSalary;
    }

    public void setBaseSalsry(double baseSalsry) {
        this.baseSalary = baseSalsry;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public double salary() {
        double salary = baseSalary + hours * grade;
        return ensureSalary(salary);
    }
}
