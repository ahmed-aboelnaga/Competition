package rental;

import java.util.List;

public class RentalAgencyMain {

    public static void main(String[] args) {
        
        // Agency
        RentalAgency agency = new RentalAgency();
        SuspiciousRentalAgency bad_agency = new SuspiciousRentalAgency();

        // Vehicles
        Vehicle v = new Vehicle("Vroum", "model", 2020, 100);
        Car car = new Car(5, "Renault", "model", 2019, 80);
        Motorbike motorbike = new Motorbike(125, "Motor", "model", 2015, 50);

        // Clients
        Client client1 = new Client("Timoleon", 23);
        Client client2 = new Client("Timophane", 35);

        // Price Filter
        MaxPriceFilter pricefilter_60 = new MaxPriceFilter(60);
        MaxPriceFilter pricefilter_90 = new MaxPriceFilter(90);
        MaxPriceFilter pricefilter_101 = new MaxPriceFilter(101);

        // Add all Vehicles to RentalAgency
        agency.addVehicle(v);
        agency.addVehicle(car);
        agency.addVehicle(motorbike);
        bad_agency.addVehicle(v);
        bad_agency.addVehicle(car);
        bad_agency.addVehicle(motorbike);

        // Selection with pricefilter_
        List<Vehicle> vehicles_60 = agency.select(pricefilter_60);
        List<Vehicle> vehicles_90 = agency.select(pricefilter_90);
        List<Vehicle> vehicles_100 = agency.select(pricefilter_101);

        // Manipulation
        System.out.println("Rental Agency Main \n-------------------\n");
        System.out.println("List of all vehicles :");
        System.out.println("\t Vehicle : " + v.toString());
        System.out.println("\t Car : "+ car.toString());
        System.out.println("\t Motorbike : "+ motorbike.toString());

        System.out.println("\nList of all vehicles with 50 MaxPriceFilter :");
        for (int i = 0; i < vehicles_60.size();i++) {
            System.out.println("\t"+ vehicles_60.get(i).toString());
        }

        System.out.println("\nList of all vehicles with 80 MaxPriceFilter :");
        for (int i = 0; i < vehicles_90.size();i++) {
            System.out.println("\t"+ vehicles_90.get(i).toString());
        }

        System.out.println("\nList of all vehicles with 100 MaxPriceFilter :");
        for (int i = 0; i < vehicles_100.size();i++) {
            System.out.println("\t"+ vehicles_100.get(i).toString());
        }

        System.out.println("\nSuspicious Rental Agency :");
        System.out.println("\tList of clients :");
        System.out.println("\t"+client1.getName() + " " + String.valueOf(client1.getAge()));
        System.out.println("\t"+client2.getName() + " " + String.valueOf(client2.getAge()));
        
        System.out.println("Rental price of the motorbike for each clients :");
        if (bad_agency.clientAvaibleToAdditionalCost(client1))
            System.out.println("\t"+client1.getName()+ " : "+ String.valueOf(bad_agency.priceWithAddtionalCost(motorbike)));
        if (!bad_agency.clientAvaibleToAdditionalCost(client2))
            System.out.println("\t"+client2.getName() + " : "+ String.valueOf(motorbike.getDailyPrice()));
        System.out.println("\tNormal rental price : " + motorbike.getDailyPrice());
    }
}