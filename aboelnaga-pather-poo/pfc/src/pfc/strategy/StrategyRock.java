package pfc.strategy;
import pfc.*;
public class StrategyRock extends Strategy{
    public StrategyRock(){

        Shape [] s=new Shape[1];
        s[0]=Shape.ROCK;
        this.s=s;
    }
}