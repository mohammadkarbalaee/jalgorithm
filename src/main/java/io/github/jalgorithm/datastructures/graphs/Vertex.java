package io.github.jalgorithm.datastructures.graphs;

import java.util.ArrayList;

/**
 * @author Muhammad Karbalaee
 * @param <T> type of the data stored in the vertex
 */
public class Vertex<T>{
  public int label;
  public boolean isVisited = false;
  public ArrayList<Vertex<T>> neighbors;

  public Vertex(int label) {
    this.label = label;
    this.neighbors = new ArrayList<>();
  }
}
