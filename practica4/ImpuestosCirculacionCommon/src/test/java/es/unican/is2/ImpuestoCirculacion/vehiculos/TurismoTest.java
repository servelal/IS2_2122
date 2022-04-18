package es.unican.is2.ImpuestoCirculacion.vehiculos;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import es.unican.is2.ImpuestoCirculacion.model.OperacionNoValida;
import es.unican.is2.ImpuestoCirculacion.vehiculos.Turismo;

public class TurismoTest {

	@Test
	public void testPrecioImpuesto() {
		//XXX: casos validos
		
		//XXX: FECHAS
		try {
			LocalDate fecha = LocalDate.now().minusYears(25).minusDays(1);
			Turismo turismo = new Turismo("1111-AAA", fecha, 4);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 0.0);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusMonths(11).minusDays(10);
			Turismo turismo = new Turismo("1111-AAA", fecha, 18);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 0.0);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Turismo turismo = new Turismo("1111-AAA", fecha, 10);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 68.16);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Turismo turismo = new Turismo("1111-AAA", fecha, 4);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 25.24);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS < 8
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Turismo turismo = new Turismo("1111-AAA", fecha, 0.01);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 25.24);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Turismo turismo = new Turismo("1111-AAA", fecha, 4);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 25.24);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Turismo turismo = new Turismo("1111-AAA", fecha, 7.99);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 25.24);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS < 12
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Turismo turismo = new Turismo("1111-AAA", fecha, 8);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 68.16);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Turismo turismo = new Turismo("1111-AAA", fecha, 10);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 68.16);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Turismo turismo = new Turismo("1111-AAA", fecha, 11.99);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 68.16);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS < 16
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Turismo turismo = new Turismo("1111-AAA", fecha, 12);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 143.88);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Turismo turismo = new Turismo("1111-AAA", fecha, 14);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 143.88);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Turismo turismo = new Turismo("1111-AAA", fecha, 15.99);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 143.88);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS < 20
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Turismo turismo = new Turismo("1111-AAA", fecha, 16);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 179.22);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Turismo turismo = new Turismo("1111-AAA", fecha, 18);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 179.22);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Turismo turismo = new Turismo("1111-AAA", fecha, 19.99);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 179.22);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS >= 20
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Turismo turismo = new Turismo("1111-AAA", fecha, 20);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 224);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Turismo turismo = new Turismo("1111-AAA", fecha, 52.94);
			Double precio = turismo.precioImpuesto();
			assertTrue(precio.toString(), precio == 224);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
				
		
		//XXX: casos no validos
		try {
			LocalDate fecha = LocalDate.now().plusDays(1);
			Turismo turismo = new Turismo("1111-AAA", fecha, 14);
			double precio = turismo.precioImpuesto();
			assertTrue(precio == 143.88);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = null;
			Turismo turismo = new Turismo("1111-AAA", fecha, 14);
			double precio = turismo.precioImpuesto();
			assertTrue(precio == 143.88);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusMonths(11).minusDays(10);
			Turismo turismo = new Turismo("1111-AAA", fecha, 0);
			double precio = turismo.precioImpuesto();
			assertTrue(precio == 0);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusMonths(11).minusDays(10);
			Turismo turismo = new Turismo("1111-AAA", fecha, -1);
			double precio = turismo.precioImpuesto();
			assertTrue(precio == 0);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
	}

}