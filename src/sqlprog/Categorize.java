
package sqlprog;


public class Categorize {
    
    private int id;
    private Shoe shoeId;
    private Category categoryId;
    
    public Categorize(){}
    public Categorize(int id, Shoe shoeId, Category categoryId){
        this.id = id;
        this.shoeId = shoeId;
        this.categoryId = categoryId;     
    }
    
    public void setShoeId(Shoe shoeId){
        this.shoeId = shoeId ;
    }
    
    public Shoe getShoeId(){
        return shoeId ;
    }
    
     public void setCategoryId(Category categoryId){
        this.categoryId = categoryId;
    }
    
    public Category getCategoryId(){
        return categoryId;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
