package practice;

import graph.AdjacencyListGraph;
import graph.Graph;

/** Practice problem: reverse a directed graph, keeping every edge's weight. */
public final class GraphReverse {

  private GraphReverse() {
    // This class should not be instantiated!
  }

  // Returns a new graph on the same vertices with every edge reversed and its
  // weight kept. Leaves graph unchanged. Assumes graph is not null.
  public static <V> Graph<V> reverse(Graph<V> graph) {
    Graph<V> reversed = new AdjacencyListGraph<>();

    for (V vertex : graph.vertices()) {
      reversed.addVertex(vertex);
    }

    for (V from : graph.vertices()) {
      for (V to : graph.neighbors(from)) {
        reversed.addEdge(to, from, graph.weight(from, to));
      }
    }

    return reversed;
  }
}
