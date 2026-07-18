package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Colaborador;
import model.Direccion;
import util.Validador;

/**
 * Servicio encargado de cargar colaboradores desde un archivo de texto
 * y de realizar búsquedas sobre la colección resultante.
 *
 * @author Macarena Alvarez Saez
 * @version 1.0
 */
public class GestorColaboradores {

    /**
     * Lee un archivo separado por punto y coma y construye la lista de
     * colaboradores. Cada línea debe tener el formato:
     * nombre;rut;rol;comuna;calle. Los campos se validan antes de crear
     * cada objeto, y la dirección se arma por composición.
     *
     * @param rutaArchivo ruta del archivo a leer
     * @return lista de colaboradores cargados; vacía si el archivo no se
     *         puede leer
     */
    public ArrayList<Colaborador> cargarColaboradores(String rutaArchivo) {

        // 1. Creamos la lista vacía
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        // 2. try-with-resources: abre el archivo y lo cierra solo
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            // 3. Leemos línea por línea hasta que no queden más
            while ((linea = lector.readLine()) != null) {

                // 4. Separamos la línea por punto y coma
                String[] datos = linea.split(";");

                // 5. Validamos y asignamos cada campo
                String nombre = Validador.validarTexto(datos[0], "nombre");
                String rut = Validador.validarTexto(datos[1], "rut");
                String rol = Validador.validarRol(datos[2]);
                String comuna = Validador.validarTexto(datos[3], "comuna");
                String calle = Validador.validarTexto(datos[4], "calle");

                // 6. Creamos la Direccion (composición)
                Direccion direccion = new Direccion(comuna, calle);

                // 7. Creamos el Colaborador con su Direccion adentro
                Colaborador colaborador = new Colaborador(nombre, rut, rol, direccion);

                // 8. Lo agregamos a la lista
                colaboradores.add(colaborador);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // 9. Devolvemos la lista llena
        return colaboradores;
    }

    /**
     * Filtra una lista de colaboradores dejando solo los que tengan el rol
     * indicado. La comparación no distingue mayúsculas de minúsculas.
     *
     * @param lista      colección de colaboradores a filtrar
     * @param rolBuscado rol por el cual filtrar (por ejemplo "guia")
     * @return nueva lista con los colaboradores que coinciden con el rol
     */
    public ArrayList<Colaborador> buscarPorRol(ArrayList<Colaborador> lista, String rolBuscado) {
        ArrayList<Colaborador> resultado = new ArrayList<>();
        for (Colaborador c : lista) {
            if (c.getRol().equalsIgnoreCase(rolBuscado)) {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
