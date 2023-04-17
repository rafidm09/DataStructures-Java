package test;
import main.java.myLib.graphalgo.Graph;
public class GraphAlgoTest {
    public static void main(String[] args) {
        Graph graph = new Graph(0);

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 4, 5);
        graph.addEdge(4, 5, 6);

        boolean[] visited = new boolean[graph.order];
        System.out.println("DFS:");
        graph.dfs(1, visited);
        System.out.println();

        System.out.println("BFS:");
        graph.bfs(1);
        System.out.println();

        System.out.println("Dijkstra's:");
        graph.dijkstra(1);
    }
}
