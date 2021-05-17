/**
 * @author PATHER Stevenson et Aboelnaga Ahmed
 *
 */

public class BikeStationMain {

	public static void main(String[] args) {
		
		BikeStation stas= new BikeStation("Timoleon",10) ;
		Bike bike1=new Bike("b001",BikeModel.CLASSICAL);
		Bike bike2=new Bike("b002",BikeModel.ELECTRIC);
		stas.dropBike(bike1);
		stas.dropBike(bike2);
		Bike bike3;
		
	
		if(args.length==1) {
			bike3=stas.takeBike(Integer.parseInt(args[0]));
			if(bike3==null)
				System.out.println("No bike at that place! ");
			else 
			    System.out.println("ref: "+bike3.getId()+" price: "+Bike.price);
		    	
		}
		else if(args.length==0) {
			System.out.println("veuillez saisir un emplacement !!!");
		}
		
		
	}

}
