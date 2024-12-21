

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public Cart() {
		qtyOrdered = 0; 
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added.");
			
		} else {
			System.out.println("The cart is almost full!");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int indexToRemove = -1;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				indexToRemove = i;
				break;
			}
		}
		if (indexToRemove != -1) {
			for (int i = indexToRemove; i < qtyOrdered - 1; i++) {
				itemsOrdered[i] = itemsOrdered[i + 1];
			}
			itemsOrdered[qtyOrdered - 1] = null;
			qtyOrdered--;
			System.out.println("The disc has been removed.");
		} else {
			System.out.println("The item passed is not found in the cart.");
		}
	}
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	public void displayCartInfo() {
		System.out.println("Items in your cart:");
		for (int i = 0; i < qtyOrdered; i++) {
			itemsOrdered[i].displayInfo();
		}
		System.out.println("Total cost: $" + totalCost());
	}
	//lab03: overloading
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	    for (DigitalVideoDisc dvd : dvdList) {
	        this.addDigitalVideoDisc(dvd); 
	    }
	}
// TRUYEN DOI SO TUY Y (TUONG TU VOI TRUYEN MANG NHUNG TIEN HON)
//	public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
//	    for (DigitalVideoDisc dvd : dvds) {
//	        this.addDigitalVideoDisc(dvd); 
//	    }
//	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    this.addDigitalVideoDisc(dvd1); // Gọi phương thức cơ bản để thêm đĩa thứ nhất
	    this.addDigitalVideoDisc(dvd2); // Gọi phương thức cơ bản để thêm đĩa thứ hai
	}


	
}


 