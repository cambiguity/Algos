package graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoints {

  int timer = 0;

  private void findArticulationPoints(Graph g, int src, boolean[] visited,
                                      int[] low, int[] in,
                                      List<Integer> articualationPoints,
                                      int parent) {
    visited[src] = true;
    in[src] = low[src] = ++timer;
    int chilren = 0;
    for (int i = 0; i < g.getGraph().get(src).size(); i++) {
      int to = g.getGraph().get(src).get(i);
      if (to == parent) {
        continue;
      }
      if (visited[to]) {
        low[src] = Math.min(low[src], in[to]);
      } else {
        findArticulationPoints(g, to, visited, low, in, articualationPoints,
            src);
        low[src] = Math.min(low[to], low[src]);
        if (low[src] >= in[src] && parent != -1) {
          articualationPoints.add(src);
        }
        chilren++;
      }
    }
    if (parent == -1 && chilren > 1) {
      articualationPoints.add(src);
    }
  }

  public List<Integer> getArticulationPoints(Graph g) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[g.getVertices()];
    int[] low = new int[g.getVertices()];
    int[] in = new int[g.getVertices()];
    for (int i = 0; i < g.getVertices(); i++) {
      if (!visited[i]) {
        List<Integer> articulationPoints = new ArrayList<>();
        findArticulationPoints(g, i, visited, low, in,
            articulationPoints, -1);
        result.addAll(articulationPoints);
      }
    }
    return result;
  }

}
