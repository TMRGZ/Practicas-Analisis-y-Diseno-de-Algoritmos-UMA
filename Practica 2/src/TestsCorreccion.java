/**
 * @author Pepe Gallardo
 * @modifiedby Jose A. Onieva
 * La implementaci�n del alumno debe pasar este test experimental
 */

public class TestsCorreccion {

    // Comprueba experimentalmente el m�todo resolverTodos
    public static void testResolverTodos() {
        EvaluacionExperimental eval = new EvaluacionExperimental("Test de resolverTodos");
        eval.realizarCon("tests.txt");
    }


    public static void main(String[] args) {
        testResolverTodos();
    }

}
