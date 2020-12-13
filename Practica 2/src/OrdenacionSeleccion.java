/**
 * @author Pepe Gallardo
 * @modifiedby Jose A. Onieva
 * @modifiedby Ricardo Conejo
 * Implementaci�n de otros m�todos de ordenaci�n para comparar tiempos de ejecuci�n
 */

public class OrdenacionSeleccion extends Ordenacion {

    // Implementaci�n de ordenaci�n por selecci�n (para comparar tiempos experimentalmente)
    public static <T extends Comparable<? super T>> void ordenar(T v[]) {
        for (int i = 0; i < v.length - 1; i++) {
            int posMin = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[posMin].compareTo(v[j]) > 0)
                    posMin = j;
            intercambiar(v, i, posMin);
        }
    }
}
