package es.unican.is2;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Furgoneta
    extends Turismo implements Serializable
{
    
    private double potencia;
    private boolean comercial;
    
   /**
    * Retorna el valor del atributo comercial
    * @return true si la furgoneta es de uso comercial
    *         false si no es de uso comercial
    */
    public boolean getComercial() {
    	return comercial;
    }
    
    /**
	 * Retorna la potencia de la furgoneta
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
    
  
	@Override
    public double precioImpuesto() {
		double precio = 0;
		if(getPotencia()>8) {
			precio=25.24;
		}else if(getPotencia()>11.99) {
			precio=68.16;
		}else if(getPotencia()>15.99) {
			precio=143.88;
		}else if(getPotencia()>19.99) {
			precio=179.22;
		}else if(getPotencia()<20) {
			precio=224;
		}
		if(getComercial()) {
			precio = precio * 1.20 ;
		} 
		return precio;
    	
    }
}
