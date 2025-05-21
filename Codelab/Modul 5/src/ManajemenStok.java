import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n>>>> Menu Manajemen Stok <<<<");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (pilihan) {
                    case 1:
                        tambahBarang(scanner, daftarBarang);
                        break;
                    case 2:
                        tampilkanBarang(daftarBarang);
                        break;
                    case 3:
                        kurangiStok(scanner, daftarBarang);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Terima kasih! Program berakhir.");
                        break;
                    default:
                        System.out.println("Opsi tidak valid! Silakan pilih 0-3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void tambahBarang(Scanner scanner, ArrayList<Barang> daftarBarang) {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();

        try {
            System.out.print("Masukkan stok awal: ");
            int stok = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            daftarBarang.add(new Barang(nama, stok));
            System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("Input stok harus berupa angka!");
            scanner.nextLine();
        }
    }

    private static void tampilkanBarang(ArrayList<Barang> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
            return;
        }

        System.out.println("--- Daftar Barang ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.println(i + ". Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
        }
    }

    private static void kurangiStok(Scanner scanner, ArrayList<Barang> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
            return;
        }

        System.out.println("--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.println(i + ". Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
        }

        try {
            System.out.print("Masukkan nomor indeks barang: ");
            int indeks = scanner.nextInt();

            if (indeks < 0 || indeks >= daftarBarang.size()) {
                throw new IndexOutOfBoundsException("Indeks tidak valid!");
            }

            Barang barang = daftarBarang.get(indeks);

            System.out.print("Masukkan jumlah stok yang akan diambil: ");
            int jumlahDiambil = scanner.nextInt();
            scanner.nextLine();

            if (jumlahDiambil > barang.getStok()) {
                throw new StokTidakCukupException("Stok untuk " + barang.getNama() +
                        " hanya tersisa " + barang.getStok());
            }

            barang.setStok(barang.getStok() - jumlahDiambil);
            System.out.println("Stok barang '" + barang.getNama() + "' berhasil dikurangi. Sisa stok: " +
                    barang.getStok());

        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine(); // Clear buffer
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StokTidakCukupException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}