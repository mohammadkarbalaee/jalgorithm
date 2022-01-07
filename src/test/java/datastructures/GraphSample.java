package datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GraphSample {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    Graph<Integer> myGraph = new Graph<>(n);
    Set<Integer> vertices = new HashSet<>();
    ArrayList<ArrayList<Integer>> edgesData = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int vertex1 = input.nextInt();
      int vertex2 = input.nextInt();
      vertices.add(vertex1);
      vertices.add(vertex2);
      ArrayList<Integer> tuple = new ArrayList<>();
      tuple.add(vertex1);
      tuple.add(vertex2);
      edgesData.add(tuple);
    }
    for (Integer vertex : vertices) {
      myGraph.addVertex(vertex);
    }
    for (ArrayList<Integer> tuple : edgesData) {
      myGraph.addEdge(tuple.get(0) - 1,tuple.get(1) - 1);
    }

    System.out.println(myGraph.calculateLongestPath());
  }
}


class Vertex<T>{
  public int label;
  public boolean isVisited = false;
  public ArrayList<io.github.jalgorithm.datastructures.graphs.Vertex<T>> neighbors;

  public Vertex(int label) {
    this.label = label;
    this.neighbors = new ArrayList<>();
  }
}

class Graph<T> {
  protected ArrayList<Vertex<T>> vertices;
  protected int longestPathLength;
  int[] dp;
  protected int n;


  public Graph(int n) {
    this.vertices = new ArrayList<>();
    this.longestPathLength = 0;
    this.n = n;
    dp = new int[n];
  }

  public void addVertex(int label) {
    Vertex<T> newVertex = new Vertex<>(label);
    this.vertices.add(newVertex);
  }

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
}
