package ListaEnlazada;

import java.util.Scanner;

public class TestLista {
    public static void main(String [] args) {
        Lista l = new Lista();
        Scanner sc = new Scanner(System.in);
        int num, data;
        System.out.println("Ingrese la cantidad de datos a obtener");
        num=10;

        l.InsertaFinal(5);
        l.InsertaInicio(16);
        l.InsertaFinal(29);
        l.InsertaInicio(36);
        l.InsertaFinal(49);
        l.InsertaInicio(100);
        l.InsertaFinal(1);
        l.InsertaInicio(78);
        l.InsertaFinal(61);
        l.InsertaInicio(23);
        System.out.println("La lista posee los siguientes datos:");
        l.Print();
        int prom = l.Promedio();
        System.out.println("\nPromedio de la lista es:" + prom);
        Lista x = l.GetMayoresProm(prom);
        System.out.println("Los datos mayores al promedio son:");
        x.Print();

    }
}
