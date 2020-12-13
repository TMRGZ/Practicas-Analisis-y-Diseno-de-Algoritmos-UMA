package org.ada.va.driver;

import org.ada.va.impl.NReinasAbstract;
import org.ada.va.impl.NReinasVueltaAtras;

/**
 * Driver para la ejecucion del algoritmo de las N-Reinas para encontrar la primera solucion.
 * @author Unknown
 */
public class NReinasDriverFirstSolution extends NReinasDriverAbstract{
	
	/**
	 * Constructor sin parámertros, selecciona la dimensión por defecto.
	 */
	public NReinasDriverFirstSolution() {
		super();
	}
	
	/**
	 * Constructor con parametros, permite seleccionar la dimension deseada.
	 * Puede provocar que la instancia sea inválida si la dimension es menor que la minima.
	 * @param dimension
	 */
	public NReinasDriverFirstSolution(int dimension) {
		super(dimension);
	}
	
	/**
	 * Implementa el metodo de ejecución.
	 * Llama al metodo init para calcular la primera solucion para cada una de las dimensiones y registra sus tiempos.
	 * 
	 */
	public void ejecutar() {

		if (isValid()) {
			// hay que recorrer desde la minima dimension hasta la dimension seleccionada +1
			for (int i = MIN_DIMENSION; i < dimension +1; i++) {
				// creamos la instancia de la clase con la dimensión actual
				// TODO: Restaurar esta linea: NReinasAbstract nReinas = new NReinasVueltaAtras(i);
				NReinasAbstract nReinas = new NReinasVueltaAtras(i);
				// tomamos tiempos
				long initTime = System.currentTimeMillis();
				nReinas.init();
				long endTime = System.currentTimeMillis();
				// guardamos los tiempos en la estructura
				tiempos[i] = endTime - initTime;
				
			}			
			// si verbose sacamos los tiempos por consola
			if (isVerbose()) {
				for (int i = 4; i < dimension +1; i++) {
					System.out.println("Tiempo total para " + i + " reinas: " + tiempos[i]);
				}
			}
		} else {
			if (isVerbose()) {
				System.out.println("Error. No podemos calcular resultados de instancias invalidas");
			}
		}
	}
}
