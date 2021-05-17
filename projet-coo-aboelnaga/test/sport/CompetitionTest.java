package sport;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

import org.junit.Before;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public abstract class CompetitionTest{
	protected List <Competitor> comps=new ArrayList<>();
	protected Competition comp;
	protected Match match;
	
	public abstract Competition createOne(List <Competitor> comps,Match match);
	
	@Before
    	public void init(){
        Competitor c1,c2,c3,c4;
        c1=new Competitor("Bayern");c2=new Competitor("Ajax");
        c3=new Competitor("ManU");c4=new Competitor("Chelsea");
        this.comps.add(c1);this.comps.add(c2);this.comps.add(c3);this.comps.add(c4);
        
    }
    
	@Test
	public void addLookerIsOk() {
		
		Competition comp = this.createOne(this.comps, this.match);
		OnLookerC l = new Reporter("toto");
		assertTrue(comp.getLookers().size()==0);
		comp.addLooker(l);
		assertTrue(comp.getLookers().contains(l));
	}
	
	@Test
	public void removeLookerIsOk() {
		Competition comp = this.createOne(this.comps, this.match);
		OnLookerC l = new Reporter("toto");
		comp.addLooker(l);
		assertTrue(comp.getLookers().contains(l));
		comp.removeLooker(l);
		assertFalse(comp.getLookers().contains(l));
	}
	
}
