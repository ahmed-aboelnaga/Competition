import static org.junit.Assert.*;

import org.junit.Test;

import date.util.*;

public class DateTest {

	@Test
	public void tomorrowWhenOrdinaryCase() {
		Date d = new Date(11, Month.february, 2020);
		Date e = new Date(12, Month.february, 2020);
		assertEquals(d.tomorrow() , e);
	}

	@Test
	public void dateAfterNdays() {
		Date d = new Date(14,Month.february, 2020);
		Date d_weekafter = new Date(21,Month.february,2020);
		assertEquals(d_weekafter,d.nDaysLater(7));
	}

	@Test(expected=IllegalArgumentException.class)
	public void dateAfterNdaysExceptionTest() {
		Date d = new Date(14,Month.february, 2020);
		d.nDaysLater(-1);
	}

// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(DateTest.class);
}


}
