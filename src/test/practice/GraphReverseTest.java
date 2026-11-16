package practice;

import graph.AdjacencyListGraph;
import graph.Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for reversing a directed graph. */
public class GraphReverseTest {

  @Test
  public void reverseOfEmptyGraphHasNoVertices() {
    Graph<String> reversed = GraphReverse.reverse(new AdjacencyListGraph<String>());
    assertEquals(0, reversed.numVertices());
  }

  @Test
  public void reverseKeepsEveryVertex() {
    Graph<String> reversed = GraphReverse.reverse(triangle());
    assertEquals(listOf("A", "B", "C"), sorted(reversed.vertices()));
  }

  @Test
  public void reverseKeepsNumEdges() {
    Graph<String> reversed = GraphReverse.reverse(triangle());
    assertEquals(3, reversed.numEdges());
  }

  @Test
  public void reverseFlipsAnEdge() {
    Graph<String> reversed = GraphReverse.reverse(triangle());
    assertTrue(reversed.containsEdge("B", "A"));
  }

  @Test
  public void reverseDropsTheOriginalDirection() {
    Graph<String> reversed = GraphReverse.reverse(triangle());
    assertFalse(reversed.containsEdge("A", "B"));
  }

  @Test
  public void reverseTurnsInNeighborsIntoOutNeighbors() {
    Graph<String> reversed = GraphReverse.reverse(triangle());
    assertEquals(listOf("A", "B"), sorted(reversed.neighbors("C")));
  }

  @Test
  public void reverseGivesSourceVertexNoOutNeighbors() {
    Graph<String> reversed = GraphReverse.reverse(triangle());
    assertFalse(reversed.neighbors("A").iterator().hasNext());
  }

  @Test
  public void reverseKeepsIsolatedVertices() {
    Graph<String> graph = new AdjacencyListGraph<>();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addEdge("A", "B");
    Graph<String> reversed = GraphReverse.reverse(graph);
    assertTrue(reversed.containsVertex("D"));
  }

  @Test
  public void reverseKeepsVertexCountWithIsolatedVertices() {
    Graph<String> graph = new AdjacencyListGraph<>();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addEdge("A", "B");
    Graph<String> reversed = GraphReverse.reverse(graph);
    assertEquals(4, reversed.numVertices());
  }

  @Test
  public void reverseKeepsTheWeight() {
    Graph<String> graph = new AdjacencyListGraph<>();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addEdge("A", "B", 5.0);
    Graph<String> reversed = GraphReverse.reverse(graph);
    assertEquals(5.0, reversed.weight("B", "A"));
  }

  @Test
  public void reverseSwapsWeightsOfOppositeEdges() {
    Graph<String> graph = new AdjacencyListGraph<>();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addEdge("A", "B", 5.0);
    graph.addEdge("B", "A", 7.0);
    Graph<String> reversed = GraphReverse.reverse(graph);
    assertEquals(7.0, reversed.weight("A", "B"));
  }

  @Test
  public void reverseLeavesInputEdgesInPlace() {
    Graph<String> graph = triangle();
    GraphReverse.reverse(graph);
    assertTrue(graph.containsEdge("A", "B"));
  }

  @Test
  public void reverseAddsNoEdgesToInput() {
    Graph<String> graph = triangle();
    GraphReverse.reverse(graph);
    assertEquals(3, graph.numEdges());
  }

  @Test
  public void reverseAddsNoReversedEdgeToInput() {
    Graph<String> graph = triangle();
    GraphReverse.reverse(graph);
    assertFalse(graph.containsEdge("B", "A"));
  }

  // The graph with vertices A, B, C and edges A -> B, A -> C, B -> C.
  private Graph<String> triangle() {
    Graph<String> graph = new AdjacencyListGraph<>();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "C");
    return graph;
  }

  // The vertices an iterable visits, in ascending order.
  private List<String> sorted(Iterable<String> vertices) {
    List<String> result = new ArrayList<>();
    for (String vertex : vertices) {
      result.add(vertex);
    }
    Collections.sort(result);
    return result;
  }

  // The given vertices as a list, in the order given.
  private List<String> listOf(String... vertices) {
    List<String> result = new ArrayList<>();
    for (String vertex : vertices) {
      result.add(vertex);
    }
    return result;
  }
}
