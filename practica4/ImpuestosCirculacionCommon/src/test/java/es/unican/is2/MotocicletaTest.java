package es.unican.is2;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import es.unican.is2.ImpuestoCirculacion.model.OperacionNoValida;
import es.unican.is2.ImpuestoCirculacion.vehiculos.Motocicleta;

public class MotocicletaTest {

	@Test
	public void testPrecioImpuesto() {
		//XXX: casos validos
		
		//XXX: FECHAS
		try {
			LocalDate fecha = LocalDate.now().minusYears(25).minusDays(1);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 62);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 0.0);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusMonths(11).minusDays(10);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 187);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 0.0);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 375);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 30.30);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 750);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 60.58);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS < 125
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 1);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 8.84);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 62);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 8.84);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 124);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 8.84);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS < 250
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 125);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 15.14);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 187);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 15.14);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 249);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 15.14);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS < 500
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 250);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 30.30);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 375);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 30.30);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 499);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 30.30);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS < 1000
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 500);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 60.58);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 750);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 60.58);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 999);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 60.58);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
		
		//XXX: POTENCIAS >= 1000
		try {
			LocalDate fecha = LocalDate.now().minusYears(10).minusMonths(2).minusDays(7);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 1000);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 121.16);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}

		try {
			LocalDate fecha = LocalDate.now().minusYears(25);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 2200);
			Double precio = moto.precioImpuesto();
			assertTrue(precio.toString(), precio == 121.16);
		} catch (OperacionNoValida e) {
			fail("No se tendria que haber lanzado la excepcion");
		}
				
		
		//XXX: casos no validos
		try {
			LocalDate fecha = LocalDate.now().plusDays(1);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 14);
			double precio = moto.precioImpuesto();
			assertTrue(precio == 30.30);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = null;
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 14);
			double precio = moto.precioImpuesto();
			assertTrue(precio == 30.30);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusMonths(11).minusDays(10);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, 0);
			double precio = moto.precioImpuesto();
			assertTrue(precio == 0);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = LocalDate.now().minusYears(30).minusMonths(11).minusDays(10);
			Motocicleta moto = new Motocicleta("1111-AAA", fecha, -1);
			double precio = moto.precioImpuesto();
			assertTrue(precio == 0);
			fail("No se ha lanzado la excepcion");
		} catch (OperacionNoValida e) {
			// Debe lanzarse la excepcion
		}
	}

}