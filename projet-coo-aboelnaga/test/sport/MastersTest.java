package sport;



import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;


public class MastersTest  {
	
	protected List <Competitor> comps=new ArrayList<>();
	protected Masters comp;
	
	@Before
	public void init() {
		Competitor c1,c2,c3,c4;
        c1=new Competitor("Bayern");c2=new Competitor("Ajax");
        c3=new Competitor("ManU");c4=new Competitor("Chelsea");
        this.comps.add(c1);this.comps.add(c2);this.comps.add(c3);this.comps.add(c4);
        this.comp=new Masters (this.comps,2,new LeagueMatch(1,0,0),new LeagueMatch(),new A());
        this.comp.setDisplayer(new StdDisplayer());
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void passingBadNbOfGroupsExceptionRaised() {
		
		new Masters(comps,0,new LeagueMatch(),new LeagueMatch(),new A());
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void passingBadSelectionMethodExceptionRaised() {
		new Masters(comps,0,new LeagueMatch(),new LeagueMatch(),new MockSelection());
		
	}

	
	
	@Test 
	public void allPhaseOneCompsHaveEqualNbOfPlayers() {
		for (Competition comp : this.comp.getGroups()) assertEquals(2,comp.getParticipants().size());
	}
	
	@Test
	public void phase1IsZeroBforeAndIsAffectedAfterCallingInitPhase1() {
		
		assertEquals(0,this.comp.getGroups().size());
		this.comp.initPhase1(this.comps);
		assertTrue(this.comp.getToKnockout().size()==0);
	}
	@Test
	public void toKnockoutIsZeroBeforeAndIsAffectedAfterCallingInitPhase2() {
		
		assertTrue(this.comp.getToKnockout().size()==0);
		this.comp.initPhase1(this.comps);
		this.comp.initPhase2();
		assertTrue(this.comp.getToKnockout().size()!=0);
	}
	
	@Test
	public void allCompetitionInPhaseOneArePlayedAfterCallingStartPhase1() {
		this.comp.initPhase1(this.comps);
		for(Competition comp :this.comp.getGroups()) for(Challenger c :comp.getParticipants())assertEquals(0,c.getPoints());
		this.comp.startPhase1(this.comps);
		for(Competition comp :this.comp.getGroups()) assertTrue( new A().mapLSorted(comp.ranking()).get(0).getPoints()!=0);
	}
	@Test 
	public void toKnockoutIsPassedToSizeOneAfterCallingStartPhase2() {
		this.comp.initPhase1(this.comps);
		this.comp.initPhase2();
		assertEquals(2,this.comp.getToKnockout().size());
		this.comp.startPhase2();
		assertEquals(1,this.comp.getToKnockout().size());
		
	}
	@Test
	public void MasterHasWinnerAfterCallingPlay() {
		this.comp.play();
		assertSame(this.comp.getWinner(),this.comp.getToKnockout().get(0));
		
	}
	@Test 
	public void WinnerIsInParticipants() {
		
		this.comp.play();
		assertTrue(this.comps.contains(this.comp.getWinner()));
	}
	private class MockSelection extends Selection{

		@Override
		public List<? extends Challenger> selectFrom(List<? extends CompetitionInfo> groups) throws IllegalArgumentException {
			return this.bestFrom(groups, 1, 0);
		}
		
		
	}
}

