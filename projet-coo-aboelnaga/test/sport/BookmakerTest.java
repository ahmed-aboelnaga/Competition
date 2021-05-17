package sport;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import util.MapUtil;
import java.util.ArrayList;
import java.util.Map;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class BookmakerTest {

	@Test
	public void cotesUpdatesAfterPlayed() {
		List <Competitor> cps = new ArrayList<>();
		Competitor c1  = new Competitor("toto");
		Competitor c2  = new Competitor("titi");
		cps.add(c1);cps.add(c2);
		Match m = new MockLeagueMatch();
		Competition comp = new LeagueCompetition(cps,m);
		Bookmaker b = new Bookmaker();
		comp.addLooker(b);
		comp.play();
		assertTrue(5==b.players.get(c1));
		assertTrue(5==b.players.get(c2));
	}
	
	@Test
	public void allCompetitionCompetitorsAreInPlayers() {
		List <Competitor> cps = new ArrayList<>();
		Competitor c1  = new Competitor("toto");
		Competitor c2  = new Competitor("titi");
		cps.add(c1);cps.add(c2);
		Competition comp = new LeagueCompetition(cps,new LeagueMatch());
		Bookmaker b = new Bookmaker();
		comp.addLooker(b);
		int i=0;
		for (Map.Entry<Competitor,Integer> cp : b.players.entrySet()) assertSame(cp,cps.get(i++));
		
	
	}
public static junit.framework.Test suite() {
	    return new junit.framework.JUnit4TestAdapter(BookmakerTest.class);
	}	
		
}
