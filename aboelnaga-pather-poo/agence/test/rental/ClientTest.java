package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	private Client c1;
	private Client c2;
	private Vehicle v;
	private Vehicle v2;

    
	@Before 
	public void before() {
		this.c1 = new Client("client1",20);
		this.c2 = new Client("client2",30);
		this.v = new Vehicle("brand1","model1",2015,100);
		this.v2 = new Vehicle("brand2","model2",2016,80);
	}


	@Test
	public void testGetName() {
		assertEquals("client1",this.c1.getName());
		assertEquals("client2",this.c2.getName());
	}

	@Test
	public void testGetAge() {
	    assertEquals(20,this.c1.getAge());
	    assertEquals(30,this.c2.getAge());
	}

	@Test
	public void testGetVehicleRentend() {
		assertNull(this.c2.getVehicleRented());
		this.c2.setVehicle(this.v);
		assertTrue(this.v.equals(this.c2.getVehicleRented()));
	}

	@Test
	public void testSetVehicle() {
		assertEquals(null,this.c2.getVehicleRented());
		this.c2.setVehicle(this.v);
		assertEquals(this.v,this.c2.getVehicleRented());
		this.c2.setVehicle(this.v2);
		assertEquals(this.v,this.c2.getVehicleRented());
	}
	
	@Test
	public void testRemoveVehicle() {
		assertNull(this.c2.getVehicleRented());
		this.c2.setVehicle(this.v);
		assertNotNull(this.c2.getVehicleRented());
		this.c2.removeVehicle();
		assertNull(this.c2.getVehicleRented());
	}

	@Test
	public void testCanRent() {
		assertTrue(this.c2.canRent());
		this.c2.setVehicle(this.v);
		assertFalse(this.c2.canRent());
	}

    // ---Pour permettre l'execution des tests ----------------------
    
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.ClientTest.class);
    }

}
