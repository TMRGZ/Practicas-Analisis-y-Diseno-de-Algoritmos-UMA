import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ***** Miguel Angel Ruiz Gomez *******
 */
public class MochilaAV extends Mochila {

    public static void ordenar(double[] densidades, ArrayList<Item> items) {
        ordRapidaRec(densidades, 0, densidades.length - 1, items);
    }

    public static void ordRapidaRec(double[] densidades, int izq, int der, ArrayList<Item> items) {
        while (izq < der) {
            int s = partir(densidades, densidades[der], izq, der, items);

            if (s - izq < der - s) {
                ordRapidaRec(densidades, izq, s - 1, items);
                izq = s + 1;
            } else {
                ordRapidaRec(densidades, s + 1, der, items);
                der = s - 1;
            }
        }
    }

    public static int partir(double[] densidades, double pivote, int izq, int der, ArrayList<Item> items) {
        int i = izq - 1;

        for (int j = izq; j < der; j++) {
            if (Double.compare(densidades[j], pivote) <= 0) {
                i++;
                intercambiar(densidades, i, j, items);
            }
        }

        intercambiar(densidades, i + 1, der, items);

        return i + 1;

    }

    public static void intercambiar(double[] densidades, int i, int j, ArrayList<Item> items) {
        double auxDens = densidades[i];
        densidades[i] = densidades[j];
        densidades[j] = auxDens;

        Item auxItem = items.get(i);
        items.set(i, items.get(j));
        items.set(j, auxItem);
    }

    public SolucionMochila resolver(ProblemaMochila pm) {
        double[] densidades = densidadObjetos(pm);
        ArrayList<Item> items = pm.getItems();
        ArrayList<Integer> solucion = new ArrayList<>(Collections.nCopies(pm.size(), 0));
        ordenar(densidades, items);

        int sumaPesos = 0;
        int sumaValores = 0;
        int i = pm.size() - 1;

        while (sumaPesos < pm.pesoMaximo && i >= 0) {
            if (items.get(i).peso <= pm.pesoMaximo - sumaPesos) {
                solucion.set(items.get(i).index, 1);

                sumaValores += items.get(i).valor;
                sumaPesos += items.get(i).peso;
            }
            i--;
        }
        return new SolucionMochila(solucion, sumaPesos, sumaValores);
    }

    private double[] densidadObjetos(ProblemaMochila pm) {
        ArrayList<Item> objetos = pm.getItems();
        double[] densidades = new double[pm.size()];


        for (int i = 0; i < pm.size(); i++) {
            densidades[i] = ((double) objetos.get(i).valor / (double) objetos.get(i).peso);
        }
        return densidades;
    }
}
