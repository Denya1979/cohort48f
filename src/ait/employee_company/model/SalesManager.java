package ait.employee_company.model;

public class SalesManager extends Employee {

    private double salesValue;
    private double percent;

    public SalesManager(int id, String firstNAME, String lastNAME, double hours, int age, double salesValue, double percent) {
        super(id, firstNAME, lastNAME, hours, age);
        this.salesValue = salesValue;
        this.percent = percent;
    }

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public double salary() {
        double salary = percent * salesValue;
        return ensureSalary(salary);
    }
}
