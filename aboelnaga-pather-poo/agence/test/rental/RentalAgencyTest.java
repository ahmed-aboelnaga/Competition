package rental;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RentalAgencyTest {

	private RentalAgency agency;
	private Vehicle v, v2;
	private List<Vehicle> allVehicles;
	
	@Before
	public void before() {
		this.agency = new RentalAgency();
		this.v = new Vehicle("Vroum", "Vroum", 2000, 100);
		this.v2 = new Vehicle("Vroum2", "Vroum", 2005,120);
		this.allVehicles = new ArrayList<Vehicle>();
		this.allVehicles.add(this.v);
		this.allVehicles.add(this.v2);
	}

	@Test 
	public void testAddVehicleAndSelect() {
		MaxPriceFilter criterion = new MaxPriceFilter(150);
		this.agency.addVehicle(this.v);
		this.agency.addVehicle(this.v2);
		assertEquals(this.agency.select(criterion),this.allVehicles);
	}

	@Test // Also test rentVehicle and hasRentedAVehicle methods of RentalAgency 
	public void twoClientObjectsWithSameNameCorrespondsToSameClient()
				throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(this.v);
		
		Client client1 = new Client("Tim Oleon", 25);
		assertEquals(100, agency.rentVehicle(client1, this.v),0.0001);
		assertTrue(agency.hasRentedAVehicle(client1));
		// client2 corresponds to same client than client1 since names are equals
		Client client2 = new Client("Tim Oleon", 25);
		// then test should succeed
		assertTrue(agency.hasRentedAVehicle(client2));
	}

	@Test
	public void testAllRentedVehiclesAndReturnVehicle() throws IllegalStateException, UnknownVehicleException {
		Client c1 = new Client("Test", 25);
		Client c2 = new Client("Test_2", 25);
		this.agency.addVehicle(this.v);
		this.agency.addVehicle(this.v2);
		assertEquals(100, this.agency.rentVehicle(c1, this.v),0.0001);
		assertEquals(120, this.agency.rentVehicle(c2, this.v2),0.0001);
		assertEquals(this.agency.allRentedVehicles(),this.allVehicles);
		this.agency.returnVehicle(c1);
		this.agency.returnVehicle(c2);
		this.allVehicles.clear(); // clear the preset array to compare
		assertEquals(this.agency.allRentedVehicles(),this.allVehicles);
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.RentalAgencyTest.class);
	}

}
