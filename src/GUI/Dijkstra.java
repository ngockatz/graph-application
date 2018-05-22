package GUI;

// Graph operation main function.
// To use: java -ea GraphTest <graphfile>

import java.io.*;
import java.util.*;

public class Dijkstra
{

static final int UNVISITED = 0;
static final int VISITED = 1;


static void Gprint(Graph G, StringBuffer out) {
  int i, j;

  for (i=0; i<G.n(); i++) {
    for(j=0; j<G.n(); j++)
      if (G.weight(i, j) == Integer.MAX_VALUE)
        out.append("0 ");
      else
        out.append(G.weight(i, j) + " ");
  }
}


static int[] D = new int[100];
static StringBuffer out=new StringBuffer();

static int minVertex(Graph G, int[] D) {
  int v = 0;  // Initialize v to any unvisited vertex;
  for (int i=0; i<G.n(); i++)
    if (G.getMark(i) == UNVISITED) { v = i; break; }
  for (int i=0; i<G.n(); i++)  // Now find smallest value
    if ((G.getMark(i) == UNVISITED) && (D[i] < D[v]))
      v = i;
  return v;
}
// Compute shortest path distances from s, store them in D
static void Dijkstra(Graph G, int s, int[] D) {
  for (int j=0;j<G.n();j++) G.setMark(j, UNVISITED);
    for (int i=0; i<G.n(); i++)    // Initialize
    D[i] = Integer.MAX_VALUE;
  D[s] = 0;
  for (int i=0; i<G.n(); i++) {  // Process the vertices
    int v = minVertex(G, D);     // Find next-closest vertex
    G.setMark(v, VISITED);
    if (D[v] == Integer.MAX_VALUE) return; // Unreachable
    for (int w = G.first(v); w < G.n(); w = G.next(v, w))
      if (D[w] > (D[v] + G.weight(v, w)))
        D[w] = D[v] + G.weight(v, w);
  }
}
  /**
   * This method is automatically called once before each test case
   * method, so that all the variables are cleanly initialized for
   * each test.
   */
  public void setUp()
  {
    out = new StringBuffer(100);
  }

//  public void testGraph()
//  throws IOException {
//    BufferedReader f;
//    f = new BufferedReader(new InputStreamReader(new FileInputStream("testfile.gph")));
//    Graph G = new Graphm();
//    createGraph(f, G);
//    Dijkstra(G, 0, D);
//    for (int i=0; i< G.n(); i++) out.append(D[i] + " ");
//    assertEquals(out.toString(), "0 5 3 10 18 ");
//  }

}
