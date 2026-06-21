# LlanquihueTourApp

## Descripcion

Aplicacion de consola desarrollada en Java para la agencia de turismo Llanquihue Tour, ubicada en la Region de Los Lagos. El sistema gestiona la informacion de los colaboradores vinculados a la agencia: guias, operadores y proveedores.

El programa lee los datos de los colaboradores desde un archivo externo (colaboradores.csv), construye objetos a partir de esa informacion, los almacena en una lista dinamica del tipo ArrayList y permite recorrer el listado completo y filtrar los colaboradores segun su rol.

El proyecto esta organizado en paquetes funcionales y aplica buenas practicas de Programacion Orientada a Objetos: encapsulamiento, composicion entre clases y validacion de datos con bloques try-catch.

## Estructura del proyecto

El codigo fuente esta organizado en cuatro paquetes:

model: clases que representan las entidades del dominio.
- Direccion: representa la direccion de un colaborador (comuna y calle).
- Colaborador: representa a un colaborador (nombre, rut, rol) y contiene un objeto Direccion adentro (relacion tiene una).

util: clases de apoyo.
- Validador: valida los datos leidos desde el archivo usando bloques try-catch (campos vacios y roles permitidos).

service: logica de carga y operaciones sobre los datos.
- GestorColaboradores: lee el archivo CSV, crea los objetos, los carga en un ArrayList y permite buscar colaboradores por rol.

app: punto de entrada del programa.
- Main: ejecuta el sistema, muestra el listado completo por consola y aplica el filtro por rol.

Ademas, la carpeta resources (en la raiz del proyecto) contiene el archivo de datos colaboradores.csv.

## Relacion de composicion

La clase Colaborador contiene un atributo del tipo Direccion, lo que refleja una relacion de composicion: un colaborador tiene una direccion. Al construir cada colaborador, primero se crea su objeto Direccion y luego se le asigna.

## Tecnologias

- Lenguaje: Java
- IDE: Apache NetBeans
- Estructura de datos: ArrayList
- Lectura de archivos: BufferedReader y FileReader

## Instrucciones de ejecucion

1. Clonar o descargar este repositorio.
2. Abrir el proyecto en NetBeans (File, Open Project).
3. Verificar que el archivo resources/colaboradores.csv exista en la raiz del proyecto.
4. Ubicar la clase Main dentro del paquete app.
5. Hacer clic derecho sobre Main.java y seleccionar Run File (o presionar Shift + F6).
6. El resultado se muestra en la consola Output: primero el listado completo de colaboradores y luego el filtrado por rol.

## Formato del archivo de datos

Cada linea del archivo colaboradores.csv representa un colaborador, con sus campos separados por punto y coma en este orden:

nombre;rut;rol;comuna;calle

Ejemplo:

Juan Perez;12345678-9;guia;Llanquihue;Av. Costanera 123

Los roles validos son: guia, operador y proveedor.

## Autor

Macarena Alvarez Saez
