package GUI;
// Graph operation main function.
// To use: java -ea GraphTest <graphfile>


import java.io.*;
import java.util.*;

public class Traversing
    //extends junit.framework.TestCase
{
static StringBuffer out = new StringBuffer();
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


//static StringBuffer out;

static void PreVisit(Graph G, int v) {
  out.append(v + " ");
}

static void PostVisit(Graph G, int v) {
  out.append(v + " ");
}

static void doTraverse(Graph G, int v,boolean dfs) {
  if (dfs) DFS(G, v);
  else
      BFS(G,v);
}
static void graphTraverse(Graph G,boolean dfs) {
  out.setLength(0);
  int v;
  for (v=0; v<G.n(); v++)
    G.setMark(v, UNVISITED); // Initialize 
  for (v=0; v<G.n(); v++)
    if (G.getMark(v) == UNVISITED)
      doTraverse(G, v,dfs);
}
/** Depth first search */
static void DFS(Graph G, int v) {
  PreVisit(G, v);                 // Take appropriate action
  G.setMark(v, VISITED);
  for (int w = G.first(v); w < G.n() ; w = G.next(v, w))
    if (G.getMark(w) == UNVISITED)
      DFS(G, w);
  //PostVisit(G, v);                // Take appropriate action
}

static void BFS(Graph G, int start) {
  Queue<Integer> Q = new AQueue<Integer>(G.n());
  Q.enqueue(start);
  G.setMark(start, VISITED);
  while (Q.length() > 0) {    // Process each vertex on Q
    int v = Q.dequeue();
    PreVisit(G, v);           // Take appropriate action
    for (int w = G.first(v); w < G.n(); w = G.next(v, w))
      if (G.getMark(w) == UNVISITED) { // Put neighbors on Q
        G.setMark(w, VISITED);
        Q.enqueue(w);
      }
    //PostVisit(G, v);          // Take appropriate action
  }
}

  /**
   * This method is automatically called once before each test case
   * method, so that all the variables are cleanly initialized for
   * each test.
   */
  //public void setUp()
  //{
  //  out = new StringBuffer(100);
  //}

/*
  public void testGraph()
  throws IOException {
    BufferedReader f;
    f = new BufferedReader(new InputStreamReader(new FileInputStream("testfile.gph")));
    Graph G = new Graphm();
    createGraph(f, G);
    graphTraverse(G);
    assertEquals(out.toString(), "0 2 1 5 3 3 4 4 5 1 2 0 ");
  }
*/
}
