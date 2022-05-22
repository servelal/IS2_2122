package es.unican.is2.gestionTienda;


public abstract class VendedorEnPlantilla extends Vendedor {

	//private TipoVendedor tipo;

	/*
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1 + 2 + 1 + 1 --> 5
	 * WMCn = 5/4 --> 1,2
	 * CBO = AFF-2 EFF-1 --> 2
	 * DIT = 1
	 * NOC = 2
	 * Ccog = 0 + 0 + 0 + 1 = 1

	 * Crea un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */

	protected VendedorEnPlantilla(String nombre, String id, String dni) {		//WMC+1
		super(nombre, id, dni);
	}

	@Override
	public boolean equals(Object obj) {		//WMC+1
		if (!(obj instanceof VendedorEnPlantilla)) 		//WMC+1  CCog+1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
	
	//Como sobreescribimos el equals tambien debemos cambiar el hashCode()
	@Override
	public int hashCode() {
		String str = this.getId();
		str = str.substring(0, str.length()-1);
		return Integer.parseInt(str);
		
	}

	public abstract void anhadeVenta(double importe);		//WMC+1
}
