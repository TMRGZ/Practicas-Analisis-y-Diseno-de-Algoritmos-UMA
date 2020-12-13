public class PruebaFAC {

    public static void PruebaFACC(int n) {
        for (int i = 0; i < n; i++) {
            PruebaFACC(n - 1);
        }
    }
}
