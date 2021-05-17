package pfc.strategy;
import pfc.*;


public class StrategyFeuille extends Strategy{

    public StrategyFeuille(){
        Shape[]p=new Shape[1];
        p[0]=Shape.PAPER;
        this.s=p;
    }
}