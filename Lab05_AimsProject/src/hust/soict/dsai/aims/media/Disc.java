package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length; 
    private String director; 

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost); // Gọi constructor của lớp Media
        this.length = length;
        this.director = director;
    }
    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

   
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public void displayInfo() {
        System.out.println("Disc ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Director: " + director);
        System.out.println("Length: " + length + " minutes");
        System.out.println("Cost: $" + getCost());
    }
}
