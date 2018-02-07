
package sqlprog;


public class rateComm {
    
    private int id;
    private Rate rateId;
    private String comment;
    private Shoe shoeId;
    private Customer customerId;
    
    public rateComm(){}
    public rateComm(int id, Rate rateId, String comment, Shoe shoeId, Customer customerId){
        this.id = id;
        this.rateId = rateId;
        this.comment = comment;
        this.shoeId = shoeId;
        this.customerId = customerId;       
    }
    
    
    public void setRateId(Rate rateId){
        this.rateId = rateId ;
    }
    
    public Rate getRateId(){
        return rateId;
    }
    
    public void setComment(){
        this.comment = comment ;
    }
    
    public String getComment(){
        return comment;
    }
    
    public void setShoeId(Shoe shoeId){
        this.shoeId = shoeId ;
    }
    
    public Shoe getShoeId(){
        return shoeId;
    }
    
    public void setCustomerId(Customer  customerId){
        this.customerId = customerId ;
    }
    
    public Customer getCustomerId(){
        return customerId;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
