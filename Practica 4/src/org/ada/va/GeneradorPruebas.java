package org.ada.va;

import java.util.ArrayList;
import java.util.List;

import org.ada.va.driver.NReinasDriverTodas;
import org.ada.va.driver.NReinasDriverFirstSolution;
import org.ada.va.presentation.Grafica;

/**
 * Clase encargada de las pruebas.
 * @author Unknown
 */
public class GeneradorPruebas{
	
	/** Línea con los tiempos de cálculo de todas las soluciones posibles. */
	private static Grafica.Linea ln;
	/** Línea con los tiempos de cálculo de la primera solución. */
	private static Grafica.Linea lnFirst;
	/** Driver de pruebas de todas las soluciones posibles. */
	public static NReinasDriverTodas driverTodas;
	/** Driver de pruebas de la primera solución. */
	public static NReinasDriverFirstSolution driverFirst;
	/** Número de ejecuciones para normalizar los datos. */
	private static final int NUMERO_EJECUCIONES = 1000;
	/** Tamaño del tablero. */
	private static final int TABLERO_SIZE= 30;
	/**
	 * Método main de la case
	 * @param args no recibe argumentos
	 */
	public static void main(String[] args) {
		
		// instanciamos el driver para todas las soluciones
		driverTodas = new NReinasDriverTodas(TABLERO_SIZE);
		List<long[]> tiempoEjecucionesDriverTodas = new ArrayList<long[]>();

		// instanciamos el driver para solo la primera solución
		driverFirst = new NReinasDriverFirstSolution(TABLERO_SIZE);
		List<long[]> tiempoEjecucionesDriverFirst = new ArrayList<long[]>();

		// inicializa la gráfica en la que mostraremos los datos
		final Grafica gr  = new Grafica ( "Tiempo de ordenación para distintos tamaños de tablero"
         		, "N-Reinas"
         		, "Tamaño tablero" 
         		, "Milisegundos"
         		, "%.0f"
         		, "%.3f"
				);
		// línea para los tiempos de cálculo de todas las soluciones
		ln = gr.new Linea("Todas las soluciones");
		// línea para los tiempos de cálculo de la primera solución.
		lnFirst = gr.new Linea("Primera solucion");
		
		// Comenzamos por el driver de la primera solución
		for (int i = 0; i < NUMERO_EJECUCIONES; i++) {
			driverFirst.ejecutar();
			tiempoEjecucionesDriverFirst.add(driverFirst.getTiempos().clone());
		}		
		double[] tiempos = normaliza(tiempoEjecucionesDriverFirst);
		for (int i = 0; i < tiempos.length; i++) {
			double tiempo = tiempos[i];
			lnFirst.anadeDatos(i, tiempo);
		}
		
		// Seguimos por el driver de todas las soluciones.
		for (int i = 0; i < NUMERO_EJECUCIONES; i++) {
			driverTodas.ejecutar();
			tiempoEjecucionesDriverTodas.add(driverTodas.getTiempos().clone());
		}
		tiempos = normaliza(tiempoEjecucionesDriverTodas);
		for (int i = 0; i < tiempos.length; i++) {
			double tiempo = tiempos[i];
			ln.anadeDatos(i, tiempo);
		}
	}
	
	/**
	 * Normaliza los datos en base al número de pruebas realizadas.
	 * @param lista lista de resultados
	 * @return los datos normalizados
	 */
	private static double[] normaliza(List<long[]> lista) {
		int n = lista.get(0).length;
		double[] salida = new double[n];
		
		for (int i = 0; i < n; i++) {
			double acc = 0;
			for (int j = 0; j < lista.size(); j++) {
				acc = acc + (double)lista.get(j)[i];
			}
			salida[i] = acc/(double)lista.size();
		}
		return salida;
	}
}
