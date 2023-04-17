package main.java.myLib.graphalgo;
import java.util.*;
public class Graph {
    public int order; // number of vertices
    public int size; // number of edges
    public int[][] adjacencyMatrix; // adjacency matrix representation
    public List<List<Pair<Integer, Integer>>> adjacencyList; // adjacency list representation

    // Default constructor for an empty graph
    public Graph() {
        this.order = 0;
        this.size = 0;
        this.adjacencyMatrix = new int[0][0];
        this.adjacencyList = new ArrayList<>();
    }

    // Overloaded constructor to initialize first node of the graph
    public Graph(int firstNode) {
        this.order = 1;
        this.size = 0;
        this.adjacencyMatrix = new int[1][1];
        this.adjacencyList = new ArrayList<>();
        this.adjacencyList.add(new ArrayList<>());
        addVertex(firstNode);
    }

    // Add a new vertex to the graph
    public void addVertex(int vertex) {
        if (!adjacencyList.isEmpty() && adjacencyList.size() < order + 1) {
            // If using adjacency list, ensure size is sufficient
            adjacencyList.add(new ArrayList<>());
        }
        if (adjacencyMatrix.length < order + 1) {
            // If using adjacency matrix, ensure size is sufficient
            int[][] newMatrix = new int[order + 1][order + 1];
            for (int i = 0; i < order; i++) {
                System.arraycopy(adjacencyMatrix[i], 0, newMatrix[i], 0, order);
            }
            adjacencyMatrix = newMatrix;
        }
        order++;
    }

    // Add an edge between two vertices
    public void addEdge(int source, int destination, int weight) {
        if (source < 0 || source >= order || destination < 0 || destination >= order) {
            throw new IllegalArgumentException("Invalid vertex index");
        }
        if (adjacencyMatrix[source][destination] == 0) {
            size++;
        }
        adjacencyMatrix[source][destination] = weight;
        adjacencyList.get(source).add(new Pair<>(destination, weight));
    }

    // Perform a depth-first search traversal of the graph
    public void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (Pair<Integer, Integer> edge : adjacencyList.get(vertex)) {
            int nextVertex = edge.getKey();
            if (!visited[nextVertex]) {
                dfs(nextVertex, visited);
            }
        }
    }

    // Perform a breadth-first search traversal of the graph
    public void bfs(int start) {
        boolean[] visited = new boolean[order];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (Pair<Integer, Integer> edge : adjacencyList.get(vertex)) {
                int nextVertex = edge.getKey();
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }

    // Find the shortest path using Dijkstra's algorithm
    public void dijkstra(int start) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        int[] distance = new int[order];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Pair<>(start, 0));
        while (!pq.isEmpty()) {
            int vertex = pq.poll().getKey();
            for (Pair<Integer, Integer> edge : adjacencyList.get(vertex)) {
                int nextVertex = edge.getKey();
                int weight = edge.getValue();
                if (distance[vertex] + weight < distance[nextVertex]) {
                    distance[nextVertex] = distance[vertex] + weight;
                    pq.add(new Pair<>(nextVertex, distance[nextVertex]));
                }
            }
        }
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < order; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }
}
