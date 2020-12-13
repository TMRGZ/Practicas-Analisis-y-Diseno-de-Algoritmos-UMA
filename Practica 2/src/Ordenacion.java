/**
 * @author Pepe Gallardo
 * @modifiedby Jose A. Onieva
 * @modifiedby Ricardo Conejo
 * Implementaci�n de otros m�todos de ordenaci�n para comparar tiempos de ejecuci�n
 */

import java.util.Random;


public abstract class Ordenacion {

    // Generador de n�meros aleatorios
    protected static Random aleat = new Random();

    // este metodo se redefine en las subclases
    public static <T extends Comparable<? super T>> void ordenar(T v[]) {
    }

    // Itercambia los datos en v[i] y v[j]
    protected static <T> void intercambiar(T v[], int i, int j) {
        T tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }

    // Convierte un vector a una cadena de caracteres.
    public static <T> String vectorAString(T v[]) {
        String res = "[";
        for (int i = 0; i < v.length; i++)
            res += v[i].toString() + (i == v.length - 1 ? ']' : ',');
        return res;
    }

}
