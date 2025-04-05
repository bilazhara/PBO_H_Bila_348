// kelas rekening bank
class RekeningBank {
    // ada 3 atribut
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    //  untuk menginisialisasi objek dengan nilai-nilai awal yang diberikan saat pembuatan objek baru
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // untuk menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.printf("Saldo: Rp%.1f%n", saldo);
        System.out.println();
    }

    // proses untuk setor uang
    public void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.printf("%s menyetor Rp%.1f. Saldo sekarang: Rp%.1f%n", namaPemilik, jumlah, saldo);
    }

    // metode untuk menarik uang
    public void tarikUang(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.printf("%s menarik Rp%.1f. (Berhasil) Saldo sekarang: Rp%.1f%n", namaPemilik, jumlah, saldo);
        } else {
            System.out.printf("%s menarik Rp%.1f. (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp%.1f%n", namaPemilik, jumlah, saldo);
        }
        System.out.printf(""); // Jeda antar transaksi
    }
}

// kelas main
public class Main {
    public static void main(String[] args) {
        // ada 2 objek untuk rekening kita dan rekening tean kita
        RekeningBank rekening1 = new RekeningBank("202410370110348", "Salsabila Ayu Azhara", 500000);
        RekeningBank rekening2 = new RekeningBank("202410370110363", "Clara Olivia Ekawati", 1000000);

        // menampilkan informasi
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // melakukan setor uang
        rekening1.setorUang(200000);
        rekening2.setorUang(500000);
        System.out.println();

        // transaksi untuk menarik uang
        rekening1.tarikUang(800000);
        rekening2.tarikUang(300000);
        System.out.println();

        // memberikan informasi untuk terakhir
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}