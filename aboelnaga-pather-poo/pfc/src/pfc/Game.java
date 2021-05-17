public class Game{
    private Player p1,p2;
    private int nbRounds;
    public Game(Player p1,Player p2){
        this.p1=p1;
        this.p2=p2;
    }
    public Player playOneRound(){
        Shape c1=p1.playRound();
        Shape c2=p2.playRound();
        if(c1.whoGain(c2)==c1){
            p1.addPoints(2);
            return p1;
        }
        else if (c1.whoGain(c2)==c2){
            p2.addPoints(2);
            return p2;
        }
        else{
            p1.addPoints(1);
            p2.addPoints(1);
            return null;
        }
    }

    public Player play(int nbRounds){
        this.nbRounds=nbRounds;
        while(this.nbRounds-->0){
            Player vic=playOneRound();
            System.out.println(this.p1.getName()+"a joue"+this.p1.getCurr()+","+this.p2.getName()+"a joue"+this.p2.getCurr());
            if(vic.equals(this.p1)){
                Sysytem.out.println(this.p1.getName()+"l'emporte et marque 2 points");
            }else if (vic.equals(this.p2)){
                Sysytem.out.println(this.p2.getName()+"l'emporte et marque 2 points");
            }
            System.out.println("le score est maintenant:"+this.p1.toString()+"-"+this.p2.toString());
        }
        if (this.p1.getScore()>this.p2.getScore()){
            System.out.println(this.p1.getName()+"est le vainceur");
        }else if(this.p1.getScore()<this.p2.getScore()){
            System.out.println(this.p2.getName()+"est le vainceur");
        }else{
            System.out.println("match null");
        }
    }   
}