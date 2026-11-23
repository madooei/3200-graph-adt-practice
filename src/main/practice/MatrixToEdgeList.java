package practice;

import list.ArrayList;
import list.List;

/** Practice problem: convert an adjacency matrix to an edge list. */
public final class MatrixToEdgeList {

  private MatrixToEdgeList() {
    // This class should not be instantiated!
  }

  // Returns one Edge for each entry of matrix that is not null, where
  // matrix[i][j] is the weight of the edge from i to j and null means no edge.
  // Throws IllegalArgumentException if an entry on the diagonal is not null.
  // Assumes matrix is square.
  public static List<Edge> toEdgeList(Double[][] matrix) {
    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] != null) {
          if (i == j) {
            throw new IllegalArgumentException();
          } else {
            edges.add(new Edge(i, j, matrix[i][j]));
          }
        }
      }
    }
    return edges;
  }
}
