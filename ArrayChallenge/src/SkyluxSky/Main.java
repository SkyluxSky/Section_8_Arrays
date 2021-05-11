package SkyluxSky;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //field
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a program using arrays that sorts a list of integers in descending order.
        // Descending order is highest value to lowest.
        // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
        // ultimately have an array with 106,81,26, 15, 5 in it.
        // Set up the program so that the numbers to sort are read in from the keyboard.
        // Implement the following methods - getIntegers, printArray, and sortIntegers
        // getIntegers returns an array of entered integers from keyboard
        // printArray prints out the contents of the array
        // and sortIntegers should sort the array and return a new array containing the sorted numbers
        // you will have to figure out how to copy the array elements from the passed array into a new
        // array and sort them and return the new sorted array.

        int[] myIntegers = getIntegers(5);
        printArray(myIntegers);

        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);
    }

    public static int[] getIntegers(int capacity){
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " Integer values:\r");
        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array){
//        //Establishes new array.
//        int[] sortedArray = new int[array.length];
//
//        //Places all existing array numbers into a new array.
//        for (int i = 0; i < array.length; i++){
//            sortedArray[i] = array[i];
//        }

        //takes copy of array at the arrays length.
        int[] sortedArray = Arrays.copyOf(array, array.length);

        //Test Variables for sorting algorithm.
        boolean flag = true;
        int temp;

        //While loop only runs while flag is true.
        while (flag){
            flag = false;
            //Goes through entire array.
            for (int i = 0; i < sortedArray.length - 1; i++){

                if (sortedArray[i] < sortedArray[i+1]){
                    //Stores current value into a temp variable.
                    temp = sortedArray[i];
                    //First value is changed to array i+1
                    sortedArray[i] = sortedArray[i + 1];
                    //Next element in array is changed to temp value.
                    sortedArray[i + 1] = temp;
                    //Keeps while loop going until if statement returns false.
                    flag = true;
                }
            }
        }

        return sortedArray;
    }



}
