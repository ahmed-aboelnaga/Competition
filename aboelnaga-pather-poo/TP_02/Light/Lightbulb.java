
/**
 * Create a bulb (state and change of state (on / off), power, color and obtaining these)
 *
 * @author PATHER Stevenson et Aboelnaga Ahmed
 * @version 28/01/2020
 */
public class Lightbulb
{
    /**
     * state of this lightbulb, <t>true</t> if on, <t>false</t> else
     */
    private boolean on; // true si l'ampoule est allumée false sinon
    /**
     * the power of the lightbulb 
     */
    private double power ;// la puissance de l'ampoule
      /**
     * the color of the lightbulb 
     */
    private String color;// la couleur de l'ampoule 
    /**
     * Builds a lightbulb, initially it is off
     * power the power of the lightbulb
     * param color the color of the lightbulb
     */
    public Lightbulb()
    {
       this.on = false;
       this.power = 45;
       this.color = "white";
    }
    
    /**
     * Builds a lightbulb, initially it is off
     * @param power the power of the lightbulb
     * @param color the color of the lightbulb
     */
    public Lightbulb(double power, String color)
    {
       this.on = false;
       this.power = power;
       this.color = color;
    }

    /**
     *  gives the power of the lightbulb
     * @return  the power of the lightbulb
     */
    public double getPower()
    {
        return this.power;
    }
    
    /**
     *  gives the color of the lightbulb
     * @return  the color of the lightbulb
     */
    public String getColor()
    {
        return this.color;
    }
    
    /**
     * return the state of the lightbulb
     * @return true if the lightbulb is on false else
     */
    public boolean getState()
    {
        return this.on;
    }
    
    /**
     * change the state of the lightbulb to the value
     */
    
    public void setOn(boolean value){
        this.on=value;
    }
    
    /**
     * turn this lightbulb on 
     */
    public void on()
    {
        this.on = true;
    }
    
    /**
     * turn this lightbulb off
     */
    public void off()
    {
        this.on = false;
    }
    
    /**
     * @return a string representation for this lightbulb object
     */
    public String toString()
    {       String result = "";
	    if (this.on) {
			 result = " is on ";
		} else {
		         result = " is off ";
		}
		return "The state of the lightbulb "+ result + " - the color : " + this.color+ " - the power : " + this.power+"w";
		
    }
    
}

