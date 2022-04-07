package es.unican.is2.ImpuestoCirculacion.vehiculos;

import java.time.LocalDate;
import java.time.Period;

import es.unican.is2.ImpuestoCirculacion.model.OperacionNoValida;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;

	public Motocicleta(String matricula, LocalDate fechaMatriculacion, int cilindrada) {
		super(matricula, fechaMatriculacion);
		this.cilindrada = cilindrada;
	}
    /**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
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
		
		if (cilindrada <= 0) {
			throw new OperacionNoValida("La cilindrada tiene que ser un numero positivo mayor que 0");
		}
		
		if (diferencia.getYears() >= 25 && diferencia.getDays() >= 1) {
			return 0;
		}
		
		if (cilindrada < 125) {
			return 8.84;
		}
		else if (cilindrada < 250) {
			return 15.14;
		}
		else if (cilindrada < 500) {
			return 30.30;
		}
		else if (cilindrada < 1000) {
			return 60.58;
		}
    	return 121.16;
    }
}
