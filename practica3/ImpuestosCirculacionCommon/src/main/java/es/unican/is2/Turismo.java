package es.unican.is2;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{

	private double potencia;
	
	/**
	 * Retorna la potencia del turismo
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
       
    
    /**
     * Retorna el precio del impuesto a pagar
     *  @return precio
     */
	@Override
    public double precioImpuesto() {
		if (potencia < 8) {
			return 25.24;
		}
		else if (potencia < 12) {
			return 68.16;
		}
		else if (potencia < 16) {
			return 143.88;
		}
		else if (potencia < 20) {
			return 179.22;
		}
    	return 224;
    }
    
}
