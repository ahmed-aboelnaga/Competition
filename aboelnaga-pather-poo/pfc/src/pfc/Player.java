package pfc;
public class Player{
    private Strategy s;
    private int score;
    private String name;
    private Shape curr;
    public Player (Strategy s,String name){
        this.s=s;
        this.name= name;
    }
    public void addPoints(int i){
        this.score+=i;
    }
    public int getScore(){
        return this.score;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.name+"="+this.getScore()+"Points";
    }
    public Shape getCurr(){
        return this.curr;
    }
    public Shape playRound(){

        this.curr = this.s.currentCoup();
        return this.curr;
    }
    public boolean equals(Object o){
        if (o==null)return false;
        if (o==this)return true;
        if ( o instanceof Player){
            Player oo =(Player)o;
            return this.name.equals(oo.getName()) && this.s==oo.s&&this.getScore()==oo.getScore()&&this.curr==oo.getCurr();
    }
    return false;
    }
}