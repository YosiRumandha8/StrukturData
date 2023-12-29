package Graph.Graph;

import java.util.*;

//Untuk merepresentasikan sisi dari graph 
class Edge implements Comparable<Edge> {
    String source;       
    String destination;  
    int weight;          

    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

//Fungsi Utama
public class KruskalGraphTraversal {
    private List<Edge> edges = new ArrayList<>(); 
    private Map<String, String> parent = new HashMap<>(); 

    
    public void addEdge(String source, String destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public String find(String node) {
        if (!parent.containsKey(node)) {
            parent.put(node, node);
        }

        if (!parent.get(node).equals(node)) {
            parent.put(node, find(parent.get(node)));
        }

        return parent.get(node);
    }

    
    public void union(String node1, String node2) {
        String parent1 = find(node1);
        String parent2 = find(node2);
        parent.put(parent1, parent2);
    }

    
    public void kruskalMST() {
        Collections.sort(edges); 

        int mstWeight = 0; 
        for (Edge edge : edges) {
            String root1 = find(edge.source);
            String root2 = find(edge.destination);

            
            if (!root1.equals(root2)) {
                System.out.println(edge.source + " - " + edge.destination + " [" + edge.weight + "]");
                mstWeight += edge.weight;
                union(edge.source, edge.destination);
            }
        }

        System.out.println("Total bobot MST: " + mstWeight);
    }

    //Untuk menjalankan sebuah program  
    public static void main(String[] args) {
        KruskalGraphTraversal graph = new KruskalGraphTraversal();
        
        
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("B", "E", 10);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        
        graph.kruskalMST();
    }

}