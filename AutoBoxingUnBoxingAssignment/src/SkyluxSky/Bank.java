package SkyluxSky;

import java.util.ArrayList;

public class Bank {
    /**Fields**/
    private String name;
    //A bank can hold multiple branches...
    private ArrayList<Branch> branches;

    /**Constructor**/
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    /**Methods**/

    public boolean addBranch(String branchName){

        //If branch name not found add new branch!
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        //Branch not added!
        return false;
    }

    //Method for customers who want to open an account at a specific branch
    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);

        if (branch != null){
            //returns new customer - adds new customer into array...
            return branch.newCustomer(customerName, initialAmount);
        }

        return false;
    }

    //Method for adding customer transaction
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);

        if (branch != null){
            //adds customers transactions
            return branch.addCustomerTransaction(customerName, amount);
        }

        return false;
    }

//----------------------------------Find Functionality---------------------------------------------

    //Finds if branch already exists...
    private Branch findBranch(String branchName){
        //Search ArrayList for Branch Name
        for (int i = 0; i < this.branches.size(); i++){

            //Variable for this.branches.get(i);
            Branch checkedBranches = this.branches.get(i);

            //Checks if branch name at index i is equal to entered customer name...
            if (checkedBranches.getName().equals(branchName)){
                return checkedBranches;
            }
        }

        //Customer not Found!!! please add!
        return null;
    }

//---------------------------------------------------------------------------------------------------

    //Shows a list of customers and their transactions:
    public boolean listCustomer(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);

        //Search if branch exists!
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();

            //Iterate through branchCustomers
            for (int i = 0; i < branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customers: " + branchCustomer.getName() + "["+ (i + 1) +"]");

                //If showTransactions  == true (Show transactions)
                if (showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();

                    //Second loop for all possible transactions...
                    for (int j = 0;j < transactions.size(); j++){
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }

            //Operation Successful
            return true;

        } else {

            //Problem finding branch
            return false;
        }
    }
}
