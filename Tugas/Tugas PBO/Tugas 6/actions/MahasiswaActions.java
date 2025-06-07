package actions;

import data.DataStore;
import data.Item;

public class MahasiswaActions {
    public static void laporBarang(String namaBarang, String deskripsi, String lokasi, String pelapor) {
        DataStore.itemList.add(new Item(namaBarang, deskripsi, lokasi, pelapor));
    }
}
