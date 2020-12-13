public class PruebasEXP {
    public static void f(int n) {
        //int[] a = new int[40000000];	//Prueba Constante
        int[] a = new int[n];            //Prueba Variable
        int suma2 = 0;
        int suma = 0;

        //////////////////////////////////////////////////////////POTENCIAS DE N

        for (int i = 0; i < a.length - 1; i++) {            //Prueba N
            a[i] = 1;
		 
			/*for (int j=i+1;j<a.length;j++) {		//Prueba N2
				suma = suma +a[j];
				
				for (int k=i+1;k<a.length;k++) {	//Prueba N3
					suma2 = suma2 +a[k];
					/*for(int q=0; q<a.length-1; q++) {
						a[q]=2;
					}
				}
			}*/
        }
    }
}

