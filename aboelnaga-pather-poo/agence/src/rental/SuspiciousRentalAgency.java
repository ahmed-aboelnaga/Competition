package rental;

/** a suspicious vehicle agency, client can rent one vehicle at a time
 *  client under 25 years old have an additional cost of 10% of rental price
 */
public class SuspiciousRentalAgency extends RentalAgency {
    
    private int percentage;

    public SuspiciousRentalAgency() {
        this.percentage = 10;
    }
    
    /**
     * returns <em>true</em> if the client is less than 25 years old
     * @param client the client
     * @return <em>true</em> if the client is less than 25 years old
     */
    public boolean clientAvaibleToAdditionalCost(Client client) {
        return (client.getAge() < 25);
    }

    /**
     * returns the rental price of a Vehicle with additional cost
     * @param v the Vehicle
     * @return the rental price of a Vehicle with additional cost
     */
    public float priceWithAddtionalCost(Vehicle v) {
        float add = v.getDailyPrice() * this.percentage/100;
        return v.getDailyPrice() + add;
    }

    /** client rents a vehicle 
    * @param client the renter
    * @param v the rented vehicle
    * @return the daily rental price with or without the additional cost if the client is avaible
    * @exception UnknownVehicleException   if v is not a vehicle of this agency  
    * @exception IllegalStateException if v is already rented or client rents already another vehicle
    */
    public float rentVehicle(Client client, Vehicle v)throws IllegalStateException, UnknownVehicleException {
        if (this.hasRentedAVehicle(client) || this.isRented(v)) {
            throw new IllegalStateException();
        }
        if (this.theVehicles.contains(v) == false) {
            throw new UnknownVehicleException();
        }
        else {
            this.rentedVehicles.put(client, v);
            client.setVehicle(v);
            if (this.clientAvaibleToAdditionalCost(client))
                return this.priceWithAddtionalCost(v);
            return v.getDailyPrice();
        }
    }
}