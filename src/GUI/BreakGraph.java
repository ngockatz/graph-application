/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author ngockatz
 */
public class BreakGraph {

    public static Graphm lessEdge(Graphm G) {
        for (int i = 0; i < G.n(); i++) {
            G.delEdge(i, G.first(i)); //del first neighbor
            //break;
            return G;
        }
        return G;
    }

    public static Graphm mergeEdge(Graphm G) {
        Graphm mergeG = new Graphm(G.n() - 1);
        int w = G.first(0); //first neighbor of 0

        //all neighbors of first neighbor of 0 now points to 0
        for (int x = G.first(w); x < G.n(); x = G.next(w, x)) {
            mergeG.setEdge(0, x - 1, 1); //edge is arbitrary
            //next neighbors point to previous neighbors
            for (int k = G.first(x); k < G.n(); k = G.next(x, k)) {
                mergeG.setEdge(x - 1, k - 1, 1);
            }
        }

        //all next neighbors of 0 after first neighbor point to 0, but with one less index
        for (int w2 = G.next(0, w); w2 < G.n(); w2 = G.next(0, w2)) {
            mergeG.setEdge(0, w2 - 1, 1);
            for (int w3 = G.first(w2); w3 < G.n(); w3 = G.next(w2, w3)) {
                mergeG.setEdge(w2 - 1, w3 - 1, 1);
            }
        }
        return mergeG;
    }

    static Polynomial undirectedChromaPolynomial(Graphm G, Polynomial p) {
        //Polynomial p = new Polynomial();
        if (G.e() == 0) {
            for (int i = 0; i < G.n(); i++) {
                p.append(0);
            }
            p.append(1);
            return p;
        }
        // if not a special case
        //int n = getFirst(G);
        //int q = G.first(n);

        //noedge and oneless - the name should be self-explanatory
        //Graphl noEdge = G.noEdge(n, q);
        //Graphl oneLess = G.oneLess(n, q);
        p = Polynomial.sub(undirectedChromaPolynomial(BreakGraph.lessEdge(G),p), undirectedChromaPolynomial(BreakGraph.mergeEdge(G),p));
        return p;
    }
}
