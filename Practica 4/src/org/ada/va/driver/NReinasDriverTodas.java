package org.ada.va.driver;

import org.ada.va.impl.NReinasAbstract;
import org.ada.va.impl.NReinasVueltaAtras;

/**
 * Driver para la ejecución del algoritmo de las N-Reinas para encontrar todas las soluciones posibles.
 * @author Unknown
 */
public class NReinasDriverTodas extends NReinasDriverAbstract{
	
	/**
	 * Constructor sin parámertros, selecciona la dimensión por defecto.
	 */
	public NReinasDriverTodas() {
		super();
	}
	
	/**
	 * Constructor con parámetros, permite seleccionar la dimensión deseada.
	 * Puede provocar que la instancia sea inválida si la dimensión es menor que la mínima.
	 * @param dimension
	 */
	public NReinasDriverTodas(int dimension) {
		super(dimension);
	}
	
	/**
	 * Implementa el método de ejecución.
	 * Llama al método initTodas para calcular todas las soluciones para cada una de las dimensiones y registra sus tiempos.
	 * 
	 */
	public void ejecutar() {

		if (isValid()) {
			// hay que recorrer desde la mínima dimensión hasta la dimensión seleccionada +1
			for (int i = MIN_DIMENSION; i < dimension +1; i++) {
				// creamos la instancia de la clase con la dimensión actual
				// TODO: Restaurar esta línea: NReinasAbstract nReinas = new NReinasVueltaAtras(i);
				NReinasAbstract nReinas = new NReinasVueltaAtras(i);
				// tomamos tiempos
				long initTime = System.currentTimeMillis();
				nReinas.initTodas();
				long endTime = System.currentTimeMillis();
				// guardamos los tiempos en la estructura
				tiempos[i] = endTime - initTime;
				
			}
						
			// si verbose sacamos los tiempos por consola
			if (isVerbose()) {
				for (int i = MIN_DIMENSION; i < dimension +1; i++) {
					System.out.println("Tiempo total para " + i + " reinas: " + tiempos[i]);
				}
			}
		} else {
			if (isVerbose()) {
				System.out.println("Error. No podemos calcular resultados de instancias inválidas");
			}
		}
	}
}
