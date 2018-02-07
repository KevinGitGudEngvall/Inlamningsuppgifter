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
public class SQLprog {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
        
        Properties p = new Properties();
        p.load(new FileInputStream("src/sqlprog/Settings.properties"));
        
        Class.forName("com.mysql.jdbc.Driver");

        
        try (Connection con = DriverManager.getConnection(
                             p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));   
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("select customer.id, customer.name, sum(price) from customer\n" +
            "inner join orders on customer.id = orders.customerId\n" +
            "inner join ordering on orders.id = ordering.ordersId\n" +
            "inner join shoe on ordering.shoeId = shoe.id\n" +
            "group by customer.name;")) {
            
            String s1 = JOptionPane.showInputDialog(null, "Skriv in ett KundId: ");

            while (rs.next()) {
                String id = rs.getString("customer.id");
                String name = rs.getString("name");
                String sum = rs.getString("sum(price)");
                   
                if(s1.equals(id)){
                System.out.println("Kund: " + name + " Besttällningsvärde: " + sum);
                }
                
                if(s1.equals("")){
                System.out.println("Kund: " + name + " besttällningsvärde: " + sum);
                }
                
                
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}