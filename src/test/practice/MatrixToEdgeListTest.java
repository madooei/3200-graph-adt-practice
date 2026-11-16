package practice;

import list.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/** Tests for converting an adjacency matrix to an edge list. */
public class MatrixToEdgeListTest {

  @Test
  public void emptyMatrixHasNoEdges() {
    List<Edge> edges = MatrixToEdgeList.toEdgeList(new Double[0][0]);
    assertEquals(0, edges.size());
  }

  @Test
  public void allNullMatrixHasNoEdges() {
    Double[][] matrix = {{null, null, null}, {null, null, null}, {null, null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertEquals(0, edges.size());
  }

  @Test
  public void oneEntryGivesOneEdge() {
    Double[][] matrix = {{null, 1.0}, {null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertEquals(1, edges.size());
  }

  @Test
  public void oneEntryGivesThatEdge() {
    Double[][] matrix = {{null, 1.0}, {null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertTrue(edges.contains(new Edge(0, 1, 1)));
  }

  @Test
  public void entryIsTheEdgeWeight() {
    Double[][] matrix = {{null, 5.0}, {null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertTrue(edges.contains(new Edge(0, 1, 5)));
  }

  @Test
  public void negativeEntryIsAnEdge() {
    Double[][] matrix = {{null, null}, {-2.0, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertTrue(edges.contains(new Edge(1, 0, -2)));
  }

  @Test
  public void zeroEntryIsAnEdge() {
    Double[][] matrix = {{null, 0.0}, {null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertTrue(edges.contains(new Edge(0, 1, 0)));
  }

  @Test
  public void oneEdgePerEntryThatIsNotNull() {
    Double[][] matrix = {{null, 1.0, 1.0}, {null, null, 1.0}, {null, null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertEquals(3, edges.size());
  }

  @Test
  public void edgeInLastColumnIsFound() {
    Double[][] matrix = {{null, 1.0, 1.0}, {null, null, 1.0}, {null, null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertTrue(edges.contains(new Edge(0, 2, 1)));
  }

  @Test
  public void edgeInMiddleRowIsFound() {
    Double[][] matrix = {{null, 1.0, 1.0}, {null, null, 1.0}, {null, null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertTrue(edges.contains(new Edge(1, 2, 1)));
  }

  @Test
  public void edgeInLastRowIsFound() {
    Double[][] matrix = {{null, null, null}, {null, null, null}, {4.0, null, null}};
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    assertTrue(edges.contains(new Edge(2, 0, 4)));
  }

  @Test
  public void nonNullFirstDiagonalEntryThrows() {
    Double[][] matrix = {{3.0, null}, {null, null}};
    try {
      MatrixToEdgeList.toEdgeList(matrix);
      fail("expected IllegalArgumentException when the first diagonal entry is not null");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void nonNullLastDiagonalEntryThrows() {
    Double[][] matrix = {{null, 1.0, null}, {null, null, null}, {null, null, 3.0}};
    try {
      MatrixToEdgeList.toEdgeList(matrix);
      fail("expected IllegalArgumentException when the last diagonal entry is not null");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void zeroOnTheDiagonalThrows() {
    Double[][] matrix = {{0.0, null}, {null, null}};
    try {
      MatrixToEdgeList.toEdgeList(matrix);
      fail("expected IllegalArgumentException when a diagonal entry is 0");
    } catch (IllegalArgumentException e) {
      return;
    }
  }
}
