import java.util.Scanner;

public class SimpleLoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih Jenis Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1/2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {

            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (username.equals("admin348") && password.equals("password348")) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (choice == 2) {

            System.out.print("Masukkan Nama: ");
            String name = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (name.equals("Salsabila Ayu Azhara") && nim.equals("202410370110348")) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + name);
                System.out.println("NIM: " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {

            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}