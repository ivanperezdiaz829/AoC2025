# Día 2: Gift Shop

## Descripción del Problema

El objetivo de este reto es ayudar a los Elfos a identificar IDs de productos inválidos que fueron introducidos accidentalmente en la base de datos de la tienda de regalos del Polo Norte.

El archivo de entrada consiste en una única línea con múltiples rangos de IDs separados por comas. Cada rango indica el primer y el último ID a revisar, separados por un guion.

*   **Parte A**: Un ID de producto se considera inválido si está formado únicamente por una secuencia de dígitos que se repite exactamente dos veces 
*   **Parte B**: La especificación se actualiza de manera física. Ahora el password es el número total de veces que el dial **pasa o toca** la posición **`0`** a lo largo de todo el movimiento de giro de la secuencia de rotaciones (incluyendo pasos intermedios y finales).

---

## Explicación de las Relaciones y Elementos

*   **Implementación:** `Day02ASolver` y `Day02BSolver` implementan la interfaz `Solver`, exponiendo así únicamente el método público `solve` hacia el exterior.
*   **Ensamblaje e Inyección:** Los solvers específicos (`Day02ASolver/B`) instancian las dependencias correctas (ej. `RepeatedSequenceValidator`) y se las inyectan al motor principal (`Day02Solver`), el cual se ejecuta a través de su método `execute`.
*   **Composición y Uso:** `Day02Solver` contiene `RangeReader` e `IdValidator`, delegando en ellos. A su vez, los dominios se comunican haciendo uso de un Record inmutable llamado `IdRange`.

---

## Arquitectura de Clases y Responsabilidades

- **Los Ensambladores y el Motor Principal:**
    *   `Solver` **(Interfaz):** Contrato global del repositorio para la ejecución de cualquier día.
    *   `Day02ASolver` / `Day02BSolver` **(Clases):** Implementan `Solver`. Configuran las dependencias concretas para la Parte A o B y se las pasan al motor genérico.
    *   `Day02Solver` **(Clase):** Actúa como el motor principal agnóstico. Recibe las dependencias inyectadas por constructor (`RangeReader` y `IdValidator`) y orquesta el flujo (lee los rangos, itera sobre los IDs y suma los que no cumplen la validación).
- **Dominio de Lectura (Abstracción y Value Objects):**
    *   `RangeReader` **(Interfaz):** Establece el contrato público para la lectura de los rangos.
    *   `ObtainRanges` **(Clase):** Implementa el contrato utilizando la API de Streams de Java para transformar la cadena de rangos separada por comas en una lista de objetos `IdRange`.
    *   `IdRange` **(Record):** *Value Object* inmutable que encapsula el inicio y el fin del rango (`start`y `end`), liberando al resto del sistema de la responsabilidad de hacer splits de cadenas.
- **Dominio de Validación (Polimorfismo):**
    *   `IdValidator` **(Interfaz):** Interfaz que define el contrato `isInvalid(id)` permitiendo la inyección de la lógica de negocio y las reglas de filtrado.
    *   `RepeatedSequenceValidator` **(Clase):** Implementación concreta de la Parte A.
    *   `ASDKJHFVJSA` **(Clase):** Implementación concreta de la Parte B.
- **Dominio de Estado (Inmutabilidad):**
    *   En este día el estado a evaluar es un long id por lo que la inmutabilidad se garantiza procesando esos datos mediante Streams o bucles puros sin mutar variables globales.

