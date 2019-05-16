package graph;

public class MainGraphClass {

  public static void main(String[] args) {
    Graph g = new UndirectedGraph(14);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(4, 6);
    g.addEdge(4, 7);
    g.addEdge(5, 6);
    g.addEdge(3, 5);
    g.addEdge(7, 8);
    g.addEdge(6, 10);
    g.addEdge(5, 9);
    g.addEdge(10, 11);
    g.addEdge(11, 12);
    g.addEdge(11, 13);
    g.addEdge(12, 13);
    System.out.println(new AllCycles().noOfCycles(g));
    System.out.println(new ArticulationPoints().getArticulationPoints(g));
  }

}
