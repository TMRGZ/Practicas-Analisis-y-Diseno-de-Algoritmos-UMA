package org.ada.va.driver;

/**
 * Clase abstacta que implementa la funcionalidad común de los drivers del algoritmo de las N-Reinas.
 * Estos drivers realizaán ejecuciones sucesivas desde MIN_DIMENSION hasta la dimensión deseada y recogerá los tiempos de solución.
 * Habrá dos drivers, uno para todas las soluciones (para cada dimensión calculará todas las soluciones posibles) y otro para la primera solución encontrada.
 * @author Unknown
 */
public abstract class NReinasDriverAbstract{
	/** Valor por defecto del tablero y el número de reinas a colocar. */
	private static final int MAX_VALUE = 8;
	/** Dimensión mínima del tablero para que los resultados tengan sentido. */
	protected static final int MIN_DIMENSION = 4;
	/** Array de tiempos registrados por cada tamaño del problema. */
	protected long[] tiempos;
	/** Dimensión seleccionada en la instancia actual. */
	protected int dimension;
	/** Indica si la clase está configurada para mostrar los mensajes por consola. */
	private boolean verbose = Boolean.FALSE;	
	/** Indica si los resultados de la clase serán válidos (si la dimensión seleccionada es correcta). */
	private boolean valid = Boolean.TRUE;

	/**
	 * Constructor sin parámertros, selecciona la dimensión por defecto.
	 */
	public NReinasDriverAbstract() {
		dimension = MAX_VALUE;
		// el array de tiempos lo seleccionamos de tamaño dimension +1 porque 
		// java inicia las estructuras en 0 y nos interesan también los datos del
		// último valor de la dimensión si queremos empezar en MIN_DIMENSION.
		tiempos = new long[dimension +1];
	}
	
	/**
	 * Constructor con parámetros, permite seleccionar la dimensión deseada.
	 * Puede provocar que la instancia sea inválida si la dimensión es menor que la mínima.
	 * @param dimension
	 */
	public NReinasDriverAbstract(int dimension) {
		if (dimension < MIN_DIMENSION) {
			valid = Boolean.FALSE;
			if (verbose) {
				System.out.println("Warning: La dimensión seleccionada [" + dimension + "] es menor que la mínima dimensión [4] para obtener resultados reales.");
			}
		}
		this.dimension = dimension;
		// el array de tiempos lo seleccionamos de tamaño dimension +1 porque 
		// java inicia las estructuras en 0 y nos interesan también los datos del
		// último valor de la dimensión si queremos empezar en MIN_DIMENSION.
		tiempos = new long[dimension +1];
	}
	
	/**
	 * Devuelve el array de tiempos registrados por el driver.
	 * @return array de tiempos registrados
	 */
	public long[] getTiempos() {
		return tiempos;
	}
	
	/**
	 * Indica si la instancia actual es válida.
	 * @return TRUE si la instancia actual es válida, FALSE en otro caso
	 */
	public Boolean isValid() {
		return valid;
	}
	
	/**
	 * Indica si la instancia actual está configurada como verbose.
	 * @return TRUE si la instancia actual es verbose, FALSE en otro caso
	 */
	public Boolean isVerbose() {
		return verbose;
	}
	
	/**
	 * Selecciona si queremos la clase en modo verbose.
	 * @param verbose valor que queremos de verbose
	 */
	public void setVerbose(Boolean verbose) {
		this.verbose = verbose;
	}
}
