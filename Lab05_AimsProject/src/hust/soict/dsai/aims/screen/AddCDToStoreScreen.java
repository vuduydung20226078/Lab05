package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;


public class AddCDToStoreScreen extends JFrame {
    private Store store;
    private JTextField idField, titleField, categoryField, costField, artistField;
    private JTextArea tracksField;

    public AddCDToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add CD to Store");

        // Tạo các trường nhập liệu
        idField = new JTextField(20);
        titleField = new JTextField(20);
        categoryField = new JTextField(20);
        costField = new JTextField(20);
        artistField = new JTextField(20);
        tracksField = new JTextArea(5, 20);
        
        // Tạo nút Submit
        JButton btnSubmit = new JButton("Add CD");

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddCD();
            }
        });

        // Thiết lập giao diện
        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Category:"));
        add(categoryField);
        add(new JLabel("Cost:"));
        add(costField);
        add(new JLabel("Artist:"));
        add(artistField);
        add(new JLabel("Tracks (comma separated):"));
        add(tracksField);
        add(btnSubmit);

        setSize(300, 350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void handleAddCD() {
     
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String artist = artistField.getText();
        String[] trackNames = tracksField.getText().split(",");

        ArrayList<Track> tracks = new ArrayList<>();
        for (String trackName : trackNames) {
            Track track = new Track(trackName.trim()); 
        }

        CompactDisc cd = new CompactDisc(id, title, category, cost, artist, tracks);
        store.addMedia(cd);

        JOptionPane.showMessageDialog(this, "CD added to store successfully!");
        dispose();  
    }
}
