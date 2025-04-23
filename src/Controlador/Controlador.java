package Controlador;

import java.util.*;

public class Controlador {

    public List<String> generarDatos(int size) {
        List<String> data = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data.add("item" + random.nextInt(size / 2)); // con repetidos
        }
        return data;
    }

    public Set<String> procesarLista(List<String> data, List<String> estructura) {
        Set<String> vistos = new HashSet<>();
        Set<String> repetidos = new HashSet<>();

        for (String item : data) {
            if (!vistos.add(item)) {
                repetidos.add(item);
            }
            estructura.add(item);
        }
        return repetidos;
    }

    public long medirTiempo(List<String> data, List<String> estructura) {
        long inicio = System.currentTimeMillis();
        procesarLista(data, estructura);
        long fin = System.currentTimeMillis();
        return fin - inicio;
    }
}