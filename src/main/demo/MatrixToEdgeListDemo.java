package demo;

import java.util.Arrays;
import list.List;
import practice.Edge;
import practice.MatrixToEdgeList;

/** A demo of MatrixToEdgeList on the notes' first example. */
public final class MatrixToEdgeListDemo {

  private MatrixToEdgeListDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Double[][] matrix = {
      {null, 1.0, 1.0},
      {null, null, 1.0},
      {null, null, null}
    };
    System.out.println("matrix:");
    for (Double[] row : matrix) {
      System.out.println("  " + Arrays.toString(row));
    }

    // Row 0 has edges to 1 and 2, and row 1 has an edge to 2.
    // Expect (0, 1, 1.0), (0, 2, 1.0), and (1, 2, 1.0).
    List<Edge> edges = MatrixToEdgeList.toEdgeList(matrix);
    System.out.println("edge list:");
    for (int i = 0; i < edges.size(); i++) {
      System.out.println("  " + edges.get(i));
    }
  }
}
