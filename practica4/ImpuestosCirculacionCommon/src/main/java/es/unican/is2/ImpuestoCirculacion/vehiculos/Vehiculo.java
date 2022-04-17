package es.unican.is2.ImpuestoCirculacion.vehiculos;
import java.io.Serializable;
import java.time.LocalDate;

import es.unican.is2.ImpuestoCirculacion.model.OperacionNoValida;


@SuppressWarnings("serial")
public abstract class Vehiculo implements Serializable{
  
    private String matricula;
	private LocalDate fechaMatriculacion;	
	
	public Vehiculo(String matricula, LocalDate fechaMatriculacion) {
		this.matricula = matricula;
		this.fechaMatriculacion = fechaMatriculacion;
	}

	/**
     * Retorna el valor del impuesto de circulacion
     *  @return valor del impuesto circulacion
     */
	public abstract double precioImpuesto () throws OperacionNoValida; 


	/**
	 * Retorna la matricula del vehiculo
	 * @return matriculas
	 */
    public String getMatricula() {
		return matricula;
	}

    /**
     * Retorna la fecha de matriculacion del vehiculo
     * @return fecha de matriculacion
     */
	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", fechaMatriculacion=" + fechaMatriculacion + "]";
	}
	
	

}