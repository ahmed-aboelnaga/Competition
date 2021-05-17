
/**
 *  Create and manage a Stock (add, remove and know the quantity)
 *
 * @author PATHER Stevenson et Aboelnaga Ahmed
 * @version 28/01/2020
 */
 
public class Stock
{
    /**
     * the current quantity of the Stock 
     */
  private int quantity;
   
/**
 * @returns the quantity in the stock
 */
public int getQuantity () {
    return this.quantity; 
}


/**
 * initializes the value of the quantity to zero 
 */
public Stock () {
   this.quantity = 0 ;
}

/**
 * @param n 
 * increases the stock of ñ element
 */public void add(int n) {
       this.quantity = this.quantity + n;
}

/**
 * @param n 
 * increases the stock of ñ element
 */
public int remove(int n) {
       if (this.quantity - n>0){
                             this.quantity = this.quantity - n; 
			     return n;
}         else{
                            int q = this.quantity;
                            this.quantity = 0;
    
                            return q;
		}
       
       
       
}

/**
 * @returns the quantity in the stock
 */
public String toString() {
    return "the stock’s quantity is"+ this.quantity; 
}

/**
 * initializes the value of the quantity to zero 
 */
public Stock(int n) {
    this.quantity = n ;
}


}


