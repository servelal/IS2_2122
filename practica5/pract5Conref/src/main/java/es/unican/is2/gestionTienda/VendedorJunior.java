package es.unican.is2.gestionTienda;

public class VendedorJunior extends VendedorEnPlantilla {

	private static final double COMISION = 0.005;
	public VendedorJunior(String nombre, String id, String dni) {
		super(nombre, id, dni);
	}

	@Override
	public void anhadeVenta(double importe) {
		super.anhade(importe * COMISION);
	}
	
	

}
