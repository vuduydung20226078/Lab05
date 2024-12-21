package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();  
    private ArrayList<Media> cart = new ArrayList<>();
    public void addMedia(Media media) {
        if (media != null) {
            itemsInStore.add(media);
            System.out.println("Added media: " + media.getTitle() + " to the store.");
        } else {
            System.out.println("Cannot add null media to the store.");
        }
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public void removeMedia(Media media) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).equals(media)) {
                System.out.println("Removed media: " + itemsInStore.get(i).getTitle() + " from the store.");
                itemsInStore.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found: " + media.getTitle());
        }
    }

    public void addMediaToCart(Media media) {
        if (media != null && !cart.contains(media)) {
            cart.add(media);
            System.out.println("Added media: " + media.getTitle() + " to the cart.");
        } else {
            System.out.println("Media already in cart or invalid.");
        }
    }
    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; 
    }
    public void removeMediaFromCart(Media media) {
        if (cart.contains(media)) {
            cart.remove(media);
            System.out.println("Removed media: " + media.getTitle() + " from the cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }
    public void displayCart() {
        System.out.println("********** Cart **********");
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (Media media : cart) {
                System.out.println(media.toString());
            }
        }
    }
    public void clearCart() {
        cart.clear();
        System.out.println("The cart has been cleared.");
    }
    public boolean removeMediaByTitle(String title) {
        Media media = searchMediaByTitle(title);
        if (media != null) {
            itemsInStore.remove(media);
            return true;
        }
        return false; 
    }
    public int getNumberOfItemsInStore() {
        return itemsInStore.size();
    }
    public void displayStore() {
        System.out.println("******************* STORE *******************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                itemsInStore.get(i).displayInfo();  // Hiển thị thông tin từng phương tiện
            }
        }
        System.out.println("*********************************************");
    }
}
