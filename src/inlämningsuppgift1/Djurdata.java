
package inlämningsuppgift1;

import java.util.*;
import javax.swing.JOptionPane;

public class Djurdata {
    
    // inkapslingar
    private Hund Sixten = new Hund("Sixten", 5000, "hundfoder");
    private Hund Dogge = new Hund("Dogge", 10000, "hundfoder"); 
    private Katt Venus = new Katt("Venus", 5000, "kattfoder"); 
    private Katt Ove = new Katt("Ove", 3000, "kattfoder"); 
    private Orm Hypno = new Orm("Hypno", 1000, "ormpellets");
    
    public List<INeeds> getWanted(String n){
        
        List <INeeds> wanted = new ArrayList<>();
        
        n = n.toLowerCase().trim();
        
        if(n.matches("sixten")){
            wanted.add(Sixten);
        } else if(n.matches("dogge")){
            wanted.add(Dogge);
        } else if(n.matches("venus")){
            wanted.add(Venus);
        } else if(n.matches("ove")){
            wanted.add(Ove);
        } else if(n.matches("hypno")){
            wanted.add(Hypno);
        } else {
            JOptionPane.showMessageDialog(null, n + " finns inte på"
            + " hotellet HealthyPets");
        } 
        
        return wanted;
    }
}
