package util;

/**
 * Excepción personalizada para errores de validación de datos
 * en las entidades del sistema LlanquihueTourApp.
 *
 * @author Macarena Álvarez Sáez
 */
public class ValidacionException extends Exception {

    /**
     * Crea una excepción con un mensaje descriptivo del error.
     *
     * @param mensaje descripción del problema de validación
     */
    public ValidacionException(String mensaje) {
        super(mensaje);
    }

    /**
     * Crea una excepción con mensaje y causa original.
     *
     * @param mensaje descripción del problema de validación
     * @param causa excepción que originó este error
     */
    public ValidacionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}