package es.unican.is2.gestionTienda;


public abstract class VendedorEnPlantilla extends Vendedor {
	
	//private TipoVendedor tipo;
	
	/**
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1 + 2 + 1 + 1 --> 5
	 * WMCn = 5/4 --> 1,2
	 * CBO = AFF-0 EFF-1 --> 1
	 * DIT = 1
	 * Ccog = 0 + 0 + 0 + 1 = 1
	 */
	
	/**
	 * Crea un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni) {		//WMC+1
		super(nombre, id, dni);
	}
	
	@Override
	public boolean equals(Object obj) {		//WMC+1
		if (!(obj instanceof VendedorEnPlantilla)) 		//WMC+1  CCog+1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}

	public abstract void anhadeVenta(double importe);		//WMC+1
	
	public void anhade(double importe) {		//WMC+1
		super.anhade(importe);
	}
}
