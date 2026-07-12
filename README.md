# LlanquihueTourApp

Aplicación Java de escritorio para la agencia de turismo ficticia **Llanquihue Tour**, ambientada en la región de Los Lagos (Chile). El sistema permite gestionar los servicios turísticos y otras entidades de la agencia (guías, vehículos y colaboradores externos), aplicando conceptos de programación orientada a objetos.

Este proyecto se desarrolla de forma incremental como parte del ramo **Desarrollo Orientado a Objetos I (PRY2202)**.

## Descripción del sistema (Semana 8)

En esta etapa el sistema incorpora:

- Una **interfaz de comportamiento común** (`Registrable`) que obliga a todas las entidades gestionables a entregar un resumen de su información.
- **Herencia y polimorfismo** entre distintas entidades de la empresa, con una clase base común (`Persona`) para guías y colaboradores.
- Una **colección genérica** (`ArrayList<Registrable>`) que almacena entidades de distinto tipo y las diferencia en tiempo de ejecución mediante `instanceof`.
- Una **interfaz gráfica básica** (con `JOptionPane`) que permite ingresar nuevas entidades y visualizar un resumen de las registradas.

## Clases e interfaces principales

### Paquete `model`
- `Registrable` (interfaz): define los métodos `mostrarResumen()` y `obtenerResumen()`.
- `Persona` (clase base abstracta): agrupa datos comunes (nombre, RUT, teléfono).
- `GuiaTuristico`: hereda de `Persona` e implementa `Registrable`.
- `ColaboradorExterno`: hereda de `Persona` e implementa `Registrable`.
- `Vehiculo`: implementa `Registrable` directamente.
- `ServicioTuristico` y sus subclases (`ExcursionCultural`, `PaseoLacustre`, `RutaGastronomica`): jerarquía de servicios turísticos de semanas anteriores.
- Clases de apoyo: `Colaborador`, `Direccion`.

### Paquete `data`
- `GestorEntidades`: gestiona la colección `ArrayList<Registrable>` y diferencia los tipos con `instanceof`.
- `GestorServicios`: gestiona los servicios turísticos.

### Paquete `service`
- `GestorColaboradores`: carga colaboradores desde un archivo CSV.

### Paquete `ui`
- `Main`: clase principal que ejecuta el programa.
- `VentanaPrincipal`: interfaz gráfica basada en `JOptionPane` para ingresar y mostrar entidades.

### Paquete `util`
- `Validador`: utilidades de validación de datos.

## Cómo ejecutar el programa

1. Clonar o descargar este repositorio.
2. Abrir el proyecto en **Apache NetBeans**.
3. Ejecutar la clase principal **`ui.Main`** (clic derecho sobre el archivo → *Run File*, o presionar F6 y seleccionar `ui.Main`).
4. Al ejecutar, primero se muestran por consola los servicios turísticos y luego se abre la interfaz gráfica.
5. En el menú gráfico se puede:
   - Agregar un guía turístico.
   - Agregar un vehículo.
   - Agregar un colaborador externo.
   - Mostrar todas las entidades registradas.
   - Salir.

## Tecnologías

- **Lenguaje:** Java (OpenJDK)
- **IDE:** Apache NetBeans
- **Interfaz gráfica:** Swing (`JOptionPane`)
