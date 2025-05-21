package com.praktikum.models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean logout = false;

        while (!logout) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola Pengguna");
            System.out.println("3. Logout");
            System.out.print("Pilih menu (1-3): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        manageItems(scanner);
                        break;
                    case 2:
                        manageUsers(scanner);
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

    private void manageItems(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\n===== KELOLA BARANG =====");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih menu (1-3): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        viewAllItems();
                        break;
                    case 2:
                        markItemAsClaimed(scanner);
                        break;
                    case 3:
                        back = true;
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

    private void viewAllItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("\n===== DAFTAR SEMUA BARANG =====");
        System.out.println("No. | Nama Barang | Deskripsi | Lokasi | Status");
        System.out.println("------------------------------------------------");

        int index = 0;
        for (Item item : LoginSystem.reportedItems) {
            System.out.printf("%d. | %s | %s | %s | %s\n",
                    index++, item.getItemName(), item.getDescription(),
                    item.getLocation(), item.getStatus());
        }
    }

    private void markItemAsClaimed(Scanner scanner) {
        // Cek apakah ada barang yang dilaporkan
        boolean hasReportedItems = false;

        System.out.println("\n===== BARANG YANG MASIH BERSTATUS 'REPORTED' =====");
        System.out.println("No. | Nama Barang | Deskripsi | Lokasi");
        System.out.println("------------------------------------------");

        int index = 0;
        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equals(item.getStatus())) {
                System.out.printf("%d. | %s | %s | %s\n",
                        index, item.getItemName(), item.getDescription(), item.getLocation());
                hasReportedItems = true;
            }
            index++;
        }

        if (!hasReportedItems) {
            System.out.println("Tidak ada barang dengan status 'Reported'.");
            return;
        }

        System.out.print("\nMasukkan nomor barang yang ingin ditandai sebagai 'Claimed': ");
        try {
            int itemIndex = scanner.nextInt();
            scanner.nextLine();

            // Validasi indeks dan status
            if (itemIndex >= 0 && itemIndex < LoginSystem.reportedItems.size()) {
                Item selectedItem = LoginSystem.reportedItems.get(itemIndex);

                if ("Reported".equals(selectedItem.getStatus())) {
                    selectedItem.setStatus("Claimed");
                    System.out.println("Barang '" + selectedItem.getItemName() + "' berhasil ditandai sebagai 'Claimed'.");
                } else {
                    System.out.println("Barang ini sudah berstatus 'Claimed'.");
                }
            } else {
                System.out.println("Nomor barang tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nomor barang tidak valid!");
        }
    }

    private void manageUsers(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\n===== KELOLA PENGGUNA =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Lihat Semua Mahasiswa");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih menu (1-4): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        removeStudent(scanner);
                        break;
                    case 3:
                        viewAllStudents();
                        break;
                    case 4:
                        back = true;
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

    private void addStudent(Scanner scanner) {
        System.out.println("\n===== TAMBAH MAHASISWA =====");
        System.out.print("Masukkan Nama: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        // Cek apakah NIM sudah ada
        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getNim().equals(nim)) {
                    System.out.println("Mahasiswa dengan NIM tersebut sudah terdaftar!");
                    return;
                }
            }
        }

        Mahasiswa newStudent = new Mahasiswa(name, nim);
        LoginSystem.userList.add(newStudent);
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    private void removeStudent(Scanner scanner) {
        System.out.println("\n===== HAPUS MAHASISWA =====");
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();

        boolean found = false;
        User userToRemove = null;

        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getNim().equals(nim)) {
                    userToRemove = user;
                    found = true;
                    break;
                }
            }
        }

        if (found && userToRemove != null) {
            LoginSystem.userList.remove(userToRemove);
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    private void viewAllStudents() {
        System.out.println("\n===== DAFTAR MAHASISWA =====");
        System.out.println("No. | Nama | NIM");
        System.out.println("----------------------");

        int index = 1;
        boolean foundStudents = false;

        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                System.out.printf("%d. | %s | %s\n", index++, mahasiswa.getUsername(), mahasiswa.getNim());
                foundStudents = true;
            }
        }

        if (!foundStudents) {
            System.out.println("Belum ada mahasiswa yang terdaftar.");
        }
    }
}