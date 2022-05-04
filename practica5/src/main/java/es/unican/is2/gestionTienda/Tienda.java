package es.unican.is2.gestionTienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores.
 * Gestiona las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como par�metro al crear la tienda
 */
public class Tienda {
	/**
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1 + 1 + 1 + 2 + 2 + 5 + 7+ 5 + 9 = 33
	 * WMCn = 33/9 = 3.6
	 * CBO = AFF-2 EFF-0 --> 2
	 * DIT = 0
	 * NOC = 0
	 * CCog = 0 + 0 + 0 + 1 + 1 + 4 + 8 + 5 + 11 = 30
	 */

	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 * CC del metodo = 1
	 */
	public Tienda(String datos) {	//WMC +1  CCog 0
		this.datos = datos;
	}
	
	/* Retorna la direcci�n de la tienda
	 * @return Direcci�n de la tienda
	 * @CC del metodo = 1
	 */
	public String direccion() { // WMC +1 CCog 0 
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 * @CC del metodo = 1
	 */
	public String nombre() { //WMC +1 CCog 0
		return nombre;
	}

	/**
	 * A�ade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya hab�a un vendedor con el mismo id
	 */
	public boolean anhade(Vendedor nuevoVendedor) throws IOException {	//WMC +1 Ccog 1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {	//WMC +1 Ccog + 1
			return false;
		}
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como par�metro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ning�n vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException {	//Ccog + 1 WMC +1
		Vendedor v = buscaVendedor(id);
		if (v == null) { // WMC +1, CCog + 1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * A�ade una venta a un vendedor
	 * @param id Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se a�ade la venta 
	 *         false si no se encuentra el vendedor
	 * @CC del metodo = 5
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException { // WMC +1 Ccog 4
		Vendedor v = buscaVendedor(id);
		if (v == null) {	//WMC +1
			return false;
		}
		double importeFinal = importe;
		if (v instanceof VendedorEnPlantilla) {	//WMC +1 CCog +1
			switch (((VendedorEnPlantilla) v).tipo()) { // Ccog + 2
			case JUNIOR:	//WMC +1
				importeFinal += importeFinal * 0.005;
				break;
			case SENIOR:	//WMC +1
				importeFinal += importeFinal * 0.01;
				break;
			}
		}
		v.anhade(importeFinal);
		vuelcaDatos();
		return true;
	}		

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 * @CC del metodo = 7
	 */
	public Vendedor buscaVendedor(String id) { //Ccog 8 WMC +1

		lista = new LinkedList<Vendedor>();
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de n�meros
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
			while (in.hasNext() && !in.next().equals("Junior")) { // Ccog + 2 WMC +1

				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.SENIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Pr�cticas")) { // Ccog + 2 WMC +1

				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.JUNIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
			while (in.hasNext()) { // Ccog + 1 WMC +1
				in.next();
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new vendedorEnPracticas(nombre, idIn, dni);
				ven.setT(totalVentas);
				lista.add(ven);
			}
		} catch (FileNotFoundException e) {
		} finally {
			if (in != null) {	//WMC +1
				in.close();
			}
		} // try

		for (Vendedor v : lista) { // Ccog + 1 WMC +1
			if (v.getId().equals(id)) { // Ccog + 2 WMC +1
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 * @CC del metodo = 5
	 */
	public List<Vendedor> vendedores() { //Ccog 5 WMC +1

		lista = new LinkedList<Vendedor>();

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de n�meros
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
			while (in.hasNext() && !in.next().equals("Junior")) { // Ccog + 2 WMC +1

				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.SENIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Pr�cticas")) { // Ccog + 2 WMC +1
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.JUNIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
			while (in.hasNext()) { // Ccog + 1 WMC +1
				in.next();
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new vendedorEnPracticas(nombre, idIn, dni);
				ven.setT(totalVentas);
				lista.add(ven);
			}
		} catch (FileNotFoundException e) {

		} finally {
			if (in != null) {	//WMC +1
				in.close();
			}
		} // try

		return lista;

	}

	/**
	 * M�todo que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 * @CC del metodo = 9
	 */
	private void vuelcaDatos() throws IOException { //Ccog 11 WMC +1
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : lista) { // Ccog + 1 WMC +1
			if (v instanceof vendedorEnPracticas) { // Ccog + 2 WMC +1
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) { // Ccog + 2 WMC +1
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR)) // Ccog + 3 WMC +1
					junior.add(vp);
				else	
					senior.add(vp);
			}
		}

		try {

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("Senior");
			for (Vendedor v : senior) { // Ccog + 1 WMC +1
				VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v1.getNombre() + " Id: " + v1.getId() + " DNI: "+ v1.getDni()+" TotalVentasMes: "
						+ v1.getTotalVentas());
			}
			out.println();
			out.println("Junior");
			for (Vendedor v : junior) { // Ccog + 1 WMC +1
				VendedorEnPlantilla v2 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v2.getNombre() + " Id: " + v2.getId() + " DNI: "+ v2.getDni()+" TotalVentasMes: "
						+ v2.getTotalVentas());
			}
			out.println();
			out.println("Pr�cticas");
			for (Vendedor v : practicas) { // Ccog + 1 WMC +1
				vendedorEnPracticas v3 = (vendedorEnPracticas) v;
				out.println("  Nombre: " + v3.getNombre() + " Id: " + v3.getId() + " DNI: "+ v3.getDni()+" TotalVentasMes: "
						+ v3.getTotalVentas());
			}

		} finally {
			if (out != null)	//WMC +1
				out.close();
		}
	}

}
