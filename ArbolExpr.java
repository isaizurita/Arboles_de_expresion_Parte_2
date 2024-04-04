import java.util.StringTokenizer;
public class ArbolExpr 
    {
        // Declaración del atributo raiz como un objeto de NodoArbol
        private NodoArbol raiz;

        // Método para construir el árbol de expresión a partir de una expresión en notación prefija
        public void construye(StringTokenizer expression) 
            {
                raiz = construyeSub(expression);
            }
        
        // Método para imprimir la expresión en notación prefija
        public void expresion() 
            {
                expresion(raiz);
            }

        // Método para evaluar la expresión contenida en el árbol
        public double evaluar() 
            {
                return evaluar(raiz);
            }
        
        // Método recursivo para evaluar la expresión contenida en el árbol
        private double evaluar(NodoArbol p) 
            {
                double resultado = 0;
            
                if (p != null) 
                {
                    if (Character.isDigit(p.getElemento())) 
                        {
                            resultado = Double.parseDouble(p.getElemento().toString());
                        } 
                    else 
                        {
                            switch (p.getElemento()) 
                                {
                                    case '+':
                                        resultado = evaluar(p.getIzq()) + evaluar(p.getDer());
                                        break;
                                    case '-':
                                        resultado = evaluar(p.getIzq()) - evaluar(p.getDer());
                                        break;
                                    case '*':
                                        resultado = evaluar(p.getIzq()) * evaluar(p.getDer());
                                        break;
                                    case '/':
                                        resultado = evaluar(p.getIzq()) / evaluar(p.getDer());
                                        break;
                                }
                        }
                }
            
                return resultado;
            }
        

        // Método para imprimir en terminal la estructura del árbol
        public void muestraEstructura() 
            {
                if (raiz == null) 
                    {
                        System.out.println("Árbol vacío");
                    } 
                else 
                    {
                        System.out.println();
                        muestraEstruct(raiz, 1);
                        System.out.println();
                    }
            }

        // Método recursivo para mostrar la estructura del árbol
        private void muestraEstruct(NodoArbol p, int nivel) 
            {
                int j;
                NodoArbol right;
                NodoArbol left;

                if (p != null) 
                    {
                        right = p.getDer();
                        left = p.getIzq();

                        muestraEstruct(right, nivel + 1);

                        for (j = 0; j < nivel; j++) 
                            {
                                System.out.print("\t");
                            }

                        System.out.print(" " + p.getElemento());

                        if ((left != null) && (right != null)) 
                            {
                                System.out.print(" < ");
                            } 
                        else if (right != null) 
                            {
                                System.out.print("/");
                            } 
                        else if (left != null) 
                            {
                                System.out.print("\\");
                            }
                        System.out.println();
                        
                        muestraEstruct(left, nivel + 1);
                    }
            }

        // Método recursivo para construir el árbol de expresión
        private NodoArbol construyeSub(StringTokenizer expresion) 
            {
                if (expresion.hasMoreTokens()) 
                    {
                        String token = expresion.nextToken();
                
                        NodoArbol temp = new NodoArbol(token.charAt(0), null, null);
                
                        if (!Character.isDigit(token.charAt(0))) 
                            {
                                temp.setIzq(construyeSub(expresion));
                                temp.setDer(construyeSub(expresion));
                            }
                        return temp;
                    }
                return null;
            }
        
        // Método recursivo para imprimir la expresión en notación infija
        private void expresion(NodoArbol p) 
            {
                if (p != null) 
                    {
                        if (!Character.isDigit(p.getElemento())) 
                            {
                                System.out.print("(");
                                expresion(p.getIzq());
                                System.out.print(" " + p.getElemento() + " ");
                                expresion(p.getDer());
                                System.out.print(")");
                            } 
                        else 
                            {
                                System.out.print(p.getElemento());
                            }
                    }
            }

        // Método para imprimir la expresión en notación posfija
        public void postOrden() 
            {
                postOrden(raiz);
                System.out.println();
            }

        // Método recursivo para imprimir la expresión en notación posfija
        private void postOrden(NodoArbol p) 
            {
                if (p != null) 
                    {
                        postOrden(p.getIzq());
                        postOrden(p.getDer());
                        System.out.print(p.getElemento() + " ");
                    }
            }
        
    }
