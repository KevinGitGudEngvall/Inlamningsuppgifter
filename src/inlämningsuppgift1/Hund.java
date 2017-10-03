
package inlämningsuppgift1;


public class Hund extends Djur {
    
    // inkapslingar
    private String mat;
    private int mängd;
    
    public Hund(String namn, int vikt, String mat){
        super(namn, vikt);
        this.mat = mat;
    }
    
    // polymorfism metod 
    public int rättMängd(int v){
        mängd = v / 100;
        return mängd;
    }
    
    public String getMat(){
        return mat;
    } 
}
