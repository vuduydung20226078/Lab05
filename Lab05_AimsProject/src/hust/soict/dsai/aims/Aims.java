package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Scanner;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static Store store = new Store();
	private static Cart currentCart = new Cart();

	public static void main(String[] args)  throws PlayerException{
		// Some sample data for testing
		store.addMedia(new Book(0, "Java Programming", "Technology", 29.99f));
		store.addMedia(new DigitalVideoDisc(1, "The Lord of the Rings", "Fantasy", "Peter Jackson", 180, 19.99f));
		store.addMedia(new CompactDisc(2, "Michael Jackson's Thriller", "Pop", 15.99f, "John Landis" ));

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			showMenu();
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline
			switch (choice) {
			case 1:
				viewStore(scanner);
				break;
			case 2:
				updateStore(scanner);
				break;
			case 3:
				seeCurrentCart(scanner);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);

		scanner.close();
	}

	// Show the main menu
	public static void showMenu()  throws PlayerException{
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	// Handle viewing the store
	public static void viewStore(Scanner scanner)  throws PlayerException{
		store.displayStore();
		int choice;
		do {
			storeMenu();
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline
			switch (choice) {
			case 1:
				seeMediaDetails(scanner);
				break;
			case 2:
				addToCart(scanner);
				break;
			case 3:
				playMedia(scanner);
				break;
			case 4:
				currentCart.displayCartInfo();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	// Store menu
	public static void storeMenu()  throws PlayerException{
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	// See media details
	public static void seeMediaDetails(Scanner scanner)  throws PlayerException{
		System.out.print("Enter media title: ");
		String title = scanner.nextLine();
		Media media = findMediaByTitle(title);
		if (media != null) {
			System.out.println(media.toString());
			mediaDetailsMenu(scanner, media);
		} else {
			System.out.println("Media not found.");
		}
	}

	// Find media by title
	public static Media findMediaByTitle(String title) {
		for (Media media : store.getItemsInStore()) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		return null;
	}

	// Media details menu
	public static void mediaDetailsMenu(Scanner scanner, Media media) throws PlayerException {
		int choice;
		do {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");

			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline
			switch (choice) {
			case 1:
				currentCart.addMedia(media);
				break;
			case 2:
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("This media cannot be played.");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	// Add media to cart
	public static void addToCart(Scanner scanner)  throws PlayerException{
		System.out.print("Enter media title to add to cart: ");
		String title = scanner.nextLine();
		Media media = findMediaByTitle(title);
		if (media != null) {
			currentCart.addMedia(media);
			System.out.println("Media added to cart.");
		} else {
			System.out.println("Media not found.");
		}
	}

	// Play media
	public static void playMedia(Scanner scanner) throws PlayerException {
		System.out.print("Enter media title to play: ");
		String title = scanner.nextLine();
		Media media = findMediaByTitle(title);
		if (media != null && media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("Media not found or cannot be played.");
		}
	}

	// Update store (add or remove media)
	public static void updateStore(Scanner scanner)  throws PlayerException{
		System.out.println("1. Add media to store");
		System.out.println("2. Remove media from store");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline
		if (choice == 1) {
			addMediaToStore(scanner);
		} else if (choice == 2) {
			removeMediaFromStore(scanner);
		}
	}

	// Add media to store
	
	public static void addMediaToStore(Scanner scanner)  throws PlayerException{
	    System.out.println("Enter media type (Book, DVD, CD): ");
	    String type = scanner.nextLine();
	    System.out.println("Enter title: ");
	    String title = scanner.nextLine();
	    System.out.println("Enter category: ");
	    String category = scanner.nextLine();
	    System.out.println("Enter cost: ");
	    float cost = scanner.nextFloat();
	    scanner.nextLine();  // Consume the newline character after reading the float

	    System.out.println("Enter ID: ");
	    int id = scanner.nextInt();
	    scanner.nextLine();  // Consume the newline character after reading the int

	    if (type.equalsIgnoreCase("Book")) {
	        store.addMedia(new Book(id, title, category, cost));
	    } else if (type.equalsIgnoreCase("DVD")) {
	        System.out.println("Enter director: ");
	        String director = scanner.nextLine();
	        System.out.println("Enter length: ");
	        int length = scanner.nextInt();
	        scanner.nextLine();  // Consume the newline character after reading the int
	        store.addMedia(new DigitalVideoDisc(id, title, category, director, length, cost));
	    } else if (type.equalsIgnoreCase("CD")) {
	        System.out.println("Enter artist: ");
	        String artist = scanner.nextLine();
	        System.out.println("Enter director: ");
	        String director = scanner.nextLine();
	        scanner.nextLine();  // Consume the newline character after reading the int
	        store.addMedia(new CompactDisc(id, title, category, cost, artist));
	    } else {
	        System.out.println("Invalid media type.");
	    }
	}


	// Remove media from store
	public static void removeMediaFromStore(Scanner scanner) {
		System.out.print("Enter media title to remove: ");
		String title = scanner.nextLine();
		Media media = findMediaByTitle(title);
		if (media != null) {
			store.removeMedia(media);
		} else {
			System.out.println("Media not found.");
		}
	}

	// See current cart
	public static void seeCurrentCart(Scanner scanner)  throws PlayerException{
		currentCart.displayCartInfo();
		int choice;
		do {
			cartMenu();
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline
			switch (choice) {
			case 1:
				filterCart(scanner);
				break;
			case 2:
				sortCart(scanner);
				break;
			case 3:
				removeMediaFromCart(scanner);
				break;
			case 4:
				playMediaFromCart(scanner);
				break;
			case 5:
				placeOrder();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}

	// Cart menu
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	// Filter medias in cart
	public static void filterCart(Scanner scanner) {
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline
		if (choice == 1) {
			// Implement filter by ID
		} else if (choice == 2) {
			// Implement filter by title
		} else {
			System.out.println("Invalid choice.");
		}
	}

	// Sort medias in cart
	public static void sortCart(Scanner scanner) {
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline
		if (choice == 1) {
			// Implement sort by title
		} else if (choice == 2) {
			// Implement sort by cost
		} else {
			System.out.println("Invalid choice.");
		}
	}

	// Remove media from cart
	public static void removeMediaFromCart(Scanner scanner) {
		System.out.print("Enter media title to remove from cart: ");
		String title = scanner.nextLine();
		Media media = findMediaByTitle(title);
		if (media != null) {
			currentCart.removeMedia(media);
		} else {
			System.out.println("Media not found in cart.");
		}
	}

	// Play media from cart
	public static void playMediaFromCart(Scanner scanner)  throws PlayerException{
		System.out.print("Enter media title to play from cart: ");
		String title = scanner.nextLine();
		Media media = findMediaByTitle(title);
		if (media != null && media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("Media not found in cart or cannot be played.");
		}
	}

	// Place order (simplified)
	public static void placeOrder() {
		System.out.println("Order placed successfully.");
		store.clearCart();
	}
}
