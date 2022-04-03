package es.unican.is2;
import java.io.Serializable;
import java.time.LocalDate;
@SuppressWarnings("serial")
public class Furgoneta
    extends Turismo implements Serializable
{
    
    private double potencia;
    private boolean comercial;
    
    public Furgoneta(String matricula, LocalDate fechaMatriculacion, double potencia) {
		super(matricula, fechaMatriculacion, potencia);
    }
    
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
		if (potencia > 8) {
			precio = 25.24;
		} else if (potencia > 11.99) {
			precio = 68.16;
		} else if (potencia > 15.99) {
			precio = 143.88;
		} else if (potencia > 19.99) {
			precio = 179.22;
		} else if (potencia > 20) {
			precio = 224;
		}
		
		if (getComercial()) {
			precio *= (1 - 0.2) ;
		} 
		
		return precio;
    	
    }
}
