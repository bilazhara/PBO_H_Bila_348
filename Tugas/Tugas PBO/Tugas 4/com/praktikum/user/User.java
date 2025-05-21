package com.praktikum.users;

public abstract class User {
    protected String nama;
    protected String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public abstract boolean login();
    public abstract void displayAppMenu();
}