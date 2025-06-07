package users;

import data.DataStore;

public class test {
    public static void main(String[] args) {

        String nama = "Salsabila Ayu Azhara";
        String password = "202410370110348";
        boolean found = false;
        for (Mahasiswa m : DataStore.mahasiswaList) {
            if (m.getNama().equals(nama) && m.getPassword().equals(password)) {
                found = true;
                System.out.println("Login Mahasiswa berhasil: " + m.getNama() + " (" + m.getNim() + ")");
            }
        }
        if (!found) {
            System.out.println("Login Mahasiswa gagal.");
        }

        String adminUser = "admin348";
        String adminPass = "password348";
        found = false;
        for (Admin a : DataStore.adminList) {
            if (a.getNama().equals(adminUser) && a.getPassword().equals(adminPass)) {
                found = true;
                System.out.println("Login Admin berhasil: " + a.getNama());
            }
        }
        if (!found) {
            System.out.println("Login Admin gagal.");
        }
    }
}
