/**
 * @author Pepe Gallardo
 * @modifiedby Jose A. Onieva
 * @modifiedby Ricardo Conejo
 * Implementaci�n de otros m�todos de ordenaci�n para comparar tiempos de ejecuci�n
 */

public class OrdenacionBurbuja extends Ordenacion {

    // Implementaci�n de ordenaci�n por burbuja (para comparar tiempos experimentalmente)
    public static <T extends Comparable<? super T>> void ordenar(T v[]) {
        boolean seguir = true;
        for (int i = v.length - 1; seguir; i--) {
            seguir = false;
            for (int j = 0; j < i; j++)
                if (v[j].compareTo(v[j + 1]) > 0) {
                    intercambiar(v, j, j + 1);
                    seguir = true;
                }
        }
    }

}
