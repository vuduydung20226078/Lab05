public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Jungle Book", "Adventure", "Unknown", 95, 20.50f);

    
        System.out.println("Adding one DVD:");
        anOrder.addDigitalVideoDisc(dvd1); 

       
        System.out.println("Adding two DVDs:");
        anOrder.addDigitalVideoDisc(dvd2, dvd3); 

      
        System.out.println("Adding DVDs from an array:");
        DigitalVideoDisc[] dvdArray = {dvd1, dvd2, dvd3, dvd4};
        anOrder.addDigitalVideoDisc(dvdArray);

        // TRUYEN DOI SO TUY Y
//        System.out.println("Adding DVDs using varargs:");
//        anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4); 

        System.out.println("Cart content:");
        anOrder.displayCartInfo();
    } 
}
