package sport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public abstract class SelectionTest {

	protected List <CompetitionInfo> gr = new ArrayList<>(); 
	protected Selection method;
	
	
	
	@Before
	public void init() {
		for (int i =0;i<4;i++) {
			List <Competitor> com= new ArrayList <>();
			com.add(new Competitor("Bayern"));
			this.gr.add(new LeagueCompetition(com,new LeagueMatch()));
		}
		this.method=this.createOne();
	
	}
	public abstract Selection createOne();
	
	@Test 
	public void TestSelectIFromAllWhenOk() {
		List <Challenger> l = new ArrayList <>();
		l=this.method.iFromAll(gr, 0);
		assertEquals(4,l.size());
	}
	@Test
	public void testSelectBestFromAllWhenOk() {
		List <Challenger> l = new ArrayList <>();
		l= this.method.bestFrom(this.gr, 2, 0);
		assertEquals(2,l.size());
		
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSelectBestFromAllWhenHasToFailWhenBadNb() {
		this.method.bestFrom(this.gr, 10, 0);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSelectBestFromAllWhenHasToFailWhenBadPos() {
		this.method.bestFrom(this.gr, 2, 10);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testSelectIFromAllWhenHasToFailWhenBadPos() {
		this.method.iFromAll(this.gr, 10);
	}
	
	@Test 
	public void PlayersReturnedIsCorrect() {
		List <Challenger> l = new ArrayList <>();
		try {
			l=this.method.iFromAll(this.gr, 0);
		}catch (NullPointerException e) {
			fail();
		}
		for (int i=0;i<l.size();i++) {
			assertSame(l.get(i),this.gr.get(i).getParticipants().get(0));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


