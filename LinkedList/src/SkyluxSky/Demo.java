package SkyluxSky;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {

    //psvm is a shortcut for creating a new main method.
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        printList(placesToVisit);

        //Alice Springs will now point to Melbourne.
        placesToVisit.add(1,"Alice Springs");
        printList(placesToVisit);

        //Dereferences Perth - Brisbane links to Canberra
        placesToVisit.remove(4);
        printList(placesToVisit);

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

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        //Iterator that is useful for LinkedLists and Lists Specifically.
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()){
            //gives us a value of 0 or 1
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

            stringListIterator.add(newCity);
        }
    }
}
