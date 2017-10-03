
package inlämningsuppgift1;


public class Orm extends Djur {
    
    // inkapslingar
    private String mat;
    private int mängd = 20;
    
    public Orm(String namn, int vikt, String mat){
        super(namn, vikt);
        this.mat = mat;
    }
    
    // polymorfism metod
    public int rättMängd(int v){
        return mängd;
    }
    
    public String getMat(){
        return mat;
    }
}
