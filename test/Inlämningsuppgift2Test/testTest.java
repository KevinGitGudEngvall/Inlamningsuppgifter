
package Inlämningsuppgift2Test;

import inlämningsuppgift2.Customer;
import inlämningsuppgift2.Databas;
import inlämningsuppgift2.Inlämningsuppgift2;
import java.io.File;
import javax.swing.JOptionPane;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;

public class testTest {
    
    Inlämningsuppgift2 InLäm;
    Databas Da = new Databas();
    Customer C = new Customer();
    
    @Before
    public void setUp() throws Exception{
        InLäm = new Inlämningsuppgift2();
    }
    
    @Test
    public void fileExist() throws Exception {
    
        File data = new File("customerdata.txt");
        
        TestCase.assertTrue(data.exists());
        
    
    }
    
    @Test
    public void fileExistNot() throws Exception {
    
        File data = new File("customerdatahgfhj.txt");
        
        TestCase.assertFalse(data.exists());
        
    
    }
    
    @Test
    public void cameOutRight() throws Exception {
        
        
        File data = new File("customerdata.txt");
       
        String femtePersonsDatum = Da.läserFil(data);
        
        
        TestCase.assertTrue(femtePersonsDatum.equals("2008-4-7"));
    
    }
    
    @Test
    public void cameOutWrong() throws Exception {
        
        
        File data = new File("customerdata.txt");
       
        String femtePersonsDatum = Da.läserFil(data);
        
        
        TestCase.assertFalse(femtePersonsDatum.equals("2008-04-07"));
    
    }
    
    
    
    
    @Test
    public void giveMeRight() throws Exception {
        
        File data = new File("customerdata.txt");
       
        Da.läserFil(data);
        
        String inNamn = "Bear Belle";
       
        boolean fickNågot = Da.checkCustomer(inNamn);
        
        
        TestCase.assertEquals(true, fickNågot);
        
    
    }
    
    @Test
    public void giveMeWrong() throws Exception {
        
        File data = new File("customerdata.txt");
       
        Da.läserFil(data);
        
        String inNamn = "Bea Belle";
       
        boolean fickNågot = Da.checkCustomer(inNamn);
        
        
        TestCase.assertEquals(false, fickNågot);
        
    
    }
    
    
    
}
