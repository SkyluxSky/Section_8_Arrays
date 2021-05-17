package SkyluxSky;

import java.util.ArrayList;

//Class - Wrapper (Wrapping the Functionality)
class IntClass{
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
        //Arrays
	    String[] strArray = new String[10];
	    int[] intArray = new int[10];

	    //ArrayLists
        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("cam");

        //We cannot save a list of integers in an arraylist.
        //ArrayList<int> intArrayList = new ArrayList<int>();

        //Example of self made class to parse integers into an arraylist.
        ArrayList<IntClass> intArrayList = new ArrayList<IntClass>();
        intArrayList.add(new IntClass(54));
        //Integer is a class and int is not.
        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.54);


        //Autoboxing Example:
        ArrayList<Integer> intArrayList2 = new ArrayList<Integer>();

        for (int i = 0; i <= 10; i++){
            //takes value of i and converts it to integer value within the integer class.
            //puts a primitive type in an object wrapper.
            intArrayList2.add(Integer.valueOf(i));
        }

        //Example of Unboxing:
        for (int i = 0; i <= 10; i++){
            //Takes value out of wrapper class and converts it back into primitive types.
            System.out.println(i + " --> " + intArrayList2.get(i).intValue());
        }

        //ShortCut Method:
        Integer myIntValue = 56; //Integer.valueOf(56);
        int myInt = myIntValue; //myIntValue.intValue();


        //Double Example:
        //(Autoboxing)
        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5){
            myDoubleValues.add(dbl);
        }
        //(Unboxing)
        for (int i = 0; i < myDoubleValues.size(); i++){
            double value = myDoubleValues.get(i);
            System.out.println(i + " --> " + value);
        }


    }
}
