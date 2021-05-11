package SkyluxSky;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Count: ");
        int count = scanner.nextInt();
        scanner.nextLine();//functions as reading the enter key.

        //Stores created array
        int[] returnedArray = readIntegers(count);
        //Passes returned array
        int returnedMin = findMin(returnedArray);

        System.out.println("min = " + returnedMin);




    }

    //Method allows user to assign values to array.
    private static int[] readIntegers(int count){
        int[] array = new int[count];

        for (int i = 0; i < array.length; i++){
            System.out.println("Enter a Number: ");
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number;
        }
        return array;
    }


    //Finds minimum value.
    private static int findMin(int[] array){
        //saves max value to integer.
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++){
            int value = array[i];
            if (value < min){
                min = value;
            }
        }

        return min;
    }


}
