package org.ada.va.impl;

/**
 * Implementación del algoritmo de las n-reinas con la técnica de vuelta atrás.
 * Tiene dos métodos de entrada a la funcionalidad proporcionados por la clase que implementa:
 * - init: devuelve la primera solución para el problema
 * - initTodas: devuelve todas las soluciones para el problema
 * El modificador verbose nos permite controlar el nivel de salida de la clase
 * @author Unknown
 */
public class NReinasVueltaAtras extends NReinasAbstract {
	
	/**
	 * Constructor de la clase.
	 * @param dimension tamaño del tablero y número de reinas a colocar
	 */
	public NReinasVueltaAtras(Integer dimension) {
		super(dimension);
	}

	/**
	 * Calcula la solución para una etapa concreta.
	 * @param etapa etapa para la que queremos calcular la solución.
	 */
	public void vueltaAtras(int etapa) {
		int n = getDimension();
		int i = 0;

		if(etapa<n){
			while(i<n && !isExito()){
				solucion[etapa] = i;

				if(valido(etapa)){
					if(etapa<n-1) vueltaAtras(etapa+1);
					else setExito(true);
				}
			i++;
			}
		}
	}
	
	/**
	 * Indica si la posible solución es válida para una etapa concreta
	 * @param  etapa etapa para la que queremos validar la solución
	 * @return si la solución es correcta
	 */
	protected Boolean valido(int etapa) { 
		for (int i=0; i<etapa; i++) {
			if ((getSolucion()[i]==getSolucion()[etapa]) || (valAbs(getSolucion()[i]-getSolucion()[etapa])==valAbs(i-etapa))){
				return false;
			}
		}
		return true;
	}

	/**
	 * Método que calcula todas las soluciones posibles para una etapa.
	 * 
	 * @param etapa etapa
	 */
	public void vaTodas(int etapa) {
		int n = getDimension();

		if (etapa < n) {
			solucion[etapa] = 0;

			for(int i=0; i<n; i++){
				solucion[etapa] = i;

				if(valido(etapa)){
					if(etapa<n-1) vaTodas(etapa + 1);
					else{
						todas.add(solucion.clone());
					}
				}
			}
		}
	}
}
