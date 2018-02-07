package sqlprog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


//Try with resources saves a lot of closing...
public class SQLprogMap {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
        
        int n = 0;
        int kundId = 0;
        
        Properties p = new Properties();
        p.load(new FileInputStream("src/sqlprog/Settings.properties"));
        
        Class.forName("com.mysql.jdbc.Driver");

        
        try (Connection con = DriverManager.getConnection(
                             p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));   
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("select customer.id, customer.name, sum(price) as total from customer\n" +
            "inner join orders on customer.id = orders.customerId\n" +
            "inner join ordering on orders.id = ordering.ordersId\n" +
            "inner join shoe on ordering.shoeId = shoe.id\n" +
            "group by customer.name;")) {
            
            String s = JOptionPane.showInputDialog(null, "Skriv in ett KundId: ");
            if(!s.equals("")){
            kundId = Integer.parseInt(s);
            }
            
            List<Map<String, Object>> row = new ArrayList<Map<String, Object>>();
            ResultSetMetaData metaData = rs.getMetaData();
            int colCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> columns = new HashMap<String, Object>();
                for (int i = 1; i <= colCount; i++) {
                    columns.put(metaData.getColumnLabel(i), rs.getObject(i));
                }

                row.add(columns);
                
                
                if(row.get(n).containsValue(kundId)){
                System.out.println(row.get(n).toString());
                }
                
                n++;
            }

            

            

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
