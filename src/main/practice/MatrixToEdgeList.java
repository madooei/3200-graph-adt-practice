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
    int n = matrix.length;

    for (int from = 0; from < n; from++) {
      for (int to = 0; to < n; to++) {
        if (from == to && matrix[from][to] != null) {
          throw new IllegalArgumentException();
        }
        if (matrix[from][to] != null) {
          edges.add(new Edge(from, to, matrix[from][to]));
        }
      }
    }

    return edges;
  }
}
