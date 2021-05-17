package SkyluxSky;

import java.util.ArrayList;

public class Customer {
    /**Fields**/
    private String name;
    private ArrayList<Double> transactions;

    /**Constructor**/
    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();

        //Adds initial amount to ArrayList<>
        addTransaction(initialAmount);
    }

    /**Methods**/
    //adds amount to transaction arraylist.
    public void addTransaction(double amount){
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
