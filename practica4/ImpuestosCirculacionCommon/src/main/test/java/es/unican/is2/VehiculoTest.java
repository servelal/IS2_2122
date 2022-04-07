package es.unican.is2.practica3common;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

@SuppressWarnings("serial")
class FechaNoValida extends RuntimeException {};


class VehiculoTest {
	

	@Test
	void testPrecioImpuesto() {
		
		try {
			LocalDate fecha = LocalDate.now().plusYears(4).plusMonths(1).plusDays(29);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 14);
			fail("No se ha lanzado la excepcion");
		} catch (FechaNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = null;
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 14);
			fail("No se ha lanzado la excepcion");
		} catch (FechaNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = LocalDate.now().plusYears(25).plusMonths(0).plusDays(1);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, 0);
			fail("No se ha lanzado la excepcion");
		} catch (FechaNoValida e) {
			// Debe lanzarse la excepcion
		}
		
		try {
			LocalDate fecha = LocalDate.now().plusYears(25).plusMonths(0).plusDays(1);
			Furgoneta furgoneta = new Furgoneta("1111-AAA", fecha, -1);
			fail("No se ha lanzado la excepcion");
		} catch (FechaNoValida e) {
			// Debe lanzarse la excepcion
		}
	}

}
