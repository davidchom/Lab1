package com.company;

import java.util.Objects;

enum CarBrand{
    UNKOWN("----"),
    AUDI("Audi"),
    MERCEDES("Mercedes"),
    CITROEN("Citroen"),
    DACIA("Dacia");


    String brand;

    private CarBrand(String brand){this.brand = brand;}


    @Override
    public String toString() {return brand;}
}

class CarException extends Exception{

    private static final long serialVersionUID = 1L;

    public CarException(String message){
        super(message);
    }
}

public class Car implements Comparable<Car>{
    private CarBrand carBrand;
    private int yearOfProduction;
    private int carMileage;
    private String color;

    public Car(){
        carBrand = CarBrand.UNKOWN;
        carMileage = 0;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public void setCarBrand(String car_brand) throws CarException{
        if(car_brand == null || car_brand.equals("")){
            this.carBrand=CarBrand.UNKOWN;
            return;
        }
        for(CarBrand cars: CarBrand.values()){
            if(cars.brand.equals(car_brand)){
                this.carBrand=cars;
                return;
            }
        }
        throw new CarException("Nie ma takiej marki samochodu na liście!");
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int year_of_production) throws CarException {
        if((year_of_production!=0) && (year_of_production < 1900 || year_of_production > 2022))
            throw new CarException("Rocznik samochodu zawierać się musi w latach [1900, 2022]");
        else
            this.yearOfProduction = year_of_production;
    }

    public void setYearOfProduction(String year_of_production) throws CarException{
        if(year_of_production==null || year_of_production.equals("")) {
            setYearOfProduction(0);
            return;
        }
        try{
            setYearOfProduction(Integer.parseInt(year_of_production));
        } catch (NumberFormatException e){
            throw new CarException("Rok musi być liczbą całkowitą!");
        }
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage (int car_mileage) throws CarException {
        if(car_mileage<0)
            throw new CarException("Nie można mieć ujemnego przebiegu auta!");
        else
            this.carMileage = car_mileage;
    }

    public void setCarMileage (String car_mileage) throws CarException{
        if(car_mileage==null || car_mileage.equals("")){
            setYearOfProduction(0);
            return;
        }
        try{
            setCarMileage(Integer.parseInt(car_mileage));
        } catch (NumberFormatException e){
            throw new CarException("Przebieg samochodu musi być liczbą całkowitą!");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {return color;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getYearOfProduction() == car.getYearOfProduction() && getCarMileage() == car.getCarMileage() && getCarBrand() == car.getCarBrand() && Objects.equals(getColor(), car.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarBrand(), getYearOfProduction(), getCarMileage(), getColor());
    }

    @Override
    public int compareTo(Car o) {
       if(equals(o)) return 0;
       Car car = (Car) o;
       return getColor().compareTo(car.getColor());

    }
}
