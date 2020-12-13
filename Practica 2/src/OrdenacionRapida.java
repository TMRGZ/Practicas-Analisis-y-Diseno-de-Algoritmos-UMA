////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO:	Miguel Angel Ruiz Gomez
// GRUPO:	Informatica A
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapida extends Ordenacion {

    public static <T extends Comparable<? super T>> void ordenar(T v[]) {
        ordRapidaRec(v, 0, v.length - 1);
    }

    // Debe ordenar ascendentemente los primeros @n elementos del vector @v con
    // una implementacion recursiva del metodo de ordenacion rapida.
    public static <T extends Comparable<? super T>> void ordRapidaRec(T v[], int izq, int der) {
        // A completar por el alumno

        while (izq < der) {
            int s = partir(v, v[der], izq, der);

            if (s - izq < der - s) {
                ordRapidaRec(v, izq, s - 1);
                izq = s + 1;
            } else {
                ordRapidaRec(v, s + 1, der);
                der = s - 1;
            }
        }
    }

    public static <T extends Comparable<? super T>> int partir(T v[], T pivote, int izq, int der) {
        int i = izq - 1;

        for (int j = izq; j < der; j++) {
            if (v[j].compareTo(pivote) <= 0) {
                i++;
                intercambiar(v, i, j);
            }
        }

        intercambiar(v, i + 1, der);

        return i + 1;

    }

    public static <T extends Comparable<? super T>> void intercambiar(T v[], int i, int j) {
        T aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    // Pequennos ejemplos para pruebas iniciales.
    public static void main(String args[]) {

        // Un vector de enteros
        Integer vEnt[] = {3, 8, 6, 5, 2, 9, 1, 1, 4};
        ordenar(vEnt);
        System.out.println(vectorAString(vEnt));

        // Un vector de caracteres
        Character vCar[] = {'d', 'c', 'v', 'b'};
        ordenar(vCar);
        System.out.println(vectorAString(vCar));

    }
}
