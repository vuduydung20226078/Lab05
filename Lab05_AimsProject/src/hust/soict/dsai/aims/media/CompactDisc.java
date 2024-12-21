package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist; 
    private ArrayList<Track> tracks; 

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost, 0, ""); 
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }
    public CompactDisc(int id, String title, String category, float cost,String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost);
        this.tracks = tracks;
        this.artist = artist;
        this.setLength(getLength());
    }
    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {  
            tracks.add(track);
            System.out.println("Track has been added.");
        } else {
            System.out.println("Track already exists.");
        }
    }


    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found.");
        }
    }
    public ArrayList<Track> getTracks() {
        return tracks;
    }
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    //implement method play() from Playable
    @Override
    public void play()  throws PlayerException{
        System.out.println("Playing Compact Disc: " + getTitle());
        System.out.println("Artist: " + artist);
        for (Track track : tracks) {
            track.play(); 
        }
    }
    @Override
    public String toString() {
        return "CompactDisc [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() 
                + ", cost=" + getCost() + ", artist=" + artist + "]";
    }

    @Override
    public void displayInfo() {
    	 System.out.println(this.toString());
    }
    
}
