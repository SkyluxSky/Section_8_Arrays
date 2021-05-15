package SkyluxSky;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    //Checks if contact exists.
    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact,Contact newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0){
            System.out.println(oldContact.getName() + ", was not found");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact){
        //Checks to see if contact is found.
        int foundPosition = findContact(contact);
        if (foundPosition < 0){
            System.out.println(contact.getName() + ", was not found");
            return false;
        }
        //deletes found contact
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    private int findContact(Contact contact){
        //determines if contact exists
        return this.myContacts.indexOf(contact);

    }

    private int findContact(String contactName){
       for (int i = 0; i < this.myContacts.size(); i++){
           Contact contact = this.myContacts.get(i);
           //determines if contact is present in contact list.
           if(contact.getName().equals(contactName)){
               return i;
           }
       }
       return -1;
    }

    //Finds contact using public method
    public String queryContact(Contact contact){
        //checks for record using existing contact name
        if(findContact(contact) >= 0){
            //gets contact info
            return contact.getName();
        }
        return null;
    }

    //prints out entire contact list.
    public void printContacts(){
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i+1) + "." +
                    //myContacts/access current index/call getter
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }


}
