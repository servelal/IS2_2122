package es.unican.is2.gestionTienda;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
public abstract class Vendedor {
	
	private String id;
	private String nombre;
	private String dni;
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double totalVentas;
	
	public Vendedor(String nombre, String id, String dni) {
		this.nombre = nombre;
		this.id = id;
		this.dni = dni;
	}
	
	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna el id del vendedor
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {
		return totalVentas;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setTotalVentas(double totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	
	public void anhade(double importe){
		totalVentas += importe;
	}

	public abstract void anhadeVenta(double importe);
	
	
}
