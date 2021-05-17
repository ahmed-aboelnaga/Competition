package sport;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LeagueMatchTest extends MatchTest{
	

	
	public Match createMatch() {
		return new LeagueMatch(1,0,0);
	}
	@Test
	public void winnerIsNotNullAfterMatch()throws IllegalStateException {
		this.match.setPlayers(this.c1, this.c2);
		this.match.startMatch();
		assertNotNull(this.match.getWinner());
    }
	@Test
	public void matchHasOneWinner() throws IllegalStateException{
		Match m=new MockLeagueMatch();
		m.setPlayers(this.c1, this.c2);
		m.startMatch();
		assertSame(this.c1,m.getWinner());
	}
	
	
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(LeagueMatchTest.class);
}

}
