package sport;

import java.util.Random;
/**
 * @author ABOELNAGA Ahmed
 * @author NOURY Louis
 */
public class LeagueMatch extends Match {
	
	public LeagueMatch(){
		super();
	}

	public LeagueMatch(int n1,int n2,int n3){
		super(n1,n2,n3);
	}
	/**
	 * 
	 * @return a random int number 0 or 1
	 */
	public int randomNumber() {
	 return new Random().nextInt(2);
	}
	
	/**
	 * allows to simulate a match between two competitors
	 * @throws IllegalStateException if no enough players 
	 */
	public void startMatch() throws IllegalStateException{
		if (this.getC1() ==null || this.getC2()==null) throw new IllegalStateException("not enough players to play");
		int random=this.randomNumber();
		if (random==1) {
			this.winner=this.getC1();
			this.looser=this.getC2();
		}
		else {
			this.winner=this.getC2();
			this.looser=this.getC1();
		}
		this.getWinner().addPoints(this.getMatchWinPoints());
		this.getLooser().addPoints(this.getMatchLoosePoints());
		
	}
		
}
