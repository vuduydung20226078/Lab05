package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPolymorphism {
    public static void main(String[] args) {
        ArrayList<Media> mediae = new ArrayList<>();

        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book(2, "Java Programming", "Educational", 29.99f);
        CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 15.50f, "The Beatles");

        mediae.add(dvd);
        mediae.add(book);
        mediae.add(cd);

       
        for (Media m : mediae) {
            System.out.println(m.toString()); 
        }
    }
}

