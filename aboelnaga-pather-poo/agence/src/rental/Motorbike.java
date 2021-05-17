package rental;

public class Motorbike extends Vehicle {
	
	private int cylinder;
	/**
	 * creates a motorbike with given informations
	 * 
	 * @param cylinder
	 * 			  the cylinder of the motor in cm^3
	 */
	public Motorbike(int cylinder, String brand, String model, int productionYear, float dailyRentalPrice) {
		super(brand, model, productionYear, dailyRentalPrice);
		this.cylinder = cylinder;
		
	}

	/**
	 * @return the cylinder of the motor of this motorbike in cm^3s
	 */
	public int getCylinder() {
		return this.cylinder;
	}
	
	public String toString() {
		return (super.toString() + " " + this.cylinder + " cm³");
		}
}