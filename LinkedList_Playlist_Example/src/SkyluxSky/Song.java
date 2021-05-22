package SkyluxSky;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }


    //Simple method for printing out the contents of an object.
    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
