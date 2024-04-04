import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) 
            {
                try (Scanner scanner = new Scanner(System.in)) 
                    {
                        System.out.println("\n\n\n\n\nIngrese la expresión en notación prefija (con espacios entre cada caracter): ");
                        String expresion = scanner.nextLine();
                        ArbolExpr arbol = new ArbolExpr();
            
                        System.out.println("\n\nExpresión en notación prefijo: " + expresion);
                        arbol.construye(new StringTokenizer(expresion));
            
                        System.out.println("\nExpresión en notación infija: ");
                        arbol.expresion();

                        System.out.println("\n\nExpresión en notación posfija: ");
                        arbol.postOrden();
            
                        System.out.println("\nEvaluación de la expresión: " + arbol.evaluar());
            
                        System.out.println("\nEstructura del árbol de expresión:");
                        arbol.muestraEstructura();
                    }
            }
    
}
