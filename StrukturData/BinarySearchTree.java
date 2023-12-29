class Node {
    int data;        // Nilai node dengan tipe data integer
    Node left, right; // Referensi ke kiri dan kanan

    // node baru dengan nilai awal atau null
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Kelas untuk merepresentasikan Binary Search Tree
public class BinarySearchTree {
    Node root;  // digunakan untuk menyimpan referensi ke akar pohon

    
    public Node insert(Node root, int data) {
        // digunakan apabila ada pohon kosong dan membuat node baru sebagai akar
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Apabila data kurang dari nilai pada node saat ini menyimpan ke kiri
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        // Apabila data lebih besar maka menyimpan ke kanan
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // untuk mencetak struktur pohon
    public void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            // mencetak nilai node 
            System.out.println(indent + "+-- " + node.data);

            //digunakan untuk memodifikasi
            indent += last ? "    " : "|   ";

            // mencetak anak dari kiri
            printTree(node.right, indent, false);
            printTree(node.left, indent, true);
        }
    }

    // untuk run atau menjalankan
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();  // Objek BST baru

        // Membangun struktur BST sesuai dengan contoh
        //        50
        //      /    \
        //     30     70
        //    /  \   /  \
        //   10  35 65   80
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        // Mencetak struktur pohon 
        bst.printTree(bst.root, "", true);
    }
}