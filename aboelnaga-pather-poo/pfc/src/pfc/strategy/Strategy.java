package pfc.strategy;
import pfc.*;

public abstract class Strategy{
    protected Shape[] s;
    protected int ind=0;
    public Shape currentCoup(){
        return this.s[(this.ind++)%this.s.length];
    }
    
}