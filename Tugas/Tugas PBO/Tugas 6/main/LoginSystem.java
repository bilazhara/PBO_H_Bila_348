package main;

import data.DataStore;
import users.*;

public class LoginSystem {
    public static User login(String role, String nama, String nimOrPassword) {
        if (role.equals("Admin")) {
            for (Admin a : DataStore.adminList) {
                if (a.getNama().equals(nama) && a.getPassword().equals(nimOrPassword)) {
                    return a;
                }
            }
        } else {
            for (Mahasiswa m : DataStore.mahasiswaList) {
                if (m.getNama().equals(nama) && m.getNim().equals(nimOrPassword)) {
                    return m;
                }
            }
        }
        return null;
    }
}
