public class Graph {

    private int vertices;
    private int[][] capacity;

    public Graph(int vertices) {
        this.vertices = vertices;
        capacity = new int[vertices][vertices];
    }

    public void addEdge(int from, int to, int cap) {
        capacity[from][to] = cap;
    }

    public int[][] getCapacity() {
        return capacity;
    }

    public int getVertices() {
        return vertices;
    }
}