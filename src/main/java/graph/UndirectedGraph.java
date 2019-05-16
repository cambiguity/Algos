package graph;

public class UndirectedGraph extends Graph {


  public UndirectedGraph(int vertices) {
    super(vertices);
  }

  @Override
  public void addEdge(int a, int b) {
    this.getGraph().get(a).add(b);
    this.getGraph().get(b).add(a);
  }
}
