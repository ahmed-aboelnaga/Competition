package sport;

import java.util.List;
/**
 * @author ABOELNAGA Ahmed
 * @author NOURY Louis
 */
public class LeagueCompetition extends Competition{
	
	
	/** create a LeagueCompetition with given Competitors list and match type
     * @param comps Competitors list
     * @param match match type
    */
	public LeagueCompetition(List <Competitor> comps, Match match) {
		super(comps, match);
	}

	public void sheduleMatch(Competitor c1,Competitor c2){
		super.sheduleMatch(c1,c2);
	}
	
	/**
	 * allows to start this competition 
	 * side effect : shows every match details in the standart output
	 * @param comps list of Competitors assisting in this competition
	 */
	protected void play(List <Competitor> comps) {
		
		for(Competitor c :comps) {
			for (Competitor a:comps) {
				if (!c.equals(a)) {
					this.sheduleMatch(c, a);
					this.diffuseMatchsResults();
					//this.displayer.displaymsg(this.match.matchDetails());
					this.match.reset();
				}
			}
		}
	}


}
