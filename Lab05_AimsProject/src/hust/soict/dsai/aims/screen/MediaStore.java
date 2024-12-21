package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;

public class MediaStore extends JPanel{
	private Cart cart;
	private Media media;
	public MediaStore(Media media, Cart cart) {
		this.cart = cart;
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(e -> {
        	if (cart != null) {  // Kiểm tra cart có null hay không
                cart.addMedia(media);
                System.out.println("Added to cart: " + media.getTitle());
            } else {
                System.out.println("Cart is not initialized!");
            }
        });
        
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                JDialog playDialog = new JDialog();
                playDialog.setLayout(new FlowLayout(FlowLayout.CENTER));
                playDialog.setTitle("Playing: " + media.getTitle());
                playDialog.setSize(300, 200);
                JLabel mediaLabel = new JLabel("Now playing: " + media.getTitle());
                mediaLabel.setAlignmentX(CENTER_ALIGNMENT);
                playDialog.add(mediaLabel);
                playDialog.setVisible(true); 
            });
            container.add(playButton);  
		}
		
		container.add(addToCartButton);
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	 static JDialog createPlayDialog(Media media) {
	        JDialog playDialog = new JDialog();
	        Container container = playDialog.getContentPane();
	        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
	        container.add(Box.createRigidArea(new Dimension(10,10)));
	        if(media instanceof DigitalVideoDisc dvd) {
	            container.add(new JLabel("Playing DVD:" + dvd.getTitle()));
	            container.add(new JLabel("DVD length:" + dvd.getLength() +" min"));
	        } else if (media instanceof CompactDisc cd) {
	            container.add(new JLabel("Title: " + cd.getTitle()));
	            container.add(new JLabel("Artist: " + cd.getArtist()));
	            for (Track track : cd.getTracks()) {
	                container.add(new JLabel("Play: " + track.getTitle() + ". Length: " + track.getLength() + " min"));
	            }
	        }
	        playDialog.setTitle("Play " + media.getTitle());
	        return playDialog;
	    }
}
