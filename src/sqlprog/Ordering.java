
package sqlprog;


public class Ordering {
    
    private int id;
    private Orders ordersId;
    private Shoe shoeId;
    
    Ordering(){}
    Ordering(int id, Orders ordersId, Shoe shoeId){
        this.id = id;
        this.ordersId = ordersId;
        this.shoeId = shoeId;
    }
    
    public void setOrdersId(Orders ordersId){
        this.ordersId = ordersId;
    }
    
    public Orders getOrdersId(){
        return ordersId;
    }
    
     public void setShoeId(Shoe shoeId){
        this.shoeId = shoeId;
    }
    
    public Shoe getShoeId(){
        return shoeId;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
