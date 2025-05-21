package com.praktikum.models;

public abstract class User {
    protected String username; // bisa diakses dikelas ini disimpan di username+password
    protected String password;

    public User(String username, String password) { // mengisi username+password
        this.username = username;
        this.password = password;
    }

    // Getter dan Setter mengubah data
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void displayMenu();
}