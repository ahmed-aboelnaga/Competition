/**
 * @author PATHER Stevenson et Aboelnaga Ahmed
 *
 */

public class BikeMain {

	public static void main(String[] args) {
		
	
	
		Bike bike1=new Bike("b001",BikeModel.CLASSICAL);		
		Bike bike2=new Bike("b002",BikeModel.ELECTRIC);
		
		if (bike1.equals(bike2)) {
			System.out.println("bike1 et bike2 sont égaux");
		}
		else {
			System.out.println("bike1 et bike2 ne sont pas égaux");
		}
		
		System.out.println(bike1);
		System.out.println(bike1.price+" euros");

	}

}
