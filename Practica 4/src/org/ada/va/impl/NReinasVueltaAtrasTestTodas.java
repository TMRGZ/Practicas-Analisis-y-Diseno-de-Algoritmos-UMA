package org.ada.va.impl;

import static org.junit.Assert.assertTrue;
import java.util.Vector;
import org.junit.Test;

public class NReinasVueltaAtrasTestTodas extends NReinasVueltaAtrasTest {
	
	@Test
	public void testTodasSolucionesTam4() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(4);
		
		nr.initTodas(); Vector<Integer[]> vector = nr.getSoluciones();

		assertTrue(todosIncluidos(vector, valoresValidosTam4));
	}
	
	@Test
	public void testTodasSolucionesTam5() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(5);
		
		nr.initTodas(); Vector<Integer[]> vector = nr.getSoluciones();
		
		assertTrue(todosIncluidos(vector, valoresValidosTam5));
	}
	
	@Test
	public void testTodasSolucionesTam6() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(6);
		
		nr.initTodas(); Vector<Integer[]> vector = nr.getSoluciones();
		
		assertTrue(todosIncluidos(vector, valoresValidosTam6));
	}
	
	@Test
	public void testTodasSolucionesTam7() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(7);
		
		nr.initTodas(); Vector<Integer[]> vector = nr.getSoluciones();

		assertTrue(todosIncluidos(vector, valoresValidosTam7));
	}
	
	@Test
	public void testTodasSolucionesTam8() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(8);
		
		nr.initTodas(); Vector<Integer[]> vector = nr.getSoluciones();

		assertTrue(todosIncluidos(vector, valoresValidosTam8));
	}
	
	@Test
	public void testTodasSolucionesTam9() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(9);
		
		nr.initTodas(); Vector<Integer[]> vector = nr.getSoluciones();
		
//		for (int i = 0; i < vector.size(); i++) {
//			Integer[] actual = vector.get(i);
//			System.out.print("valoresValidos.add(new Integer[]{");
//			for (int j = 0; j < actual.length; j++) {
//				System.out.print(actual[j]);
//				if (j < actual.length -1) {
//					System.out.print(",");	
//				}
//			}
//			System.out.println("});");
//		}

		// comprobamos los valores esperados
		loadValidateValuesTam9();
		
		assertTrue(todosIncluidos(vector, valoresValidosTam9));
	}
	
	@Test
	public void testTodasSolucionesTam10() {
		NReinasVueltaAtras nr = new NReinasVueltaAtras(10);
		
		nr.initTodas(); Vector<Integer[]> vector = nr.getSoluciones();

		assertTrue(todosIncluidos(vector, valoresValidosTam10));
	}
	

}
