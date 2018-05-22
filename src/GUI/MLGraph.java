package GUI;

/*
*
*@author Ngoc Tran
*/
public class MLGraph {

    Graphl G = new Graphl();
    static int padding = 1;
    private final static int UNVISITED = 0;
    private final static int VISITED = 1;
    final static int DFS = 0;
    final static int BFS = 1;

    static Polynomial chromaPolynomial(Graphl G) {
        return undirectedChromaPolynomial(G.undirecticize());
    }

    static Polynomial undirectedChromaPolynomial(Graphl G) {
        Polynomial p = new Polynomial();
        if (G.e() == 0) {
            for (int i = 0; i < G.n(); i++) {
                p.append(0);
            }
            p.append(1);
            return p;
        }
        // if not a special case
        int n = getFirst(G);
        int q = G.first(n);

        //noedge and oneless - the name should be self-explanatory
        Graphl noEdge = G.noEdge(n, q);
        Graphl oneLess = G.oneLess(n, q);
        G.chroma = Polynomial.sub(chromaPolynomial(noEdge), chromaPolynomial(oneLess));
        return G.chroma;
    }

    static int getFirst(Graphl G) {
        int i = 0;
        while (i < G.n()) {
            if (G.first(i) != G.n()) {
                break;
            } else {
                i++;
            }
        }
        return i;
    }

}
