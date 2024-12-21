package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    // Tạo phần trên của giao diện
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Tạo menu bar
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store);
                addBookScreen.setVisible(true);
            }
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            AddCDToStoreScreen addCDScreen = new AddCDToStoreScreen(store);
            addCDScreen.setVisible(true);
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            AddDVDToStoreScreen addDVDScreen = new AddDVDToStoreScreen(store);
            addDVDScreen.setVisible(true);
        });
        smUpdateStore.add(addDVDItem);
        
        menu.add(smUpdateStore);
        
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        menu.add(viewStoreItem);
        
        JMenuItem viewCartItem = new JMenuItem("View Cart");
        viewCartItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo đối tượng CartScreen với đối tượng cart hiện tại
                CartScreen cartScreen = new CartScreen(cart, store); 
                cartScreen.setSize(800, 600); // Đặt kích thước cho CartScreen
                cartScreen.setVisible(true);  // Hiển thị CartScreen
                setVisible(false);  // Ẩn StoreScreen đi
            }
        });
        menu.add(viewCartItem);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        
        return menuBar;
    }

    // Tạo header
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        
        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        cart.addActionListener(e -> viewCart());
        
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
            
        return header;
    }

    // Tạo phần giữa của giao diện
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        
        int totalItems = mediaInStore.size();
        System.out.println("Total number of items in store: " + totalItems);
        
        for(int i = 0; i < totalItems; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }
        return center;
    }
    
    // Constructor
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    // Xem giỏ hàng
    private void viewCart() {
        System.out.println("Items in Cart:");
        ObservableList<Media> items = cart.getItemsOrdered();
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Media media : items) {
                System.out.println(media.getTitle());
            }
        }
    }
}
