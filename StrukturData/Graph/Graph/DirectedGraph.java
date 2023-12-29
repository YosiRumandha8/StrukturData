package Graph.Graph;
import java.util.*;

// Untuk merepresentasikan graph berarah
class DirectedGraph {
    private Map<String, List<String>> adjacencyList;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();  //Digunakan untuk menyimppan daftar node  
    }

    //Untuk menambahkan node baru kedalam graph
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    //Untuk menambahkan sisi
    public void addEdge(String source, String destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        adjacencyList.get(source).add(destination);
    }

    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    // Unuk menjalankan sebuah program
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        //Digunakan untuk mencetak graph
        graph.printGraph();
    }
}
