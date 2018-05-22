package GUI;



/**
 *
 * @author ngockatz
 */
public class tasks {
    static final int UNVISITED = 0;
    static final int VISITED = 1;

static void PreVisit(Graphm G, int v,StringBuffer out) {
  out.append(v + " ");
}

static void PostVisit(Graphm G, int v,StringBuffer out) {
  out.append(v + " ");
}

static void doTraverse(Graphm G, int v, StringBuffer out) {
  DFS(G, v,out);
}
static void graphTraverse(Graphm G,StringBuffer out) {
  int v;
  for (v=0; v<G.n(); v++)
    G.setMark(v, UNVISITED); // Initialize 
  for (v=0; v<G.n(); v++)
    if (G.getMark(v) == UNVISITED)
      doTraverse(G, v,out);
}
/** Depth first search */
static void DFS(Graphm G, int v, StringBuffer out) {
  PreVisit(G, v, out);                 // Take appropriate action
  G.setMark(v, VISITED);
  for (int w = G.first(v); w < G.n() ; w = G.next(v, w))
    if (G.getMark(w) == UNVISITED)
      DFS(G, w,out);
  PostVisit(G, v,out);
}
}
