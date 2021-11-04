package com.company;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


public class CarCollections{

    private static final String AVAILABLE_ELEMENTS = "Dostępne marki samochodów: \n" +
            "* " + CarBrand.AUDI.toString() + "\n" +
            "* " + CarBrand.DACIA.toString() + "\n" +
            "* " + CarBrand.CITROEN.toString() + "\n" +
            "* " + CarBrand.MERCEDES.toString() + "\n";


    List<Car> arrayListCar = new ArrayList<>();
    List<Car> linkedListCar = new LinkedList<>();

    Set<Car> treeSetCar = new TreeSet<>();
    Set<Car> hashSetCar = new HashSet<>();

    Map<String, Car> treeMapCar = new TreeMap<>();
    Map<String, Car> hashMapCar = new HashMap<>();

    public List<Car> getArrayListCar() {
        return arrayListCar;
    }

    public Map<String, Car> getTreeMapCar() {
        return treeMapCar;
    }

    public void setTreeMapCar(Map<String, Car> treeMapCar) {
        this.treeMapCar = treeMapCar;
    }

    public Map<String, Car> getHashMapCar() {
        return hashMapCar;
    }

    public void setHashMapCar(Map<String, Car> hashMapCar) {
        this.hashMapCar = hashMapCar;
    }

    public void setArrayListCar(List<Car> arrayListCar) {
        this.arrayListCar = arrayListCar;
    }

    public List<Car> getLinkedListCar() {
        return linkedListCar;
    }

    public void setLinkedListCar(List<Car> linkedListCar) {
        this.linkedListCar = linkedListCar;
    }

    public Set<Car> getTreeSetCar() {
        return treeSetCar;
    }

    public void setTreeSetCar(Set<Car> treeSetCar) {
        this.treeSetCar = treeSetCar;
    }

    public Set<Car> getHashSetCar() {
        return hashSetCar;
    }

    public void setHashSetCar(Set<Car> hashSetCar) {
        this.hashSetCar = hashSetCar;
    }

    public void addingStarterCarsOnList() throws CarException {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();

        car1.setCarBrand(CarBrand.AUDI);
        car1.setCarMileage(125000);
        car1.setYearOfProduction(2002);
        car1.setColor("Czerwony");

        car2.setCarBrand(CarBrand.MERCEDES);
        car2.setCarMileage(2000);
        car2.setYearOfProduction(2020);
        car2.setColor("Niebieski");

        car3.setCarBrand(CarBrand.DACIA);
        car3.setCarMileage(450000);
        car3.setYearOfProduction(1998);
        car3.setColor("Czarny");

        car4.setCarBrand(CarBrand.CITROEN);
        car4.setCarMileage(220050);
        car4.setYearOfProduction(2016);
        car4.setColor("Żółty");

        car5.setCarBrand(CarBrand.AUDI);
        car5.setCarMileage(315000);
        car5.setYearOfProduction(2009);
        car5.setColor("Zielony");

        arrayListCar.add(car1);
        arrayListCar.add(car2);
        arrayListCar.add(car3);
        arrayListCar.add(car4);
        arrayListCar.add(car5);

        linkedListCar.addAll(arrayListCar);
    }

    public void addingStarterCarsOnSet() throws CarException{
        hashSetCar.addAll(arrayListCar);
        treeSetCar.addAll(arrayListCar);
    }

    public void addingStarterCarsToMap() throws CarException{
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setCarBrand(CarBrand.CITROEN);
        car1.setColor("Biały");
        car1.setCarMileage(25000);
        car1.setYearOfProduction(2018);

        car2.setCarBrand(CarBrand.AUDI);
        car2.setColor("Srebrny");
        car2.setCarMileage(560000);
        car2.setYearOfProduction(2002);

        treeMapCar.put(car1.getCarBrand().toString(),car1);
        treeMapCar.put(car2.getCarBrand().toString(),car2);
        hashMapCar.put(car2.getCarBrand().toString(), car2);
        hashMapCar.put(car1.getCarBrand().toString(), car1);
    }

