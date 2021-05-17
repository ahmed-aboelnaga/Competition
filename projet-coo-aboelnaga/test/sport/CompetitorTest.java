package sport;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompetitorTest {
	int points;
	Competitor c;
	@Before
	public void init() {
		
		this.c=new Competitor("Chelsea");
	}
	
	@Test
	public void pointsAre0AtCreation() {
		assertEquals(0,this.c.getPoints());
	}
	@Test
	public void pointsAddedAfterCallingAddPoints() {
		this.c.addPoints(15);
		assertEquals(15,this.c.getPoints());
	}
	@Test 
	public void equalsTest() {
		
		Competitor c1=new Competitor("Spurs");
		assertFalse(this.c.equals(c1));
		assertNotSame(c1,this.c);
		
	}
	public static junit.framework.Test suite() {
	    return new junit.framework.JUnit4TestAdapter(CompetitorTest.class);
	}	

}
