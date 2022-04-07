package es.unican.is2;
import java.util.List;
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
		Contribuyente con = contribuyente(dni);
		if (con.getVehiculos().size() < 0) {
			throw new OperacionNoValida("Este contribuyente no tiene vehiculos");
		}
		return contribuyentes.eliminaContribuyente(dni);
	}

	public Contribuyente contribuyente(String dni) {
		return contribuyentes.contribuyente(dni);
	}

	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		if (vehiculos.vehiculo(v.getMatricula()) != null) {
			throw new OperacionNoValida("El vehiculo ya existe");
		}
		Vehiculo nuevoVehiculo = vehiculos.creaVehiculo(v);
		Contribuyente contribuyente = contribuyentes.contribuyente(dni);
		if (contribuyente == null) {
			throw new OperacionNoValida("Este contribuyente no existe");
		}
		contribuyente.anhadeVehiculoContri(nuevoVehiculo);

		return nuevoVehiculo;
	}

	@Override
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		Vehiculo vehiculo = vehiculos.eliminaVehiculo(matricula);
		if (vehiculo == null) { // Vehiculo no existe
			throw new OperacionNoValida("El vehiculo con la matricula indicada no esta "
					+ "registrado");
		}
		
		// Contribuyente no existe
		Contribuyente contribuyente = contribuyentes.contribuyente(dni);
		if (contribuyente == null) {
			throw new OperacionNoValida("El usuario con el DNI indicado no esta registrado");
		}
		
		// Comprueba si el contribuyente tiene ese vehiculo
		List<Vehiculo> vehiculos = contribuyente.getVehiculos();
		if (!vehiculos.contains(vehiculo)) { 
			throw new OperacionNoValida("El usuario con el DNI indicado no tiene registrado el "
					+ "vehiculo indicado");
		}
		
		vehiculos.remove(vehiculo);
		contribuyentes.actualizaContribuyente(contribuyente);

		return vehiculo;
	}

	@Override
	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
	}
}
