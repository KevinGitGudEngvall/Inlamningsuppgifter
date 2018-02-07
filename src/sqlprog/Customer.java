
package sqlprog;


public class Customer {
    
    private int id;
    private String name;
    private String county;
    
    Customer(){}
    Customer(int id, String name, String county){
        this.id = id;
        this.name = name;
        this.county = county;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setCounty(String County){
        this.county = county;
    }
    
    public String getCounty(){
        return county;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
}
