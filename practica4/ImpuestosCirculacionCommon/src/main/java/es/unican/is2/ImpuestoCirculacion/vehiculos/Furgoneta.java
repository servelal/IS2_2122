package es.unican.is2.ImpuestoCirculacion.vehiculos;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import es.unican.is2.ImpuestoCirculacion.model.OperacionNoValida;
@SuppressWarnings("serial")
public class Furgoneta
    extends Turismo implements Serializable
{
    
    private boolean comercial;
    
    public Furgoneta(String matricula, LocalDate fechaMatriculacion, double potencia, boolean comercial) {
		super(matricula, fechaMatriculacion, potencia);
		this.comercial = comercial;
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
        return super.getPotencia();
    }
    
  
	@Override
    public double precioImpuesto() throws OperacionNoValida {
		
		if (getFechaMatriculacion() == null) {
			throw new OperacionNoValida("La fecha de matriculacion no puede ser NULL");
		}
		Period diferencia = Period.between(getFechaMatriculacion(), LocalDate.now());
		
		if (diferencia.getDays() < 0) {
			throw new OperacionNoValida("La fecha de matriculacion no puede ser superior a la actual");
		}
		
		if (getPotencia() <= 0) {
			throw new OperacionNoValida("La potencia tiene que ser un numero positivo mayor que 0");
		}
		
		if (diferencia.getYears() >= 25 && diferencia.getDays() >= 1) {
			return 0;
		}
		
		double precio = 0;
		
		if (getPotencia() < 8) {
			precio = 25.24;
		}
		else if (getPotencia() < 12) {
			precio = 68.16;
		}
		else if (getPotencia() < 16) {
			precio = 143.88;
		}
		else if (getPotencia() < 20) {
			precio = 179.22;
		}		
		else {
			precio = 224; 
		}
		
		if (getComercial()) {
			return precio * (1 - 0.2);
		} 
		
		return precio;
    }
}
