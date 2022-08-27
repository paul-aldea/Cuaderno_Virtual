package Abb;

import java.util.LinkedList;

public class Abb {

    class NodoAbb {
        int elemento;
        NodoAbb lchild;
        NodoAbb rchild;

        NodoAbb(int elemento, NodoAbb lchild, NodoAbb rchild) {
            this.elemento = elemento;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        void Print() {
            System.out.println(elemento);
        }
    }

    private NodoAbb laRaiz;

    public Abb() {
        laRaiz = null;
    }

    /* Verifica si existen dos enteros a, b en el ABB tal que a+b =0.
     */
    public boolean Complemento() {
        LinkedList<Integer> datos = ListaRevi(this.laRaiz);
        for(int k = 0; k< datos.size(); k++){

            if(Buscar(laRaiz, datos.get(k)*-1)){
                return true;
            }
        }
        return false;
    }

    private LinkedList<Integer> ListaRevi(NodoAbb x){
        //Comprueba si la lista esta vacia
        if(x==null) {
            return null;
        }
        //Almacena los datos de la lista, buscando de la izquierda del arbol a su derecha.
        LinkedList<Integer> almaIzqui = new LinkedList<>();
        almaIzqui.add(x.elemento);

        if(x.rchild!=null){
            LinkedList<Integer> right = ListaRevi(x.rchild);
            for(int k = 0; k< right.size(); k++){
                almaIzqui.add(right.get(k));
            }
        }
        if(x.lchild!=null) {
            LinkedList<Integer> left = ListaRevi(x.lchild);
            for (int k = 0; k < left.size(); k++) {
                almaIzqui.add(left.get(k));
            }
        }
        return almaIzqui;

    }

    public boolean Buscar(NodoAbb root, int val){
        if(root==null){
            return false;
        }else if(val == root.elemento){
            return true;
        }
        if(val< root.elemento){
            return Buscar(root.lchild,val);
        }else{
            return Buscar(root.rchild,val);
        }
    }


    //--- Supone que no existe un nodo con valor = elemento----//
    public void Insertar(int elemento) {
        laRaiz = InsertaenAbb(laRaiz, elemento);
    }

    private NodoAbb InsertaenAbb(NodoAbb nodo, int elemento) {
        if (nodo == null)
            return new NodoAbb(elemento, null, null);
        else if (elemento < nodo.elemento)
            nodo.lchild = InsertaenAbb(nodo.lchild, elemento);
        else
            nodo.rchild = InsertaenAbb(nodo.rchild, elemento);
        return nodo;
    }

    // -- Supone que el elemento esta en el arbol----//
    public void Eliminar(int elemento) {
        laRaiz = EliminaenAbb(laRaiz, elemento);
    }

    private NodoAbb EliminaenAbb(NodoAbb nodo, int elemento) {
        if (nodo.elemento == elemento) {
            if (nodo.lchild == null && nodo.rchild == null)
                return null;
            else if (nodo.lchild == null)
                return nodo.rchild;
            else if (nodo.rchild == null)
                return nodo.lchild;
            else {
                nodo.elemento = MayorElemento(nodo.lchild);
                nodo.lchild = EliminaenAbb(nodo.lchild, nodo.elemento);
            }
        } else if (nodo.elemento > elemento)
            nodo.lchild = EliminaenAbb(nodo.lchild, elemento);
        else
            nodo.rchild = EliminaenAbb(nodo.rchild, elemento);
        return nodo;
    }

    private int MayorElemento(NodoAbb nodo) {
        if (nodo.rchild == null)
            return nodo.elemento;
        else
            return MayorElemento(nodo.rchild);
    }

    public void Imprimir() {
        ImprimeAbb(laRaiz, " ");
    }

    private void ImprimeAbb(NodoAbb n, String tab) {
        if (n != null) {
            System.out.println(tab + n.elemento);
            ImprimeAbb(n.lchild, tab + "  ");
            ImprimeAbb(n.rchild, tab + "  ");
        }
    }
}

