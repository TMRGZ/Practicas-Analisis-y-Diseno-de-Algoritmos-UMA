public class PruebaLOG {
    public static synchronized int f(int b, int x) {
        if (x == 0) {
            return 1;
        } else if (x % 2 == 0) {
            return f(b * b, x / 2);
        } else {
            return b * f(b * b, x / 2);
        }
    }
}
