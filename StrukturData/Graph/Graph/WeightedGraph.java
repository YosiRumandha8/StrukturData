package Graph.Graph;

import java.util.*;
class Edge {
    String destination;
    int weight;

    // Konstruktor digunakan untuk inisialisasi edge berbobot
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class WeightedGraph {
    private Map<String, List<Edge>> adjacencyList;

    // Konstruktor digunakan untuk inisialisasi graf berbobot
    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Methode untuk menambahkan node baru ke dalam graph
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Methode untuk menambahkan edge yang berbobot di antara dua node
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber yang ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Menambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Methode untuk mencetak struktur graf bersama dengan bobot edge
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }
    // Unyuk menjalankan atau running-an dari sebuah program
    public static void main(String[] args) {
        // Membuat objek graf berbobot
        WeightedGraph graph = new WeightedGraph();

        // Untuk menambahkan node-node ke dalam graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Untuk menambahkan edge-edge berbobot antara node-node
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Menampilkan struktur graf bersama dengan bobot edge
        graph.printGraph();
    }
}
