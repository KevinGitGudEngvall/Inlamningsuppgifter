
package inlämningsuppgift1;

import java.util.*;
import javax.swing.JOptionPane;

public class Inlämningsuppgift1 {

    public static void main(String[] args) {
        
        Djurdata djurdata = new Djurdata();
        
        boolean evig = true;
        
        while(evig){
        
            String valNamn = JOptionPane.showInputDialog("Vilket djur ska få mat?");
            
            if(valNamn == null){
                System.exit(0);
            }
            
            List <INeeds> needs = djurdata.getWanted(valNamn);
        
            if(needs.isEmpty() == false){
                INeeds I = needs.get(0);
                printNeed(I);
            }
        }
    }
    
    public static void printNeed(INeeds a){
        
        /* Här förekommer användingen av polymorfismen där rättMängd() 
           har olika kroppar beroende på vilken subclass av djur jag har
           anropat (Dynamisk bindning). */
        JOptionPane.showMessageDialog(null, a.getNamn() + " behöver " 
        + a.rättMängd(a.getVikt()) + " gram " + a.getMat());
    }
}
