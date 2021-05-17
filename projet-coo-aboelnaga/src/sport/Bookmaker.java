package sport ;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bookmaker implements OnLookerC{

	protected Map<Competitor, Integer> players = new LinkedHashMap<>();
	Competition c=null;
	Displayer <String> dis =new StdDisplayer();
	public static final int COTE = 5;
	
	@Override
	/**
	 * Reaction in the midlle of Competition 
	 * @param event the source 
	 */
	public void middleReact(Event<Competition> event) {
		this.c=event.insTance();
		Competitor winner =this.c.match.getWinner();
		Competitor looser =this.c.match.getLooser();
		this.dis.displaymsg(winner.getName()+" had rating of"+this.players.get(winner));
		this.dis.displaymsg(looser.getName()+" had rating of"+this.players.get(looser));
		this.updateR(winner, looser);
		this.dis.displaymsg(winner.getName()+" win the match his rating now is "+this.players.get(winner));
		this.dis.displaymsg(looser.getName()+" lost the match his rating now is "+this.players.get(looser)+"\n");
	}
	/**
	 * update Competitors rating
	 * @param winner competitor who won the match
	 * @param looser competitor who lost the match
	 */
	public void updateR(Competitor winner,Competitor looser) {
		this.players.computeIfPresent(winner, (k,v)->v-1);
		this.players.computeIfPresent(looser, (k,v)->v+1);
		
	}
	
	@Override
	/**
	 * Reaction when Competition has started
	 * @param event the source 
	 */
	public void startedReact(Event<Competition> event) {
		this.c=event.insTance();
		for (Competitor c : event.insTance().competitors) 
			this.players.putIfAbsent(c, COTE);
		//	this.players.put(c,COTE);
		
	}
	/**
	 * Reaction when Competition has ended
	 * @param event the source 
	 */
	@Override
	public void endedReact(Event<Competition> event) {
		this.c=event.insTance();		
	}

	@Override
	/**
	 * @return last source who has invoked this instance
	 */
	public Competition getLastCaller() {
		return this.c;
	}


	public Map<Competitor, Integer>  getMap(){
		return this.players;
	}



}
