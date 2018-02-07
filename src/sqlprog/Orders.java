
package sqlprog;

import java.util.Date;


public class Orders {
    
    private int id;
    private Date dates;
    private Customer customerId;
    private boolean expedierad;
    
    Orders(){}
    Orders(int id, Date dates, Customer customerId, boolean expedierad){
        this.id = id;
        this.dates = dates;
        this.customerId = customerId;
        this.expedierad = expedierad;
    }
    
    public void setDates(Date dates){
        this.dates = dates ;
    }
    
    public Date getDates(){
        return dates ;
    }
    
    public void setCustomerID(Customer customerId){
        this.customerId = customerId ;
    }
    
    public Customer getCustomerID(){
        return customerId;
    }
    
    public void setExpedierad(boolean expedierad){
        this.expedierad = expedierad ;
    }
    
    public boolean getExpedierad(){
        return expedierad;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
}
