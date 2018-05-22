package GUI;

import java.io.*;
import java.util.*;

public class Prim
{

static final int UNVISITED = 0;
static final int VISITED = 1;

static int[] D = new int[100];
static StringBuffer out=new StringBuffer();
//static int[] V;
static void AddEdgetoMST(int v1, int v2) {}
static int minVertex(Graph G, int[] D) {
  int v = 0;  // Initialize v to any unvisited vertex;
  for (int i=0; i<G.n(); i++)
    if (G.getMark(i) == UNVISITED) { v = i; break; }
  for (int i=0; i<G.n(); i++)  // Now find smallest value
    if ((G.getMark(i) == UNVISITED) && (D[i] < D[v]))
      v = i;
  return v;
}
/** Compute a minimal-cost spanning tree */
static void Prim(Graph G, int s, int[] D, int[] V) {
  out.setLength(0);
  for (int j=0;j<G.n();j++) G.setMark(j, UNVISITED);
  for (int i=0; i<G.n(); i++)   // Initialize
  D[i] = Integer.MAX_VALUE;
  D[s] = 0;
  for (int i=0; i<G.n(); i++) { // Process the vertices
    int v = minVertex(G, D);
    G.setMark(v, VISITED);
    if (v != s) AddEdgetoMST(V[v], v);
    if (D[v] == Integer.MAX_VALUE) return; // Unreachable
    for (int w = G.first(v); w < G.n(); w = G.next(v, w))
      if (D[w] > G.weight(v, w)) {
        D[w] = G.weight(v, w);
        V[w] = v;
      }
  }
  //for (int j=0; j< G.n(); j++) out.append(V[j] + " ");
}
  /**
   * This method is automatically called once before each test case
   * method, so that all the variables are cleanly initialized for
   * each test.
   */
//  public void setUp()
//  {
//    out = new StringBuffer(100);
//  }

//  public void testGraph()
//  throws IOException {
//    BufferedReader f;
//    f = new BufferedReader(new InputStreamReader(new FileInputStream("testfile.gph")));
//    Graph G = new Graphm();
//    createGraph(f, G);
//    int[] V = new int[G.n()];     // V[i] stores closest vertex to i
//    Prim(G, 0, D, V);
//    for (int i=0; i< G.n(); i++) out.append(V[i] + " ");
//    assertEquals(out.toString(), "0 2 3 2 5 4 ");
//  }

}
