package SkyluxSky;

import java.util.ArrayList;

public class Branch {
    /**Fields**/
    //Branch Name
    private String name;
    //List of Customers for each branch
    private ArrayList<Customer> customers;

    /**Constructor**/
    public Branch(String name) {
        this.name = name;
        //Initialize ArrayList
        this.customers = new ArrayList<Customer>();
    }

    /**Methods**/
    //Get branch name
    public String getName() {
        return name;
    }

    //Creates new customer with verification...
    public boolean newCustomer(String customerName, double initialAmount){

        //If customer is not on file we can add it!
        if (findCustomer(customerName) == null){
            //Creates new customer by calling the constructor from customer.
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }

        //Add customer not successful!
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);

        //If customer is on file we can grab it and add existing amount to customer...
        if (existingCustomer != null){

            //adds amount to customers account...
            existingCustomer.addTransaction(amount);
            return true;
        }

        //Transaction not successful!
        return false;
    }

    private Customer findCustomer(String customerName){
        //Search ArrayList for CustomerName
        for (int i = 0; i < this.customers.size(); i++){

            //Variable for this.customers.get(i);
            Customer checkedCustomer = this.customers.get(i);

            //Checks if customer name at index i is equal to entered customer name...
            if (checkedCustomer.getName().equals(customerName)){
                return checkedCustomer;
            }
        }

        //Customer not Found!!! please add!
        return null;
    }
    
}
