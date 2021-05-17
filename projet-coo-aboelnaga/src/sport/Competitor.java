package sport;
/**
 * @author ABOELNAGA Ahmed
 * @author NOURY Louis
 */
public class Competitor implements Challenger{
	private int points =0;
	private final String name;
	
	/**
	 * create a Competitor with given name
	 * @param name Competitor's name
	 */
	public Competitor(String name){
		this.name =name;

	}

	/**
	 * returns Competitor's name
	 * @return name of the Competitor
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * returns Competitor's score 
	 * @return Competitor points 0 at creation
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * adding points to the Competitor
	 * @param n nb of points to be added
	 */
	public  void addPoints(int n) {
		this.points+=n;
	}
	
	/**
	 * tests the equality of the Competitor with another
	 * @return true if two Competitors have same name and points false otherwise
	 */
	public boolean equals(Object obj) {
		if (this == obj)  return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;
        

        Competitor c = (Competitor) obj;
        return this.name.equals(c.name)&&this.points==c.getPoints();
	}
	protected void resetPoints() {
		this.points=0;
	}

	
}
