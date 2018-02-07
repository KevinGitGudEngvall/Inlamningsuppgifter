
package sqlprog;


public class Category {
    
    private int id;
    private String shoeType;
    
    public Category(){}
    public Category(int id, String shoeType){
        this.id = id;
        this.shoeType = shoeType;
        
    }
    
    public void setShoeType(String shoeType){
        this.shoeType = shoeType ;
    }
    
    public String getShoeType(){
        return shoeType;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
}
