package sport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import util.MapUtil;
/**
 * @author ABOELNAGA Ahmed
 * @author NOURY Louis
 */
public abstract class Competition implements CompetitionInfo {
	
	protected CompetitionEvent thisEvent = new CompetitionEvent(this);
	protected Set <OnLookerC>lookers = new LinkedHashSet<>();
	protected  Displayer displayer;
	protected final Match match;
	protected final List< Competitor> competitors ;
	
	/**
	 * allow to add an observer for the competition 
	 * @param l observer
	 */
	public void addLooker(OnLookerC l) {
		this.lookers.add(l);
	}
	
	/**
	 * allow to remove an observer for the competition 
	 * @param l observer
	 */
	public void removeLooker(OnLookerC l) {
		this.lookers.remove(l);
	}
	/**
	 * allow to every observer to react when a match is played
	 */
	protected void diffuseMatchsResults() {
		if (this.lookers.size()==0)return ;
		for (OnLookerC c : this.lookers) c.middleReact(this.thisEvent);
	}
	/**
	 * allow to every observer to react when a Competition is Started
	 */
	protected void Start() {
		if (this.lookers.size()==0)return ;
		for (OnLookerC c : this.lookers) c.startedReact(this.thisEvent);
	}
	/**
	 * allow to every observer to react when a Competition is ended
	 */
	protected void End() {
		if (this.lookers.size()==0)return ;
		for (OnLookerC c : this.lookers) c.endedReact(this.thisEvent);
	}
	
	public Set <OnLookerC> getLookers(){
		return this.lookers;
	}
	
	/** create a Competition with given Competitors list and match type
     * @param comps Competitors list
     * @param match match type
    */
	public Competition(List <  Competitor> comps,Match match) {
		this.competitors=comps;
		this.match=match;
		
	}
	public void setDisplayer(Displayer dis) {
		this.displayer=dis;
		
	}
	/**
	 * organize a match between two competitors 
	 * @param c1 first competitor
	 * @param c2 snd competitor
	 */
	public void sheduleMatch(Competitor c1,Competitor c2) {
		
		this.match.setPlayers(c1, c2);
		this.match.startMatch();
	}
	/**
	 * provides the list of competitors of the competition	
	 * @return the list of competitors
	 */
	
	public List< ? extends Challenger> getParticipants(){

		return this.competitors;
	}
	
	/**
	 * allows to start the competition
	 *side effect : shows every match details in the standart output  
	 */
	public void play() {
		this.Start();
		this.play(this.competitors);
		this.ranking();
		this.End();
	}
	/**
	 * @param comps Competitors List
	 * side effect : shows every match details in the standart output
	 */
	protected abstract void play(List< Competitor> comps); 
	
	/**
	 * allows to sort the competitors in descending order by their score 
	 *@return a sorted Map by Competitors score where key is a Competitor and value is his score
	 */
	public Map<? extends Challenger, Integer> ranking() {
		
		Map<Challenger, Integer> ranks = new LinkedHashMap<>();
		for(Competitor comp:this.competitors) ranks.put(comp, comp.getPoints());
		return MapUtil.sortByDescendingValue(ranks);
	}
	/**
	*side effect : shows the competitors list by descending order in the standart output 
	 */
	public void displayRanking() {
		String res="Ranking: \n";
		for (Map.Entry<? extends Challenger,Integer> comp : this.ranking().entrySet())  
            res+=comp.getKey().getName() + " has " +comp.getValue()+" points\n"; 
			this.displayer.displaymsg(res);
			this.displayer.displaymsg("--------------------");
	}
}


