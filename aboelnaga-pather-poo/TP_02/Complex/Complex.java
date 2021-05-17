
/**
 * Create a complex number with a real part and an imaginary part
 * Possible representation as well as different operations on them
 * between them
 *
 * @author PATHER Stevenson et Aboelnaga Ahmed
 * @version 04/02/2020
 */
public class Complex
{
    /**
     * the real part of the complex
     */
    private float real_part;
    /**
     * the imaginary part of the complex
     */
    private float imag_part;

    /**
     * @param  real_part the real part of the complex
     * @param imag_part the imaginary of the complex
     * builds object of classe Complex
     */
    public Complex(float real_part, float imag_part)
    {
        this.real_part = real_part;
        this.imag_part = imag_part;
    }

    /** 
     * @return the real_part of the complex
     */
    public float get_real_part()
    {
        // Insérez votre code ici
        return this.real_part;
    }
    
    /** 
     * @return the imag_part of the complex
     */    public float get_imag_part(){
    
           return this.imag_part;
    
    
    }
    
    /** 
     * @param z the object of classe Complex
     * @return true of this complex is equal to z false else
     */    public boolean are_equals(Complex z){
    
        return z.get_real_part()== this.real_part && z.get_imag_part()== this.imag_part;
    
    
    } 
    
    /** 
     * @return the modulus of this complex
     */    public double  modulus(){
   
           return  Math.sqrt( Math.pow(this.real_part,2)+ Math.pow(this.imag_part,2));
    
    
    } 
    
    /** 
     * @param z the object of classe Complex
     * @return new complex the sum of this complex and z 
     */
    public Complex add( Complex z){
    
               float x1 = z.get_real_part();
               float y1 = z.get_imag_part();
               return new Complex(x1 + this.real_part, y1 + this.imag_part);
    
    
    }   
    
    /** 
     * @param z the object of classe Complex
     * @return new complex the result of the multiplication of this complex and z
     */
    public Complex mul( Complex z){
               
               float x1 = z.get_real_part();
               float y1 = z.get_imag_part();
           
               return new Complex(x1 * this.real_part - y1 *this.imag_part , x1 * this.imag_part + y1 * this.real_part);
    
    
    } 
    
     /** 
     * @return the string presentation of this complex
     */
    public String toString(){
    

           return this.real_part+" + i"+this.imag_part ;
    
    
    }   
}
