package com.company;

import java.util.Scanner;

public class CarConsoleApp {

    private static final String MENU = "MENU GŁÓWNE \n" +
            "1. Dodaj nowy samochód do garażu\n" + "2. Usuń samochód z garażu\n"
            + "3. Wyświetl cały garaż\n" + "0. Wyjdź z programu\n";

    private static final String MENU_FOR_lIST = "\nProszę wybrać interesującą Pana listę: \n" +
            "1. ArrayList\n" + "2. LinkedList\n" +
            "3. TreeSet\n" + "4. HashSet\n" +
            "5. TreeMap\n" + "6.HashMap\n";




    private static final ConsoleUserDialog UI = new ConsoleUserDialog();
    private CarCollections carCollections = new CarCollections();

    public static void main(String[] args) throws CarException {
	    CarConsoleApp application = new CarConsoleApp();
        application.runMainLoop();
    }


    public void runMainLoop() throws CarException {
        boolean isEnd = true;
        UI.clearConsole();
        try {
            carCollections.addingStarterCarsOnList();
            carCollections.addingStarterCarsOnSet();
            carCollections.addingStarterCarsToMap();
        } catch (CarException e) {
            e.printStackTrace();
        }
        while(isEnd){
            switch(UI.enterInt(MENU + "Wpisz odpowiednią cyfrę tutaj => ")){
                case 1:
                    switch(UI.enterInt(MENU_FOR_lIST + "Wpisz odpowiednią cyfrę tutaj => ")){
                        case 1:
                            carCollections.addingNewCarToListAndSet(carCollections.getArrayListCar());
                            break;
                        case 2:
                            try {
                                carCollections.addingNewCarToListAndSet(carCollections.getLinkedListCar());
                            } catch (CarException e) {
                                throw new CarException("\nBłednie wprowadzone dane!!\n");
                            }
                            break;
                        case 3:
                            try {
                                carCollections.addingNewCarToListAndSet(carCollections.getTreeSetCar());
                            } catch (CarException e) {
                                throw new CarException("\nBłednie wprowadzone dane!!\n");
                            }
                            break;
                        case 4:
                            try {
                                carCollections.addingNewCarToListAndSet(carCollections.getHashSetCar());
                            } catch (CarException e) {
                                throw new CarException("\nBłednie wprowadzone dane!!\n");
                            }
                            break;
                        case 5:
                            try {
                                carCollections.addingNewCarToMap(carCollections.getTreeMapCar());
                            } catch (CarException e) {
                                throw new CarException("\nBłednie wprowadzone dane!!\n");
                            }
                            break;
                        case 6:
                            try {
                                carCollections.addingNewCarToMap(carCollections.getHashMapCar());
                            } catch (CarException e) {
                                throw new CarException("\nBłednie wprowadzone dane!!\n");
                            }
                            break;
                        default:
                            System.out.println("\nBłędne dane!!!\n");
                            break;
                    }
                    break;

                case 2:
                    switch (UI.enterInt(MENU_FOR_lIST + "Wpisz odpowiednią cyfrę tutaj => ")) {
                        case 1:
                            try {
                                carCollections.deletingCarFromList(carCollections.getArrayListCar());
                            } catch (CarException e) {
                                throw new CarException("\nBłednie wprowadzone dane!!\n");
                            }
                            System.out.println("\nPojazd usunięty!\n");
                            break;
                        case 2:
                            try {
                                carCollections.deletingCarFromList(carCollections.getLinkedListCar());
                            } catch (CarException e) {
                                throw new CarException("\nNie można usunąć obiektu!\n");
                            }
                            System.out.println("\nPojazd usunięty!\n");
                            break;
                        case 3:
                            try {
                                carCollections.deletingCarFromSet(carCollections.treeSetCar);
                            } catch (CarException e) {
                                throw new CarException("\nNie można usunąć obiektu!\n");
                            }

                            break;
                        case 4:
                            try {
                                carCollections.deletingCarFromSet(carCollections.hashSetCar);
                            } catch (CarException e) {
                               throw new CarException("\nNie można usunąć obiektu!\n");
                            }

                            break;
                        case 5:
                            System.out.println("\nDostępna lista:\n");
                            carCollections.printingMap(carCollections.getTreeMapCar());


                            carCollections.deletingCarFromMap(carCollections.treeMapCar);
                            break;
                        case 6:
                            System.out.println("\nDostępna lista:\n");
                            carCollections.printingMap(carCollections.getHashMapCar());

                            carCollections.deletingCarFromMap(carCollections.hashMapCar);
                            break;
                        default:
                            System.out.println("\nBłędne dane!!!\n");
                            break;
                    }
                    break;

                case 3:
                    switch (UI.enterInt(MENU_FOR_lIST + "Wpisz odpowiednią cyfrę tutaj => ")){
                        case 1:
                           carCollections.printingListAndSet(carCollections.arrayListCar);
                           break;
                        case 2:
                            carCollections.printingListAndSet(carCollections.linkedListCar);
                            break;
                        case 3:
                            carCollections.printingListAndSet(carCollections.treeSetCar);
                            break;
                        case 4:
                            carCollections.printingListAndSet(carCollections.hashSetCar);
                            break;
                        case 5:
                            carCollections.printingMap(carCollections.getTreeMapCar());
                            break;
                        case 6:
                            carCollections.printingMap(carCollections.getHashMapCar());
                            break;
                        default:
                            System.out.println("\nBłędne dane!!!\n");
                            break;
                    }
                    break;

                case 0:
                    System.out.println("\n\nWychodzenie z programu...\n\n");
                    isEnd=false;
                    break;

                default:
                    System.out.println("\nNie ma takiej liczby do wyboru!\n");
                    break;

            }
        }
    }

}
