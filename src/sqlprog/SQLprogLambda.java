package sqlprog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;


//Try with resources saves a lot of closing...
public class SQLprogLambda {

    
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
        
        Properties p = new Properties();
        p.load(new FileInputStream("src/sqlprog/Settings.properties"));
        
        Class.forName("com.mysql.jdbc.Driver");

        int n = 0;
        int m = 1;
        boolean t = true;
        
        try (Connection con = DriverManager.getConnection(
                             p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));   
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("select category.id as catId, shoeType ,shoe.id as proId, shoe.color, shoe.size, shoe.label, shoe.name from category \n" +
            "inner join categorize on category.id = categorize.categoryId\n" +
            "inner join shoe on categorize.shoeId = shoe.id;")) {
             
            ResultSetMetaData metaData = rs.getMetaData();
            int colCount = metaData.getColumnCount();

            while (rs.next()) {
                int typid = rs.getInt("catId");
                String shoeType = rs.getString("shoeType");
                Map<String, Object> columns = new HashMap<String, Object>();
                for (int i = 1; i <= colCount; i++) {
                    if(i != 1 && i != 2){
                    columns.put(metaData.getColumnLabel(i), rs.getObject(i));
                    }
                }
               
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
                
                columns.forEach((k,v)->System.out.print(k + ": " + v + "\t"));
                System.out.println();
                
               n++;
                
            }    
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
