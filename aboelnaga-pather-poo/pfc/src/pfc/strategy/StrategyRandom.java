package pfc.strategy;
import pfc.*;
public class StrategyRandom extends Strategy{
    private Shape []s;
    private int ind;
    public StrategyRandom(int len){
        this.s=new Shape[len];
        for (int i=0;i<len;i++){
            this.s[i]=Shape.random();
        }
        this.ind=0;
    }
}