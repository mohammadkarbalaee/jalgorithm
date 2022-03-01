package datastructures;
import io.github.jalgorithm.datastructures.graphs.Graph;
import io.github.jalgorithm.datastructures.graphs.Vertex;

import java.util.ArrayList;

public class GraphSample2 {
  public static void main(String[] args) {
    Graph<Integer> graph = new Graph<>();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addEdge(1,2);
    graph.addEdge(1,3);
    ArrayList<Vertex<Integer>> neighbors = graph
        .getVertices()
        .get(0)
        .getNeighbors();

    for (Vertex<Integer> vertex: neighbors) {
      System.out.println(vertex.getLabel());
    }
  }
}
