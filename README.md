# Graphs — Practice

Two practice problems on graph representations: reverse a directed graph, and convert an adjacency matrix to an edge list. Each problem has a JUnit suite.

## Prerequisites

- JDK 17+ (JUnit 6 requires it).
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      graph/
        Graph.java                  # unchanged copy of the chapter's Graph ADT
        AdjacencyListGraph.java     # unchanged copy of the chapter's implementation
      list/
        List.java                   # unchanged copy of the course List ADT
        ArrayList.java              # unchanged copy of the course array list
      map/
        Map.java                    # unchanged copy of the course Map ADT
        HashMap.java                # unchanged copy of the course hash table
      practice/
        GraphReverse.java           # reverse (transpose) a directed graph
        MatrixToEdgeList.java       # convert an adjacency matrix to an edge list
        Edge.java                   # an immutable (from, to, weight) triple
      demo/                         # one demo per solution class
        GraphReverseDemo.java
        MatrixToEdgeListDemo.java
    test/
      practice/
        GraphReverseTest.java
        MatrixToEdgeListTest.java
  scripts/
    test.sh                         # compile and run the JUnit tests
    run.sh                          # compile and run one demo
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.GraphReverseTest` — compiles everything and runs only that test class.
- `scripts/run.sh demo.GraphReverseDemo` — compiles everything and runs that one demo. Every problem class has its own demo, `<Class>Demo`.

## Contents

- `practice.GraphReverse` — `reverse`, which returns a new graph on the same vertices with every edge flipped and its weight kept.
- `practice.MatrixToEdgeList` — `toEdgeList`, which scans every cell of the matrix and returns a `List` with one `Edge` per entry that is not `null`. An entry on the diagonal that is not `null` makes it throw.
- `practice.Edge` — the `(from, to, weight)` triple that `toEdgeList` returns.
- `practice.GraphReverseTest` and `practice.MatrixToEdgeListTest` — one suite per problem.
- `demo.GraphReverseDemo` and `demo.MatrixToEdgeListDemo` — one demo per solution class, each on the first example from the notes.
- `graph.Graph<V>` and `graph.AdjacencyListGraph<V>` — unchanged copies of the chapter's classes. `GraphReverse` takes a `Graph` and builds its result as an `AdjacencyListGraph`.
- `map.Map<K, V>` and `map.HashMap<K, V>` — unchanged copies of the course's map, which `AdjacencyListGraph` is built on.
- `list.List<T>` and `list.ArrayList<T>` — unchanged copies of the course's list. `toEdgeList` returns its edges in one.
