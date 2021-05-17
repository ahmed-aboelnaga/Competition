
/**
 * Allows one and only one Lightbulb to be switched on and off (change of state of a bulb using a switch)
 *
 * @author PATHER Stevenson et Aboelnaga Ahmed
 * @version 28/01/2020
 */
public class Switch
{
    /**
     * the lightbulb we wanted to switch 
     */    
    private Lightbulb amp;
 
    
   /**
     * Builds a new lightbulb in the Switch constructor
     * @param color the color of the new lightbulb
     * @param power the power of the new lightbulb
     */
    public Switch(String color,double power){

   
    this.amp = new Lightbulb(power,color);


}

   /**
     *@return the String representation of this lightbulb 
     */
    public String getAmp(){

    return this.amp.toString();
}



   /**
    *switch the state of this lightbulb
    */
    public void switcher(){
  
    if(amp.getState())
          this.amp.off();
        
    else
          this.amp.on();
    


}

    


  
}