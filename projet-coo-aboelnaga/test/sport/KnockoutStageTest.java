package sport;


import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public class KnockoutStageTest extends CompetitionTest {
	
	@Test (expected = IllegalArgumentException.class)
    public void badListSizeThrowsException(){
        this.comps.add(new Competitor("Spurs"));			
        this.createOne(this.comps,this.match);
    }
	 
	@Before
    public void init2(){
    	this.match=new LeagueMatch();
        this.comp=this.createOne(this.comps,this.match );
        this.comp.setDisplayer(new StdDisplayer());
    }
	
	@Override
	public Competition createOne(List<Competitor> comps, Match match) {
		return  new KnockoutStage(comps,match);
	}	
			
	@Test
	public void oneCompetitorRemainsAfterPlay() {
		this.comp.play();
		assertEquals(1,this.comps.size());
	}
	
	public static junit.framework.Test suite() {
	    return new junit.framework.JUnit4TestAdapter(KnockoutStageTest.class);
	}
}
