package sqlprog;

import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SQLprog3 {
    
    public SQLprog3() throws InterruptedException{
        SQLprog3Rep r = new SQLprog3Rep();
        int anv = 0;
        int best = 0;
        int skopro = 0;
        
        
        while(true){
            
            anv = r.getAnv();
            
            System.out.println();
            
            skopro = r.getSkopro();
            
            System.out.println();
            
            best = r.getKundB(anv);
            
            break;
        }
        
        //System.out.println(anv);
        //System.out.println(best);
        //System.out.println(skopro);
        
        System.out.println(r.AddToCart(anv, best, skopro));
        
    }
    
    public static void main(String args[]) throws InterruptedException {
        SQLprog3 prog = new SQLprog3();
    }
}