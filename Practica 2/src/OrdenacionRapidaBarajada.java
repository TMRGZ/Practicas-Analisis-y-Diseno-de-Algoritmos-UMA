////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO:
// GRUPO:
////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OrdenacionRapidaBarajada extends OrdenacionRapida {

    // Implementaci�n de QuickSort con reordenaci�n aleatoria inicial (para comparar tiempos experimentalmente)
    public static <T extends Comparable<? super T>> void ordenar(T v[]) {
        barajar(v);

        ordRapidaRec(v, 0, v.length - 1);
    }

    // reordena aleatoriamente los datos de un vector
    private static <T> void barajar(T v[]) {
        // A completar or el alumno
        List<T> Barajar = new ArrayList<>();

        for (T i : v) {
            Barajar.add(i);
        }

        Collections.shuffle(Barajar);

        for (int j = 0; j < v.length; j++) {
            v[j] = Barajar.get(j);
        }
    }
}
