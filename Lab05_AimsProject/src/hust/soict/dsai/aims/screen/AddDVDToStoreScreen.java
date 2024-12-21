package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDVDToStoreScreen extends JFrame {
    private Store store;
    private JTextField idField;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField lengthField;
    private JTextField directorField;

    public AddDVDToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add DVD to Store");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2)); // 7 rows, 2 columns
        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        panel.add(new JLabel("Length (minutes):"));
        lengthField = new JTextField();
        panel.add(lengthField);

        panel.add(new JLabel("Director:"));
        directorField = new JTextField();
        panel.add(directorField);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    float cost = Float.parseFloat(costField.getText());
                    int length = Integer.parseInt(lengthField.getText());
                    String director = directorField.getText();
                    Disc dvd = new Disc(id, title, category, cost, length, director);

                    store.addMedia(dvd);
                    JOptionPane.showMessageDialog(AddDVDToStoreScreen.this, "DVD added successfully!");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddDVDToStoreScreen.this, "Please enter valid data!");
                }
            }
        });
        panel.add(addButton);
        add(panel);
    }
}
