import java.util.Random; 
public enum Shape{
    SCISSORS,ROCK,PAPER;
    public Shape whoGain(Shape s){
        if (this.ordinal()-s.ordinal()==-1 || this.ordinal()-s.ordinal()==2){
            return s;
        }
        return this;
    }
    public static Shape random(){
        Random rand = new Random();
        return Shape.values()[rand.nextInt(3)];
    }

}