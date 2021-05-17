package pfc.strategy;
import pfc.*;
public class StrategySicssors extends Strategy{

    public StrategySicssors(){
        
        Shape [] s=new Shape[1];
        s[0]=Shape.SCISSORS;
        this.s=s;
    }
}