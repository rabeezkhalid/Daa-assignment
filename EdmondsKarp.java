import java.util.LinkedList;
import java.util.Queue;

public class EdmondsKarp {

    private Graph graph;
    private int[][] residual;

    public EdmondsKarp(Graph graph) {
        this.graph = graph;
    }

    private boolean bfs(int[][] residual, int source, int sink, int[] parent) {

        boolean[] visited = new boolean[graph.getVertices()];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (int v = 0; v < graph.getVertices(); v++) {

                if (!visited[v] && residual[u][v] > 0) {

                    queue.offer(v);
                    visited[v] = true;
                    parent[v] = u;
                }
            }
        }

        return visited[sink];
    }

    private void dfs(int node, boolean[] visited) {

        visited[node] = true;

        for (int i = 0; i < graph.getVertices(); i++) {

            if (residual[node][i] > 0 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public int maxFlow(int source, int sink) {

        int V = graph.getVertices();

        residual = new int[V][V];

        int[][] capacity = graph.getCapacity();

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                residual[i][j] = capacity[i][j];

        int[] parent = new int[V];

        int maxFlow = 0;

        while (bfs(residual, source, sink, parent)) {

            int pathFlow = Integer.MAX_VALUE;

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];

                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }
    public void printMinCut(int source) {

        boolean[] visited = new boolean[graph.getVertices()];

        dfs(source, visited);

        int[][] capacity = graph.getCapacity();

        System.out.println("\nMinimum Edge Cut:");

        for (int i = 0; i < graph.getVertices(); i++) {

            for (int j = 0; j < graph.getVertices(); j++) {

                if (visited[i] && !visited[j] && capacity[i][j] > 0) {

                    System.out.println(i + " -> " + j +
                            " Capacity = " + capacity[i][j]);
                }
            }
        }
    }
}