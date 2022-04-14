package CA1;

import java.util.Scanner;

public class ElectronicsApp {

    public static void main(String[] args) {
        // Variables
        String itemName; //Electronics class variables
        String maker; //Electronics class variables
        int itemPrice; // Electronics class variables


        Electronics[] theElectronics;  //new Electronics[0]; // A variable to work with a 1D array of Student objects

        final int MAX_NUMBER_ITEMS = 5; //Max items that can be added
        int countElectronics = 0; //variable to store the items
        theElectronics = new Electronics[MAX_NUMBER_ITEMS];

        Electronics e; //



        // Declare and create objects for input

        Scanner sc = new Scanner(System.in);

        //input

        int userSelection; //Menu selection 1 - 6
        do { //do / while to validate display each case of option between 1 and 6
            userSelection = menu();
            switch (userSelection) {
                case 1: //Add items
                    if (countElectronics < 5) {
                        System.out.println("Please add an item: ");
                        itemName = sc.next();

                        System.out.println("Please add a manufacturer of the item: ");
                        maker = sc.next();

                        System.out.println("Please add a price to the the item between 100 and 5000: ");

                        while (!sc.hasNextInt()) { //Validation to accept only int numbers
                            System.out.println("It must be numbers");
                            sc.next();
                        }

                        for(itemPrice = 0; itemPrice < 100 || itemPrice > 5000;){ //Loop to accept only valid prices between 100 and 5000
                            itemPrice = sc.nextInt();
                            System.out.println("Please enter a valid price between 100 and 5000");
                        }

                        e = new Electronics(itemName, itemPrice, maker);//variable to store the created items
                        theElectronics[countElectronics] = e;
                        countElectronics++;
                    }

                    else {
                        System.out.println("\nYou have the maximum items which is 5\n"); //To display that the maximum items was already created
                    }
                    break;

                case 2://To display all items created
                    System.out.println("\nElectronics list\n");
                    for (int i = 0; i < countElectronics; i++) {

                        theElectronics[i].displayState();
                    }


                    break;

                case 3://To search the items with the same value
                    System.out.println("Please enter a price");
                    while (!sc.hasNextInt()) { //validation to accept only numbers
                        System.out.println("It must be numbers");
                        sc.next();}
                    itemPrice = sc.nextInt();
                    boolean find = false;

                    for(int i = 0; i < countElectronics; i++){
                        if(theElectronics[i].getItemPrice() == itemPrice){
                            System.out.println(theElectronics[i].getItemName());
                            find = true; //loop to show if it was found
                        }
                    }
                    if(!find){
                        System.out.println("\nNothing found");//to return that nothing was found
                    }

                    break;

                case 4://to calculate the average price of the items
                    int sum = 0; //to create a sum
                    for(int i = 0; i < countElectronics; i++){
                        sum += theElectronics[i].getItemPrice();
                    }
                    System.out.println("\nThe average price is: " + sum/countElectronics);

                    break;

                case 5: // to show the item with the highest price
                    if(theElectronics[0] != null) {//validation to return only if it has items created
                        int max = theElectronics[0].getItemPrice();
                        String name = theElectronics[0].getItemName();
                        for (int i = 0; i < countElectronics; i++) {
                            if (max < theElectronics[i].getItemPrice()) {
                                max = theElectronics[i].getItemPrice();
                            }
                        }
                        System.out.println("The highest item in the stock is: " + name + " Which its price is: " + max);
                    }
                        else{
                        System.out.println("Add an item first");//Message that it must have items first
                    }

                    break;

                case 6: //To leave the application
                    System.out.println("\nBye bye!");
                    break;

                default:
                    System.out.println("Choose a valid option");
                    break; //message that validate that it must be numbers between 1- 6

            }
        }

        while (userSelection != 6); //It must be max 6

    }

    public static int menu()//menu selection to be displayed
    {
        int selection;

        Scanner sc = new Scanner(System.in);

        do{//menu options
            System.out.println("\nWhat would like to do? Use only numbers");
            System.out.println("----------------------");
            System.out.println("1 to add an item to the list");
            System.out.println("2 to see the item list");
            System.out.println("3 to see the items with the same value");
            System.out.println("4 to calculate the average value of all items");
            System.out.println("5 to display the items with highest price");
            System.out.println("6 to exit application");
            System.out.println("Type the number that correspond to what you would like to do");
            while (!sc.hasNextInt()){//Validation to accept only int numbers
                System.out.println("That's not a number");
                sc.next();
            }
            selection = sc.nextInt();
        } while (selection <= 0);

        return selection;
    }

}//main

