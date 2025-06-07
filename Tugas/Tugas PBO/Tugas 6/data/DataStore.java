package data;

import users.*;
import java.util.*;

public class DataStore { // menyimpan data pengguna
    public static List<Mahasiswa> mahasiswaList = new ArrayList<>(); // menyimpan dafatr mhs
    public static List<Admin> adminList = new ArrayList<>();
    public static List<Item> itemList = new ArrayList<>();

    static {
        mahasiswaList.add(new Mahasiswa("Salsabila Ayu Azhara", "202410370110348", "202410370110348"));
        adminList.add(new Admin("admin348", "password348"));

    }
}
