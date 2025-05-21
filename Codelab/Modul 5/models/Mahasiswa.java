package com.praktikum.models;

import java.util.InputMismatchException; // kelas pengecualian
import java.util.Scanner;

public class Mahasiswa extends User {
    private String nim;

    public Mahasiswa(String name, String nim) {
        super(name, ""); // Untuk mahasiswa, username adalah nama
        this.nim = nim;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean logout = false;

        while (!logout) {
            System.out.println("\n===== MAHASISWA MENU =====");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Barang yang Dilaporkan");
            System.out.println("3. Logout");
            System.out.print("Pilih menu (1-3): ");

            try { // menangani error biar program ga lsg berhenti
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        reportItem(scanner);
                        break;
                    case 2:
                        viewReportedItems();
                        break;
                    case 3:
                        System.out.println("Anda telah logout...");
                        logout = true;
                        break;
                    default:
                        System.out.println("Menu tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
    }

    private void reportItem(Scanner scanner) {
        System.out.println("\n===== LAPORKAN BARANG =====");

        System.out.print("Nama Barang: ");
        String itemName = scanner.nextLine();

        System.out.print("Deskripsi: ");
        String description = scanner.nextLine();

        System.out.print("Lokasi: ");
        String location = scanner.nextLine();

        // Buat objek Item baru
        Item newItem = new Item(itemName, description, location);

        // Tambahkan ke ArrayList
        LoginSystem.reportedItems.add(newItem);

        System.out.println("Barang berhasil dilaporkan!");
    }

    private void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("\n===== DAFTAR BARANG YANG DILAPORKAN =====");
        System.out.println("No. | Nama Barang | Deskripsi | Lokasi");
        System.out.println("------------------------------------------");

        int index = 1;
        boolean foundReportedItems = false;

        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equals(item.getStatus())) {
                System.out.printf("%d. | %s | %s | %s\n", // integer, teks, baris baru
                        index++, item.getItemName(), item.getDescription(), item.getLocation());
                foundReportedItems = true;
            }
        }

        if (!foundReportedItems) {
            System.out.println("Tidak ada barang dengan status 'Reported'.");
        }
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}