
package sport;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * @author ABOELNAGA Ahmed
 * @author NOURY Louis
 */
public class KnockoutStage extends Competition {

	
    public KnockoutStage(List < Competitor> comps,Match match)throws IllegalArgumentException{
        super(comps, match);
        int i=comps.size();
        if (i%2!=0) throw new IllegalArgumentException("bad list size");
    }
    
    /**
     * allows to start the competition
     * side effect : shows every match details in the standart output
     * @param comps the list of Competitors assisting in the competition
     */
    public void play (List <Competitor> comps){
    	
        Competitor winner,p1,p2;
        List <Competitor> loosers;
        int j = 1;
        while (this.getParticipants().size()!=1){
        	loosers=new ArrayList<>(comps.size()/2);
        	this.displayer.displaymsg("\nStage"+j++ +"\n------------\n");
            for(int i=0;i<comps.size();i++){
                p1=comps.get(i);
                p2=comps.get(++i);
                this.sheduleMatch(p1,p2);
                winner = this.match.getWinner();
                if (winner.equals(p1)) loosers.add(p2);
                else loosers.add(p1);
              //  this.displayer.displaymsg(this.match.matchDetails());
                this.diffuseMatchsResults();
            }
            for (Competitor c : loosers) this.getParticipants().remove(c);
        }
        
        
    }
    public void displayRanking() {
    	
    	this.displayer.displaymsg("\n"+this.getParticipants().get(0).getName()+" wins this tournament");
    	this.displayer.displaymsg("--------------------");
    }
}
