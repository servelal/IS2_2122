package es.unican.is2.ImpuestoCirculacion.vehiculos;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import es.unican.is2.ImpuestoCirculacion.model.OperacionNoValida;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{

	private double potencia;
	
	public Turismo(String matricula, LocalDate fechaMatriculacion, double potencia) {
		super(matricula, fechaMatriculacion);
		this.potencia = potencia;
	}
	
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
    public double precioImpuesto() throws OperacionNoValida {
		
		if (getFechaMatriculacion() == null) {
			throw new OperacionNoValida("La fecha de matriculacion no puede ser NULL");
		}
		Period diferencia = Period.between(getFechaMatriculacion(), LocalDate.now());
		
		if (diferencia.getDays() < 0) {
			throw new OperacionNoValida("La fecha de matriculacion no puede ser superior a la actual");
		}
		
		if (potencia <= 0) {
			throw new OperacionNoValida("La potencia tiene que ser un numero positivo mayor que 0");
		}
		
		if (diferencia.getYears() >= 25 && diferencia.getDays() >= 1) {
			return 0;
		}
		
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
