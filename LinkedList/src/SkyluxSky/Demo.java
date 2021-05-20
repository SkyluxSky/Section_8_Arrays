package SkyluxSky;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    //psvm is a shortcut for creating a new main method.
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit,"Melbourne");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Canberra");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Darwin");

        printList(placesToVisit);
        addInOrder(placesToVisit, "Sydney");

        //Alice Springs will now point to Melbourne.
        placesToVisit.add(1,"Alice Springs");
        printList(placesToVisit);

        //Dereferences Perth - Brisbane links to Canberra
        placesToVisit.remove(4);
        printList(placesToVisit);

        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList){
        //Iterator Loop - similar to for loop
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()){
            //i.next is equivalent to printing current entry then i++
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=============================");
    }

    //Puts Strings in ABC order
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        //Iterator that is useful for LinkedLists and Lists Specifically.
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()){
            //gives us a value of 0 or 1 - Goes to first record
            int comparison = stringListIterator.next().compareTo(newCity);

            if (comparison == 0){
                //equals do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0){
                //new City should appear before this one
                //Brisbane -> Adelaide
                //Go back to previous entry to add
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0){
                //Move on to next city.
            }
        }

        stringListIterator.add(newCity);
        return true;
    }



    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()){
            System.out.println("No cities in the itenerary");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();//Buffer

            switch (action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;

                case 1:
                    //prevents repeating outputs.
                    if (!goingForward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if (listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;//only direction is backwards
                    }
                    break;

                case 2:
                    //prevents repeating outputs.
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if (listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;//only direction is forward
                    }
                    break;

                case 3:
                    printMenu();
                    break;
                    
                default:
                    System.out.println("Please enter valid value");
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available Actions:\npress");
        System.out.println("0 - to quit\n"+
                "1 - go to next city\n"+
                "2 - go to previous city\n"+
                "3 - print menu options");
    }



}
