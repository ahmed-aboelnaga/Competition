package rental;

public class Car extends Vehicle {
	
	private int nb_passagers;
	/**
	 * creates a car with given informations
	 * 
	 * @param nb_passagers
	 * 			  the number of passengers accepted
	 */
	public Car(int nb_passagers, String brand, String model, int productionYear, float dailyRentalPrice) {
		super(brand, model, productionYear, dailyRentalPrice);
		this.nb_passagers = nb_passagers;
		
	}

	/**
	 * @return the number of passengers accepted by this car
	 */
	public int getNbPassagers() {
		return this.nb_passagers;
	}
	
	public String toString() {
		return (super.toString() + " " + this.nb_passagers + " seater");
		}
}