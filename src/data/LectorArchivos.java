package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.ColaboradorExterno;
import model.ExcursionCultural;
import model.GuiaTuristico;
import model.PaseoLacustre;
import model.Persona;
import model.RutaGastronomica;
import model.ServicioTuristico;
import util.ValidacionException;
import util.Validador;

/**
 * Clase utilitaria encargada de leer los archivos de texto plano
 * ubicados en la carpeta datos/ y convertir cada linea en objetos
 * del dominio de LlanquihueTourApp.
 *
 * Los archivos usan el punto y coma (;) como separador de campos.
 * Las lineas vacias o que comienzan con # se ignoran.
 *
 * @author Macarena Alvarez Saez
 */
public class LectorArchivos {

    /** Separador de campos usado en los archivos .txt */
    private static final String SEPARADOR = ";";

    /** Carpeta donde se ubican los archivos de datos */
    private static final String CARPETA = "datos/";

    /**
     * Lee el archivo de colaboradores y construye la lista de personas.
     *
     * @param nombreArchivo nombre del archivo dentro de la carpeta datos
     * @return lista de personas cargadas correctamente
     */
    public static List<Persona> cargarColaboradores(String nombreArchivo) {
        List<Persona> personas = new ArrayList<>();
        String ruta = CARPETA + nombreArchivo;

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty() || linea.trim().startsWith("#")) {
                    continue;
                }

                try {
                    personas.add(construirPersona(linea));
                } catch (ValidacionException e) {
                    System.out.println("Linea " + numeroLinea + " descartada: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo " + ruta + ": " + e.getMessage());
        }

        return personas;
    }

    /**
     * Construye una Persona a partir de una linea del archivo.
     *
     * @param linea texto con los campos separados por punto y coma
     * @return el guia o colaborador externo correspondiente
     * @throws ValidacionException si la linea esta incompleta, el RUT
     *         es invalido o el rol no es reconocido
     */
    private static Persona construirPersona(String linea) throws ValidacionException {
        String[] campos = linea.split(SEPARADOR);

        if (campos.length != 6) {
            throw new ValidacionException("Se esperaban 6 campos y llegaron " + campos.length);
        }

        String rol = campos[0].trim().toLowerCase();
        String nombre = Validador.validarTexto(campos[1], "nombre");
        String rut = Validador.validarRut(campos[2]);
        String telefono = Validador.validarTexto(campos[3], "telefono");
        String campo1 = Validador.validarTexto(campos[4], "campo1");
        String campo2 = Validador.validarTexto(campos[5], "campo2");

        if (rol.equals("guia")) {
            int anios = convertirEntero(campo2, "aniosExperiencia");
            return new GuiaTuristico(nombre, rut, telefono, campo1, anios);
        } else if (rol.equals("externo")) {
            return new ColaboradorExterno(nombre, rut, telefono, campo1, campo2);
        } else {
            throw new ValidacionException("Rol no reconocido: " + rol);
        }
    }

    /**
     * Lee el archivo de servicios y construye la lista correspondiente.
     *
     * @param nombreArchivo nombre del archivo dentro de la carpeta datos
     * @return lista de servicios turisticos cargados correctamente
     */
    public static List<ServicioTuristico> cargarServicios(String nombreArchivo) {
        List<ServicioTuristico> servicios = new ArrayList<>();
        String ruta = CARPETA + nombreArchivo;

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty() || linea.trim().startsWith("#")) {
                    continue;
                }

                try {
                    servicios.add(construirServicio(linea));
                } catch (ValidacionException e) {
                    System.out.println("Linea " + numeroLinea + " descartada: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo " + ruta + ": " + e.getMessage());
        }

        return servicios;
    }

    /**
     * Construye un ServicioTuristico a partir de una linea del archivo.
     *
     * @param linea texto con los campos separados por punto y coma
     * @return la subclase de servicio segun el tipo indicado
     * @throws ValidacionException si la linea esta incompleta, la duracion
     *         no es numerica o el tipo no es reconocido
     */
    private static ServicioTuristico construirServicio(String linea) throws ValidacionException {
        String[] campos = linea.split(SEPARADOR);

        if (campos.length != 4) {
            throw new ValidacionException("Se esperaban 4 campos y llegaron " + campos.length);
        }

        String tipo = campos[0].trim().toLowerCase();
        String nombre = Validador.validarTexto(campos[1], "nombre");
        int duracion = convertirEntero(campos[2], "duracionHoras");
        String especifico = Validador.validarTexto(campos[3], "atributoEspecifico");

        switch (tipo) {
            case "gastronomica":
                int paradas = convertirEntero(especifico, "numeroDeParadas");
                return new RutaGastronomica(nombre, duracion, paradas);
            case "lacustre":
                return new PaseoLacustre(nombre, duracion, especifico);
            case "cultural":
                return new ExcursionCultural(nombre, duracion, especifico);
            default:
                throw new ValidacionException("Tipo de servicio no reconocido: " + tipo);
        }
    }

    /**
     * Convierte un texto a numero entero informando el campo afectado.
     *
     * @param valor texto a convertir
     * @param campo nombre del campo, usado en el mensaje de error
     * @return el valor numerico
     * @throws ValidacionException si el texto no representa un entero
     */
    private static int convertirEntero(String valor, String campo) throws ValidacionException {
        try {
            return Integer.parseInt(valor.trim());
        } catch (NumberFormatException e) {
            throw new ValidacionException("El campo " + campo + " no es numerico: " + valor, e);
        }
    }
}
