package Vista;

import Controlador.Controlador;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Controlador ctrl = new Controlador();
        List<String> data = ctrl.generarDatos(100_000);

        long[][] tiempos = new long[3][2];

        for (int i = 0; i < 3; i++) {
            // Prueba con ArrayList
            List<String> arrayList = new ArrayList<>();
            tiempos[i][0] = ctrl.medirTiempo(data, arrayList);
            Set<String> repetidosArray = ctrl.procesarLista(data, arrayList);
            System.out.println("Repetición " + (i + 1) + " - ArrayList: " + repetidosArray.size() + " repetidos");

            // Prueba con LinkedList
            List<String> linkedList = new LinkedList<>();
            tiempos[i][1] = ctrl.medirTiempo(data, linkedList);
            Set<String> repetidosLinked = ctrl.procesarLista(data, linkedList);
            System.out.println("Repetición " + (i + 1) + " - LinkedList: " + repetidosLinked.size() + " repetidos");
        }

        // Mostrar tabla de resultados
        System.out.println("\nComparación de tiempos (milisegundos):");
        System.out.println("Repetición\tArrayList\tLinkedList");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "\t\t" + tiempos[i][0] + "\t\t" + tiempos[i][1]);
        }
    }
}