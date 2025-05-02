import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Buku nonFiksi = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku fiksi = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        System.out.println("========== DAFTAR BUKU ==========");
        nonFiksi.displayInfo();
        fiksi.displayInfo();

        System.out.println("\n========== DATA ANGGOTA ==========");
        Anggota anggota1 = new Anggota("Salsabila Ayu Azhara", "H 348");
        Anggota anggota2 = new Anggota("Clara Olivia Ekawati", "H 363");

        anggota1.display();
        anggota2.display();

        System.out.println("\n========== AKSI PEMINJAMAN ==========");
        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);

        System.out.println("\n========== AKSI PENGEMBALIAN ==========");
        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");

        System.out.println("\n========== STATUS ==========");
        System.out.println("Process finished with exit code 0");
    }
}
