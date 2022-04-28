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
	 * WMC = 1+1+1+2+2+5+7+5+9 --> 33
	 * WMCn = 33/9 --> 3,6
	 * CBO = 
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
	 * @CC del metodo == 1
	 */
<<<<<<< HEAD
	public Tienda(String datos) { //CCog 0
=======
	public Tienda(String datos) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
		this.datos = datos;
	}

	/**
<<<<<<< HEAD
	 * Retorna la direcci�n de la tienda
	 * @return Direcci�n de la tienda
	 */
	public String direccion() {//CCog 0
=======
	 * Retorna la direcci�n de la tienda
	 * @return Direcci�n de la tienda
	 * @CC del metodo == 1
	 */
	public String direccion() {		//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 * @CC del metodo == 1
	 */
<<<<<<< HEAD
	public String nombre() { //CCog 0
=======
	public String nombre() {		//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
		return nombre;
	}

	/**
	 * A�ade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
<<<<<<< HEAD
	 *         false si ya hab�a un vendedor con el mismo id
	 */
	public boolean anhade(Vendedor nuevoVendedor) throws IOException { //Ccog 1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) { //Ccog + 1
=======
	 *         false si ya hab�a un vendedor con el mismo id
	 * @CC del metodo == 2
	 */
	public boolean anhade(Vendedor nuevoVendedor) throws IOException {	//WMC +1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
<<<<<<< HEAD
	 *         false si no existe ning�n vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException { //Ccog 1
		Vendedor v = buscaVendedor(id);
		if (v == null) { //CCog + 1
=======
	 *         false si no existe ning�n vendedor con el id indicado
	 * @CC del metodo == 2
	 */
	public boolean eliminaVendedor(String id) throws IOException {	//WMC +1
		Vendedor v = buscaVendedor(id);
		if (v == null) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
	 * @CC del metodo == 5
	 */
<<<<<<< HEAD
	public boolean anhadeVenta(String id, double importe) throws IOException { //Ccog 4
		Vendedor v = buscaVendedor(id);
		if (v == null) { // Ccog + 1
			return false;
		}
		double importeFinal = importe; 
		if (v instanceof VendedorEnPlantilla) { //CCog +1
			switch (((VendedorEnPlantilla) v).tipo()) { //CCog +2
			case JUNIOR:
=======
	public boolean anhadeVenta(String id, double importe) throws IOException {	//WMC +1
		Vendedor v = buscaVendedor(id);
		if (v == null) {	//WMC +1
			return false;
		}
		double importeFinal = importe;
		if (v instanceof VendedorEnPlantilla) {	//WMC +1
			switch (((VendedorEnPlantilla) v).tipo()) {
			case JUNIOR:	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
	 * @CC del metodo == 7
	 */
<<<<<<< HEAD
	public Vendedor buscaVendedor(String id) { //Ccog 8
=======
	public Vendedor buscaVendedor(String id) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf

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
<<<<<<< HEAD
			while (in.hasNext() && !in.next().equals("Junior")) { // Ccog + 2
=======
			while (in.hasNext() && !in.next().equals("Junior")) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf

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
<<<<<<< HEAD
			while (in.hasNext() && !in.next().equals("Pr�cticas")) { // Ccog + 2
=======
			while (in.hasNext() && !in.next().equals("Pr�cticas")) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
<<<<<<< HEAD
			while (in.hasNext()) { // Ccog + 1
=======
			while (in.hasNext()) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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

<<<<<<< HEAD
		for (Vendedor v : lista) { // Ccog + 1
			if (v.getId().equals(id)) { // Ccog + 2
=======
		for (Vendedor v : lista) {	//WMC +1
			if (v.getId().equals(id)) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 * @CC del metodo == 5
	 */
<<<<<<< HEAD
	public List<Vendedor> vendedores() { //Ccog 5
=======
	public List<Vendedor> vendedores() {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
<<<<<<< HEAD
			while (in.hasNext() && !in.next().equals("Junior")) { // Ccog + 2
=======
			while (in.hasNext() && !in.next().equals("Junior")) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf

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
<<<<<<< HEAD
			while (in.hasNext() && !in.next().equals("Pr�cticas")) { // Ccog + 2
=======
			while (in.hasNext() && !in.next().equals("Pr�cticas")) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
<<<<<<< HEAD
			while (in.hasNext()) { // Ccog + 1
=======
			while (in.hasNext()) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
	 * @CC del metodo == 9
	 */
<<<<<<< HEAD
	private void vuelcaDatos() throws IOException { //Ccog 11
=======
	private void vuelcaDatos() throws IOException {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

<<<<<<< HEAD
		for (Vendedor v : lista) { // Ccog + 1
			if (v instanceof vendedorEnPracticas) { // Ccog + 2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) { // Ccog + 2
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR)) // Ccog + 3
=======
		for (Vendedor v : lista) {	//WMC +1
			if (v instanceof vendedorEnPracticas) {	//WMC +1
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) {	//WMC +1
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR))	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
<<<<<<< HEAD
			for (Vendedor v : senior) { // Ccog + 1
=======
			for (Vendedor v : senior) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
				VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v1.getNombre() + " Id: " + v1.getId() + " DNI: "+ v1.getDni()+" TotalVentasMes: "
						+ v1.getTotalVentas());
			}
			out.println();
			out.println("Junior");
<<<<<<< HEAD
			for (Vendedor v : junior) { // Ccog + 1
=======
			for (Vendedor v : junior) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
				VendedorEnPlantilla v2 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v2.getNombre() + " Id: " + v2.getId() + " DNI: "+ v2.getDni()+" TotalVentasMes: "
						+ v2.getTotalVentas());
			}
			out.println();
<<<<<<< HEAD
			out.println("Pr�cticas");
			for (Vendedor v : practicas) { // Ccog + 1
=======
			out.println("Pr�cticas");
			for (Vendedor v : practicas) {	//WMC +1
>>>>>>> 3402e66588e7dfa12b97e8e5131c0f28f09422cf
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
