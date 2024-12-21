package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title; 
    private int length;  

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public Track(String title) {
        this.title = title;
        this.length = 4; 
    }
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void displayTrackInfo() {
        System.out.println("Track Title: " + title);
        System.out.println("Track Length: " + length + " minutes");
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Track other = (Track) obj;
        return title != null && title.equals(other.title) && length == other.length;
    }
    @Override
    public void play()  throws PlayerException{
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length + " minutes");
    }
}
