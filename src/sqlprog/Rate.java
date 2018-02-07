
package sqlprog;


public class Rate {
    
    private int id;
    private String rateLevel;
    
    public Rate(){}
    public Rate(int id, String rateLevel){
        this.id = id;
        this.rateLevel = rateLevel;
        
    }
    
    
    public void setRateLevel(String rateLevel){
        this.rateLevel = rateLevel ;
    }
    
    public String getRateLevel(){
        return rateLevel;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
}
