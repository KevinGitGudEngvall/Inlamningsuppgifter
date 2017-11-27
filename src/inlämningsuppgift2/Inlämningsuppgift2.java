
package inlämningsuppgift2;

import java.io.*;
import javax.swing.JOptionPane;


public class Inlämningsuppgift2 {
    
    
    public static void main(String[] args) throws IOException {
        
        
        File data = new File("customerdata.txt");
        
        Databas D = new Databas();
        
        String check = D.läserFil(data);

        System.out.println(check);
        
        D.checkCustomer(JOptionPane.showInputDialog("Skriv personens hel namn eller personnummer"));
        
    }
    
}
