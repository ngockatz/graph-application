package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author ngockatz
 */
public class Parsing {
    static final int UNVISITED = 0;
    static final int VISITED = 1;
       public static Graphm createGraph(BufferedReader file, Graphm G, boolean directed) throws IOException {
            String line = null;
            //directed = false;
            int size = 0;
            int[] ve = new int[3];
            int i = 0;
            StringTokenizer token;
            while ((line = file.readLine()) != null && !line.equals("#")) {
                size = size + 1;
            }
            G=new Graphm(size);
            for (int a=0; a<G.n(); a++)
                G.setMark(a, UNVISITED);   
            //line = file.readLine();
            while ((line = file.readLine()) != null) {
                i = 0;
                token = new StringTokenizer(line);
                while (token.hasMoreTokens()) {
                    ve[i] = Integer.parseInt(token.nextToken());
                    i++;
                }
               
                G.setEdge(ve[0], ve[1], ve[2]);
                if (directed!=true) G.setEdge(ve[1], ve[0], ve[2]);
                //if ((line=file.readLine())== null||) throw new RuntimeException("File is empty");

            }
        return G;
        }

       public static Graphl createGraphl(BufferedReader file, Graphl G2, boolean directed) throws IOException {
            String line = null;
            //directed = false;
            int size = 0;
            int[] ve = new int[3];
            int i = 0;
            StringTokenizer token;
            while ((line = file.readLine()) != null && !line.equals("#")) {
                size = size + 1;
            }
            G2=new Graphl(size);
            for (int a=0; a<G2.n(); a++)
                G2.setMark(a, UNVISITED);   
            //line = file.readLine();
            while ((line = file.readLine()) != null) {
                i = 0;
                token = new StringTokenizer(line);
                while (token.hasMoreTokens()) {
                    ve[i] = Integer.parseInt(token.nextToken());
                    i++;
                }
               
                G2.setEdge(ve[0], ve[1], ve[2]);
                if (directed!=true) G2.setEdge(ve[1], ve[0], ve[2]);
                //if ((line=file.readLine())== null||) throw new RuntimeException("File is empty");

            }
        return G2;
        }

    }

