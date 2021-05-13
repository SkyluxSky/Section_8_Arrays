package SkyluxSky;

//ArrayList inherits from an AbstractList<E> and List<E>.
//ArrayList is a resizable array.
//As s elements are added to an arraylist, the amount of memory required is updated automatically.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
private static Scanner scanner = new Scanner(System.in);
private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        //Prints instructions.
        printInstructions();

        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();//Clears input buffer.

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    //General instructions
    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem(){
        System.out.println("Please enter the grocery item: ");
        //adds an item to the existing list.
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.println("Current item name: ");
        String itemNo = scanner.nextLine();
        //scanner.nextLine();

        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        //(itemNo - 1) exists to offset list to a machine readable state (Arrays start at zero, lists start at 1 in the real world)
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem(){
        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();
        //scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    public static void searchForItem(){
        System.out.println("Item to search for: ");
        String  searchItem = scanner.nextLine();

        if (groceryList.onFile(searchItem)){
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }

    }

    //adds original list to a new ArrayList.
    public static void processArrayList(){
        //method 1
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        //method 2
        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        //method 3 - convert arraylist to array.
        String[] myArray = new String[groceryList.getGroceryList().size()];
        //Returns array list of strings and passes it to the new array.
        myArray = groceryList.getGroceryList().toArray(myArray);

    }


}
