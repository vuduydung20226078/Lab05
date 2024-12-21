package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CartScreenController {
    private Cart cart;
    private Store store;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private Label totalPrice;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private MenuItem backToStore;

    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(FXCollections.observableList(this.cart.getItemsOrdered()));
        tblMedia.setPlaceholder(new Label("No item in cart"));
//        backToStore.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.close();  // Đóng cửa sổ hiện tại
//
//                // Tạo cửa sổ Swing cho StoreScreen
//                JFrame storeFrame = new JFrame("Store");
//                storeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                // Tạo giao diện StoreScreen trong Swing
//                StoreScreen storeScreen = new StoreScreen(store, cart);  // Truyền đối tượng cart và store vào StoreScreen
//                storeFrame.getContentPane().add(storeScreen);  // Thêm StoreScreen vào JFrame
//
//                storeFrame.setSize(1024, 768);  // Cài đặt kích thước cửa sổ Store
//                storeFrame.setVisible(true);  // Hiển thị cửa sổ Store
//            }
//        });

        btnPlay.setVisible(false);
        btnPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JDialog playDialog = MediaStore.createPlayDialog(tblMedia.getSelectionModel().getSelectedItem());
                playDialog.setVisible(true);
                playDialog.setSize(600,400);
                playDialog.pack();
            }
        });
        btnRemove.setVisible(false);
        btnRemove.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Media media = tblMedia.getSelectionModel().getSelectedItem();
                cart.removeMedia(media);
                totalPrice.setText(Float.toString(cart.totalCost()) +"$");
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            }
        });
        btnPlaceOrder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createPopUp();
                cart.getItemsOrdered().clear();
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
                totalPrice.setText(Float.toString(cart.totalCost()) + "$");
            }
        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                showFilterMedia(t1);
            }
        });
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        			new ChangeListener<Media>() {
        			@Override
        			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
        				if(newValue != null) {
        					updateButtonBar(newValue);
        				}
        			}
        		});
        totalPrice.setText(Float.toString(cart.totalCost()) + "$");
      
    }
    @FXML
    void updateButtonBar(Media media) {
    	 System.out.println("0");
    	btnRemove.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
  
    @FXML
    void showFilterMedia(String input) {
    	if (input == null || input.isEmpty()) {
    		return;
        }
        if (filterCategory.getSelectedToggle() == radioBtnFilterTitle) {
            ArrayList<Media> filterByTitle = new ArrayList<Media>();
            for (Media item : cart.getItemsOrdered()) {
                if (item.getTitle().contains(input)) {
                    filterByTitle.add(item);
                }
            }
            tblMedia.setItems(FXCollections.observableList(filterByTitle));
        } else if (filterCategory.getSelectedToggle() == radioBtnFilterId) {
            ArrayList<Media> filterByID = new ArrayList<Media>();
            for (Media item : cart.getItemsOrdered()) {
                if (item.getId() == Integer.parseInt(input)) {
                    filterByID.add(item);
                }
            }
            tblMedia.setItems(FXCollections.observableList(filterByID));
        }
    }
    @FXML
    void createPopUp() {
        Stage popupwindow =new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Place order");

        Label label1 = new Label("You have place your order !");
        label1.setFont(Font.font("Arial", FontWeight.BOLD,14));
        Label label2 = new Label("Your bill total is " + Float.toString(cart.totalCost()) + "$");
        Button button1= new Button("OK !");
        label2.setTextFill(Color.RED);
        button1.setOnAction(e -> popupwindow.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, label2,button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 200);
        popupwindow.setScene(scene1);
        popupwindow.show();
    }
    @FXML
    private void viewStore() {
        // Mở lại màn hình Store với tham chiếu store và cart hiện tại
        new StoreScreen(store, cart); // Mở màn hình Store
 
       
    }
}
