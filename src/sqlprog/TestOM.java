
package sqlprog;

import java.util.Date;


public class TestOM {
    
    public TestOM() throws InterruptedException{
        
        // Exempel och testningar
        
        Customer kevin = new Customer(1, "Kevin", "Bromma");
        Customer marie = new Customer(2, "Marie", "Sollentuna");
        
        Shoe wowie = new Shoe(1,"Wowie", "Red", 42, "Vans", 399, 3);
        Shoe lovely = new Shoe(2, "Lovely", "White", 39, "Zara", 599, 2);
        Shoe babySho = new Shoe(3, "Baby Sho", "Blue", 29, "Baby Shop", 299, 4);
        
        Orders o1 = new Orders(1, new Date(2018, 2, 4), kevin, false);
        Orders o2 = new Orders(1, new Date(2018, 2, 5), marie, false);
        
        Ordering ord1 = new Ordering(1, o1, wowie);
        Ordering ord2 = new Ordering(2, o2, wowie);
        Ordering ord3 = new Ordering(3, o2, babySho);
        
        System.out.println(ord1.getOrdersId().getCustomerID().getName() + " har köpt " + ord1.getShoeId().getName());
        System.out.println(ord3.getOrdersId().getCustomerID().getName() + " har köpt " + ord3.getShoeId().getName());
        
        
        
        
        
    }
    
    public static void main(String args[]) throws InterruptedException {
        TestOM t = new TestOM();
    }
    
}
