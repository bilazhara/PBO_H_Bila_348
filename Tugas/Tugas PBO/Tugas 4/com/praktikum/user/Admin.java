package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login() {
        return username.equals("admin348") && password.equals("password348") &&
                nama.equalsIgnoreCase("Salsabila Ayu Azhara") && nim.equals("202410370110348");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelamat datang kembali, Admin " + nama + "!");
        while (true) {
            System.out.println("\nMenu Utama Admin");
            System.out.println("1️ Kelola Laporan Barang");
            System.out.println("2️ Kelola Data Mahasiswa");
            System.out.println("0️ Logout");
            System.out.print(" -- > Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Logout berhasil. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}
