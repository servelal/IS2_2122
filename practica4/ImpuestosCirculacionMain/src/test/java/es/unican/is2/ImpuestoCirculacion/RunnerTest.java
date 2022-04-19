package es.unican.is2.ImpuestoCirculacion;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
	private FrameFixture demo;

	@Before
	public void setUp() throws Exception {
		// Componentes capa DAO
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
		
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		// Componentes capa presentacion
		VistaFuncionario gui = new VistaFuncionario(negocio);
		demo = new FrameFixture(gui);
		gui.setVisible(true);
		
	}

	@After
	public void tearDown() throws Exception {
		demo.cleanUp();
	}

	// XXX: caso de prueba valido
	@Test
	public void dniNovalidoTest() {
		//demo.button("btnBuscar").requireText("Buscar");
		demo.textBox("txtDniContribuyente").setText("11111111A");
		demo.button("btnBuscar").click();
		demo.textBox("txtTotalContribuyente").requireText("403.20");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void dniNoValidoTest() {
		demo.textBox("txtDniContribuyente").setText("11111111B");
		demo.button("btnBuscar").click();
		demo.textBox("txtTotalContribuyente").requireText("0");
		demo.textBox("txtNombreContribuyente").requireText("DNI No V�lido");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
