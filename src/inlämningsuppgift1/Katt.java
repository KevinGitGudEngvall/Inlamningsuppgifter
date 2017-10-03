
package inlämningsuppgift1;


public class Katt extends Djur {
    
    // inkapslingar
    private String mat;
    private int mängd;
    
    public Katt(String namn, int vikt, String mat){
        super(namn, vikt);
        this.mat = mat;
    }
    
    // polymorfism metod
    public int rättMängd(int v){
        mängd = v / 150;
        return mängd;
    }
    
    public String getMat(){
        return mat;
    }
}
