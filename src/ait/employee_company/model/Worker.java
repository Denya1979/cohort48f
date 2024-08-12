package ait.employee_company.model;

public class Worker extends Employee {

    private double wage;

    public Worker(int id, String firstNAME, String lastNAME, double hours, int age, double wage) {
        super(id, firstNAME, lastNAME, hours, age);
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double salary() {
        double salary = wage * hours; // calculate salary
        // salary = ensureSalary(salary);
        return ensureSalary(salary); // check salary
    }
}
