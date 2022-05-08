package es.unican.is2.gestionTienda;


public class VendedorEnPracticas extends Vendedor {
	/**
	 * Crea un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String id, String dni) {
		super(nombre, id, dni);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof VendedorEnPracticas)) 
			return false;
		VendedorEnPracticas v = (VendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
	
	public void anhadeVenta(double importe) {
		super.anhade(importe);
	}
}
