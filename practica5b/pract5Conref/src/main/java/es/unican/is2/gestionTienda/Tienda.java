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
	/*
	 * Calculo de WMC, WMCn, CBO, DIT, NOC y CCog
	 * WMC = 1 + 1 + 1 + 5 + 2 + 2 + 3 + 3 + 1 + 9 = 28
	 * WMCn = 28/10 = 2.8
	 * CBO = AFF-0 EFF-1 --> 1
	 * DIT = 0
	 * NOC = 0
	 * CCog = 0 + 0 + 0 + 7 + 1 + 1 + 2 + 3 + 12 = 26
	 */

	private LinkedList<Vendedor> vendedores = new LinkedList<>();
	private String direccion;
	private String nombre;
	private String nombreFichero;


	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param nombreFichero Path absoluto del fichero de datos
	 */
	public Tienda(String nombreFichero) {	//WMC +1	CCog+0
		this.nombreFichero = nombreFichero;
	}

	/**
	 * Retorna la direcci�n de la tienda
	 * @return Direcci�n de la tienda
	 */
	public String direccion() {		//WMC +1	CCog+0
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() {	//WMC +1	CCog+0
		return nombre;
	}

	/**
	 * Lee el fichero de datos de vendedores
	 */
	public void leeDatos() {	//WMC +1	CCog+7
		// abre el fichero
		try (Scanner in = new Scanner(new FileReader(nombreFichero))){	
			// configura el formato de n�meros
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
			while (in.hasNext() && !in.next().equals("Junior")) {	//WMC +1	CCog +2

				String nombreLeido = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorSenior(nombreLeido, idIn, dni);
				ven.setTotalVentas(totalVentas);
				vendedores.add(ven);
			}
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Pr�cticas")) {	//WMC +1	CCog +2
				String nombreLeido = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorJunior(nombreLeido, idIn, dni);
				ven.setTotalVentas(totalVentas);
				vendedores.add(ven);
			}

			// lee los vendedores en practicas
			while (in.hasNext()) {		//WMC +1	CCog +1
				in.next();
				String nombreLeido = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPracticas(nombreLeido, idIn, dni);
				ven.setTotalVentas(totalVentas);
				vendedores.add(ven);
			}
		} catch (FileNotFoundException e) {		//Ccog+1
		}
	}

	/**
	 * A�ade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya hab�a un vendedor con el mismo id
	 */
	public boolean anhadeVendedor(Vendedor nuevoVendedor) throws IOException {		//WMC +1	CCog+1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {		//WMC +1	CCog +1
			return false;
		}
		vendedores.add(nuevoVendedor);
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
	public boolean eliminaVendedor(String id) throws IOException {		//WMC +1	CCog+1
		Vendedor v = buscaVendedor(id);
		if (v == null) {		//WMC +1	CCog +1
			return false;
		}
		vendedores.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * A�ade una venta a un vendedor
	 * @param id Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se a�ade la venta 
	 *         false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException {		//WMC +1	CCog+2
		Vendedor v = buscaVendedor(id);
		if (v == null) {		//WMC +1	CCog +1
			return false;
		}
		if (v instanceof VendedorEnPlantilla) {			//WMC +1	CCog +1
			((VendedorEnPlantilla) v).anhadeVenta(importe);
		}
		vuelcaDatos();
		return true;
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) {		//WMC +1	CCog+3
		for (Vendedor v : vendedores) {			//WMC +1	CCog +1
			if (v.getId().equals(id)) {			//WMC +1	CCog +2
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() {		//WMC +1	CCog+0
		return vendedores;

	}

	/**
	 * Metodo que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 */
	private void vuelcaDatos() throws IOException {		//WMC +1	CCog+12
		List<Vendedor> senior = new LinkedList<>();
		List<Vendedor> junior = new LinkedList<>();
		List<Vendedor> practicas = new LinkedList<>();

		for (Vendedor v : vendedores) {		//WMC +1	CCog +1
			if (v instanceof VendedorEnPracticas) {		//WMC +1	CCog +2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) {		//WMC +1	CCog +2
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp instanceof VendedorJunior) {			//WMC +1	CCog +3
					junior.add(vp);
				} else {
					senior.add(vp);
				}
			}
		}

		try (PrintWriter out = new PrintWriter(new FileWriter(nombreFichero));){
			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("Senior");
			for (Vendedor v : senior) {			//WMC +1	CCog +1
				VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v1.getNombre() + " Id: " + v1.getId() + " DNI: "+ v1.getDni()+" TotalVentasMes: "
						+ v1.getTotalVentas());
			}
			out.println();
			out.println("Junior");
			for (Vendedor v : junior) {			//WMC +1	CCog +1
				VendedorEnPlantilla v2 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v2.getNombre() + " Id: " + v2.getId() + " DNI: "+ v2.getDni()+" TotalVentasMes: "
						+ v2.getTotalVentas());
			}
			out.println();
			out.println("Practicas");
			for (Vendedor v : practicas) {		//WMC +1	CCog +1
				VendedorEnPracticas v3 = (VendedorEnPracticas) v;
				out.println("  Nombre: " + v3.getNombre() + " Id: " + v3.getId() + " DNI: "+ v3.getDni()+" TotalVentasMes: "
						+ v3.getTotalVentas());
			}
		}
	}

}
