  1 public class Dijkstra {
  2 
  3    // Dijkstra's algorithm to find shortest path from s to all other nodes
  4    public static int [] dijkstra (WeightedGraph G, int s) {
  5       final int [] dist = new int [G.size()];  // shortest known distance from "s"
  6       final int [] pred = new int [G.size()];  // preceeding node in path
  7       final boolean [] visited = new boolean [G.size()]; // all false initially
  8 
  9       for (int i=0; i<dist.length; i++) {
 10          dist[i] = Integer.MAX_VALUE;
 11       }
 12       dist[s] = 0;
 13 
 14       for (int i=0; i<dist.length; i++) {
 15          final int next = minVertex (dist, visited);
 16          visited[next] = true;
 17 
 18          // The shortest path to next is dist[next] and via pred[next].
 19 
 20          final int [] n = G.neighbors (next);
 21          for (int j=0; j<n.length; j++) {
 22             final int v = n[j];
 23             final int d = dist[next] + G.getWeight(next,v);
 24             if (dist[v] > d) {
 25                dist[v] = d;
 26                pred[v] = next;
 27             }
 28          }
 29       }
 30       return pred;  // (ignore pred[s]==0!)
 31    }
 32 
 33    private static int minVertex (int [] dist, boolean [] v) {
 34       int x = Integer.MAX_VALUE;
 35       int y = -1;   // graph not connected, or no unvisited vertices
 36       for (int i=0; i<dist.length; i++) {
 37          if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
 38       }
 39       return y;
 40    }
 41 
 42    public static void printPath (WeightedGraph G, int [] pred, int s, int e) {
 43       final java.util.ArrayList path = new java.util.ArrayList();
 44       int x = e;
 45       while (x!=s) {
 46          path.add (0, G.getLabel(x));
 47          x = pred[x];
 48       }
 49       path.add (0, G.getLabel(s));
 50       System.out.println (path);
 51    }
 52 
 53 }
