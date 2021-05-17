package sport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public abstract class MatchTest {


	protected  Competitor c1,c2,l,winner;
	protected Match match;
	
	@Before
	public void init() {
		this.c1=new Competitor("Chelsea");
		this.c2=new Competitor("ManU");
		this.match=this.createMatch();
	}
	
	public abstract Match createMatch();
	
	public void winnerIsNullBeforeMatch() {
        assertNull(this.match.getWinner());
    }
	
	@Test
	public void playersAreNullAtCreation() {
		assertNull(this.match.getC1());
		assertNull(this.match.getC2());
		
	}
	
	
	@Test
	public void playersNotNullAfterAffecting() {
		this.match.setPlayers(c1, c2);
		assertSame(c1,this.match.getC1());
		assertSame(c2,this.match.getC2());
	}
	@Test (expected= IllegalStateException.class)
	public void startMatchThrowsExceptionWhenNotEnoughPLayers() {
		this.match.startMatch();	
	}
	
	@Test  (expected= IllegalStateException.class)
	public void startMatchThrowExceptionWhenSamePlayer() {
		this.match.setPlayers(c1, c1);
		this.match.startMatch();
	}
	@Test
    public void MatchPlayedOnlyWinnerIsAffected() throws IllegalStateException{
		int pointsc1before=this.c1.getPoints();
		int pointsc2before=this.c2.getPoints();
		this.match.setPlayers(c1,c2);
		this.match.startMatch();
		if (this.match.getWinner().equals(c1)) {
			assertEquals(this.match.getMatchWinPoints(),c1.getPoints()-pointsc1before);
            assertEquals(this.match.getMatchLoosePoints(),c2.getPoints()-pointsc2before);
		}
		else {
			if (this.match.getWinner().equals(c2)){
                assertEquals(this.match.getMatchWinPoints(),c2.getPoints()-pointsc2before);
                assertEquals(this.match.getMatchLoosePoints(),c1.getPoints()-pointsc1before);
            } 
			else {
				assertEquals(this.match.getMatchDrawPoints(),c1.getPoints()-pointsc1before);
				assertEquals(this.match.getMatchDrawPoints(),c2.getPoints()-pointsc2before);
			}
		}
	}
	
	
}
