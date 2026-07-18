# LlanquihueTourApp

Sistema de gestión para una agencia de turismo de la región de Los Lagos, Chile.
Permite administrar servicios turísticos, guías, colaboradores externos y vehículos,
cargando la información desde archivos de texto plano y gestionándola mediante una
interfaz gráfica basada en `JOptionPane`.

**Asignatura:** Desarrollo Orientado a Objetos I (PRY2202) — Duoc UC
**Autora:** Macarena Álvarez Sáez
**Docente:** Eithel González Rojas

---

## Descripción

La aplicación modela el dominio de una agencia turística aplicando los principios
de la programación orientada a objetos: encapsulamiento, herencia, polimorfismo y
abstracción. Los datos se cargan desde archivos `.txt` ubicados en la carpeta
`datos/`, se almacenan en colecciones (`ArrayList`) y se procesan de forma
polimórfica, diferenciando los tipos concretos en tiempo de ejecución con
`instanceof`.

---

## Estructura de paquetes

```
src/
├── data/
│   ├── GestorEntidades.java    Colección polimórfica de Registrable
│   ├── GestorServicios.java    Carga y filtrado de servicios turísticos
│   └── LectorArchivos.java     Lectura de colaboradores desde .txt
├── model/
│   ├── Persona.java            Clase abstracta base
│   ├── GuiaTuristico.java      Hereda de Persona, implementa Registrable
│   ├── ColaboradorExterno.java Hereda de Persona, implementa Registrable
│   ├── Colaborador.java        Colaborador con Direccion (composición)
│   ├── Direccion.java          Comuna y calle
│   ├── Vehiculo.java           Implementa Registrable
│   ├── Registrable.java        Interfaz: mostrarResumen(), obtenerResumen()
│   ├── ServicioTuristico.java  Clase base de los servicios
│   ├── RutaGastronomica.java   Subclase de ServicioTuristico
│   ├── PaseoLacustre.java      Subclase de ServicioTuristico
│   └── ExcursionCultural.java  Subclase de ServicioTuristico
├── service/
│   └── GestorColaboradores.java  Carga y búsqueda de colaboradores por rol
├── ui/
│   ├── Main.java               Punto de entrada de la aplicación
│   └── VentanaPrincipal.java   Interfaz gráfica con JOptionPane
└── util/
    ├── Validador.java          Validación de texto, rol y RUT
    └── ValidacionException.java Excepción personalizada
datos/
├── colaboradores.txt
└── servicios.txt
```

---

## Conceptos aplicados

| Concepto | Dónde |
|---|---|
| Paquetes | `data`, `model`, `service`, `ui`, `util` |
| Encapsulamiento | Atributos `private` con getters/setters en todo `model` |
| Herencia | `Persona` → `GuiaTuristico`, `ColaboradorExterno`; `ServicioTuristico` → `RutaGastronomica`, `PaseoLacustre`, `ExcursionCultural` |
| Clase abstracta | `Persona` |
| Interfaz | `Registrable` |
| Polimorfismo | `mostrarInformacion()` y `mostrarResumen()` sobrescritos con `@Override` |
| `instanceof` | `Main` y `GestorEntidades` para diferenciar tipos concretos |
| Composición | `Colaborador` contiene un objeto `Direccion` |
| Colecciones | `ArrayList<ServicioTuristico>`, `ArrayList<Registrable>`, `List<Persona>` |
| Archivos | Lectura de `.txt` con `BufferedReader` y try-with-resources |
| Excepción personalizada | `ValidacionException` |
| Interfaz gráfica | `VentanaPrincipal` con `JOptionPane` |

---

## Requisitos

- JDK 8 o superior
- Apache NetBeans (el proyecto usa Ant)

---

## Cómo clonar y ejecutar

```bash
git clone https://github.com/Wen496/LlanquihueTourApp.git
```

1. Abrir NetBeans → **File → Open Project** → seleccionar la carpeta `LlanquihueTourApp`.
2. Clic derecho en el proyecto → **Clean and Build**.
3. Clic derecho en el proyecto → **Run** (o presionar F6).

La clase principal es `ui.Main`. Al ejecutar, el programa:

1. Carga los servicios turísticos desde `datos/servicios.txt` y los muestra por consola aplicando polimorfismo.
2. Filtra y lista los servicios de hasta 3 horas de duración.
3. Carga los colaboradores desde `datos/colaboradores.txt`.
4. Recorre una lista polimórfica de `Registrable` usando `instanceof` para mostrar los datos específicos de cada tipo.
5. Lanza la interfaz gráfica de gestión de entidades.

---

## Formato de los archivos de datos

**`datos/colaboradores.txt`**
```
rol;nombre;rut;telefono;campo1;campo2
```
- `guia` → campo1 = idioma, campo2 = años de experiencia
- `externo` → campo1 = empresa, campo2 = tipo de servicio

**`datos/servicios.txt`**
```
tipo;nombre;duracionHoras;atributoEspecifico
```
- `ruta` → número de paradas
- `paseo` → tipo de embarcación
- `excursion` → lugar histórico
