package city_copy_array.ait.city.test;

import classwork_29.city_copy_array.ait.city.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;


class CityTest {
    City[] cities;
    @BeforeEach
    void setUp() {
        cities = new City[6];
        cities[0] = new City("Denver", 600_000);
        cities[1] = new City("Boston", 670_000);
        cities[2] = new City("Chicago", 2_700_000);
        cities[3] = new City("Atlanta", 470_000);
        cities[4] = new City("New York", 8_500_000);
        cities[5] = new City("Dallas", 1_300_000);
    }
    private void printArray(Object[] arr, String title){
        System.out.println("===========" + title + "=====================");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    @Test
    void testComparable() {
        printArray(cities, "Ordinary array");
        Arrays.sort(cities);
        printArray(cities, "Natural order");
        City pattern = new City("XXX", 1_200_000);
        int index = Arrays.binarySearch(cities, pattern);
        System.out.println(index);
    }

    @Test
    void testComparator(){
        Comparator<City> comparator = (c1, c2) -> c1.getName().compareTo(c2.getName());
        Arrays.sort(cities, comparator);
        printArray(cities, "Sort by name");
        City pattern = new City("Chicago", 0);
        int index = Arrays.binarySearch(cities, pattern, comparator);
        System.out.println(index);
    }
    @Test
    void testArrayCopy(){
        Comparator<City> comparator = Comparator.nullsLast((c1, c2) -> c1.getName().compareTo(c2.getName()));
        City[] citesCopy = Arrays.copyOf(cities, cities.length * 2);
        printArray(citesCopy, "citiesCopy before sort");
        Arrays.sort(citesCopy, comparator);
        printArray(citesCopy, "citiesCopy after sort");
        City pattern = new City("Salem", 0);
        int index = Arrays.binarySearch(citesCopy, 0, cities.length, pattern, comparator);
        System.out.println(index);
    }

    @Test
    void testKeepSorting(){
        Arrays.sort(cities);
        printArray(cities, "Natural order");
        City city = new City("Salem",690_000);
        //
        City[] citiesCopy = Arrays.copyOf(cities, cities.length + 1);
        int index = Arrays.binarySearch(citiesCopy, 0, citiesCopy.length - 1, city);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(citiesCopy, index, citiesCopy, index + 1,citiesCopy.length - index - 1);//
        citiesCopy[index] = city;
        cities = citiesCopy; //
        printArray(cities,"Natural order after add new city");

    }
    @Test
    void testSystemArrayCopy(){
        City[] citiesCopy = new City[cities.length + 2];
        System.arraycopy(cities, 1, citiesCopy, 2, 4); // ставим в новый массив соо 2-й позиции 4 элемента из старого массива
        printArray(cities, " Original array");
        printArray(citiesCopy, "New and copy of range");
    }

    // Arrays.copyOfRange
    @Test
    void testCopyOfRange() {
        City[] citiesCopy = Arrays.copyOfRange(cities, 1, cities.length + 1);
        printArray(cities, "Original array");
        printArray(citiesCopy, "Copy of range");
    }
}
