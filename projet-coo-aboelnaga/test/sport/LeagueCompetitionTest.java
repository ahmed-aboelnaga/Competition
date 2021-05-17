package sport;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LeagueCompetitionTest extends CompetitionTest{
        
    
    @Before
    public void init2(){
    	this.match=new LeagueMatch(1,0,0);
        this.comp=this.createOne(this.comps,this.match );
        this.comp.setDisplayer(new StdDisplayer());
    }
    
    public Competition createOne(List <Competitor> comps,Match match) {
    	
    	return new LeagueCompetition(this.comps,this.match);
    }
    
    @Test
    public void sumOfPointsGainedByEveryCompetitorEqualsToSumOfMatchsPlayed() {
    	this.comp.play();
    	int sum=0;
    	for (Competitor c :this.comps) sum+=c.getPoints();
    	assertEquals(12,sum);
    }
     

   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(LeagueCompetitionTest.class);
}	

}


