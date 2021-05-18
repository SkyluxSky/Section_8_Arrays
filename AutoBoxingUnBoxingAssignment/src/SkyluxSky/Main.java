package SkyluxSky;

// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("CitiBank");
        //Add Branch
        bank.addBranch("Garden_City");



        //Create three customers for Garden_City Branch
        bank.addCustomer("Garden_City","Cameron", 50.05);
        bank.addCustomer("Garden_City", "Alina", 23.31);
        bank.addCustomer("Garden_City", "Nick", 1000.56);

        //Add Branch
        if (bank.addBranch("Queens")){
            System.out.println("Queens Branch Created");
        }
        bank.addCustomer("Queens", "Bob", 40.00);

        bank.addCustomerTransaction("Garden_City","Nick", 30.00);
        bank.addCustomerTransaction("Garden_City","Nick", 23.12);
        bank.addCustomerTransaction("Garden_City","Alina", 1.42);

        //List Transactions
        bank.listCustomer("Garden_City",true);
        bank.listCustomer("Queens",true);

        bank.addBranch("Melbourne");

        //Error because branch does not exist:
        if (!bank.addCustomer("Melbourne", "Brian", 5.53)){
            System.out.println("Error Melbourne Branch Does Not Exist!");
        }


        if (!bank.addBranch("Queens")){
            System.out.println("Queens Branch Already Exists...");
        }


        if(!bank.addCustomerTransaction("Queens", "Moot", 33)){
            System.out.println("Customer does not exist");
        }

        if(!bank.addCustomer("Queens", "Bob", 12.00)){
            System.out.println("Customer already exists");
        }

    }
}
