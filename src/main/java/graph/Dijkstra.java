package graph;

import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.PriorityQueue;

@AllArgsConstructor
class Pair {
  int vertex;
  int weight;
}

class DGraph {

  int vertices;
  List<List<Pair>> graph;

  public DGraph(int vertices) {
    this.vertices = vertices;
    this.graph = new ArrayList<>();
    for (int i=0;i<vertices;i++) {
      this.graph.add(new ArrayList<>());
    }
  }

  public void addEdge(int from, int to, int weight) {
    this.graph.get(from).add(new Pair(to, weight));
    this.graph.get(to).add(new Pair(from, weight));
  }

}

public class Dijkstra {

  public int[] shortestDistance(DGraph graph, int src) {
    int[] dist = new int[graph.vertices];
    for (int i=0;i<dist.length;i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;
    Comparator<Pair> pairComparator = Comparator.comparingInt(a -> a.weight);
    PriorityQueue<Pair> pq = new PriorityQueue<>(pairComparator);
    pq.add(new Pair(src, 0));
    while (!pq.isEmpty()) {
      Pair polled = pq.poll();
      int u = polled.vertex;
      int wt = polled.weight;
      if (dist[u] != wt) {
        continue;
      }
      for (Pair to: graph.graph.get(u)) {
        if (dist[to.vertex] > dist[u] + to.weight) {
          dist[to.vertex] = dist[u] + to.weight;
          pq.add(new Pair(to.vertex, dist[to.vertex]));
        }
      }
    }
    return dist;
  }

}
