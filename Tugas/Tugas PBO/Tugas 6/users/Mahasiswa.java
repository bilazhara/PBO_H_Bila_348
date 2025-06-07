package users;

public class Mahasiswa extends User {
    private String nim;

    public Mahasiswa(String nama, String nim, String password) {
        super(nama, password);
        this.nim = nim;
    }

    public String getNim() { return nim; }
}
