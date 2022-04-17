package es.unican.is2.ImpuestoCirculacion;

import static org.junit.jupiter.api.Assertions.*;
import org.fest.swing.fixture.FrameFixture;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class VistaFuncionarioTest {
	private FrameFixture demo;
	

	// Componentes capa DAO
	ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
	VehiculosDAO vehiculosDAO = new VehiculosDAO();
	
	// Componentes capa negocio
	GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
	
	@Before
	public void setUp() {
		Runner gui = new RUnn;
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
