# LlanquihueTourApp

## Descripcion

Aplicacion de consola desarrollada en Java para la agencia de turismo Llanquihue Tour, ubicada en la Region de Los Lagos. El sistema gestiona la informacion de los colaboradores vinculados a la agencia: guias, operadores y proveedores.

El programa lee los datos de los colaboradores desde un archivo externo (colaboradores.csv), construye objetos a partir de esa informacion, los almacena en una lista dinamica del tipo ArrayList y permite recorrer el listado completo y filtrar los colaboradores segun su rol.

El proyecto esta organizado en paquetes funcionales y aplica buenas practicas de Programacion Orientada a Objetos: encapsulamiento, composicion entre clases y validacion de datos con bloques try-catch.

## Estructura del proyecto

El codigo fuente esta organizado en cuatro paquetes:

model: clases que representan las entidades del dominio.

* Direccion: representa la direccion de un colaborador (comuna y calle).
* Colaborador: representa a un colaborador (nombre, rut, rol) y contiene un objeto Direccion adentro (relacion tiene una).

util: clases de apoyo.

* Validador: valida los datos leidos desde el archivo usando bloques try-catch (campos vacios y roles permitidos).

service: logica de carga y operaciones sobre los datos.

* GestorColaboradores: lee el archivo CSV, crea los objetos, los carga en un ArrayList y permite buscar colaboradores por rol.

app: punto de entrada del programa.

* Main: ejecuta el sistema, muestra el listado completo por consola y aplica el filtro por rol.

Ademas, la carpeta resources (en la raiz del proyecto) contiene el archivo de datos colaboradores.csv.

## Relacion de composicion

La clase Colaborador contiene un atributo del tipo Direccion, lo que refleja una relacion de composicion: un colaborador tiene una direccion. Al construir cada colaborador, primero se crea su objeto Direccion y luego se le asigna.

## Tecnologias

* Lenguaje: Java
* IDE: Apache NetBeans
* Estructura de datos: ArrayList
* Lectura de archivos: BufferedReader y FileReader

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

## Semana 6 - Jerarquia de clases con herencia simple

### Objetivo de la semana

Modelar los distintos tipos de servicios turisticos que ofrece la agencia mediante una jerarquia de clases con herencia simple. Se crea una superclase con los atributos comunes a todo servicio (nombre y duracion) y subclases que la extienden agregando sus propios atributos, aplicando herencia, uso de super(...) y sobrescritura del metodo toString().

### Clases creadas

Paquete model (jerarquia de clases):

* ServicioTuristico: superclase con los atributos comunes nombre y duracionHoras.
* RutaGastronomica: subclase, agrega el atributo numeroDeParadas.
* PaseoLacustre: subclase, agrega el atributo tipoEmbarcacion.
* ExcursionCultural: subclase, agrega el atributo lugarHistorico.

Todas las subclases heredan de ServicioTuristico (extends), usan super(...) en su constructor para inicializar los atributos heredados y sobrescriben toString() reutilizando el de la superclase con super.toString().

Paquete data:

* GestorServicios: crea las instancias de prueba (dos objetos de cada subclase) y las devuelve en un arreglo.

Paquete ui:

* Main: punto de entrada de esta actividad. Llama al gestor y muestra cada servicio por consola usando su metodo toString().

### Instrucciones para ejecutar Main (Semana 6)

1. Abrir el proyecto en NetBeans.
2. Ubicar la clase Main dentro del paquete ui.
3. Hacer clic derecho sobre Main.java y seleccionar Run File (o presionar Shift + F6).
4. La consola Output muestra los seis servicios turisticos de prueba, cada uno con su informacion completa.

Nota: el proyecto conserva la Main original del paquete app (semanas anteriores). Para esta actividad se ejecuta la Main del paquete ui.

## Semana 7 - Polimorfismo y colecciones genericas

### Objetivo de la semana

Extender la jerarquia de clases creada en la Semana 6 incorporando el uso de colecciones genericas, la sobrescritura de metodos y polimorfismo, de manera que los distintos tipos de servicios turisticos se puedan almacenar y recorrer desde una misma coleccion, invocando el comportamiento especifico de cada subclase a traves de una referencia del tipo de la superclase.

### Cambios realizados

Paquete model:

* ServicioTuristico: se agrega el metodo mostrarInformacion(), con una implementacion base.
* RutaGastronomica, PaseoLacustre, ExcursionCultural: cada subclase sobrescribe mostrarInformacion() (anotacion @Override) mostrando su informacion especifica.

Paquete data:

* GestorServicios: se reemplaza el arreglo de la Semana 6 por una coleccion List<ServicioTuristico> (implementada con ArrayList), cargada con seis objetos combinando las tres subclases. Se agrega el metodo mostrarTodos(), que recorre la lista con un bucle for-each e invoca mostrarInformacion() de forma polimorfica.

Paquete ui:

* Main: se actualiza para recibir la List<ServicioTuristico> desde GestorServicios y recorrerla con for-each, llamando a mostrarInformacion() desde la referencia de tipo ServicioTuristico.

No se utiliza instanceof en ningun punto: el comportamiento especifico de cada servicio se obtiene unicamente por sobrescritura de metodos (polimorfismo).

### Instrucciones para ejecutar Main (Semana 7)

1. Abrir el proyecto en NetBeans.
2. Ubicar la clase Main dentro del paquete ui.
3. Hacer clic derecho sobre Main.java y seleccionar Run File (o presionar Shift + F6).
4. La consola Output muestra los seis servicios turisticos, cada uno desplegando su informacion mediante su propia version sobrescrita de mostrarInformacion().

## Autor

Macarena Alvarez Saez
