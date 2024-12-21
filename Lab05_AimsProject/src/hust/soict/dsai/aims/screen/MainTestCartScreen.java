package hust.soict.dsai.aims.screen;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainTestCartScreen extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Khởi tạo giỏ hàng và các media
            Cart cart = new Cart();
            Book book1 = new Book(1, "Java Programming1", "Programming", 19.5f);
            book1.addAuthor("John Doe");
            Disc disc1 = new Disc(2, "Inception1", "Movie", 14.5f, 148, "Christopher Nolan");

            ArrayList<Track> tracks2 = new ArrayList<Track>();
            tracks2.add(new Track("Tobu - Candyland",3));
            tracks2.add(new Track("Niviro - You",4));
            tracks2.add(new Track("MBB - Beach",2));
            tracks2.add(new Track("MBB - Island",4));
            tracks2.add(new Track("MBB - Feel Good",3));
            tracks2.add(new Track("Alan Walker - Force",4));
            tracks2.add(new Track("Syn Cole - Feel Good (Best of 2016 EDM)",4));
            tracks2.add(new Track("Syn Cole - Gizmo",4));
            tracks2.add(new Track("Deamn - Sign",4));
            tracks2.add(new Track("MBB - Arrival",3));
            tracks2.add(new Track("EnV - Pneumatic",5));
            CompactDisc cd1 = new CompactDisc(4,"Nhac EDM gay nghien","Nhac quoc te",37.5f,"Various artist",tracks2);
            ArrayList<Track> tracks = new ArrayList<Track>();
            tracks.add(new Track("Happy new year",3));
            tracks.add(new Track("i want it that way",4));
            CompactDisc cd2 = new CompactDisc(3,"Nhac 90's","Nhac nuoc ngoai",20.5f,"Various artist",tracks);
            cart.addMedia(book1);
            cart.addMedia(disc1);
            cart.addMedia(cd1);
            cart.addMedia(cd2);
            cart.displayCartInfo();
            Store store = new Store();
            CartScreen cartScreen = new CartScreen(cart, store);
            cartScreen.setSize(1000, 700);
            cartScreen.setTitle("Cart Screen");
            cartScreen.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); 
    }
}
