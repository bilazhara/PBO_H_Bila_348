package data;

public class Item {
    private String namaBarang;
    private String deskripsi;
    private String lokasi;
    private String pelapor;
    private String status;

    public Item(String namaBarang, String deskripsi, String lokasi, String pelapor) {
        this.namaBarang = namaBarang;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.pelapor = pelapor;
        this.status = "Reported";
    }

    public String getNamaBarang() { return namaBarang; } // membaca datanya
    public String getDeskripsi() { return deskripsi; }
    public String getLokasi() { return lokasi; }
    public String getPelapor() { return pelapor; }
    public String getStatus() { return status; } // mengubah nilai nya
    public void setStatus(String status) { this.status = status; }
}
