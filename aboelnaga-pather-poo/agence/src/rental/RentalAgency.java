package rental;

import java.util.*;

/** a rental vehicle agency, client can rent one vehicle at a time */
public class RentalAgency {
    // vehicles of this agency
    protected List<Vehicle> theVehicles;

    // maps client and rented vehicle (at most one vehicle by client) 
    protected Map<Client,Vehicle> rentedVehicles;

    public RentalAgency() {
        this.theVehicles = new ArrayList<Vehicle>();
        this.rentedVehicles = new HashMap<Client,Vehicle>();
    }
    
    /** adds a vehicle to this agency 
    * @param v the added vehicle
    */
    public void addVehicle(Vehicle v) {
    	this.theVehicles.add(v);
    }
    
    /** provides the list of the vehicles that is accepted by filter  
    * @param filter the selection filter
    * @return  the list of the vehicles accepted by filter
    */
    public List<Vehicle> select(VehicleFilter filter) {	
        List<Vehicle> selectedVehicle = new ArrayList<Vehicle>();
        for (int i = 0; i < this.theVehicles.size();i++) {
            Vehicle v = this.theVehicles.get(i);
            if (filter.accept(v))
                selectedVehicle.add(v);
        }
        return selectedVehicle;
    }
    
    /** displays the vehicles accepted by the filter 
    * @param filter the selection filter
    */
    public void displaySelection(VehicleFilter filter) {
        List<Vehicle> selection = this.select(filter);
        for (int i = 0; i < selection.size();i++) {
            System.out.println(selection.get(i).toString());
        }
    }


    /** returns <em>true</em> iff client c is renting a vehicle
     * @param client the client for which we want to know it has rented a vehicle
    * @return <em>true</em> iff client c is renting a vehicle
    */
    public boolean hasRentedAVehicle(Client client){
        for (Map.Entry<Client,Vehicle> mapentry : this.rentedVehicles.entrySet()) {
            if (client.getName() == mapentry.getKey().getName())
                return true;
        }
        return false;
    }
    
    /** returns <em>true</em> iff vehicle v is rented
     * @param v the vehicle we want to check if it is rented
    * @return <em>true</em> iff vehicle v is rented    
    */
    public boolean isRented(Vehicle v){
        return this.rentedVehicles.containsValue(v);
    }

   /** client rents a vehicle 
    * @param client the renter
    * @param v the rented vehicle
    * @return the daily rental price
    * @exception UnknownVehicleException   if v is not a vehicle of this agency  
    * @exception IllegalStateException if v is already rented or client rents already another vehicle
    */
    public float rentVehicle(Client client, Vehicle v) throws IllegalStateException, UnknownVehicleException {
        if (this.hasRentedAVehicle(client) || this.isRented(v)) {
            throw new IllegalStateException();
        }
        if (this.theVehicles.contains(v) == false) {
            throw new UnknownVehicleException();
        }
        else {
            this.rentedVehicles.put(client, v);
            client.setVehicle(v);
            return v.getDailyPrice();
        }
    }

    
    /** the client returns a rented vehicle. Nothing happens if client didn't have rented a vehicle. 
    * @param client the client who returns a vehicle
    */
    public void returnVehicle(Client client){
    	if (this.hasRentedAVehicle(client)) {
            this.rentedVehicles.remove(client, client.getVehicleRented());
            client.removeVehicle();
        }
    }
    /** provides the collection of rented vehicles for this agency
    * @return collection of currently rented vehicles 
    */
    public Collection<Vehicle> allRentedVehicles() {
        List<Vehicle> allRentedVehicles = new ArrayList<Vehicle>();
        for (int i = 0; i < this.theVehicles.size();i++) {
            Vehicle v = this.theVehicles.get(i);
            if (this.isRented(v))
                allRentedVehicles.add(v);
        }
        return allRentedVehicles;
    }
}
