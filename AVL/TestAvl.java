public class TestAvl {
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();


        System.out.println("ROTACION SIMPLE DERECHA - EJEMPLO 1");
        arbol.insertar(20);
        arbol.insertar(12);
        arbol.insertar(5);
        arbol.mostrarArbolAVL();

        System.out.println("\nROTACION SIMPLE DERECHA - EJEMPLO 2");
        arbol.clearAll();

        arbol.insertar(20);
        arbol.insertar(15);
        arbol.insertar(25);
        arbol.insertar(10);
        arbol.insertar(18);
        arbol.insertar(5);
        arbol.mostrarArbolAVL();


        System.out.println("\n***********************************************************************");

        System.out.println("\nROTACION SIMPLE IZQUIERDA - EJEMPLO 1");

        arbol.clearAll();
        arbol.insertar(5);
        arbol.insertar(12);
        arbol.insertar(20);
        arbol.mostrarArbolAVL();

        System.out.println("\nROTACION SIMPLE IZQUIERDA - EJEMPLO 2");

        arbol.clearAll();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(18);
        arbol.insertar(15);
        arbol.insertar(20);
        arbol.insertar(25);
        arbol.mostrarArbolAVL();


        System.out.println("\n***********************************************************************");


        System.out.println("\nROTACION DOBLE DERECHA-IZQUIERDA - EJEMPLO 1");

        arbol.clearAll();
        arbol.insertar(5);
        arbol.insertar(12);
        arbol.insertar(8);
        arbol.mostrarArbolAVL();

        System.out.println("\nROTACION DOBLE DERECHA-IZQUIERDA - EJEMPLO 2");


        arbol.clearAll();
        arbol.insertar(5);
        arbol.insertar(2);
        arbol.insertar(12);
        arbol.insertar(8);
        arbol.insertar(14);
        arbol.insertar(7);
        arbol.mostrarArbolAVL();

        System.out.println("\n****************************************");

        System.out.println("\nROTACION DOBLE IZQUIERDA-DERECHA - EJEMPLO 1");

        arbol.clearAll();
        arbol.insertar(12);
        arbol.insertar(5);
        arbol.insertar(8);
        arbol.mostrarArbolAVL();

        System.out.println("\nROTACION DOBLE IZQUIERDA-DERECHA - EJEMPLO 2");

        arbol.clearAll();
        arbol.insertar(15);
        arbol.insertar(4);
        arbol.insertar(20);
        arbol.insertar(2);
        arbol.insertar(8);
        arbol.insertar(10);
        arbol.mostrarArbolAVL();
    }
}
