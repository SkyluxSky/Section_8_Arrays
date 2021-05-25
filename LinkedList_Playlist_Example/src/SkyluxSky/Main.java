package SkyluxSky;

// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove())

import java.util.*;

public class Main {

    //Creates New ArrayList of Multiple Albums
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

	    Album album = new Album("Kid A", "Radiohead");
	    album.addSong("Everything In Its Right Place", 4.10);
        album.addSong("Kid A", 4.40);
        album.addSong("National Anthem", 4.20);
        album.addSong("How To Disappear Completely", 4.00);
        album.addSong("Treefingers", 4.10);
        album.addSong("Optimistic", 4.30);
        album.addSong("In Limbo", 4.50);
        albums.add(album);

        //Reuse same variable, but initiate a new album with new
        //Frees up memory.
        album = new Album("In An Aeroplane Over The Sea", "Neutral Milk Hotel");
        album.addSong("King Of Carrot Flowers", 3.10);
        album.addSong("Holland 1945", 4.40);
        album.addSong("Communist Daughter", 2.20);
        album.addSong("Oh Comely", 8.00);
        album.addSong("Ghost", 3.10);
        album.addSong("Two Headed Boy", 4.30);
        album.addSong("In An Aeroplane Over The Sea", 4.50);
        //adds new album to the arraylist
        albums.add(album);


        LinkedList<Song> playList = new LinkedList<Song>();
        //add songs to playlist through name method.
        albums.get(0).addToPlaylist("Kid A", playList);
        albums.get(0).addToPlaylist("National Anthem", playList);
        albums.get(0).addToPlaylist("In Limbo", playList);
        albums.get(0).addToPlaylist("Man Of The World", playList); //Does Not Exist
        //add songs to playlist through track number method.
        albums.get(0).addToPlaylist(5, playList);
        albums.get(1).addToPlaylist(1, playList);
        albums.get(1).addToPlaylist(3, playList);
        albums.get(1).addToPlaylist(5, playList);
        albums.get(1).addToPlaylist(25, playList); //Does Not Exist

        play(playList);

    }


    //Plays song
    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0){
            System.out.println("No songs in playlist...");
        } else {
            //.toString() prints out object to a readable String...
            //Without a method like this Java will print the package name and memory address of the index of that array.
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();//Buffer

            switch(action) {
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;

                case 1:
                    //Checks if we can go forward in playlist... Prevents duplicate output...
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }

                    //Prints Next Item...
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:

                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }

                    //Prints Previous Item...
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }

                    break;
                case 3:

                    if (forward){
                        //replay previous song
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }

                    } else {
                        //replay next song
                        if (listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }

                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    //remove song
                    if (playList.size() > 0){
                        listIterator.remove();
                        //Guards against errors
                        //First catch exception...
                        if (listIterator.hasNext()){
                            System.out.println("Now Playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now Playing " + listIterator.previous());
                        }
                    }

                    break;

                default:
                    System.out.println("Please Enter Valid Action:");
                    break;
            }
        }

    }

    //Prints menu
    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" + "1 - to play next song\n" +
                "2 - to play previous song\n" + "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" + "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }


    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("=============================");
        //prints out full playlist with basic iterator
        //traditional iterators only go forward and not backwards - unlike list iterators.
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("=============================");
    }
}
