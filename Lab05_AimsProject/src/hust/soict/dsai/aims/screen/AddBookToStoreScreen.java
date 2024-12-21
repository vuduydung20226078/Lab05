package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends JFrame {
    private Store store;
    private JTextField idField;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField authorField;
    public AddBookToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Book to Store");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2)); // 6 rows, 2 columns

        // ID Field
        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        // Title Field
        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        // Category Field
        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        // Cost Field
        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        // Author Field
        panel.add(new JLabel("Author:"));
        authorField = new JTextField();
        panel.add(authorField);

        // Add Book Button
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin từ các trường nhập liệu
                try {
                    int id = Integer.parseInt(idField.getText());
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    float cost = Float.parseFloat(costField.getText());
                    String authorName = authorField.getText();

                    // Tạo đối tượng Book
                    Book book = new Book(id, title, category, cost);

                    // Thêm tác giả vào sách
                    book.addAuthor(authorName);

                    // Thêm vào cửa hàng
                    store.addMedia(book);

                    // Hiển thị thông báo thành công
                    JOptionPane.showMessageDialog(AddBookToStoreScreen.this, "Book added successfully!");

                    // Đóng cửa sổ
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddBookToStoreScreen.this, "Please enter valid data!");
                }
            }
        });
        panel.add(addButton);

        add(panel);
    }
}
