package SkyluxSky;

import java.util.ArrayList;

public class Main {

    //Linked List Index Formula (int): index # * 4 bytes(int) = Index Address
    //Linked List Index Formula (double): index # * 8 bytes(double) = Index Address

    //Linked List is an alternative for an array
    //It stores the link to the next item in the list, as well as the actual value.
    //Linked lists do not require all elements to be moved, a link can simply be redirected.
    //Objects not being used will be destroyed by java garbage collection.

    public static void main(String[] args) {
        Customer customer = new Customer("Cam", 14.56);
        Customer anotherCustomer;
        anotherCustomer = customer;//anotherCustomer points to the first class.
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }

        //inserts the number 2 in index position 1.
        intList.add(1,2);

        for (int i = 0; i < intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }

    }
}
