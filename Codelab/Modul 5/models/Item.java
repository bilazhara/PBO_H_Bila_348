package com.praktikum.models; // kelas ini berada pada praktikum models

public class Item { // kelas publik
    private String itemName;
    private String description;
    private String location;
    private String status; // "Reported" atau "Claimed"

    public Item(String itemName, String description, String location) {
        this.itemName = itemName; // harus diisi saat membuat objek baru
        this.description = description;
        this.location = location;
        this.status = "Reported"; // barang nya baru di laporkan
    }

    // Getter dan Setter
    public String getItemName() { // membaca variabel
        return itemName;
    }

    public void setItemName(String itemName) { // ngubah variabel baru
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}