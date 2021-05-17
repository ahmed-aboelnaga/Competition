package pfc.strategy;
import pfc.*;
public class StrategyRandom implements Strategy{
    private Shape []s;
    private int ind;
    public StrategyRandom(int len){
        this.s=new Shape[len];
        for (int i=0;i<len;i++){
            this.s[i]=random();
        }
        this.ind=0;
    }
    public Shape currCoup(){
        return this.s[this.ind%this.s.length];
    }
}