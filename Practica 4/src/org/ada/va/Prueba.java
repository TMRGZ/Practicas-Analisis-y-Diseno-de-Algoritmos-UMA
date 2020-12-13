/**
 * 
 */
package org.ada.va;

import org.ada.va.impl.NReinasAbstract;
import org.ada.va.impl.NReinasVueltaAtras;
import org.ada.va.presentation.MainFrame;

/**
 * @author Unknown
 *
 */
public class Prueba {
	private static final int TABLERO_SIZE= 11;

	/**
	 * Método main de la clase
	 * @param args no recibe argumentos
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NReinasAbstract nReinas = new NReinasVueltaAtras(TABLERO_SIZE);
		nReinas.init();		
		MainFrame frame = new MainFrame(TABLERO_SIZE, TABLERO_SIZE, "Primera solución: " + TABLERO_SIZE + "x" + TABLERO_SIZE);
		if (nReinas.isExito()) frame.loadData(nReinas.getSolucion());
		frame.setVisible(true);
	}
}
