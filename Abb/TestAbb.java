package Abb;

public class TestAbb {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Abb a = new Abb();
        a.Insertar(10);
        a.Insertar(8);
        a.Insertar(12);
        a.Insertar(4);
        a.Insertar(-8);

        boolean x = a.Complemento();

        a.Imprimir();

        System.out.println(" EL complemento es : " + x);	// True

        a.Eliminar(-8);
        x = a.Complemento();

        System.out.println(" EL complemento es : " + x);	// False

    }
}
