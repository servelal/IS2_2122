package es.unican.is2.gestionTienda;


public class VendedorEnPracticas extends Vendedor {
	
	
	/**
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1 + 2 + 1 --> 4
	 * WMCn = 4/3 --> 1,3
	 * CBO = AFF-0 EFF-1 --> 1
	 * DIT = 1
	 * Ccog = 0 + 1 + 0 = 1
	 */
	
	/**
	 * Crea un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String id, String dni) {		//WMC+1
		super(nombre, id, dni);
	}
	
	@Override
	public boolean equals(Object obj) {		//WMC+1
		if (!(obj instanceof VendedorEnPracticas)) 		//WMC+1		Ccog+1
			return false;
		VendedorEnPracticas v = (VendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
	
	//Como sobreescribimos el equals tambien debemos cambiar el hashCode()
	@Override
	public int hashCode() {
		String str = this.getId();
		str = str.substring(0, str.length()-1);
		int strInt = Integer.parseInt(str);
		return strInt;
	}
	
	public void anhadeVenta(double importe) {		//WMC+1
		super.anhade(importe);
	}
}
