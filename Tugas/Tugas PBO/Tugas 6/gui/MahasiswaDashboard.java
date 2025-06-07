package gui;

import actions.MahasiswaActions;
import data.DataStore;
import data.Item;
import users.Mahasiswa;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MahasiswaDashboard extends VBox {
    public interface LogoutCallback {
        void onLogout();
    }

    public MahasiswaDashboard(Mahasiswa mahasiswa, LogoutCallback logoutCallback) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label greet = new Label("Selamat datang, " + mahasiswa.getNama());
        greet.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        Label sub = new Label("Laporan Barang Hilang/Temuan");

        TextField tfNamaBarang = new TextField();
        tfNamaBarang.setPromptText("Nama Barang");
        tfNamaBarang.setPrefWidth(150);

        TextField tfDeskripsi = new TextField();
        tfDeskripsi.setPromptText("Deskripsi Barang");
        tfDeskripsi.setPrefWidth(180);

        TextField tfLokasi = new TextField();
        tfLokasi.setPromptText("Lokasi");
        tfLokasi.setPrefWidth(120);

        Button btnLapor = new Button("Laporkan");
        btnLapor.setPrefWidth(100);

        HBox form = new HBox(8, tfNamaBarang, tfDeskripsi, tfLokasi, btnLapor);
        form.setAlignment(Pos.CENTER_LEFT);

        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> colNama = new TableColumn<>("Nama Barang");
        colNama.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNamaBarang()));
        colNama.setPrefWidth(120);

        TableColumn<Item, String> colDeskripsi = new TableColumn<>("Deskripsi");
        colDeskripsi.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDeskripsi()));
        colDeskripsi.setPrefWidth(180);

        TableColumn<Item, String> colLokasi = new TableColumn<>("Lokasi");
        colLokasi.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLokasi()));
        colLokasi.setPrefWidth(100);

        TableColumn<Item, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));
        colStatus.setPrefWidth(80);

        table.getColumns().addAll(colNama, colDeskripsi, colLokasi, colStatus);
        table.setPrefHeight(170);

        ObservableList<Item> laporanMahasiswa = FXCollections.observableArrayList();
        for (Item i : DataStore.itemList) {
            if (i.getPelapor().equals(mahasiswa.getNama())) {
                laporanMahasiswa.add(i);
            }
        }
        table.setItems(laporanMahasiswa);

        btnLapor.setOnAction(e -> {
            String namaBarang = tfNamaBarang.getText().trim();
            String deskripsi = tfDeskripsi.getText().trim();
            String lokasi = tfLokasi.getText().trim();
            if (!namaBarang.isEmpty() && !deskripsi.isEmpty() && !lokasi.isEmpty()) {
                MahasiswaActions.laporBarang(namaBarang, deskripsi, lokasi, mahasiswa.getNama());
                laporanMahasiswa.clear();
                for (Item i : DataStore.itemList) {
                    if (i.getPelapor().equals(mahasiswa.getNama())) {
                        laporanMahasiswa.add(i);
                    }
                }
                tfNamaBarang.clear();
                tfDeskripsi.clear();
                tfLokasi.clear();
            }
        });

        Button btnLogout = new Button("Logout");
        btnLogout.setPrefWidth(100);
        btnLogout.setOnAction(e -> logoutCallback.onLogout());

        getChildren().addAll(greet, sub, form, new Label("Daftar Laporan Anda:"), table, btnLogout);
    }
}
