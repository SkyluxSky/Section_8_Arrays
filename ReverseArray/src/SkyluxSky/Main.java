package SkyluxSky;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {1,5,3,7,11,9,15};

        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversed Array = " + Arrays.toString(array));
    }

    public static void reverse(int[] array){

        //Determines Max Index
        int maxIndex = array.length - 1;
        //Finds Half Way Point of Array
        int halfLength = array.length / 2;

        for(int i = 0; i < halfLength; i++){
            int temp = array[i];
            //Move max index to the front of the array.
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }
}
