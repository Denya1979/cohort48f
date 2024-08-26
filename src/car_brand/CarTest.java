package car_brand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CarTest {

    Car[] cars;

    @BeforeEach
    void setUp() {

        cars = new Car[5];
        cars[0] = new Car("brand1","black",18000,2021);
        cars[1] = new Car("bran2","white",19000,2020);
        cars[2] = new Car("brand3","red",17000,2022);
        cars[3] = new Car("brand1","blue",16000,2024);
        cars[4] = new Car("bran52","yellow",15000,2023);

    }

    @Test
    void testBrandCarByYear(){
        printArray(cars); // print

        Arrays.sort(cars); // sorting

        printArray(cars); // print
    }

    @Test
    void  testBrandCarByCost(){

        printArray(cars); // print array as is

        Comparator<Car> comparatorByCost = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return Double.compare(car1.getCost(), car2.getCost());
            }
        };
        Arrays.sort(cars, comparatorByCost);
        printArray(cars);
    }

    @Test
    void
    testSortByColor(){
        printArray(cars);

        Comparator<Car> comparatorByColor = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getColor().compareTo(car2.getColor());
            }
        };

        Arrays.sort(cars, comparatorByColor);
        printArray(cars);
    }

// print array
    public void printArray(Object[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("--------------------------------------");
    }

}