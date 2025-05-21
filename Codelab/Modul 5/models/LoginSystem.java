package com.praktikum.models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {
    // ArrayList untuk menyimpan semua user
    public static ArrayList<User> userList = new ArrayList<>();

    // ArrayList untuk menyimpan item yang dilaporkan
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void initializeDefaultData() {
        // Tambahkan admin default
        Admin admin = new Admin("admin348", "password348");
        userList.add(admin);

        // Tambahkan mahasiswa default
        Mahasiswa mahasiswa = new Mahasiswa("Salsabila Ayu Azhara", "202410370110348");
        userList.add(mahasiswa);

    }

    public static User login(String usernameOrName, String passwordOrNim) {
        for (User user : userList) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equals(usernameOrName) && admin.getPassword().equals(passwordOrNim)) {
                    return admin;
                }
            } else if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getUsername().equals(usernameOrName) && mahasiswa.getNim().equals(passwordOrNim)) {
                    return mahasiswa;
                }
            }
        }
        return null; // Jika pengguna tidak ditemukan
    }

    public static void main(String[] args) {

        initializeDefaultData();

        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("\n===== SISTEM PELAPORAN BARANG HILANG/TEMUAN =====");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        loginAsAdmin(scanner);
                        break;
                    case 2:
                        loginAsMahasiswa(scanner);
                        break;
                    case 3:
                        System.out.println("Terima kasih telah menggunakan sistem pelaporan barang hilang/temuan!");
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("Menu tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void loginAsAdmin(Scanner scanner) {
        System.out.println("\n===== LOGIN ADMIN =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = login(username, password);

        if (user != null && user instanceof Admin) {
            System.out.println("Login berhasil sebagai Admin!");
            user.displayMenu();
        } else {
            System.out.println("Username atau password admin salah!");
        }
    }

    private static void loginAsMahasiswa(Scanner scanner) {
        System.out.println("\n===== LOGIN MAHASISWA =====");
        System.out.print("Nama: ");
        String name = scanner.nextLine();

        System.out.print("NIM: ");
        String nim = scanner.nextLine();

        User user = login(name, nim);

        if (user != null && user instanceof Mahasiswa) {
            System.out.println("Login berhasil sebagai Mahasiswa!");
            user.displayMenu();
        } else {
            System.out.println("Nama atau NIM mahasiswa salah!");
        }
    }
}