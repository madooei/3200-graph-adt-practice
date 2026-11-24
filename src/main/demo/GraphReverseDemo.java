package demo;

import graph.AdjacencyListGraph;
import graph.Graph;
import practice.GraphReverse;

/** A demo of GraphReverse on the notes' first example. */
public final class GraphReverseDemo {

  private GraphReverseDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Graph<String> graph = new AdjacencyListGraph<>();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "C");
    System.out.println("original:");
    printEdges(graph);

    // Every edge flips and keeps its weight. Expect B -> A, C -> A, and C -> B.
    Graph<String> reversed = GraphReverse.reverse(graph);
    System.out.println("reversed:");
    printEdges(reversed);
  }

  // Prints each edge of graph on its own line, with its weight.
  private static void printEdges(Graph<String> graph) {
    for (String from : graph.vertices()) {
      for (String to : graph.neighbors(from)) {
        System.out.println("  " + from + " -> " + to + " (" + graph.weight(from, to) + ")");
      }
    }
  }
}
