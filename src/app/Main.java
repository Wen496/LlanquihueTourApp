package app;

import java.util.ArrayList;
import model.Colaborador;
import service.GestorColaboradores;

public class Main {

    public static void main(String[] args) {

        // Ruta del archivo CSV (carpeta resources en la raíz del proyecto)
        String rutaArchivo = "resources/colaboradores.csv";

        // Creamos el gestor que lee y administra los colaboradores
        GestorColaboradores gestor = new GestorColaboradores();

        // 1. Cargamos los colaboradores desde el archivo
        ArrayList<Colaborador> colaboradores = gestor.cargarColaboradores(rutaArchivo);

        // 2. Mostramos todos los colaboradores cargados
        System.out.println("=== LISTADO COMPLETO DE COLABORADORES ===");
        for (Colaborador c : colaboradores) {
            System.out.println(c);
        }

        // 3. Filtramos por un rol especifico y mostramos el resultado
        System.out.println("\n=== COLABORADORES CON ROL: GUIA ===");
        ArrayList<Colaborador> guias = gestor.buscarPorRol(colaboradores, "guia");
        for (Colaborador c : guias) {
            System.out.println(c);
        }
    }
}