package ListaEnlazada;

public class Lista {
    private Nodo laCabeza;
    Lista() {
        laCabeza = null;
    }

    //---Inserta un objeto(int) al comienzo de la lista

    public void InsertaInicio(int o) {
        if (EstaVacia()) {
            laCabeza = new Nodo(o, null);
        } else {
            laCabeza = new Nodo(o, laCabeza);
        }
    }

    //---- Inserta al final ----
    public void InsertaFinal(int o) {
        if (EstaVacia()) {
            laCabeza = new Nodo(o, null);
        }else{
            Nodo t;
            for(t = laCabeza; t.next != null; t= t.next) ;;
            t.next = new Nodo(o,null);
        }
    }
    //El metodo inserta un dato a la lista de manera ordenada de menor a mayor
    public void InsertaOrden(int o){
        if(EstaVacia()){
            laCabeza = new Nodo(o, null);
        }else if(laCabeza.elObjeto > o){
            //En el caso de que el dato sea menor, este se inserta
            //Al inicio de la lista
            InsertaInicio(o);
        }else{
            //En el caso contrario busca en la lista su posicion ordenada
            Nodo x = laCabeza;
            Nodo u = new Nodo(o,null);
            while(x.next!=null){
                if(x.next.elObjeto>u.elObjeto){
                    u.next=x.next;
                    x.next=u;
                    return;
                }
                x=x.next;
            }
            //Si el dato o es el mayor de todos, agrega su nodo al final de la lista
            if(x.next==null){
                x.next=u;
            }
        }
    }

    // ---cuenta la cantidad de nodos de la lista (Size)
    public int Size() {
        int tnodos=0;
        for(Nodo t = laCabeza; t !=null; t= t.next) {
            tnodos++;
        }
        return tnodos;
    }
    //Calcula el promedio de la lista
    public int Promedio(){
        Nodo x = laCabeza;
        int cant = 0, tamaño = Size();
        while(x!=null){
            cant+=x.elObjeto;
            x=x.next;
        }
        if(tamaño==0){
            return 0;
        }else{
            return cant/tamaño;
        }
    }
    //eliminar un nodo de la lista

    public void Eliminar(int o) {
        if(!EstaVacia()) {
            if(laCabeza.elObjeto==o){
                laCabeza = laCabeza.next;
            }else {
                Nodo p = laCabeza;
                Nodo t = laCabeza.next;
                while (t !=null && t.elObjeto != o)  {
                    p = t ; t = t.next;
                }
                if(t.elObjeto==o){
                    p.next = t.next;
                }
            }
        }
    }
    // Verifica si la lista está vacias;
    public boolean EstaVacia() {

        return laCabeza == null;
    }
    //Crea una lista en busca de los datos mayores al promedio
    public Lista GetMayoresProm(int promedio){
        Lista prom = new Lista();//Lista para los nodos mayores al promedio
        Nodo x = laCabeza;
        //Analizara la lista y si el dato es mayor al promedio, lo agregara a la nueva lista
        while(x!=null){
            if(x.elObjeto>promedio){
                prom.InsertaOrden(x.elObjeto);
            }
            x=x.next;
        }
        return prom;
    }
    //-----Clase Nodo---------
    private class Nodo {
        public int elObjeto;
        public Nodo next;
        public Nodo(int nuevoObjeto, Nodo next){
            this.elObjeto=nuevoObjeto; this.next = next;}
        void Print(){
            System.out.print("-" + elObjeto + "-");}
    }
    //-----Imprime la lista-----
    void Print() {
        if(laCabeza!=null) {

            Imprimir(laCabeza);
        }else{
            System.out.println("Lista Vacia");
        }
    }

    void Imprimir(Nodo m ) {
        if(m !=null) {
            m.Print(); Imprimir(m.next);
        }
    }
}
