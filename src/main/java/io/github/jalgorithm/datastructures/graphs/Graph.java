package io.github.jalgorithm.datastructures.graphs;

import java.util.ArrayList;

/**
 * @author Muhammad Karbalaee
 * @param <T> type of the data stored in the vertices
 */
public class Graph<T> {
  protected ArrayList<Vertex<T>> vertices;
  protected int longestPathLength;
  int[] dp;
  int tempLen = 0;
  protected int n;

  /**
   * constructor for DirectGraph class
   */
  public Graph(int n) {
    this.vertices = new ArrayList<>();
    this.longestPathLength = 0;
    this.n = n;
    dp = new int[n];
  }

  /**
   * method to add a new vertex to the graph
   * @param label the label assigned to the new vertex
   */
  public void addVertex(int label) {
    Vertex<T> newVertex = new Vertex<>(label);
    this.vertices.add(newVertex);
  }

  /**
   * method add a new vertex to the graph
   * @param firstVertexLabel the label of the first vertex
   * @param secondVertexLabel the label of the second vertex
   */
  public void addEdge(int firstVertexLabel,int secondVertexLabel) {
    Vertex<T> firstVertex = new Vertex<>(0);
    Vertex<T> secondVertex = new Vertex<>(0);

    for (int i = 0; i < this.n; i++) {
      Vertex<T> currentVertex = this.vertices.get(i);
      if (currentVertex.label == firstVertexLabel) {
        firstVertex = currentVertex;
      }
      if (currentVertex.label == secondVertexLabel) {
        secondVertex = currentVertex;
      }
    }
    firstVertex.neighbors.add(secondVertex);
  }

  /**
   * to calculate the longest path in the current graph
   */
  public int calculateLongestPath () {
    this.longestPathLength = 0;
    for (int i = 0; i < this.n; i++) {
      this.vertices.get(i).isVisited = false;
    }
    for (Vertex<T> vertex: this.vertices) {
      if (!vertex.isVisited) {
        visit(vertex);
      }
    }
    for (int i = 0; i < this.n; i++) {
      this.longestPathLength = Math.max(this.longestPathLength,this.dp[i]);
    }
    return this.longestPathLength;
  }

  public void visit(Vertex<T> vertex){
  vertex.isVisited = true;
  for (int i = 0; i < vertex.neighbors.size(); i++) {
      if (!vertex.neighbors.get(i).isVisited) {
        visit(vertex.neighbors.get(i));
      }
      this.dp[vertex.label] = Math.max(this.dp[vertex.label],1 + this.dp[vertex.neighbors.get(i).label]);
    }
  }

  public ArrayList<Vertex<T>> getVertices() {
    return vertices;
  }

  public void setVertices(ArrayList<Vertex<T>> vertices) {
    this.vertices = vertices;
  }

  public int getLongestPathLength() {
    return longestPathLength;
  }

  public void setLongestPathLength(int longestPathLength) {
    this.longestPathLength = longestPathLength;
  }
}