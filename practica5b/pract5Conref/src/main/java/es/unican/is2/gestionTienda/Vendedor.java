package es.unican.is2.gestionTienda;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
public abstract class Vendedor {
	
	/**
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1+1+1+1+1+1+1 --> 7
	 * WMCn = 7/7 --> 1
	 * CBO = AFF-3 EFF-0 --> 3
	 * DIT = 0
	 * Ccog = 0
	 */
	
	private String id;
	private String nombre;
	private String dni;
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double totalVentas;
	
	protected Vendedor(String nombre, String id, String dni) {		//WMC+1
		this.nombre = nombre;
		this.id = id;
		this.dni = dni;
	}
	
	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {		//WMC+1
		return nombre;
	}
	
	/**
	 * Retorna el id del vendedor
	 * @return id
	 */
	public String getId() {		//WMC+1
		return id;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getDni() {		//WMC+1
		return dni;
	}

	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {		//WMC+1
		return totalVentas;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setTotalVentas(double totalVentas) {		//WMC+1
		this.totalVentas = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	
	public void anhade(double importe){		//WMC+1
		totalVentas += importe;
	}
	
	
}
