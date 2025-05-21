package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login() {
        return nama.equalsIgnoreCase("Salsabila Ayu Azhara") && nim.equals("202410370110348");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelamat datang, " + nama + "!");
        while (true) {
            System.out.println("\nMenu Mahasiswa");
            System.out.println("1️ Laporkan Barang Temuan/Hilang");
            System.out.println("2️ Lihat Daftar Laporan");
            System.out.println("0️ Logout");
            System.out.print(" -- > Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout berhasil. Terima kasih telah menggunakan sistem kami.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public void reportItem() {
        System.out.println(">> Fitur Laporkan Barang Belum Tersedia <<");
    }

    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
}