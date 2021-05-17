
/**
 *  Create a Goods with an associated value. With a representation in char that give
 *  the name the value of the goods
 *
 * @author PATHER Stevenson et Aboelnaga Ahmed
 * @version 28/01/2020
 */
public class Goods
{
    // les attributs de la classe Goods
    /** value of this goods  */
    private double value;
    /** name of this goods  */
    private String name;

    /**
     * Constructor for objects of class Goods
     * @param name the name of the goods 
     */
    public Goods(String name){
          this.name = name;
          this.value = 0;
        
    }
    /**
     * Constructor for objects of class Goods
     * @param name the name of the goods 
     * @param value the value of the goods 
     */
    public Goods(String name, double value){
          this.name = name;
          this.value = value;
        
    }
    /**
     * returns the value of the goods 
     * @return value the value of the object  
     */
    public double getValue(){
          return this.value;
       
    }
    /**
     * returns the name of the goods 
     * @return name the name of the goods  
     */
    public String getName(){
          return this.name;
       
    }
    /**
     * change the current value of the goods to the new_value 
     * @param new_value the new value of the goods  
     */
    public void setValue(double new_value){
          this.value = new_value;
       
    }
    /**
     * change the current name of the goods to the new_name 
     * @param  new_name the new name of the goods  
     */
    public void setValue(String new_name){
          this.name = new_name;
       
    }
    /**
     * change the current name of the goods to the new_name 
     * @param  new_name the new name of the goods  
     */
    public String toString(){
          return "the goods "+ this.name +" costs "+ this.value  ;
       
    } 
/**
 * @param n 
 * increases the stock of ñ element
 */
public double TTC() {
     double n =  this.value*0.196 ;
       if ( this.value - n > 0){
                             this.value = this.value - n; 
			     return n ;
}         else{
                            double q = this.value;
                            this.value = 0;
    
                            return q;
		}
       
       
       
}
}
