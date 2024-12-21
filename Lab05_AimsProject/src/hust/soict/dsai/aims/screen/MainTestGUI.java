package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class MainTestGUI {
    public static void main(String[] args) {
       
        Book book1 = new Book(1, "Java Programming1", "Programming", 19.99f);
        book1.addAuthor("John Doe");
        Disc disc1 = new Disc(2, "Inception1", "Movie", 14.99f, 148, "Christopher Nolan");
        CompactDisc cd1 = new CompactDisc(9, "Greatest Hits1", "Music", 9.99f, "The Beatles");
        
        Book book2 = new Book(3, "Java Programming2", "Programming", 19.99f);
        book2.addAuthor("John Doe");
        Disc disc2 = new Disc(4, "Inception2", "Movie", 14.99f, 148, "Christopher Nolan");
        CompactDisc cd2 = new CompactDisc(7, "Greatest Hits2", "Music", 9.99f, "The Beatles");
        Book book3 = new Book(5, "Java Programming2", "Programming", 19.99f);
        book3.addAuthor("John Doe");
        Disc disc3 = new Disc(6, "Inception2", "Movie", 14.99f, 148, "Christopher Nolan");
        CompactDisc cd3 = new CompactDisc(8, "Greatest Hits2", "Music", 9.99f, "The Beatles");
        
        Store store = new Store();
        store.addMedia(book1);
        store.addMedia(disc1);
        store.addMedia(cd1);
        store.addMedia(book2);
        store.addMedia(disc2);
        Cart cart = new Cart(); 

        
        // Khởi tạo StoreScreen và hiển thị GUI
        new StoreScreen(store, cart);
    }
}
