package sqlprog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;


//Try with resources saves a lot of closing...
public class SQLprog2 {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
        
        Properties p = new Properties();
        p.load(new FileInputStream("src/sqlprog/Settings.properties"));
        
        Class.forName("com.mysql.jdbc.Driver");

        boolean t = true;
        int m = 1;
        
        try (Connection con = DriverManager.getConnection(
                             p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));   
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("select category.id, shoeType ,shoe.id, shoe.color, shoe.size, shoe.label from category \n" +
            "inner join categorize on category.id = categorize.categoryId\n" +
            "inner join shoe on categorize.shoeId = shoe.id;")) {
            
            while(rs.next()){
                int typid = rs.getInt("category.id");
                String shoeType = rs.getString("shoeType");
                int id = rs.getInt("shoe.id");    
                String color = rs.getString("shoe.color");
                int size = rs.getInt("shoe.size");
                String label = rs.getString("shoe.label");
                
                if(typid == m){
                       
                } else {
                    m++;
                    t = true;
                    System.out.println();
                }
                            
                        
                if(t == true){
                    System.out.println(shoeType + ": ");
                    t = false;
                }
                        
            System.out.println("ProduktID: " + id + " Färg: " + color + " Storlek: " + size + " Märke: " + label);
                        
            }
                
            System.out.println();  
                
               
                        
                
                
                
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
