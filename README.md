# **Advent of Code 2025 — Soluciones en Java**

## Repositorio de soluciones para los retos diarios de programación

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?logo=apachemaven&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?logo=intellij-idea&logoColor=white)
![Clean Code](https://img.shields.io/badge/Code-Clean-success)

---

## ¿En qué consiste?
Este repositorio contiene todas mis soluciones a los rompecabezas de programación del evento anual [Advent of Code 2025](https://adventofcode.com/2025).

Cabe destacar que **todo el Advent of Code se va a hacer utilizando Java**. El proyecto ha sido desarrollado utilizando **IntelliJ IDEA** como entorno principal, haciendo un fuerte énfasis en la aplicación de **Clean Code** para mantener la legibilidad, escalabilidad y buenas prácticas en cada solución algorítmica.

### Características Principales
* **Lenguaje Principal:** Desarrollado íntegramente en Java.
  * **Gestor de dependencias:** Compilación y ejecución de tests configurados a través de Maven.
* **Diseño Homogéneo:** Uso de una interfaz estándar (`Solver`) para la resolución de todas las partes, facilitando el testing individual de cada puzzle.

## Estructura del proyecto

```
Aoc25/
└── src/
    ├── main/java/software/aoc/
    │   ├── SafeSolver.java          # Interfaz común para todos los solvers
    │   ├── day01/                   # Un paquete por día
    │   │   ├── a/Day01ASolver.java
    │   │   └── b/Day01BSolver.java
    │   └── ...
    └── test/
        ├── java/software/aoc/
        │    └── dayXX/              # Tests unitarios e integración
        └── resources/
             └── dXX-a/input.txt     # Inputs de cada puzzle
```

Cada día sigue exactamente el siguiente patrón:
- `DayXXASolver.java` → Parte A
- `DayXXBSolver.java` → Parte B
- Ambos implementan `Solver` (`long solve(String input)`)

## Configuración de los Inputs

Los archivos de entrada (inputs) de los puzzles no se suben al repositorio. Para poder ejecutar los tests y soluciones, debes crear y guardar tus inputs en la ruta `src/test/resources/` con los siguientes nombres:

| Día | Directorio | Nombre del Archivo |
| :--- | :--- | :--- |
| **Día 01** | `src/test/resources/d01-a/` | `ids.txt` |
| **Día 02** | `src/test/resources/d02-a/` | `id.txt` |
| **Día 03** | `src/test/resources/d03-a/` | `battery.txt` |
| **Día 04** | `src/test/resources/d04-a/` | `input.txt` |
| **Día 05** | `src/test/resources/d05-a/` | `input.txt` |
| **Día 06** | `src/test/resources/d06-a/` | `input.txt` |
| **Día 07** | `src/test/resources/d07-a/` | `input.txt` |
| **Día 08** | `src/test/resources/d08-a/` | `input.txt` |
| **Día 09** | `src/test/resources/d09-a/` | `input.txt` |
| **Día 10** | `src/test/resources/d10-a/` | `input.txt` |
| **Día 11** | `src/test/resources/d11-a/` | `input.txt` |
| **Día 12** | `src/test/resources/d12-a/` | `input.txt` |

*(Nota: Las soluciones de la parte A y parte B de cada día comparten el mismo archivo de entrada ubicado en el directorio de la parte A `dXX-a`).*

## Configuración de los Inputs

- Iván Pérez Díaz - Ingeniería del Software II (Java, IntelliJ, Clean Code)

*_Este repositorio es de carácter personal y tiene fines educativos. _Advent of Code_ es una marca registrada de **Eric Wastl**._*