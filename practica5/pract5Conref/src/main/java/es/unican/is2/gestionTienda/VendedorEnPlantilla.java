package es.unican.is2.gestionTienda;


public abstract class VendedorEnPlantilla extends Vendedor {
	
	//private TipoVendedor tipo;
	
	/**
	 * Crea un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni) {
		super(nombre, id, dni);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof VendedorEnPlantilla)) 
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}

	public abstract void anhadeVenta(double importe);
	
	public void anhade(double importe) {
		super.anhade(importe);
	}
}
