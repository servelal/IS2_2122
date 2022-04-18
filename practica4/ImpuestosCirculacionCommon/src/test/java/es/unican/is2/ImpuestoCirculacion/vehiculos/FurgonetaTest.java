package es.unican.is2.ImpuestoCirculacion.vehiculos;

import static org.junit.Assert.*;
import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.junit.Test;

import es.unican.is2.ImpuestoCirculacion.model.OperacionNoValida;
import es.unican.is2.ImpuestoCirculacion.vehiculos.Furgoneta;

public class FurgonetaTest {

	@Test
	public void testPrecioImpuesto() {
		//XXX: casos validos
		
		//XXX: FECHAS
		try {
			LocalDate fecha = LocalDate.now().minusYears(25).minusDays(1);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 4, true);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 0.0);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusDays(1);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 12, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 0.0);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 14, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 143.88);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 18, true);
			Double precio = furgoneta.precioImpuesto();
			assertEquals(precio, 143.38, 0.01);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		
		//XXX: POTENCIA < 8
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 7.99, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 25.24);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 4, true);
			Double precio = furgoneta.precioImpuesto();
			assertEquals(precio, 20.19, 0.01);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 7.99, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 25.24);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIA < 12

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 8, true);
			Double precio = furgoneta.precioImpuesto();
			assertEquals(precio, 54.53, 0.01);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 10, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 68.16);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 11.99, true);
			Double precio = furgoneta.precioImpuesto();
			assertEquals(precio, 54.53, 0.01);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIA < 16
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 12, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 143.88);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 14, true);
			Double precio = furgoneta.precioImpuesto();
			assertEquals(precio, 115.11, 0.01);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 15.99, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 143.88);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIA < 20

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 16, true);
			Double precio = furgoneta.precioImpuesto();
			assertEquals(precio, 143.38, 0.01);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 18, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 179.22);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 19.99, true);
			Double precio = furgoneta.precioImpuesto();
			assertEquals(precio, 143.38, 0.01);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIA > 20
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 20, false);
			Double precio = furgoneta.precioImpuesto();
			assertTrue(precio.toString(), precio == 224);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
	
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 52.94, true);
			Double precio = furgoneta.precioImpuesto();
			assertEquals(precio, 179.2, 0.01);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}		
		
		//XXX: casos no validos
		try {
			LocalDate fecha = LocalDate.now().plusDays(1);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 14, true);
			double precio = furgoneta.precioImpuesto();
			assertTrue(precio == 143.88);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = null;
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 14, false);
			double precio = furgoneta.precioImpuesto();
			assertTrue(precio == 143.88);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusMonths(11).minusDays(10);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 0, true);
			double precio = furgoneta.precioImpuesto();
			assertTrue(precio == 0);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusMonths(11).minusDays(10);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, -1, false);
			double precio = furgoneta.precioImpuesto();
			assertTrue(precio == 0);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
	}

}
