package es.unican.is2.gestionTienda;

public class VendedorSenior extends VendedorEnPlantilla {
	
	private static final double COMISION = 0.01;
	
	/**
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1 + 1 = 2
	 * WMCn = 2/2 = 1
	 * CBO = AFF-0 EFF-1 --> 1
	 * DIT = 1
	 * Ccog = 0
	 */

	public VendedorSenior(String nombre, String id, String dni) { // WMC + 1
		super(nombre, id, dni);
	}
	
	@Override
	public void anhadeVenta(double importe) { // WMC + 1
		super.anhade(importe * COMISION);
	}

}
