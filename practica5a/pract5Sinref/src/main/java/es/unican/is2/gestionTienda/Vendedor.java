package es.unican.is2.gestionTienda;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
public abstract class Vendedor {
	
	/**
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1 + 1 + 1 + 1 + 1 + 1 --> 6
	 * WMCn = 6/6 --> 1
	 * CBO = AFF-3 EFF-0 --> 3
	 * DIT = 0
	 * Ccog = 0
	 */
	
	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	
	public Vendedor(String nombre, String id) {		//WMC +1 Ccog = 0
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {		//WMC +1 Ccog = 0
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() {		//WMC +1 Ccog = 0
		return id;
	}
	
	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {		//WMC +1 Ccog = 0
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setT(double totalVentas) {		//WMC +1 Ccog = 0
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhade(double importe){		//WMC +1 Ccog = 0
		t += importe;
	}
	
}
