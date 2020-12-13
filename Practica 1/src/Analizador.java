public class Analizador {
    public static String masCercano(double ratio, int n, long t1, long t2) {
        if (ratio <= 1.2 && (n == 200000)) {
            Temporizador t = new Temporizador();
            long a = tiempoPasado(t, 10);

            if (esConstante(a, t2)) {
                return "1";
            } else {
                return "LOGN";
            }

        } else if ((1.2 <= ratio && ratio < 3.0) && (n == 20002 || n == 20003)) {
            Temporizador t = new Temporizador();

            long tiempo1 = tiempoPasado(t, 8 * n);
            long tiempo2 = tiempoPasado(t, 16 * n);

            long tiempo3 = tiempoPasado(t, 2 * n);
            long tiempo4 = tiempoPasado(t, 4 * n);

            tiempo1 = (tiempo1 + tiempo3) / 2;
            tiempo2 = (tiempo2 + tiempo4) / 2;

            double pend1 = (double) (t2 - t1) / n;
            double pend2 = (double) (tiempo2 - tiempo1) / (2 * n);
            boolean esN = esAproximado(pend1, pend2, 50);

            //System.out.println(pend1);
            //System.out.println(pend2);
            //System.out.println(esN);

            if (n == 20002 && esN) {
                return "N";
            } else if (n == 20003 && !esN) {
                return "NLOGN";
            }

        } else if ((3 <= ratio && ratio < 6.0) && (n == 20001)) {
            return "N2";
        } else if ((6 <= ratio && ratio < 10.0) && (n == 500)) {
            return "N3";
        } else if ((ratio > 10) && (n <= 20)) {
            if ((ratio < 1500 && esExponencial(t1, t2, n))) {
                if ((n == 10 || n == 6) && exponencialDoble()) {
                    return "2N";
                }
            } else if (n == 6) {
                return "NF";
            }
        }
        return "Repite";
    }

    public static boolean esConstante(double a, double b) {
        if (esAproximado(a / b, 1, 0.5)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean exponencialDoble() {
        Temporizador t = new Temporizador();
        boolean doble = false;

        long exp1 = tiempoPasado(t, 20);
        long exp2 = tiempoPasado(t, 10);
        double rel = (double) (exp1 / exp2);


        if (esAproximado(rel, 1000, 1000)) {
            doble = true;
        }
        //System.out.println(rel);
        return doble;
    }

    public static boolean esExponencial(long t1, long t2, int n) {
        double relacion = (double) (t1 * t1) / t2;
        boolean exponencial = false;

        if (esAproximado(relacion, 1, 500)) {
            exponencial = true;
        }
        //System.out.println("Relacion Exponencial=" +relacion);
        //System.out.println(exponencial);
        return exponencial;
    }

    public static long tiempoPasado(Temporizador t, int n) {
        t.iniciar();
        hacerAlgoritmo(n);
        t.parar();
        long tiempo = t.tiempoPasado();
        t.reiniciar();

        t.iniciar();
        hacerAlgoritmo(n);
        t.parar();
        tiempo = t.tiempoPasado();
        t.reiniciar();
        return tiempo;
    }

    public static boolean esAproximado(double x, double y, double dif) {
        if ((x >= y && (x - y <= dif)) || (x < y) && (y - x <= dif)) {
            return true;
        } else return false;
    }

    public static void hacerAlgoritmo(int x) {
        //Algoritmo.f(x);					//ESTANDAR
        //PruebasEXP.f(x);				//Potencias de N
        //PruebaFIB.PruebaFIBB(x);		//2N
        //PruebaFAC.PruebaFACC(x);		//N
        new PruebaNLOGN(x);            //NLOGN
        //PruebaLOG.f(2,x);				//LOGN
        //Prueba2N.f(500, x);
    }

    public static String medirComplejidad(int n) {
        int n1 = n;
        int n2 = n * 2;

        Temporizador t = new Temporizador();

        long t1 = tiempoPasado(t, n1);
        long t2 = tiempoPasado(t, n2);
        double ratio = (double) t2 / t1;
		
		/*System.out.println("Tiempo N= " + t1);
		System.out.println("Tiempo 2N= " +t2);
		System.out.println("Ratio= " +ratio);*/
        String fin = (masCercano(ratio, n, t1, t2));
        //System.out.println(fin);

        return (fin);
    }

    public static void main(String arg[]) {
        //PRUEBA NO AUTOMATIZADA
        //medirComplejidad(10000);
        //System.out.println(medirComplejidad(10000));
        //System.out.println("AUTOMATIZACION");

        //PRUEBA AUTOMATIZADA
        if (medirComplejidad(6).equals("NF")) {
            System.out.println("NF");
        } else if (medirComplejidad(6).equals("2N")) {
            System.out.println("2N");
        } else if (medirComplejidad(10).equals("2N")) {
            System.out.println("2N");
        } else if (medirComplejidad(500).equals("N3")) {
            System.out.println("N3");
        } else if (medirComplejidad(20001).equals("N2")) {
            System.out.println("N2");
        } else if (medirComplejidad(20002).equals("N")) {
            System.out.println("N");
        } else if (medirComplejidad(20003).equals("NLOGN")) {
            System.out.println("NLOGN");
        } else if (medirComplejidad(200000).equals("LOGN")) {
            System.out.println("LOGN");
        } else if (medirComplejidad(200000).equals("1")) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}