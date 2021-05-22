package SkyluxSky;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        //Always initialize arraylist in constructor for a class that must utilize it within its methods...
        this.songs = new ArrayList<Song>();
    }

    //Ensures that all songs can only be added once.
    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    //Finds Songs
    private Song findSong(String title){
        //For-Each Loop
        //creates a variable of checkedSong for every entry in our array list.
        for (Song checkedSong: this.songs){
            if (checkedSong.getTitle().equals(title)){
                //returns title
                return checkedSong;
            }
        }
        return null;
    }

    //Adds song to playlist
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        //tracks start from 1 instead of zero
        int index = trackNumber - 1;

        //Checks if their is a song in an index position.
        if((index >= 0) && (index <= this.songs.size())){
            //adds song to linked list
            playlist.add(this.songs.get(index));
            return true;
        }

        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    //Adds song to playlist - Overloaded Method
    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song checkSong = findSong(title);

        //Checks if their is a song in an index position.
        if(checkSong != null){
            playlist.add(checkSong);
            return true;
        }

        System.out.println("The song " + title + " is not in this album");
        return false;
    }



}
