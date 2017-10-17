
package inlämningsuppgift2;


public class Customer {
    
    private String pernum = "";
    private String namn = "";
    private int peryear = 0;
    private int permonth = 0;
    private int perday = 0;
    
    public Customer(){};
    
    public String getPernum(){
        return pernum;
    }
    
    public String getNamn(){
        return namn;
    }
    
    public int getPeryear(){
        return peryear;
    }
    
    public int getPermonth(){
        return permonth;
    }
    
    public int getPerday(){
        return perday;
    }
    
    public void setPernum(String pernum){
        this.pernum = pernum;
    }
    
    public void setNamn(String namn){
        this.namn = namn;
    }
   
    public void setPeryear(int peryear){
        this.peryear = peryear;
    }
    
    public void setPermonth(int permonth){
        this.permonth = permonth;
    }
    
    public void setPerday(int perday){
        this.perday = perday;
    }
    
}
