package org.ada.va.impl;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NReinasVueltaAtrasTestUna extends NReinasVueltaAtrasTest {
	
	@Test
	public void testPrimeraSolucionTam4() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(4);
		Integer[] solucion = nr.init();
		
		// comprobamos los valores esperados
		assertTrue(incluido(solucion,valoresValidosTam4));
	}

	@Test
	public void testPrimeraSolucionTam5() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(5);
		Integer[] solucion = nr.init();
		
		// comprobamos los valores esperados
		assertTrue(incluido(solucion,valoresValidosTam5));
	}
	
	@Test
	public void testPrimeraSolucionTam6() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(6);
		Integer[] solucion = nr.init();
		
		// comprobamos los valores esperados
		assertTrue(incluido(solucion,valoresValidosTam6));
	}
	
	@Test
	public void testPrimeraSolucionTam7() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(7);
		Integer[] solucion = nr.init();
		
		// comprobamos los valores esperados
		assertTrue(incluido(solucion,valoresValidosTam7));
	}
	
	@Test
	public void testPrimeraSolucionTam8() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(8);
		Integer[] solucion = nr.init();
		
		// comprobamos los valores esperados
		assertTrue(incluido(solucion,valoresValidosTam8));
	}
	
	@Test
	public void testPrimeraSolucionTam9() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(9);
		Integer[] solucion = nr.init();
		
		// comprobamos los valores esperados
		assertTrue(incluido(solucion,valoresValidosTam9));
	}
	
	@Test
	public void testPrimeraSolucionTam10() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(10);
		Integer[] solucion = nr.init();

		// comprobamos los valores esperados
		assertTrue(incluido(solucion,valoresValidosTam10));
	}
	
}
