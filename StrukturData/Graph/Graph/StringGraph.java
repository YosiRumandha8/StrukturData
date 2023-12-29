package Graph.Graph;

import java.util.*;

class StringGraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi graph
    public StringGraph() {
        adjacencyList = new HashMap<>();
    }

    // Untuk menambahkan node baru ke dalam graph
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Untuk menambahkan edge ke dalam graph
    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // Untuk graf tidak terarah
    }

    // Method untuk mencetak graph
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    // Untuk menjalankan atau running-an dari sebuah program

    public static void main(String[] args) {
        StringGraph graph = new StringGraph();

        // Untuk menambahkan node ke dalam graph
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Untuk menambahkan edge ke dalam graph
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Untuk mencetak graph
        graph.printGraph();
    }
}