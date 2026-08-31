# Día 11: Reactor

## Descripción del Problema

Tras bajar por una escotilla, encontramos el reactor toroidal que alimenta la fábrica. Los elfos tienen problemas de comunicación entre el servidor y el reactor debido a un laberinto de cables y dispositivos.

*   **Parte A**: Se proporciona una lista de dispositivos y las salidas hacia las que envían datos. Los datos fluyen en una sola dirección (formando un Grafo Acíclico Dirigido o DAG). El objetivo es calcular el **número total de caminos únicos** que conectan el dispositivo etiquetado como `you` con el dispositivo etiquetado como `out`.
*   **Parte B**: *(Pendiente de ser revelada)*.

---

## Explicación de las Relaciones y Elementos

*   **Implementación:** `Day11ASolver` implementa la interfaz global `Solver`.
*   **Ensamblaje e Inyección:** La tarea matemática de contar caminos en un grafo puede variar drásticamente en la Parte B (podrían introducir ciclos, pesos en las aristas, o restricciones de paso). Por ello, el ensamblador inyecta una `PathCountingStrategy` (`MemoizedDfsPathCountingStrategy`) en el orquestador `Day11Solver`.
*   **Composición y Uso (Tell, Don't Ask):** `ReactorNetwork` es el *Aggregate Root*. En lugar de exponer su lista de adyacencia mediante *getters*, se le ordena calcular los caminos a través del método `countPathsFrom(start, end, strategy)`, cediendo sus datos a la estrategia inyectada.

---

## Arquitectura de Clases y Responsabilidades

- **Los Ensambladores y el Motor Principal:**
    *   `Solver` **(Interfaz):** Contrato global del repositorio.
    *   `Day11ASolver` **(Clase):** Ensamblador de la Parte A. Inyecta la estrategia y el lector de red.
    *   `Day11Solver` **(Clase):** Orquestador agnóstico de las reglas de recorrido de grafos.
- **Dominio de Búsqueda (Patrón Strategy):**
    *   `PathCountingStrategy` **(Interfaz):** Contrato que aísla el algoritmo de cálculo de caminos (`countPaths`).
    *   `MemoizedDfsPathCountingStrategy` **(Clase):** Implementa un algoritmo *Depth-First Search* (DFS). Al tratarse de un problema combinatorio en un DAG, utiliza **Programación Dinámica (Memoización)**. Mantiene una caché interna local para recordar cuántos caminos hay desde un nodo intermedio hasta el final, reduciendo el tiempo de ejecución de exponencial $O(2^N)$ a lineal $O(V + E)$.
- **Dominio de Lectura y Modelado (Value Objects):**
    *   `ReactorNetworkReader` **(Clase):** Parsea las reglas de texto plano (`dispositivo: salida1 salida2`) y construye el diccionario de adyacencia.
    *   `ReactorNetwork` **(Record):** *Value Object* inmutable que encapsula el grafo mediante un `Map<String, List<String>>`.

```mermaid
classDiagram
  class Solver {
    «interface»
    +solve(input: String) long
  }

  class Day11ASolver {
    +solve(input: String) long
  }

  class Day11BSolver {
    +solve(input: String) long
  }

  class Day11Solver {
    -reader: ReactorNetworkReader
    -strategy: PathCountingStrategy
    -startNode: String
    -endNode: String
    +execute(input: String) long
  }

  class ReactorNetwork {
    «record»
    -adjacencyList: Map~String, List~String~~
    +countPathsFrom(start: String, end: String, strategy: PathCountingStrategy) long
  }

  class PathCountingStrategy {
    «interface»
    +countPaths(network: ReactorNetwork, start: String, end: String) long
  }

  class MemoizedDfsPathCountingStrategy {
    +countPaths(network: ReactorNetwork, start: String, end: String) long
  }

  class MandatoryNodesPathCountingStrategy {
    -node1: String
    -node2: String
    +countPaths(network: ReactorNetwork, start: String, end: String) long
    -dfs(current: String, target: String, adjList: Map, v1: boolean, v2: boolean, memo: Map) long
  }

  class ReactorNetworkReader {
    +read(input: String) ReactorNetwork
  }

%% Relaciones de Implementación
  Solver <|.. Day11ASolver : implementa
  Solver <|.. Day11BSolver : implementa
  PathCountingStrategy <|.. MemoizedDfsPathCountingStrategy : implementa
  PathCountingStrategy <|.. MandatoryNodesPathCountingStrategy : implementa

%% Relaciones de Ensamblaje e Inyección
  Day11ASolver ..> Day11Solver : ensambla
  Day11BSolver ..> Day11Solver : ensambla
  Day11Solver *-- ReactorNetworkReader : inyecta
  Day11Solver *-- PathCountingStrategy : inyecta

%% Relaciones de Dominio
  Day11Solver ..> ReactorNetwork : coordina
  ReactorNetwork ..> PathCountingStrategy : usa
  ReactorNetworkReader ..> ReactorNetwork : crea
```