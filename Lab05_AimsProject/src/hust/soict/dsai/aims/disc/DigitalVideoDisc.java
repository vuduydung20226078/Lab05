package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;
public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost, length, director); // Gọi constructor của Disc
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }
    @Override
    public void play()  throws PlayerException{
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength() + " minutes");
    }
    @Override
    public String toString() {
        return "DigitalVideoDisc [id=" + getId() + ", title=" + getTitle() + ", category=" + getCategory() 
                + ", director=" + getDirector() + ", length=" + getLength() + " minutes, cost=" + getCost() + "]";
    }
    
}
