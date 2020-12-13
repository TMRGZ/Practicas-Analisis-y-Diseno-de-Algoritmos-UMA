import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ***** Miguel Angel Ruiz Gomez *******
 */
public class MochilaPD extends Mochila {

    public SolucionMochila resolver(ProblemaMochila pm) {
        return crearSolucion(pm.pesoMaximo, pm.getPesos(), pm.getValores());
    }

    public int max2(int a, int b) {
        return (a > b) ? a : b;
    }

    public SolucionMochila crearSolucion(int capacidad, int[] pesos, int[] valores) {
        int n = pesos.length;
        int[][] m = new int[n + 1][capacidad + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (i == 0 || w == 0) m[i][w] = 0;

                else if (pesos[i - 1] <= w) m[i][w] = max2(valores[i - 1] + m[i - 1][w - pesos[i - 1]], m[i - 1][w]);

                else m[i][w] = m[i - 1][w];
            }
        }

        ArrayList<Integer> solucion = new ArrayList<>(Collections.nCopies(pesos.length, 0));
        int sumaValores = m[n][capacidad];
        int sumaPesos = 0;
        int i = n;
        int k = capacidad;

        while (i > 0) {
            if (m[i][k] != m[i - 1][k]) {
                i--;
                solucion.set(i, 1);
                k = k - pesos[i];
                sumaPesos += pesos[i];
            } else {
                i--;
            }
        }
        return new SolucionMochila(solucion, sumaPesos, sumaValores);
    }
}
