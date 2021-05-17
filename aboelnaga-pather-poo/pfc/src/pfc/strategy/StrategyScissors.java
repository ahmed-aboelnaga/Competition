package pfc.strategy;
import pfc.*;
public class StrategySicssors implements Strategy{
    private Shape []s;
    private int ind;
    public StrategyFeuille(){
        this.s[0]=Shape.SCISSORS;
        this.ind=0;
    }
    public Shape currCoup(){
        return this.s[this.ind%this.s.length];
    }
}