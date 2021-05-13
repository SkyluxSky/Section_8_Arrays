package SkyluxSky;

import java.util.ArrayList;

public class GroceryList {
    //Traditional arrays must be defined by datatype.
    //private int[] myNumbers = new int[50];

    //Array list is a class - Can have its own constructor
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item){
        //adds element to list
        groceryList.add(item);

    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    //Outputs all elements in an arraylist.
    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0;  i < groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    //Overloaded method - Modifies based on name
    public void modifyGroceryItem(String currentItem, String newItem){
        //Checks for current item.
        int position = findItem(currentItem);
        if (position >= 0){
            modifyGroceryItem(position,newItem);
        }

    }

    //Replaces item
    private void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        //(position + 1) allows for list to start from 1 instead of 0.
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    //Overloaded Methods - Deletes based on name
    public void removeGroceryItem(String item){
        int position = findItem(item);
        if (position >= 0){
            removeGroceryItem(position);
        }
    }

    //Removes Item
    private void removeGroceryItem(int position){
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }

    //Search items
    private int findItem(String searchItem){
        return groceryList.indexOf(searchItem);
        //contains functionality to search list if the arraylist contains the item
        //boolean exists = groceryList.contains(searchItem);

        //returns index position of searched item.
        //int position = groceryList.indexOf(searchItem);

        //if (position >= 0){
        //    return groceryList.get(position);
        //}

        //return null;
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if (position >= 0){
            return true;
        }
        return false;
    }
}
