package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang di Sistem Pelaporan Barang!");
        System.out.println("Pilih jenis pengguna:");
        System.out.println("1️ Admin");
        System.out.println("2️ Mahasiswa");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        User user = null;

        if (pilihan == 1) {
            System.out.print("Nama lengkap: ");
            String nama = scanner.nextLine();
            System.out.print("NIM         : ");
            String nim = scanner.nextLine();
            System.out.print("Username    : ");
            String username = scanner.nextLine();
            System.out.print("Password    : ");
            String password = scanner.nextLine();

            user = new Admin(nama, nim, username, password);

            if (user.login()) {
                System.out.println("Login Admin Berhasil");
                System.out.println("NAMA : " + nama);
                System.out.println("NIM  : " + nim);
                user.displayAppMenu();
            } else {
                System.out.println("Login gagal. Cek kembali data Anda.");
            }

        } else if (pilihan == 2) {
            System.out.print("Nama lengkap: ");
            String nama = scanner.nextLine();
            System.out.print("NIM         : ");
            String nim = scanner.nextLine();

            user = new Mahasiswa(nama, nim);

            if (user.login()) {
                System.out.println("Login Mahasiswa Berhasil");
                System.out.println("NAMA : " + nama);
                System.out.println("NIM  : " + nim);
                user.displayAppMenu();
            } else {
                System.out.println("Data Mahasiswa tidak ditemukan.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}
