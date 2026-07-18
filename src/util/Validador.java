package util;

/**
 * Clase utilitaria con métodos estáticos de validación de datos
 * para las entidades del sistema LlanquihueTourApp.
 *
 * @author Macarena Álvarez Sáez
 */
public class Validador {

    /**
     * Valida que un texto no sea nulo ni esté vacío.
     * Si está vacío, lo maneja con try-catch y devuelve un valor por defecto.
     *
     * @param valor texto a validar
     * @param campo nombre del campo, usado en el mensaje de error
     * @return el texto sin espacios sobrantes, o "SIN DATO" si es inválido
     */
    public static String validarTexto(String valor, String campo) {
        try {
            if (valor == null || valor.trim().isEmpty()) {
                throw new IllegalArgumentException("El campo " + campo + " esta vacio");
            }
            return valor.trim();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
            return "SIN DATO";
        }
    }

    /**
     * Valida que el rol sea uno de los permitidos: guia, operador o proveedor.
     *
     * @param rol rol a validar
     * @return el rol normalizado en minúsculas, o "desconocido" si es inválido
     */
    public static String validarRol(String rol) {
        try {
            if (rol == null || rol.trim().isEmpty()) {
                throw new IllegalArgumentException("El rol esta vacio");
            }
            String rolLimpio = rol.trim().toLowerCase();
            if (!rolLimpio.equals("guia")
                    && !rolLimpio.equals("operador")
                    && !rolLimpio.equals("proveedor")) {
                throw new IllegalArgumentException("Rol no valido: " + rol);
            }
            return rolLimpio;
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
            return "desconocido";
        }
    }

    /**
     * Valida el formato y dígito verificador de un RUT chileno.
     *
     * @param rut RUT en formato 12345678-9 o 12.345.678-9
     * @return el RUT normalizado sin puntos, en mayúsculas
     * @throws ValidacionException si el RUT es nulo, vacío, tiene
     *         formato incorrecto o el dígito verificador no coincide
     */
    public static String validarRut(String rut) throws ValidacionException {
        if (rut == null || rut.trim().isEmpty()) {
            throw new ValidacionException("El RUT esta vacio");
        }

        String limpio = rut.trim().replace(".", "").toUpperCase();

        if (!limpio.matches("\\d{7,8}-[\\dK]")) {
            throw new ValidacionException("Formato de RUT invalido: " + rut);
        }

        String cuerpo = limpio.substring(0, limpio.indexOf('-'));
        char dvIngresado = limpio.charAt(limpio.length() - 1);

        int suma = 0;
        int multiplicador = 2;
        for (int i = cuerpo.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(cuerpo.charAt(i)) * multiplicador;
            multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
        }

        int resto = 11 - (suma % 11);
        char dvCalculado;
        if (resto == 11) {
            dvCalculado = '0';
        } else if (resto == 10) {
            dvCalculado = 'K';
        } else {
            dvCalculado = (char) (resto + '0');
        }

        if (dvIngresado != dvCalculado) {
            throw new ValidacionException("Digito verificador incorrecto en RUT: " + rut);
        }

        return limpio;
    }
}