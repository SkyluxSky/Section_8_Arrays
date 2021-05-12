package SkyluxSky;

import java.util.ArrayList;

public class GroceryList {
    //Traditional arrays must be defined by datatype.
    private int[] myNumbers = new int[50];
    //Array list is a class - Can have its own constructor
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item){
        //adds element to list
        groceryList.add(item);

    }

    //Outputs all elements in an arraylist.
    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0;  i < groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    //Replaces item
    public void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        //(position + 1) allows for list to start from 1 instead of 0.
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    //Removes Item
    public void removeGroceryItem(int position){
        String theItem = groceryList.get(position);
        groceryList.remove(position);

    }
}
