
package Inlämningsuppgift2Test;

import javax.swing.JOptionPane;
import junit.framework.TestCase;
import org.junit.Test;

public class testTest {
    
    
    
    @Test
    public final void littlemathTest() {
        
    String s = JOptionPane.showInputDialog("2 + ? = 5 [Vad ska ? vara]");       
    int a = Integer.parseInt(s);
    int b = 2;
    int summa = a + b;
    
    TestCase.assertEquals(5, summa);
    }
    
    @Test
    public final void littleStringTest() {
        
    String a = JOptionPane.showInputDialog("skriv detta namn precis som det står? [Kevin]");
    String b = "Kevin";
    
    TestCase.assertEquals("Du skrev inte likadant", b, a);
    
    
    }
    
    @Test
    public final void littletrueTest() {
    boolean rättTal = false;    
    
    String s = JOptionPane.showInputDialog("Vilken av siffrorna 1 till 10 är rätt? [GISSA] ");
    
    int i = Integer.parseInt(s);
   
    if(i == 7){
        rättTal = true;
    }
   
    TestCase.assertTrue("Den rätta siffran är 7", rättTal);
    }

    
}
