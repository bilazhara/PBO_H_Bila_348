class KarakterGame { // digunakan untuk membuat karakter lainnya.
    private String nama; // menyimpan nama karakter
    private int kesehatan; // menyimpan jumlah karakter

    // mengatur nama dan kesehatan awal saat objek dibuat
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // getter untuk mendapatkan nilai, setter untuk mengunah nilai atribut
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // satu karakter untuk menyerang karakter lainnya
    public void serang(KarakterGame target) {
        System.out.println(this.nama + " menyerang " + target.getNama() + "!");
    }
}

// turunan subclass
class Pahlawan extends KarakterGame {
    //  untuk memanggil constructor
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }


    @Override
    public void serang(KarakterGame target) {
        System.out.println(this.getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");

        target.setKesehatan(target.getKesehatan() - 20);

        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// subclass dari karakter game
class Musuh extends KarakterGame {
    // constructor ini memanggil constructor dari superclass menggunakan super()
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // saat musuh menyerang muncul pesan, Viper menyerang Brimstone menggunakan Snake Bite!
    @Override
    public void serang(KarakterGame target) {
        System.out.println(this.getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");

        target.setKesehatan(target.getKesehatan() - 15);

        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// tempat program dimulai
public class Main {
    public static void main(String[] args) {

        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100); // bbjek dari kelas karakter game
        Pahlawan brimstone = new Pahlawan("Brimstone", 150); // objek pahlawan dengan kesehatan 150
        Musuh viper = new Musuh("Viper", 200); // objek musuh dengan kesehatan 200

        // menampilkan kesehatan awal dari brimstone dan viper
        System.out.println("Status awal:");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());

        brimstone.serang(viper); // brimstone menyerang viper, menggurangi 20 point
        viper.serang(brimstone); // viper menyerang brimstone, mengurangi 15 point
    }
}