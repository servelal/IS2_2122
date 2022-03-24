package es.unican.is2;
/**
 * Clase que implementa la capa de negocio de la aplicacion
 */
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	
	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}
	
	public Contribuyente altaContribuyente(Contribuyente c) {	
		return contribuyentes.creaContribuyente(c);
	}

	
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida {
		return contribuyentes.eliminaContribuyente(dni);
	 }
	
	public Contribuyente contribuyente(String dni) {
		return contribuyentes.contribuyente(dni);
	}

	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		Vehiculo nuevoVehiculo = vehiculos.creaVehiculo(v);
		Contribuyente contribuyente = contribuyentes.contribuyente(dni);
		contribuyentes.actualizaContribuyente(contribuyente);
		
		return nuevoVehiculo;
	}

	@Override
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		Vehiculo vehiculo = vehiculos.eliminaVehiculo(matricula);
		
		Contribuyente contribuyente = contribuyentes.contribuyente(dni);
		contribuyentes.actualizaContribuyente(contribuyente);
		
		return vehiculo;
	}

	@Override
	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
	}	
}

