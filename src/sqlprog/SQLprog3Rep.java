package sqlprog;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;


public class SQLprog3Rep {

    private Properties p = new Properties();
    
    public SQLprog3Rep(){
        try {
            p.load(new FileInputStream("src/sqlprog/Settings.properties"));
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    public String AddToCart(int kundid, int bestid, int proid ){
       
        ResultSet rs = null;
        String query = "{call AddToCart(?,?,?)}";
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));
            CallableStatement stmt = con.prepareCall(query)){
            
            
            stmt.setInt(1, kundid);
            stmt.setInt(2, bestid);
            stmt.setInt(3, proid);
            stmt.execute(); 
           
            
            
            
        }
        catch (Exception e){
            return "Could not add order";
        }
        return "Done.";
    }
    
    public int getAnv(){
        
        int getAnvId = 0;
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name from customer;")){
            
            
            while(rs.next()){
       
                String name = rs.getString("name");
                
                System.out.println(name);
               
            }
            
            String valNamn = JOptionPane.showInputDialog(null, "Vilken Användare (skriv hela namn):");
            if (valNamn.equalsIgnoreCase("q")){
                System.exit(0);
            }
            
            valNamn = valNamn.toLowerCase().trim();
            
            rs.beforeFirst();
            
            while(rs.next()){
               
                String name = rs.getString("name");
                name = name.toLowerCase();
                int id = rs.getInt("id");
                
                if(name.equals(valNamn)){
                    getAnvId = id;
                }
                  
            }
             
        }
        catch (Exception e){
            System.out.println("Could not add order");
        }
        return getAnvId;
    }
    
    public int getSkopro(){
        
        int getSkoId = 0;
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, color, size, label, quantity from shoe;")){
            
            while(rs.next()){
                
                String name = rs.getString("name");
                String color = rs.getString("color");
                int size = rs.getInt("size");
                String label = rs.getString("label");
                int quan = rs.getInt("quantity");
                
                System.out.println("Namn: [" + name + "] Färg: [" + color + "] Storlek: [" + size + "] Märke: [" + label + "] Quantity: [" + quan + "]");
                 
            }  
            
            String valSko = JOptionPane.showInputDialog(null, "Vilken sko vill du ha (tryck in namnet):");
            if (valSko.equalsIgnoreCase("q")){
                System.exit(0);
            }
            
            valSko = valSko.toLowerCase().trim();
            
            rs.beforeFirst();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String name = rs.getString("name");
                name = name.toLowerCase();
                
                if(name.equals(valSko)){
                    getSkoId = id;
                }
                  
            }
                
        }
        catch (Exception e){
            System.out.println("Could not add order");
        }
        return getSkoId;
    }
    
    public int getKundB(int a){
        
        int getKundId = 0;
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select orders.id, dates, orders.customerId, customer.name, orders.expedierad from orders\n" +
            "inner join customer on orders.customerId = customer.id\n" +
            "order by orders.id")){
            
            while(rs.next()){
                
                String dates = rs.getString("dates");
                int kund = rs.getInt("orders.customerId");
                String name = rs.getString("customer.name");
                int exped = rs.getInt("orders.expedierad");
                
                if(kund == a && exped == 0)
                System.out.println("Datum: " + dates + " Kund: " + name );
        
            } 
            
            String s2 = JOptionPane.showInputDialog(null, "Vilken icke expedierad bestälning vill du välja eller tryck 'n' för ny beställning\n "
            + "(välj genom att trycka in datumet exakt)");
            
            s2 = s2.trim();
            
            if (s2.equalsIgnoreCase("q")){
                System.exit(0);
            }
            
            rs.beforeFirst();
            
            while(rs.next()){
                
                int id = rs.getInt("orders.id");
                String dates = rs.getString("dates");
                
                if(dates.equals(s2)){
                    getKundId = id;
                }
                
                if(s2.equals("n")){
                    getKundId = id + 1;
                }
                
            } 
       
        }
        catch (Exception e){
            System.out.println("Could not add order");
        }
        return getKundId;
    }
    
    public String addPresent(String pn){
       
        ResultSet rs = null;
        String query = "{call addPresent(?)}";
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("anv"),
                             p.getProperty("password"));
            CallableStatement stmt = con.prepareCall(query)){
            
            
            stmt.setString(1, pn);
            
            stmt.execute(); 
           
            
            
            
        }
        catch (Exception e){
            return "Could not add order";
        }
        return "Done.";
    }
    
}

