package es.unican.is2.gestionTienda;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VendedorEnPlantillaTest {
	
	private static VendedorEnPlantilla sutJunior;
	private static VendedorEnPlantilla sutSenior;

	
	@Before
	public void setUp(){
		sutJunior = new VendedorJunior("Ana", "1", "11111111A");
		sutSenior = new VendedorSenior("Pepe", "2", "222222222A");
	}
	
	@Test
	public void testConstructor() {
		assertEquals("1", sutJunior.getId());
		assertEquals("11111111A", sutJunior.getDni());
		assertEquals("Ana", sutJunior.getNombre());		
	}

	@Test
	public void testAnhadeVenta() {
		
		sutJunior.anhade(200);
		assertEquals(200, sutJunior.getTotalVentas(), 0);
		
		sutJunior.anhade(300);
		assertEquals(500, sutJunior.getTotalVentas(), 0);
		
		sutSenior.anhade(300);
		assertEquals(300, sutSenior.getTotalVentas(), 0);
		
		sutSenior.anhade(300);
		assertEquals(600, sutSenior.getTotalVentas(), 0);
		
	}
	
	@Test
	public void testSetTotalVentas() {
		
		sutJunior.setTotalVentas(2000);
		assertEquals(2000, sutJunior.getTotalVentas(), 0);	
		sutJunior.setTotalVentas(4000);
		assertEquals(4000, sutJunior.getTotalVentas(), 0);	
		sutJunior.setTotalVentas(0);
		assertEquals(0, sutJunior.getTotalVentas(), 0);
		
		sutSenior.setTotalVentas(4500);
		assertEquals(4500, sutSenior.getTotalVentas(), 0);		
		sutSenior.setTotalVentas(4000);
		assertEquals(4000, sutSenior.getTotalVentas(), 0);
		sutJunior.setTotalVentas(0);
		assertEquals(0, sutJunior.getTotalVentas(), 0);	
		
	}

	
	@Test
	public void testEquals() {
		VendedorJunior igualJunior = new VendedorJunior("Ana", "1", "11111111A");
		VendedorJunior distintoIdJunior = new VendedorJunior("Ana", "2", "11111111A");
		VendedorJunior distintoDNIJunior = new VendedorJunior("Ana", "1", "222222222A");
		
		assertEquals(sutJunior, igualJunior);
		assertNotEquals(sutJunior, distintoIdJunior);
		assertNotEquals(sutJunior, distintoDNIJunior);
		
		
		VendedorSenior igualSenior = new VendedorSenior("Pepe", "2", "222222222A");
		VendedorSenior distintoIdSenior = new VendedorSenior("Pepe", "3", "222222222A");
		VendedorSenior distintoDNISenior = new VendedorSenior("Pepe", "2", "33333333A");
		
		assertEquals(sutSenior, igualSenior);
		assertNotEquals(sutSenior, distintoIdSenior);
		assertNotEquals(sutSenior, distintoDNISenior);
		
		
		
		
	}
	
	
	
}
