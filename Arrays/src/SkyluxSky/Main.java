package SkyluxSky;

//Array is a Data Structure tha allows you to store multiple objects of the same type.

import java.util.Scanner;

public class Main {

    //Static field of scanner. Scans user input
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
	    //Standard Definition of an Array
        //Array assigned 10 elements.
        int[] myIntArray = new int[20];

        //Saves value 50 into array at position 5.
        //Remember Arrays start at 0, so 50 is stored 6 indexes into the array.
        myIntArray[5] = 50;
        myIntArray[0] = 51;
        myIntArray[1] = 52;

        //Alternate method to assign array values when array is created.
        double[] myDoubleArray = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(myIntArray[5]);
        System.out.println(myDoubleArray[8]);
        System.out.println(myDoubleArray[6]);

        //Sets values in array
        for (int i = 0; i < myIntArray.length; i++){
            myIntArray[i] = i * 10;
        }

        //Outputs array values
        //for (int i = 0; i < 10; i++){
        //  System.out.println("Element " + i + ", value is " + myIntArray[i]);
        //}

        System.out.println("\n");

        //passes array to a method.
        //printArray(myIntArray);

        /**Finds Average of Array**/
        int[] myIntegers = getIntegers(5);

//        for (int i = 0; i < myIntegers.length; i++){
//            System.out.println("Element " + i + ", value is " + myIntegers[i]);
//        }

        printArray(myIntegers);
        System.out.println("The average is " + getAverage(myIntegers));

    }

    public static int[] getIntegers(int number){
        System.out.println("Enter " +  number + " Integer values.\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }

        return values;
    }

    //Gets the average of an array
    public static double getAverage(int[] array){

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        
        return (double) sum / (double) array.length;
    }


    public static void printArray(int[] array){
        //Method tells for loop the size of the array (No hard numbers needed)
        for (int i = 0; i < array.length; i++){
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }
}
