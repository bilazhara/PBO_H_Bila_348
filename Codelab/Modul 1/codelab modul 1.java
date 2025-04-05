import java.util.Scanner;
import java.time.LocalDate;

class SistemLogin {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // menginstall scanner untuk input

        String nama = getInput(scanner, "Masukkan Nama: "); // mendapatkan data pengguna

        char jenisKelaminInput = getGenderInput(scanner);

        int tahunLahir = getBirthYearInput(scanner);

        int umur = calculateAge(tahunLahir); // menghitung umur pengguna

        String jenisKelamin = convertGenderCode(jenisKelaminInput);

        displayUserInfo(nama, jenisKelamin, umur); // menampilkan hasil inputan

        scanner.close(); // menutup scanner
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // untuk mendapatkan input jenis kelamin
    private static char getGenderInput(Scanner scanner) {
        System.out.print("Masukkan Jenis Kelamin (L/P): ");
        char input = scanner.next().charAt(0);
        scanner.nextLine();
        return input;
    }

    // untuk mendapatkan input tahun lahir
    private static int getBirthYearInput(Scanner scanner) {
        System.out.print("Masukkan Tahun Lahir: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Harap masukkan tahun lahir dalam bentuk angka!");
            scanner.next();
        }
        int tahun = scanner.nextInt();
        scanner.nextLine();
        return tahun;
    }

    // untuk menghitung umur pengguna
    private static int calculateAge(int tahunLahir) {
        return LocalDate.now().getYear() - tahunLahir;
    }

    // untuk membaca jenis kelamin pengguna
    private static String convertGenderCode(char code) {
        switch (Character.toUpperCase(code)) {
            case 'L':
                return "Laki-laki";
            case 'P':
                return "Perempuan";
            default:
                return "Tidak diketahui";
        }
    }

    // menampilkan informasi yang telah di inputkan pengguna
    private static void displayUserInfo(String nama, String jenisKelamin, int umur) {
        System.out.println("\n=== Data Pengguna ===");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur: " + umur + " tahun");
    }
}