package rental;

/** represent clients of a rental agency, the names are supposed to be
 * unique then two Client objects with same name are considered equals
*/
public class Client {

    private String name;
    private int age;
    private Vehicle v;
    
    /** create a client with given name, age and without a Vehicle, two different clients
     * have different names by assumption (no verification)
     * @param name name of the client
     * @param age age of the client
    */
    public Client(String name, int age) {
        this.name = name;
        this.age = age;
        this.v = null;

    }
    
    /** @return the client's name
      */
    public String getName() {
        return this.name;
    }
    
    /**@return the client's age
    */
    public int getAge() {
        return this.age;
    }
    
    /** @return true if this client can rent a vehicle,
    * false otherwise
    */
    public boolean canRent() {
        return this.v == null;
    }

    /** set a Vehicle to this client
     */
    public void setVehicle(Vehicle vehicle) {
        if (this.canRent())
            this.v = vehicle;
    }

    /** remove the Vehicle of this client
     */
    public void removeVehicle() {
        this.v = null;
    }
    /** @return the Vehicle objet that this client rent,
     *  return null if this client is not renting a vehicle 
     */
    public Vehicle getVehicleRented() {
        return this.v;
    }
    
}
