package es.unican.is2.gestionTienda;


public class vendedorEnPracticas extends Vendedor {
	
	/**
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1 + 1 + 2 --> 4
	 * WMCn = 4/3 --> 1,3
	 * CBO = AFF-0 EFF-1 --> 1
	 * DIT = 1
	 * Ccog = 0 + 0 + 1 = 1
	 */
	
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en pr�cticas
	 * @param nombre
	 * @param dni
	 */
	public vendedorEnPracticas(String nombre, String id, String dni) {	//WMC +1 Ccog = 0
		super(nombre, id);
		this.dni= dni;
	}
	
	public String getDni() {	//WMC +1 Ccog = 0
		return dni;
	}

	@Override
	public boolean equals(Object obj) {	//WMC +1
		if (!(obj instanceof vendedorEnPracticas)) 	//WMC +1 Ccog + 1
			return false;
		vendedorEnPracticas v = (vendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
