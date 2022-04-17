package es.unican.is2.listaOrdenadaAcotada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaOrdenadaAcotadaTest {
	private ListaOrdenadaAcotada<Integer> lista;

	@Before
	public void setUp() {
		lista = new ListaOrdenadaAcotada<Integer>();
	}
	
	public void rellenaListaCompleto() {
		int max = 20;
		int min = -20;
		for (int i = 1; i < lista.maximoTamanho(); i++) {
			int random = (int)(Math.random() * ((max - min) + 1)) + min;
			lista.add(random);
		}
	}
	
	@Test
	public void addTest() {
		// Caso valido: anhade elemento valido
		int tamanhoInicial = lista.size();
		lista.add(0);
		int tamanhoActual = lista.size();
		assertTrue(tamanhoActual == tamanhoInicial + 1);
		
		// XXX: Casos no validos
		// XXX: se anhade elemento nulo
		tamanhoInicial = tamanhoActual;
		try {
			lista.add(null);
			fail("No se ha lanzado la excepcion");
		} catch (NullPointerException e) {
			// Debe lanzarse la excepcion
			assertTrue(tamanhoActual == tamanhoInicial);
		}	
		
		// XXX: se anhade elemento con la lista llena
		tamanhoInicial = tamanhoActual;
		rellenaListaCompleto();
		
		// Anhade elemento 10
		tamanhoActual = lista.size();
		try {
			lista.add(10);
			fail("No se ha lanzado excepcion por lista llena");
		} catch (IllegalStateException e) {
			// Debe lanzarse la excepcion
			assertTrue(tamanhoActual == 10);
		}		
	}
	
	@Test
	public void removeTest() {
		// XXX Caso valido: elimina elemento con lista no vacia
		
		lista.add(0);
		
		int tamanhoInicial = lista.size();
		lista.remove(0);
		int tamanhoActual = lista.size();
		assertTrue(tamanhoActual == tamanhoInicial - 1);
		
		// XXX Casos no validos
		// XXX Lista vacia
		
		tamanhoInicial = lista.size();
		
		try {
			lista.remove(0);
			fail("No se ha lanzado la excepcion por lista vacia");
		} catch (IndexOutOfBoundsException e) {
			// Se tiene que lanzar la excepcion
		}
		
		// XXX Se intenta acceder a elemento vacio
		lista.add(0);
		try {
			lista.remove(1);
			fail("No se ha lanzado la excepcion por intentar acceder a elemento vacio");
		} catch (IndexOutOfBoundsException e) {
			// Se tiene que lanzar la excepcion
		}
		
		// XXX Se intenta acceder a elemento en posicion fuera de tamanho de la lista
		try {
			lista.remove(lista.maximoTamanho() + 1);
			fail("No se ha lanzado la excepcion por intentar acceder a elemento fuera de la lista");
		} catch (IndexOutOfBoundsException e) {
			// Se tiene que lanzar la excepcion
		}
		
		try {
			lista.remove(tamanhoInicial - 1);
			fail("No se ha lanzado la excepcion por intentar acceder a elemento fuera de la lista");
		} catch (IndexOutOfBoundsException e) {
			// Se tiene que lanzar la excepcion
		}
	}
	
	@Test
	public void sizeTest() {
		int tamanhoInicial = lista.size();
		assertTrue(tamanhoInicial == 0);
		
		lista.add(0);
		int tamanhoActual = lista.size();
		assertTrue(tamanhoActual == 1);
	}
	
	@Test
	public void getTest() {
		int tamanhoInicial = lista.size();
		lista.add(1);
		// XXX Casos validos
		int elemento = lista.get(0);
		assertTrue(elemento == 1);
		
		// XXX Casos no validos
		// XXX Intentar acceder a elemento fuera de la lista (positivo)
		try {
			lista.get(lista.maximoTamanho() + 1);
			fail("No se ha lanzado la excepcion por intentar acceder a elemento fuera de la lista "
					+ "(+)");
		} catch (ArrayIndexOutOfBoundsException e) {
			// Se tiene que lanzar la excepcion
		}
		// XXX Intentar acceder a elemento fuera de la lista (negativo)

		try {
			lista.get(tamanhoInicial - 1);
			fail("No se ha lanzado la excepcion por intentar acceder a elemento fuera de la lista "
					+ "(-)");
		} catch (ArrayIndexOutOfBoundsException e) {
			// Se tiene que lanzar la excepcion
		}
	}
	
	@Test
	public void clearTest() {
		// Borrar lista vacia
		int tamanhoInicial = lista.size();
		lista.clear();
		int tamanhoActual = lista.size();
		assertTrue(tamanhoActual == tamanhoInicial);
		
		// Borrar lista con elementos
		lista.add(0);
		lista.clear();
		tamanhoActual = lista.size();
		assertTrue(tamanhoActual == tamanhoInicial);		
	
	}

}
