public class PruebaFIB {
    public static int PruebaFIBB(int n) {
        //if(n<3) {
        if (n < 2) {
            return n;
        } else {
            return PruebaFIBB(n - 1) + PruebaFIBB(n - 2);
            //return PruebaFIBB(n-1)+PruebaFIBB(n-2)+PruebaFIBB(n-3);
        }
    }
}
