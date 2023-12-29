package Graph.Graph;

import java.util.*;

class UndirectedGraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi graf
    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Methode untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Methode untuk menambahkan edge (sambungan) antara dua node
    public void addEdge(String source, String destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Methode untuk mengembalikan daftar tetangga dari suatu node
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Methode untuk menampilkan struktur graph beserta hubungan antar node
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Methode untuk membuat objek graf
        UndirectedGraph graph = new UndirectedGraph();

        // Methode untuk menambahkan node-node ke dalam graph
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge antara node-node
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Methode untuk menampilkan struktur graf
        graph.printGraph();
    }
}
