package es.unican.is2.gestionTienda;


public class VendedorEnPlantilla extends Vendedor {
	
	/**
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1+1+1+2 --> 5
	 * WMCn = 5/4 --> 1,2
	 * CBO = 
	 * DIT = 1
	 * Ccog = 0 + 0 + 0 + 1 = 1
	 */
	
	private TipoVendedor tipo;
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	// WMC +1, Ccog = 0
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) {	
		super(nombre, id);
		this.tipo = tipo;
		this.dni=dni;
	}
	
	public TipoVendedor tipo() {	//WMC +1, Ccog = 0
		return tipo;
	}
	
	public String getDni() {	//WMC +1, Ccog = 0
		return dni;
	}
	
	@Override
	public boolean equals(Object obj) {	//WMC + 1, Ccog = 1
		if (!(obj instanceof VendedorEnPlantilla)) 	//WMC +1 Ccog + 1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
