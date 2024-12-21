package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;
    
    public CartScreen(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;

        // Tạo JFXPanel để nhúng JavaFX vào Swing
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setSize(800, 600); // Thêm kích thước cho JFrame
        this.setVisible(true);

        // Khởi tạo JavaFX trong một thread riêng
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Tải FXML và set controller
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart, store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
