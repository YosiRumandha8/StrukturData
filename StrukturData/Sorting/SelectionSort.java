package Sorting;

public class SelectionSort {

    // Fungsi yang digunakan  untuk melakukan pengurutan seleksi pada array
    public static int[] selectionSort(int[] array) {
        int ukuran = array.length; // Mendapatkan panjang array
        while (ukuran > 0) {
            int max = 0; // Untuk menyimpan indeks elemen maksimum
            for (int i = 1; i < ukuran; i++) {
                // Digunakan untuk mencari elemen terbesar dalam sebuah array
                if (array[max] < array[i]) {
                    max = i; // Untuk memperbarui indeks elemen maksimum
                }
            }

            // Menukar elemen terbesar dengan elemen terakhir dalam array
            int temp = array[max];
            array[max] = array[ukuran - 1];
            array[ukuran - 1] = temp;
            ukuran--; // Mengurangi ukuran array dikarenakan elemen terbesar sudah benar
        }
        return array; // Untuk mengembalikan array
    }

    //Untuk menjalankan sebuah program
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90}; // Array awal yang akan diurutkan
        int[] sortedArray = selectionSort(array); // Memanggil fungsi pengurutan seleksi

        // Untuk menampilkan hasil array yang telah diurutkan secara menurun
        System.out.println("Sorted array in descending order:");
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}