    public static void addingNewCarToListAndSet(Collection<Car> collection) throws CarException {
        Scanner sc = new Scanner(System.in);
        System.out.println(AVAILABLE_ELEMENTS);
        System.out.println("Proszę wpisać interesującą Pana nazwę samochodu: ");
        String bVariable = sc.nextLine();

        System.out.println("\nTeraz proszę o wpisanie koloru: ");
        String cVariable = sc.nextLine();

        System.out.println("\nProszę o podanie rocznika: ");
        Integer yVariable = sc.nextInt();

        System.out.println("\nProszę o podanie przebiegu: ");
        Integer mVariable = sc.nextInt();

        Car ultimateCar = new Car();

        try {
            ultimateCar.setCarMileage(mVariable);
        } catch (CarException e) {
            throw new CarException("\nBłednie wprowadzone dane!!\n");
        }

        try {
            ultimateCar.setCarBrand(bVariable);
        } catch (CarException e) {
            throw new CarException("\nBłednie wprowadzone dane!!\n");
        }

        ultimateCar.setColor(cVariable);

        try {
            ultimateCar.setYearOfProduction(yVariable);
        } catch (CarException e) {
            throw new CarException("\nBłednie wprowadzone dane!!\n");
        }

        collection.add(ultimateCar);
    }

    public void addingNewCarToMap(Map map) throws CarException {
        Scanner sc = new Scanner(System.in);
        System.out.println(AVAILABLE_ELEMENTS);
        System.out.println("Proszę wpisać interesującą Pana nazwę samochodu: ");
        String bVariable = sc.nextLine();

        System.out.println("\nTeraz proszę o wpisanie koloru: ");
        String cVariable = sc.nextLine();

        System.out.println("\nProszę o podanie rocznika: ");
        Integer yVariable = sc.nextInt();

        System.out.println("\nProszę o podanie przebiegu: ");
        Integer mVariable = sc.nextInt();

        Car ultimateCar = new Car();

        try {
            ultimateCar.setCarMileage(mVariable);
        } catch (CarException e) {
            throw new CarException("\nBłednie wprowadzone dane!!\n");
        }

        try {
            ultimateCar.setCarBrand(bVariable);
        } catch (CarException e) {
            throw new CarException("\nBłednie wprowadzone dane!!\n");
        }

        ultimateCar.setColor(cVariable);

        try {
            ultimateCar.setYearOfProduction(yVariable);
        } catch (CarException e) {
            throw new CarException("\nBłednie wprowadzone dane!!\n");
        }
        map.put(bVariable.toString(), ultimateCar);

    }

    public static void deletingCarFromList(List<Car> list) throws CarException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Dostępne samochody: \n" );
        printingListAndSet(list);
        System.out.println("Proszę wskazać samochód po indeksie \n");
        int index = sc.nextInt();

        if(index<0 || index>=list.size())
            throw new CarException("Nie ma takiego indeksu!");
        else
            list.remove(index);
    }

    public void deletingCarFromSet(Set<Car> set) throws CarException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Dostępne samochody: \n" );
        printingListAndSet(set);
        System.out.println("Proszę wkazać pojazd do usunięcia po kolorze auta: ");
        String index = sc.nextLine();
        for (Car car: set)
        {
            if ((car.getColor().toString()).equals(index)) {
                System.out.println("Pojazd usunięty!");
                set.remove(car);
                break;
            }
            else {
                System.out.println("Nie udało się");
                break;
            }
        }
    }

    public static void deletingCarFromMap(Map<String, Car> map){
        System.out.println("\nProszę wybrać auto do usunięcia wpisaniem Marki samochodu: ");
        Scanner sc = new Scanner(System.in);
        String confirmation = sc.nextLine();
        map.remove(confirmation);
        System.out.println("\nSamochód usunięty z garażu!\n");
    }

    public static void printingListAndSet(Collection<Car> collection){
        int i=0;

        System.out.println();
        for(Car car : collection){
            System.out.println("Index: " + i + " Element: [Marka:" + car.getCarBrand() + ", Kolor:" + car.getColor() +
                    ", Przegieg:" + car.getCarMileage() +", Rok Produkcji:"
                    + car.getYearOfProduction() + "]");

            i++;
        }
        System.out.println();
    }

    public  static void printingMap(Map<String, Car> map){
        System.out.println();
        Car value;
        String format = new String();

        for(String key : map.keySet()){
            value = map.get(key);
            format = "[Kolor:" + value.getColor() + ", Marka samochodu:"+ value.getCarBrand() +
                    ", Przebieg:" + value.getCarMileage() + ", Rok produkcji:" + value.getYearOfProduction() + "]";
            System.out.println(format);
        }
        System.out.println();
    }
}
