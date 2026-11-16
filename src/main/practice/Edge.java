package practice;

import java.util.Objects;

/** One directed, weighted edge, recorded as a (from, to, weight) triple. */
public class Edge {
  private int from;
  private int to;
  private double weight;

  public Edge(int from, int to, double weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  public int from() {
    return from;
  }

  public int to() {
    return to;
  }

  public double weight() {
    return weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Edge other = (Edge) o;
    return from == other.from && to == other.to && weight == other.weight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, weight);
  }

  @Override
  public String toString() {
    return "(" + from + ", " + to + ", " + weight + ")";
  }
}
