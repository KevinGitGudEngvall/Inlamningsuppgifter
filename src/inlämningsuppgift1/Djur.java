
package inlämningsuppgift1;


abstract public class Djur implements INeeds{
    
    // inkapslingar
    private String namn;
    private int vikt;
    
    public Djur(String namn, int vikt){
        this.namn = namn;
        this.vikt = vikt;
    } 
    
    public String getNamn(){
        return namn;
    }
    
    public int getVikt(){
        return vikt;
    }
}
