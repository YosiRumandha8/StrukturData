import java.util.ArrayList;
import java.util.Scanner;

// Kelas Mahasiswa untuk merepresentasikan data mahasiswa
class Mahasiswa {
    private String nim;      
    private String nama;     
    private String jurusan;  

    // Konstruktor untuk membuat objek Mahasiswa
    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // Methode Getter untuk mendapatkan NIM dari Mahasiswa
    public String getNim() {
        return nim;
    }

    // Methode Getter untuk mendapatkan Nama dari Mahasiswa
    public String getNama() {
        return nama;
    }

    // Methode Getter untuk mendapatkan Jurusan dari Mahasiswa
    public String getJurusan() {
        return jurusan;
    }

    // Methode untuk memberikan representasi string dari objek Mahasiswa
    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Jurusan: " + jurusan;
    }
}

// Kelas DataMahasiswa untuk mengelola data mahasiswa
public class DataMahasiswa {

    // Methode pencarian data dengan menggunakan Sequential Search
    public static int sequentialSearch(ArrayList<Mahasiswa> list, String nimTarget) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNim().equals(nimTarget)) {
                return i;
            }
        }
        return -1;
    }

    // Methodepencarian data dengan menggunakan Binary Search
    public static int binarySearch(ArrayList<Mahasiswa> list, String nimTarget) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).getNim().compareTo(nimTarget) < 0) {
                low = mid + 1;
            } else if (list.get(mid).getNim().compareTo(nimTarget) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Methode pencarian data dengan menggunakan Interpolation Search
    public static int interpolationSearch(ArrayList<Mahasiswa> list, String nimTarget) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high && nimTarget.compareTo(list.get(low).getNim()) >= 0 && nimTarget.compareTo(list.get(high).getNim()) <= 0) {
            int position = low + (((int) (high - low) / (list.get(high).getNim().compareTo(list.get(low).getNim())))
                                * (nimTarget.compareTo(list.get(low).getNim()) - low));
            if (list.get(position).getNim().compareTo(nimTarget) < 0) {
                low = position + 1;
            } else if (list.get(position).getNim().compareTo(nimTarget) > 0) {
                high = position - 1;
            } else {
                return position;
            }
        }
        return -1;
    }

    // Methode yang digunakan untuk menampilkan header tabel dari data mahasiswa
    public static void tampilkanHeaderTabel() {
        System.out.printf("+--------------+---------------------+--------------------+%n");
        System.out.printf("|     NIM      |         Nama        |      Jurusan       |%n");
        System.out.printf("+--------------+---------------------+--------------------+%n");
    }

    // Fungsi utama program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>(); // List untuk menyimpan data mahasiswa

        boolean continueInput = true;

        // Loop utama program
        while (continueInput) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Semua Data Mahasiswa");
            System.out.println("3. Hapus Data Mahasiswa");
            System.out.println("4. Pencarian Mahasiswa (Sequential Search)");
            System.out.println("5. Pencarian Mahasiswa (Binary Search)");
            System.out.println("6. Pencarian Mahasiswa (Interpolation Search)");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dari buffer

            switch (choice) {
                case 1:
                    // Menambahkan data mahasiswa baru
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan: ");
                    String jurusan = scanner.nextLine();

                    listMahasiswa.add(new Mahasiswa(nim, nama, jurusan));
                    break;
                case 2:
                    // Menampilkan semua data mahasiswa
                    tampilkanHeaderTabel();
                    for (Mahasiswa mhs : listMahasiswa) {
                        System.out.printf("| %-12s | %-19s | %-18s |%n", mhs.getNim(), mhs.getNama(), mhs.getJurusan());
                    }
                    System.out.printf("+--------------+---------------------+--------------------+%n");
                    break;
                case 3:
                    // Menghapus data mahasiswa berdasarkan indeks
                    System.out.print("Masukkan indeks data mahasiswa yang ingin dihapus: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < listMahasiswa.size()) {
                        listMahasiswa.remove(index);
                        System.out.println("Data mahasiswa pada indeks " + index + " telah dihapus.");
                    } else {
                        System.out.println("Indeks tidak valid.");
                    }
                    break;
                case 4:
                    // Pencarian menggunakan Sequential Search
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimSeq = scanner.nextLine();
                    int indexSeq = sequentialSearch(listMahasiswa, nimSeq);
                    if (indexSeq != -1) {
                        System.out.println("Data ditemukan pada indeks " + indexSeq);
                        System.out.println(listMahasiswa.get(indexSeq));
                    } else {
                        System.out.println("Data dengan NIM " + nimSeq + " tidak ditemukan.");
                    }
                    break;
                case 5:
                    // Pencarian menggunakan Binary Search
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimBin = scanner.nextLine();
                    int indexBin = binarySearch(listMahasiswa, nimBin);
                    if (indexBin != -1) {
                        System.out.println("Data ditemukan pada indeks " + indexBin);
                        System.out.println(listMahasiswa.get(indexBin));
                    } else {
                        System.out.println("Data dengan NIM " + nimBin + " tidak ditemukan.");
                    }
                    break;
                case 6:
                    // Pencarian dengan menggunakan Interpolation Search
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimInt = scanner.nextLine();
                    int indexInt = interpolationSearch(listMahasiswa, nimInt);
                    if (indexInt != -1) {
                        System.out.println("Data ditemukan pada indeks " + indexInt);
                        System.out.println(listMahasiswa.get(indexInt));
                    } else {
                        System.out.println("Data dengan NIM " + nimInt + " tidak ditemukan.");
                    }
                    break;
                case 7:
                    // Keluar dari program
                    continueInput = false;
                    break;
                default:
                    // Pilihan tidak valid
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
        System.out.println("Terima kasih telah menggunakan program ini.");
    }
}