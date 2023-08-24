import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);
        for (int v : adjacencyList.keySet()) {
            List<Integer> neighbors = adjacencyList.get(v);
            while (neighbors.contains(vertex)) {
                neighbors.remove((Integer) vertex);
            }
        }
    }

    public void addEdge(int source, int destination) {
        if (adjacencyList.containsKey(source)) {
            List<Integer> neighbors = adjacencyList.get(source);
            if (!neighbors.contains(destination)) {
                neighbors.add(destination);
            }
        } else {
            List<Integer> neighbors = new ArrayList<>();
            neighbors.add(destination);
            adjacencyList.put(source, neighbors);
        }
    }

    public void printGraph() {
        for (int vertex : adjacencyList.keySet()) {
            List<Integer> neighbors = adjacencyList.get(vertex);
            System.out.print(vertex + ": ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Graph Operations:");
            System.out.println("1. Add vertex");
            System.out.println("2. Remove vertex");
            System.out.println("3. Add edge");
            System.out.println("4. Print graph");
            System.out.println("5. Exit");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter vertex to add:");
                    int vertex = scanner.nextInt();
                    graph.addVertex(vertex);
                    graph.printGraph();
                    break;
                case 2:
                    System.out.println("Enter vertex to remove:");
                    vertex = scanner.nextInt();
                    graph.removeVertex(vertex);
                    graph.printGraph();
                    break;
                case 3:
                    System.out.println("Enter source vertex:");
                    int source = scanner.nextInt();
                    System.out.println("Enter destination vertex:");
                    int destination = scanner.nextInt();
                    graph.addEdge(source, destination);
                    graph.printGraph();
                    break;
                case 4:
                    graph.printGraph();
                    graph.printGraph();
                    break;
                case 5:
                    System.exit(0);
                    graph.printGraph();
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}