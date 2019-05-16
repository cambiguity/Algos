package graph;//Adjacency List Representation Of Graph

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Graph {

  private int vertices;
  private List<List<Integer>> graph;

  public Graph(int vertices) {
    this.vertices = vertices;
    this.graph = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
      this.graph.add(new ArrayList<>());
    }
  }

  public abstract void addEdge(int a, int b);

}
