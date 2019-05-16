package graph;

public class DirectedGraph extends Graph {

  public DirectedGraph(int vertices) {
    super(vertices);
  }

  @Override
  public void addEdge(int a, int b) {
    this.getGraph().get(a).add(b);
  }
}
