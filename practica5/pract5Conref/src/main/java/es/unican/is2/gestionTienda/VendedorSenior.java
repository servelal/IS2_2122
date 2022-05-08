package es.unican.is2.gestionTienda;

public class VendedorSenior extends VendedorEnPlantilla {
	
	private static final double COMISION = 0.01;

	public VendedorSenior(String nombre, String id, String dni) {
		super(nombre, id, dni);
	}
	
	@Override
	public void anhadeVenta(double importe) {
		super.anhade(importe * COMISION);
	}

}
