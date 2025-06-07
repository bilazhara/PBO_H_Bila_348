package actions;

import data.DataStore;
import users.Mahasiswa;

public class AdminActions {
    public static void tambahMahasiswa(String nama, String nim) {
        DataStore.mahasiswaList.add(new Mahasiswa(nama, nim, nim));
    }

    public static void hapusMahasiswa(Mahasiswa mhs) {
        DataStore.mahasiswaList.remove(mhs);
    }
}
