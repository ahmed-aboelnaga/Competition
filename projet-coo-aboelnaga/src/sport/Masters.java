package sport;

import java.util.ArrayList;
import java.util.List;

public class Masters extends Competition {

	private Competitor winner;
	private List<LeagueCompetition> groups ;
	private KnockoutStage knockoutPhase;
	private List< Competitor> toKnockout;
	private Match matchPhase2;
	private int nbGrps;
	private Selection selectionMethod;

	public Masters(List<Competitor> competitors, int nbGrps, Match matchPhase1, Match matchPhase2,Selection select)
			throws IllegalArgumentException {
		super(competitors, matchPhase1);
		if (nbGrps==0||competitors.size() % nbGrps != 0)
			throw new IllegalArgumentException("bad arguments");
		this.init(competitors, nbGrps, matchPhase2,select);

	}
	/**
	 * intialise the competition
	 * 
	 * @param competitors list of competitors assisting in the competition
	 * @param nbGrps      number of groups of competitors
	 * @param matchPhase2 match type of competition phase 2
	 * @param toPhase2    number of competitors to select to play phase 2
	 */
	private void init(List<Competitor> competitors, int nbGrps, Match matchPhase2,Selection select) {
		this.nbGrps = nbGrps;
		this.matchPhase2 = matchPhase2;
		this.selectionMethod=select;
		this.groups=new ArrayList<>();
		this.toKnockout=new ArrayList<>();

	}
	
	/**
	 * initialise phase 1 of competiton
	 */
	protected void initPhase1(List<Competitor> competitors) {
		int size = (int) competitors.size() / this.nbGrps;
		for (int i = 0; i < competitors.size(); i += size) {
			LeagueCompetition comp=new LeagueCompetition(competitors.subList(i, i + size), this.match);
			comp.setDisplayer(this.displayer);
			comp.lookers.addAll(this.lookers);
			this.groups.add(comp);
		}

	}
	
	/**
	 * initialize list of competitors participating in phase 2
	 * @throws IllegalStateException if the size of List returned by the selectionMethod not a power of 2 
	 */
	private void initToKnockout() throws IllegalStateException {
		
		this.toKnockout =(List<Competitor>) this.selectionMethod.selectFrom(this.groups);
		int x = this.toKnockout.size();
		if ( (x & (x - 1)) != 0 || this.toKnockout.size()==0)
			throw new IllegalStateException("bad selection ");
	}

	


	/**
	 * initialise phase 2 of competiton
	 */
	protected void initPhase2() throws IllegalStateException , IllegalArgumentException{
		this.initToKnockout();
		this.knockoutPhase = new KnockoutStage( this.toKnockout, this.matchPhase2);
		this.knockoutPhase.setDisplayer(this.displayer);
		this.knockoutPhase.lookers=this.lookers;
	}
	
	/**
	 * allow to start phase 1
	 * 
	 * @param competitors list of competitors participating in phase 1
	 */
	protected void startPhase1(List<Competitor> competitors) {
		this.initPhase1(competitors);
		int i =1;
		for (Competition comp :this.groups) {
			this.displayer.displaymsg("Groupe"+ i++ +"\n");
			
			comp.play();
		}

	}
	
	/**
	 * allow to start phase 2
	 */
	protected void startPhase2() {
		this.initPhase2();
		this.displayer.displaymsg("Knockout\n");
		this.knockoutPhase.play();

	}
	
	

	/**
	 * allow to start the whole competition
	 */
	protected void play(List<Competitor> competitors) {
		this.startPhase1(competitors);
		this.startPhase2();
	}



	public void displayRanking() {
		this.winner = this.knockoutPhase.competitors.get(0);
		this.displayer.displaymsg("\nChampion is : " + this.winner.getName());
	}

	

	public Competitor getWinner() {
		return winner;
	}
	public List<LeagueCompetition> getGroups() {
		return groups;
	}
	public List<? extends Challenger> getToKnockout() {
		return toKnockout;
	}




}
