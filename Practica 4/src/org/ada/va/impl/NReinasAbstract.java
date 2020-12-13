package org.ada.va.impl;

import java.util.Vector;

/**
 * Esqueleto para la implementación del algoritmo de las n-reinas con la técnica de vuelta atrás.
 * Tiene dos métodos de entrada a la funcionalidad:
 * - init: devuelve la primera solución para el problema
 * - initTodas: devuelve todas las soluciones para el problema
 * El modificador verbose nos permite controlar el nivel de salida de la clase
 * @author Unknown
 */
public abstract class NReinasAbstract {

	/** Dimesión del tablero, y número de reinas a colocar. */
	private Integer dimension;
	/** Solución al problema. */
	protected Integer[] solucion;
	/** Todas las soluciones al problema. */
	protected Vector<Integer[]> todas;
	/** Indica si el algorit ha tenido éxito. */
	private Boolean exito = Boolean.FALSE;
	/** Indica si se desea que el algoritmo muestre las soluciones a las que llega. */
	private Boolean verbose = Boolean.FALSE;
	
	/**
	 * Constructor de la clase.
	 * @param dimension tamaño del tablero y número de reinas a colocar
	 */
	public NReinasAbstract(Integer dimension) {
		this.dimension = dimension;
		solucion = new Integer[dimension];
	}
	
	/**
	 * Indica si queremos que la clase muestre los resultados que va generando.
	 * @param verbose
	 */
	public void setVerbose(Boolean verbose) {
		this.verbose = verbose;
	}
	
	/**
	 * Devuelve si la clase está en modo verbose 
	 * @return
	 */
	public Boolean isVerbose() {
		return verbose;
	}

	/**
	 * Calcula la solución para una etapa concreta y la almacena en la propiedad correspondiente.
	 * @param etapa etapa para la que queremos calcular la soluión.
	 */
	public abstract void vueltaAtras(int etapa);

	/**
	 * Indica si la posible solución es válida para una etapa concreta
	 * @param etapa etapa
	 * @return si la solución es correcta
	 */
	protected abstract Boolean valido(int etapa);
	
	/**
	 * Devuelve el valor absoluto del entero pasado por parámetro.
	 *
	 * @param x entero de entrada
	 * @return valor absoluto del entero
	 */
	protected Integer valAbs(Integer x) {
		return (x<0)?(-x):x; 
	}

	/**
	 * Método que devuelve la primera solución encontrada.
	 * @return primera solución encontrada
	 */
	public Integer[] init() {
		exito = Boolean.FALSE;
		vueltaAtras(0);
		return solucion;
	}
	
	/**
	 * Método que devuelve todas las soluciones posibles.
	 */
	public void initTodas() {
		exito = Boolean.FALSE;
		todas = new Vector<Integer[]>();
		vaTodas(0);
	}
	
	/**
	 * Método que calcula todas las soluciones posibles para una etapa.
	 * 
	 * @param k etapa
	 */
	protected abstract void vaTodas(int k);
	
	/**
	 * Devuelve la dimensión seleccionada para la clase.
	 * @return dimensión seleccionada
	 */
	public Integer getDimension() {
		return dimension;
	}
	
	/**
	 * Devuelve el array de solución.
	 * @return
	 */
	public Integer[] getSolucion() {
		return solucion;
	}
	
	/**
	 * Establece el array de solución.
	 * @return
	 */
	public void setSolucion(Integer[] solucion) {
		this.solucion = solucion;
	}
	
	/**
	 * Devuelve el vector con todas las soluciones.
	 * @return
	 */
	public Vector<Integer[]> getSoluciones() {
		return todas;
	}
	
	/**
	 * Informa si se ha producido un éxito.
	 * @param exito éxito producido
	 */
	public void setExito(Boolean exito) {
		this.exito = exito;
	}
	
	/**
	 * Devuelve si es un éxito.
	 * @return éxito
	 */
	public Boolean isExito() {
		return exito;
	}
	
	/**
	 * Imprime por consola el array de objetos pasado por parámetro.
	 * @param array datos a imprimir por consola
	 */
	protected void printArray(Object[] array) {
		// comunicar solucion
		for (int j=0; j < solucion.length; j++) {
			System.out.print(solucion[j]);
			if (j != getDimension() -1)  System.out.print(" ,");
		}
		System.out.println();
	}
}
