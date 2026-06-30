public class Graph {

    private int vertices;
    private int[][] graph;

    public Graph(int vertices) {
        this.vertices = vertices;
        graph = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination, int weight) {
        graph[source][destination] = weight;
    }

    public int[][] getGraph() {
        return graph;
    }

    public int getVertices() {
        return vertices;
    }
}