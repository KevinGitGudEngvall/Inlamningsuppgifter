
package inlämningsuppgift2;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;


public class Databas {
    
    Customer[] C = new Customer[14];
    
    public Databas(){};
    
    
    public void läserFil(File data) throws IOException{
        try (Scanner sc = new Scanner(data);){
        
        int n = 0;
        
        
        while(sc.hasNext()){
            
            C[n] = new Customer();
             
            C[n].setPernum(sc.next().replace(",", ""));
            
            String förnamn = sc.next();
            String efternamn = sc.next();
            C[n].setNamn(förnamn + " " + efternamn);
            
            String perdatum = sc.next().replace("-", " ");
            Scanner sc2 = new Scanner(perdatum);
            C[n].setPeryear(sc2.nextInt());
            C[n].setPermonth(sc2.nextInt());
            C[n].setPerday(sc2.nextInt());
            
            n++;
        }
        } catch (InputMismatchException e) {
            System.out.println("Någon text från 'customerdata' har tagits bort eller ligger fel");
        } catch (Exception e) {
            System.out.println("Programmet hittar inte text filen eller så har något obergipligt hänt");
        }
        
       /* String s = "";
        int n = 0;
        for(int i = 0; i < C.length; i++){ 
            s = s + C[n].getPernum() + ", " + C[n].getNamn() + "\n" 
            + C[n].getPeryear() + "-"+ C[n].getPermonth() + "-"
            + C[n].getPerday() + "\n";
            n++;
        }
        
        JOptionPane.showMessageDialog(null, s);
        */
    }
    
    public void checkCustomer(String input) throws IOException {
        try (PrintWriter skriv = new PrintWriter(new BufferedWriter(new FileWriter("medlemmar.txt", true)));){
        LocalDate datum = LocalDate.now();
        int n = 0;
        int year = datum.getYear();
        int month = datum.getMonthValue();
        int day = datum.getDayOfMonth();
        boolean fylld = false;
        
        if(input == null){
            System.exit(0);
        }
        
        input = input.trim();
        
        while(n < C.length){
              
            if(input.equalsIgnoreCase(C[n].getNamn()) || input.matches(C[n].getPernum())){
                fylld = true;
                if(C[n].getPeryear() == year){
                    JOptionPane.showMessageDialog(null, C[n].getNamn() + " är en medlem" );
                    skriv.println(C[n].getPernum() + ", " + C[n].getNamn());
                    skriv.println("" + datum);
                } else if(C[n].getPeryear() == year - 1){
                    if(C[n].getPermonth() >= month){
                        JOptionPane.showMessageDialog(null, C[n].getNamn() + " är en medlem" );
                        skriv.println(C[n].getPernum() + ", " + C[n].getNamn());
                        skriv.println("" + datum);
                    } else if(C[n].getPermonth() == month) {
                        if(C[n].getPerday() >= day){
                            JOptionPane.showMessageDialog(null, C[n].getNamn() + " är en medlem" );
                            skriv.println(C[n].getPernum() + ", " + C[n].getNamn());
                            skriv.println("" + datum);
                            
                        } else {
                            JOptionPane.showMessageDialog(null, C[n].getNamn() + " var en före detta kund1" );
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, C[n].getNamn() + " var en före detta kund2" );
                    }
                } else {
                    JOptionPane.showMessageDialog(null, C[n].getNamn() + " var en före detta kund3" );
                }
            
            }
            
            n++;
        }
        
        skriv.close();
        
        if(fylld == false){
            JOptionPane.showMessageDialog(null, input + " är inte medlem, har namngivits fel eller har fel personnummer" );
        }   
        } catch ( NullPointerException e ){
            System.out.println("och har orsakat att fältet har element med 'null'. Kan orsaka att information och data inte kommer ut");
        } catch (Exception e){
            System.out.println("text filen hittas inte eller så har något obegripligt hänt");
        }
    }
    
    
}
