package io.github.jalgorithm.datastructures.graphs;

import java.util.ArrayList;

/**
 * @author Muhammad Karbalaee
 * @param <T> type of the data stored in the vertices
 */
public class Graph<T> {
  protected ArrayList<Vertex<T>> vertices;

  /**
   * constructor for DirectGraph class
   */
  public Graph() {
    this.vertices = new ArrayList<>();
  }

  /**
   * method to add a new vertex to the graph
   * @param label the label assigned to the new vertex
   */
  public void addVertex(T label) {
    Vertex<T> newVertex = new Vertex<>(label);
    this.vertices.add(newVertex);
  }

  /**
   * method add a new vertex to the graph
   * @param firstVertexLabel the label of the first vertex
   * @param secondVertexLabel the label of the second vertex
   */
  public void addEdge(T firstVertexLabel,T secondVertexLabel) {
    Vertex<T> firstVertex = new Vertex<T>(firstVertexLabel);
    Vertex<T> secondVertex = new Vertex<T>(secondVertexLabel);

    for (int i = 0; i < this.vertices.size(); i++) {
      Vertex<T> currentVertex = this.vertices.get(i);
      if (currentVertex.getLabel() == firstVertexLabel) {
        firstVertex = currentVertex;
      }
      if (currentVertex.getLabel() == secondVertexLabel) {
        secondVertex = currentVertex;
      }
    }
    firstVertex.addNeighbor(secondVertex);
  }


  public ArrayList<Vertex<T>> getVertices() {
    return vertices;
  }

  public void setVertices(ArrayList<Vertex<T>> vertices) {
    this.vertices = vertices;
  }
}