package SkyluxSky;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Value Types
        int myIntValue = 10;
	    int anotherIntValue = myIntValue;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        anotherIntValue++;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        //Reference Types - Holds an address to the object, but not the object itself.
        int[] myIntArray = new int[5];
        //Another reference to the same array in memory.
        int[] anotherArray = myIntArray;

        //Prints out array as a string.
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        anotherArray[0] = 1;

        //Both variables are changed.
        //Both variables are pointing to the same address in memory.
        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(anotherArray));

        //de-reference array and reference new array.
        anotherArray = new int[] {4,5,6,7,8};
        modifyArray(myIntArray);

        System.out.println("after method change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after method change anotherArray = " + Arrays.toString(anotherArray));
    }

    private static void modifyArray(int[] array){
        array[0] = 2;
        //reference points to a new array with new parameters
        array = new int[] {1,2,3,4,5};
    }
}
