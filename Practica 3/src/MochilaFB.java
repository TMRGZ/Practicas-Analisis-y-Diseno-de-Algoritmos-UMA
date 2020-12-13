/**
 * @author ***** Miguel Angel Ruiz Gomez *******
 */
public class MochilaFB extends Mochila {
    public SolucionMochila resolver(ProblemaMochila pm) {
        SolucionMochila temporal = null;
        SolucionMochila solucion = null;
        int[] w = new int[pm.size()];

        for (int i = 0; i < Math.pow(2, pm.size()); i++) {
            temporal = pasarBinario(i, w, pm);
            if (solucion == null || temporal.getSumaPesos() <= pm.getPesoMaximo() && solucion.getSumaValores() < temporal.getSumaValores()) {
                solucion = temporal;
            }
        }
        return solucion;
    }

    private SolucionMochila pasarBinario(int n, int[] obj, ProblemaMochila pm) {
        int sumaPesos = 0;
        int sumaValores = 0;

        for (int i = pm.size() - 1; i >= 0; i--) {
            if (n % 2 == 0) obj[i] = 0;

            else {
                obj[i] = 1;
                sumaPesos += pm.getPeso(i);
                sumaValores += pm.getValor(i);
            }
            n = n / 2;
        }
        return new SolucionMochila(obj, sumaPesos, sumaValores);
    }
}
