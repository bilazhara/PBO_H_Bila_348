// Kelas Hewan
class Hewan {
    // Atribut-atribut
    private String nama;
    private String jenis;
    private String suara;

    // Konstruktor
    public Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    // Metode untuk menampilkan informasi hewan
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
        System.out.println(); // Tambahkan baris kosong untuk pemisah
    }
}

// Kelas Main
public class Main {
    public static void main(String[] args) {
        // Membuat dua objek Hewan
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Meongg~");
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Guk Guk!");

        // Memanggil metode tampilkanInfo() untuk kedua objek
        System.out.println("Informasi Hewan 1:");
        hewan1.tampilkanInfo();

        System.out.println("Informasi Hewan 2:");
        hewan2.tampilkanInfo();
    }
}
