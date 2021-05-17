package sport;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public  class OnLookerTest {
	
	
	@Test
	public void testMiddleReact() {
		MockLookerTest c = new MockLookerTest();
		assertTrue(0==c.x);
		Competition com = new LeagueCompetition(null,null);
		c.middleReact(com.thisEvent );
		assertTrue(1==c.x);
	}
	@Test
	public void testStartReact() {
		MockLookerTest c = new MockLookerTest();
		assertTrue(0==c.y);
		Competition com = new LeagueCompetition(null,null);
		c.startedReact(com.thisEvent );
		assertTrue(1==c.y);
	}
	@Test
	public void testEndeReact() {
		MockLookerTest c = new MockLookerTest();
		assertTrue(0==c.z);
		Competition com = new LeagueCompetition(null,null);
		c.endedReact(com.thisEvent );
		assertTrue(1==c.z);
	}
	
	public static junit.framework.Test suite() {
	    return new junit.framework.JUnit4TestAdapter(OnLookerTest.class);
	}	
	
}
