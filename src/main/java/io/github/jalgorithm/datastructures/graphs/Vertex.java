package io.github.jalgorithm.datastructures.graphs;

import java.util.ArrayList;

/**
 * @author Muhammad Karbalaee
 * @param <T> type of the data stored in the vertex
 */
public class Vertex<T>{
  private T label;
  private ArrayList<Vertex<T>> neighbors;

  public Vertex(T label) {
    this.label = label;
    this.neighbors = new ArrayList<>();
  }

  public T getLabel() {
    return label;
  }

  public void setLabel(T label) {
    this.label = label;
  }

  public ArrayList<Vertex<T>> getNeighbors() {
    return neighbors;
  }

  public void setNeighbors(ArrayList<Vertex<T>> neighbors) {
    this.neighbors = neighbors;
  }

  /**
   * adds a new vertex to the neighbors list of this vertex
   * @param newNeighbor the new neighbor of this vertex
   */
  public void addNeighbor(Vertex<T> newNeighbor) {
    this.neighbors.add(newNeighbor);
  }
}
