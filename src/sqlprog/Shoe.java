
package sqlprog;


public class Shoe {
    
    private int id;
    private String name;
    private String color;
    private int size;
    private String label;
    private int price;
    private int quantity;
    
    public Shoe(){}
    public Shoe(int id, String name, String color, int size, String label, int price, int quantity){
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.label = label;
        this.price = price;
        this.quantity = quantity;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    public int getSize(){
        return size;
    }
    
    public void setLabel(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return label;
    }
    
    public void setPrice(int price){
        this.price = price ;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setquantity(int quantity){
        this.quantity = quantity ;
    }
    
    public int getquantity(){
        return quantity;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
