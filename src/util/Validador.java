package util;

public class Validador {

    // Valida que un texto no sea nulo ni esté vacío.
    // Si está vacío, lo maneja con try-catch y devuelve un valor por defecto.
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

    // Valida que el rol sea uno de los permitidos: guia, operador o proveedor.
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
}