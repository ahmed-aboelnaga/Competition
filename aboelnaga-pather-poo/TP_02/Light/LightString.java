
/**
 * Allows the change of state of all the bulbs on a garland
 *
 * @author PATHER Stevenson et Aboelnaga Ahmed
 * @version 28/01/2020
 */
public class LightString
{
    /**
     * the number of the lightbulbs in the lightbulbString
     */    
    private int n;
    /**
     * the table of lightbulbs
     */
    private Lightbulb tab[];
    /**
     * the interptor used to switch the state of lightbulbString 
     */
    private boolean intreptor=false;
    
    
    /**
     * Constructeur d'objets de classe LightString
     */
    public LightString(int n)
    {
      tab= new Lightbulb[n];
       for(int i=0; i<tab.length; i++){
            tab[i] = new Lightbulb(1, "white");
        
        
        
        }
            
    }

    /**
     * get the lightbulb in range i of the table 
     * @param  i the index of the lightbulb
     * @return  the lightlab with index i 
     */
    public Lightbulb getLight(int i)
    {
        return this.tab[i];
    }
    
 /** replace the n-th lightbulb of the light string by the given lightbulb.
  *  Nothing happens if i is not a valid index.
  * @param i the number of the lightbulb to be changed (first has number 1)
  * @param theBulb the new lightbulb
  */
 public void changeLightbulb(int i, Lightbulb theBulb){
    
      
         this.tab[i-1] = theBulb;
    
    
    
    }
    
    /**
     * switch  the state of the lightString 
     */
    public void switchLightString(){
        
        this.intreptor=!this.intreptor;
        for(int i=0; i<this.tab.length; i++){
                  tab[i].setOn(this.intreptor);
        }   
        
        
    
    }  
    /**
     * give the consumed power by the lighted bulbs 
     */    
    public double getConsumedPower(){
             double cpt=0;
             for(int i=0; i<this.tab.length; i++){
                 if (this.tab[i].getState())
                     cpt += this.tab[i].getPower() ;
                          
                    }
            return cpt;
    
    
   
}
}