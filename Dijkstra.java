import java.util.Arrays;

public class Dijkstra {

    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    private int minDistance(int[] distance, boolean[] visited) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < graph.getVertices(); i++) {

            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public void shortestPath(int source) {

        int V = graph.getVertices();
        int[] parent = new int[V];
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(distance, Integer.MAX_VALUE);

        Arrays.fill(parent, -1);
        distance[source] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(distance, visited);

            visited[u] = true;

            for (int v = 0; v < V; v++) {

                if (!visited[v]
                        && graph.getGraph()[u][v] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph.getGraph()[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph.getGraph()[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Vertex\tDistance from Source");

        for (int i = 0; i < V; i++) {

            System.out.println(i + "\t\t" + distance[i]);
        }

        System.out.println("\nShortest Path Tree:");

        for (int i = 0; i < V; i++) {

            if (parent[i] != -1) {
                System.out.println(parent[i] + " -> " + i +
                        " (Weight = " + graph.getGraph()[parent[i]][i] + ")");
            }
        }
    }
}