public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(7);

        graph.addEdge(0,1,3);
        graph.addEdge(0,3,3);
        graph.addEdge(1,2,4);
        graph.addEdge(2,0,3);
        graph.addEdge(2,4,2);
        graph.addEdge(2,3,1);
        graph.addEdge(3,4,2);
        graph.addEdge(3,5,6);
        graph.addEdge(4,1,1);
        graph.addEdge(4,6,1);
        graph.addEdge(5,6,9);

        EdmondsKarp ek = new EdmondsKarp(graph);

        int maxFlow = ek.maxFlow(0,5);

        System.out.println("Maximum Flow = " + maxFlow);

        ek.printMinCut(0);
    }
}