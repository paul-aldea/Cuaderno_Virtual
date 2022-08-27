public class arbolAvl {


    NodoAVL root;

    public void clearAll() {
        root = null;
    }

    public void insertar(int key) {
        root = insertarAVL(root, key);
    }

    private NodoAVL insertarAVL(NodoAVL nodoActual, int key) {
        if (nodoActual == null) {
            return (new NodoAVL(key));
        }

        if (key < nodoActual.key) {
            nodoActual.left = insertarAVL(nodoActual.left, key);
        }else if (key > nodoActual.key) {
            nodoActual.right = insertarAVL(nodoActual.right, key);
        }else {
            return nodoActual;
        }

        nodoActual.altura = 1 +
                max(getAltura(nodoActual.left), getAltura(nodoActual.right));

        int fe = getFactorEquilibrio(nodoActual);

        if (fe > 1 && key < nodoActual.left.key) {
            return rightRotate(nodoActual);
        }


        if (fe < -1 && key > nodoActual.right.key) {
            return leftRotate(nodoActual);
        }

        if (fe > 1 && key > nodoActual.left.key) {
            nodoActual.left = leftRotate(nodoActual.left);
            return rightRotate(nodoActual);
        }

        if (fe < -1 && key < nodoActual.right.key) {
            nodoActual.right = rightRotate(nodoActual.right);
            return leftRotate(nodoActual);
        }

        return nodoActual;
    }


    public void buscar(int elemento) {
        if(BuscaEnAVL(root, elemento)) {
            System.out.println("Existe");
        }else {
            System.out.println("No Existe");
        }
    }

    private boolean BuscaEnAVL(NodoAVL nodoActual, int elemento) {
        if (nodoActual == null) {
            return false;
        } else if (elemento == nodoActual.key) {
            return true;
        } else if (elemento < nodoActual.key) {
            return BuscaEnAVL(nodoActual.left, elemento);
        } else {
            return BuscaEnAVL(nodoActual.right, elemento);
        }
    }

    public void eliminar(int key) {
        root = eliminarAVL(root, key);
    }

    private NodoAVL eliminarAVL(NodoAVL nodoActual, int key) {
        if (nodoActual == null)
            return nodoActual;

        if (key < nodoActual.key){
            nodoActual.left = eliminarAVL(nodoActual.left, key);
        }else if (key > nodoActual.key){
            nodoActual.right = eliminarAVL(nodoActual.right, key);
        }else {

            if ((nodoActual.left == null) || (nodoActual.right == null)) {
                NodoAVL temp = null;
                if (temp == nodoActual.left) {
                    temp = nodoActual.right;
                }else {
                    temp = nodoActual.left;
                }


                if (temp == null) {
                    nodoActual = null;
                }else{

                    nodoActual = temp;
                }
            }else {
                NodoAVL temp = getNodoConValorMaximo(nodoActual.left);

                nodoActual.key = temp.key;

                nodoActual.left = eliminarAVL(nodoActual.left, temp.key);
            }
        }

        if (nodoActual == null)
            return nodoActual;

        nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;

        int fe = getFactorEquilibrio(nodoActual);


        */
        if (fe > 1 && getFactorEquilibrio(nodoActual.left) >= 0) {
            return rightRotate(nodoActual);
        }


        if (fe < -1 && getFactorEquilibrio(nodoActual.right) <= 0) {
            return leftRotate(nodoActual);
        }


        if (fe > 1 && getFactorEquilibrio(nodoActual.left) < 0) {
            nodoActual.left = leftRotate(nodoActual.left);
            return rightRotate(nodoActual);
        }


        if (fe < -1 && getFactorEquilibrio(nodoActual.right) > 0) {
            nodoActual.right = rightRotate(nodoActual.right);
            return leftRotate(nodoActual);
        }

        return nodoActual;
    }

    private NodoAVL rightRotate(NodoAVL nodoActual) {
        NodoAVL nuevaRaiz = nodoActual.left;
        NodoAVL temp = nuevaRaiz.right;

        nuevaRaiz.right = nodoActual;
        nodoActual.left = temp;

        nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
        nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;

        return nuevaRaiz;
    }

    private NodoAVL leftRotate(NodoAVL nodoActual) {
        NodoAVL nuevaRaiz = nodoActual.right;
        NodoAVL temp = nuevaRaiz.left;

        nuevaRaiz.left = nodoActual;
        nodoActual.right = temp;

        nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
        nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;

        return nuevaRaiz;
    }


    public void mostrarArbolAVL() {
        System.out.println("Arbol AVL");
        showTree(root, 0);
    }

    private void showTree(NodoAVL nodo, int depth) {
        if (nodo.right != null) {
            showTree(nodo.right, depth + 1);
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println("(" + nodo.key + ")");

        if (nodo.left != null) {
            showTree(nodo.left, depth + 1);
        }
    }

    private int getAltura(NodoAVL nodoActual) {
        if (nodoActual == null) {
            return 0;
        }

        return nodoActual.altura;
    }

    private int getFactorEquilibrio(NodoAVL nodoActual) {
        if (nodoActual == null) {
            return 0;
        }

        return getAltura(nodoActual.left) - getAltura(nodoActual.right);
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    private NodoAVL getNodoConValorMaximo(NodoAVL node) {
        NodoAVL current = node;

        while (current.right != null){
            current = current.right;
        }

        return current;
    }
}
