package SkyluxSky;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Method that does not need an instance handles the creation of contacts - Calls Constructor.
    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }
}
