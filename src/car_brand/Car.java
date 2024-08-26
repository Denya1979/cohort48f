package car_brand;

import java.util.Objects;

public class Car implements Comparable<Car>{

    private String brand;
    private String color;
    private  double cost;
    private  int year;

    public Car(String brand, String color, double cost, int year) {
        this.brand = brand;
        this.color = color;
        this.cost = cost;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Double.compare(cost, car.cost) == 0 && year == car.year && Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, cost, year);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Car car) {
        return - (this.getYear() - car.getYear());
    }
}
