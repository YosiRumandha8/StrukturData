package HashTable.HashTable;

public class DirectHash {
    
    private int[] table; // Array digunakan untuk menyimpan sebuah data dengan indeks sesuai nilainya
    public DirectHash(int size) {
        table = new int[size]; // Membuat array dengan ukuran yang tertentu
    }

    // Fungsi yang digunakan untuk memasukkan nilai ke dalam tabel hash 
    public void insert(int value) {
        table[value] = value; // Menyimpan nilai ke dalam array 
        System.out.println("Data: " + value + " dimasukkan ke indeks: " + value);
    }

    // Fungsi yang digunakan untuk mencari nilai dalam tabel hash 
    public int search(int value) {
        if (table[value] == value) {
            return table[value]; // Mengembalikan nilai jika ditemukan pada indeks yang sesuai
        }
        return -1; // Mengembalikan -1 jika nilai tidak ditemukan
    }

    // Untuk menjalankan atau running-an dari sebuah program
    public static void main(String[] args) {
        
        DirectHash directHash = new DirectHash(200); // Membuat objek tabel hash  dengan ukuran 200

        // Memasukkan beberapa nilai ke dalam tabel hash 
        directHash.insert(9);
        directHash.insert(50);
        directHash.insert(100);

        // Mencari dan menampilkan hasil pencarian beberapa nilai dalam tabel hash langsung
        System.out.println("Hasil pencarian nilai 9 di indeks: " + directHash.search(9));  // Seharusnya mengembalikan 9
        System.out.println("Hasil pencarian nilai 50 di indeks: " + directHash.search(50));  // Seharusnya mengembalikan 50
        System.out.println("Hasil pencarian nilai 100 di indeks: " + directHash.search(100));  // Seharusnya mengembalikan 100
        System.out.println("Hasil pencarian nilai 150 di indeks: " + directHash.search(150));  // Seharusnya mengembalikan -1 (tidak ditemukan)
    }
}