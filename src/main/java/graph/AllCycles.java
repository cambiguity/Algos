//No of cycles in an undirected graph

package graph;

import java.util.List;

public class AllCycles {

  private int cycleNumber = 0;

  private void dfs(Graph g, int[] color, int src, int parent) {
    color[src] = 1;
    for (int to: g.getGraph().get(src)) {
      if (color[to] == 0) {
        dfs(g, color, to, src);
      } else if (color[to] == 1) {
        if (to == parent) {
          continue;
        }
        cycleNumber++;
      }
    }
    color[src] = 2;
  }

  public int noOfCycles(Graph g) {
    int[] color = new int[g.getVertices()];
    for(int i=0;i<g.getVertices();i++) {
      if (color[i] == 0 ) {
        dfs(g,color,i,-1);
      }
    }
    return cycleNumber;
  }

}
