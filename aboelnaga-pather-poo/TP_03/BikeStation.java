


public class BikeStation {

    
	private String name;
	private int capacity;
	private Bike station[];
	
   /**
    *make a station with a name and a members of bikes
    *@param name the name of the station
    *@param capacity the capacity of the station 
    */
	public BikeStation(String name, int capacity) {
	    this.name=name;
	    this.capacity=capacity;
	    this.station= new Bike [capacity];
	    
	    for (int i = 0; i < station.length; i++) {
			station[i]=null;
		}
	}

  
   /**
    *@return the name of the station 
    */
    public String getName() {
		return this.name;
	}

    /**
     *@return the capacity of the station 
     */
	public int getCapacity() {
		return this.capacity;
	}

	/**
     * @return the numbers of bikes left in the station
     */
	public int getNumberOfBikes() {
		int cpt=0;
		for (int i = 0; i < station.length; i++) {
			if( station[i]!=null ) {
				cpt++;
			}
		}
		return cpt;
	}

  /**
   *@return the index of the first place available in the station -1 if no place left 
   */
   public int firstFreeSlot() {
	   for (int i = 0; i < station.length; i++) {
		  if (station[i]==null) {
			  return i;
		  }
	   }
	   return -1;
   }


	/**
	* add a bike to the station
    * @param  bike a bike to add to the station at the first place available
    * @return true if the bike added successfully false otherwise
    */
	public boolean dropBike(Bike bike) {
	     
		int i=this.firstFreeSlot();
		
		if (i==-1) 
			 return false;
		else
		{
			this.station[i]=bike;
			return true;
		}
	}
	
	
	
	/**
	* take a bike of the station
    * @param  i the index of the place to take the bike
    * @return the bike at the index i , null if the place d'ont exist
    */
	public Bike takeBike(int i) {
	    
		Bike bike=null;
		if (i<this.station.length && i>=0) {
			bike=station[i];
			station[i]=null;
		}
	    return bike;
	}
	
	
}