```mermaid
classDiagram
  class SafeSolver {
    «interface»
    +solve(input: String) long
  }

  class Day02ASolver {
    +solve(input: String) long
  }

  class Day02BSolver {
    +solve(input: String) long
  }

  class Day02Solver {
    -reader: RangeReader
    -validator: IdValidator
    +execute(input: String) long
  }

  class IdRange {
    «record»
    -start: long
    -end: long
  }

  class RangeReader {
    «interface»
    +readRanges(input: String) List~IdRange~
  }

  class ObtainRanges {
    +readRanges(input: String) List~IdRange~
  }

  class IdValidator {
    «interface»
    +isInvalid(id: long) boolean
  }

  class RepeatedSequenceValidator {
    +isInvalid(id: long) boolean
  }

  class FutureRuleValidator {
    +isInvalid(id: long) boolean
  }

%% Relaciones de Implementación
  SafeSolver <|.. Day02ASolver : implementa
  SafeSolver <|.. Day02BSolver : implementa
  RangeReader <|.. ObtainRanges : implementa
  IdValidator <|.. RepeatedSequenceValidator : implementa
  IdValidator <|.. FutureRuleValidator : implementa

%% Relaciones de Orquestación e Inyección
  Day02ASolver ..> Day02Solver : ensambla
  Day02BSolver ..> Day02Solver : ensambla
  Day02Solver *-- RangeReader : inyecta
  Day02Solver *-- IdValidator : inyecta

%% Dependencias de Dominio (Value Objects e Inmutabilidad)
  ObtainRanges ..> IdRange : crea
  Day02Solver ..> IdRange : itera
```

---

## Fundamentos y Principios de Diseño Aplicados

El diseño de esta solución se ha construido sobre los pilares de la calidad de software, separando responsabilidades y garantizando la mantenibilidad del código:

*   **Principio de Responsabilidad Única (SRP):** Cada módulo en el sistema se centra en una tarea específica. Por ejemplo, `IdValidator` solo decide si un número es válido y `RangeReader` solo procesa texto, asegurando que cada clase tenga una única razón para cambiar y sea más fácil de probar.
*   **Abstracción y Diseño por Contrato:** Se utilizan interfaces (`IdValidator` y `RangeReader`) como un contrato que define métodos públicos, ocultando detalles complejos de implementación (como las expresiones regulares o las matemáticas usadas para detectar secuencias repetidas). Esto facilita comprender el comportamiento del código sin necesidad de analizar operaciones interconectadas.
*   **Bajo Acoplamiento e Inyección de Dependencias:** El `Day02Solver` no crea sus propias dependencias, sino que estas se inyectan desde fuera separando la creación del objeto con su uso, reduciendo la dependencia interna y permitiendo reemplazar módulos sin afectar al estado del sistema.
*   **Principio Abierto Cerrado (OCP):** El diseño permite añadir nuevas reglas de validación de IDs creando nuevas clases, extendiendo el comportamiento sin necesidad de modificar el código orquestador existente.
*   **Principio de Sustitución de Liskov (LSP):** Cualquier objeto de un subtipo (como `RepeatedSequenceValidator`) puede sustituir a un supertipo (`IdValidator`) garantizando la interoperabilidad sin alterar el programa.
*   **Principio de Inversión de Dependencias (DIP):** El módulo de alto nivel (`Day02Solver`) no depende de las implementaciones concretas de bajo nivel, sino que depende directamente de las abstracciones.

---

## Mecanismos del Lenguaje

Para llegar a cabo esta arquitectura, se han empleado las siguientes características avanzadas de Java:

*   **Polimorfismo (Upcasting):** Las instancias de tipos específicos se asignan de forma automática y segura a variables de supertipo (interfaz), permitiendo trabajar con los objetos de manera genérica.
*   **API de Streams:** Se utiliza para el procesamiento declarativo. `Arrays.stream()` se emplea para parsear (`ObtainRanges`) dividiendo por comas, y `LongStream.rangeClosed()` se usa de forma excepcionalmente eficiente para generar e iterar sobre los números comprendidos dentro de cada `IdRange`, procesándolos en paralelo si fuera necesario sin el sobrecoste del autoboxing.
*   **Records:** Entidades puramente portadoras de datos inmutables como el `IdRange` se encapsulan utilizando record, proporcionando constructores, `getters`, `equals` y `hashCode` de fábrica.