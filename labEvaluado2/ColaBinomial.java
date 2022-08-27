
    //==============================
//Cola Binomial
    // Integrantes; RIchard Ortiz, Paul Aldea
        //respuesta: Para que la implementacion pase de Min heap a Max heap se tiene que alterar el metodo insert
//==============================
    class ColaBinomial {
        NodoCB head; // Puntero al primer árbol binomial de la cola
        ColaBinomial(){head=null;} // Constructor



        //==================================================
        //Inserción de un elemento en la cola binomial
        //==================================================
        void Insert(int a) {
            ColaBinomial H1 = new ColaBinomial();
            H1.head = new NodoCB(null, null, null, a, (short)0);
            head = BinomialHeapUnion(H1);
        }

        //============ Imprime cola binomial ===================================
        //La salida de la impresión es código fuente Latex la cual
        //se puede rediccionar a un archivo. Por ejemplo, java lp > micola.tex.
        //Luego el archivo micola.tex se compila con latex micola.tex.
        //=======================================================================
        void Print(){
            System.out.println("\\documentclass[10pt]{article}");
            System.out.println("\\usepackage{graphicx}");
            System.out.println("\\usepackage{pstricks,pst-node,pst-tree}");
            System.out.println("\\title{Cola Binomial}");
            System.out.println("\\begin{document}");
            System.out.println("\\maketitle");
            for(NodoCB l = head; l!=null; l = l.sibling) l.Print();
            System.out.println("\\end{document}");
            System.out.println("EL VALOR MAYOR ES:"+max());
        }

        //====================================================
        // Método privados
        //====================================================

        //====================================================
        //Unión (fusión de dos colas binomiales)
        //====================================================
        private NodoCB BinomialHeapUnion(ColaBinomial H2){
            ColaBinomial H = BinomialHeapMerge(this, H2);
            if(H.head==null) return H.head;
            NodoCB prevx= null;
            NodoCB x = H.head;
            NodoCB nextx=x.sibling;
            while(nextx!=null) {
                if ((x.degree != nextx.degree) ||  (nextx.sibling !=null && nextx.sibling.degree == x.degree)){
                    prevx = x;
                    x = nextx;
                }
                else if(x.key <= nextx.key) {
                    x.sibling= nextx.sibling;
                    nextx.BinomialLink(x);
                }
                else {
                    if(prevx==null) H.head=nextx;
                    else  prevx.sibling= nextx;
                    x.BinomialLink(nextx);
                    x = nextx;
                }
                nextx = x.sibling;
            }
            return H.head;
        }

        //===========================================================
        // Mezcla de dos colas Binomiales. A partir de dos colas
        // se obtine una tercera que contiene los árboles binomiales
        // de las dos colas ordenados por k
        //===========================================================
        private  ColaBinomial BinomialHeapMerge(ColaBinomial H1, ColaBinomial H2) {
            NodoCB h1 = H1.head;
            NodoCB h2 = H2.head;//crea las variables ndod


            if (h1==null) return H2;
            if (h2==null) return H1;// si alguno esta vacio retorna el otro


            ColaBinomial H = new ColaBinomial();
            NodoCB ini = null;
            NodoCB fin= null;
            while(h1!=null && h2!=null) {
                if(h1.degree <= h2.degree) {
                    if(ini == null) {ini = fin= h1;}
                    else {fin.sibling = h1; fin = h1;}
                    h1 = h1.sibling;
                }
                else  {
                    if(ini == null) {ini = fin= h2;}
                    else {fin.sibling = h2; fin = h2;}
                    h2 = h2.sibling;
                }
            }
            if(h1==null) fin.sibling = h2;
            if(h2==null) fin.sibling = h1;
            H.head=ini;
            return  H;
        }
        public int max(){
            int contador = 0;
            NodoCB  buscar= head;

            if(buscar == null){
                return 0;
            }else{
                while(buscar.p != null){

                    if (buscar.key > contador) {
                        contador = buscar.key;
                    } else {
                        buscar = buscar.sibling;
                    }

                }

            }

            return contador;
        }

    }


