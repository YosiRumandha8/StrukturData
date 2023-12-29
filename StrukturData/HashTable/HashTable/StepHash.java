package HashTable.HashTable;

public class StepHash {

    private int[] table;
    private int step = 1;

    // Konstruktor untuk inisialisasi tabel hash
    public StepHash(int size) {
        table = new int[size];
    }

    // Metode untuk menyisipkan nilai ke dalam tabel hash
    public void insert(int value) {
        int index = value % table.length; 
        while (table[index] != 0) {
            System.out.println("Terjadi collision pada key: " + index);
            index = (index + step) % table.length; 
            System.out.println("Index digeser ke: " + index);
        }
        table[index] = value; 
        System.out.println("Data dimasukkan ke dalam index: " + index);
    }

    // Metode untuk mencari nilai dalam tabel hash
    public int search(int value) {
        int index = value % table.length; 
        while (table[index] != 0) {
            if (table[index] == value) {
                return index; 
            }
            index = (index + step) % table.length; 
        }
        return -1; 
    }

    public static void main(String[] args) {
        // Membuat objek StepHash dengan ukuran tabel 10
        StepHash stepHash = new StepHash(10);

        // Menyisipkan beberapa nilai ke dalam tabel hash
        stepHash.insert(9);
        stepHash.insert(9);
        stepHash.insert(8);
        stepHash.insert(50);

        // Mencari indeks dari beberapa nilai dalam tabel hash
        System.out.println("Hasil pencarian nilai 9 di Index: " + stepHash.search(9));  
        System.out.println("Hasil pencarian nilai 50 di Index: " + stepHash.search(50));  
        System.out.println("Hasil pencarian nilai 8 di Index: " + stepHash.search(8));  
        System.out.println("Hasil pencarian nilai 200 di Index: " + stepHash.search(200));  
    }
}
