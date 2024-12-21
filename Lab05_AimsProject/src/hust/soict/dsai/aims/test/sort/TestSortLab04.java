package hust.soict.dsai.aims.test.sort;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
public class TestSortLab04 {
    public static void main(String[] args) {
        // Tạo đối tượng Media và giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        Book book1 = new Book(3, "Java Programming", "Educational", 29.99f);
        CompactDisc cd1 = new CompactDisc(4, "Greatest Hits", "Music", 15.50f, "The Beatles");

        Cart cart = new Cart();
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(book1);
        cart.addMedia(cd1);

        // Hiển thị trước khi sắp xếp
        System.out.println("Before sorting:");
        cart.displayCartInfo();

        // Sắp xếp theo tiêu đề rồi đến chi phí
        cart.sortByTitleAndCost();
        System.out.println("\nAfter sorting by Title and Cost:");
        cart.displayCartInfo();

        // Sắp xếp theo chi phí rồi đến tiêu đề
        cart.sortByCostAndTitle();
        System.out.println("\nAfter sorting by Cost and Title:");
        cart.displayCartInfo();
    }
}
