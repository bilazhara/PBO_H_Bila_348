class Admin extends User {
    private final String username = "admin348";
    private final String password = "password348";

    public Admin(String nama, String nim) { // consctuctor menggunakan super untuk memanggil punya user
        super(nama, nim);
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    @Override
    public void displayInfo() { // menampilkan informasi
        System.out.println("Login Admin berhasil!");
    }
}