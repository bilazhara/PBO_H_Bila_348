package gui;

import data.DataStore;
import data.Item;
import users.Admin;
import users.Mahasiswa;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AdminDashboard extends VBox {
    public interface LogoutCallback {
        void onLogout();
    }

    public AdminDashboard(Admin admin, LogoutCallback logoutCallback) {
        setSpacing(10);
        setPadding(new Insets(15));

        Label greet = new Label("Halo, Administrator " + admin.getNama());
        greet.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        TableView<Item> tableLaporan = new TableView<>();
        TableColumn<Item, String> colNama = new TableColumn<>("Nama");
        colNama.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNamaBarang()));
        colNama.setPrefWidth(120);

        TableColumn<Item, String> colLokasi = new TableColumn<>("Lokasi");
        colLokasi.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLokasi()));
        colLokasi.setPrefWidth(120);

        TableColumn<Item, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));
        colStatus.setPrefWidth(120);

        tableLaporan.getColumns().addAll(colNama, colLokasi, colStatus);
        ObservableList<Item> laporan = FXCollections.observableArrayList(DataStore.itemList);
        tableLaporan.setItems(laporan);
        tableLaporan.setPrefHeight(220);
        tableLaporan.setPrefWidth(380);

        Button btnClaimed = new Button("Tandai Claimed");
        btnClaimed.setOnAction(e -> {
            Item selected = tableLaporan.getSelectionModel().getSelectedItem();
            if (selected != null && !"Claimed".equals(selected.getStatus())) {
                selected.setStatus("Claimed");
                tableLaporan.refresh();
            }
        });

        TableView<Mahasiswa> tableMhs = new TableView<>();
        TableColumn<Mahasiswa, String> colNamaMhs = new TableColumn<>("Nama");
        colNamaMhs.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNama()));
        colNamaMhs.setPrefWidth(140);

        TableColumn<Mahasiswa, String> colNim = new TableColumn<>("NIM");
        colNim.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNim()));
        colNim.setPrefWidth(140);

        tableMhs.getColumns().addAll(colNamaMhs, colNim);
        ObservableList<Mahasiswa> mahasiswaList = FXCollections.observableArrayList(DataStore.mahasiswaList);
        tableMhs.setItems(mahasiswaList);
        tableMhs.setPrefHeight(220);
        tableMhs.setPrefWidth(280);

        TextField tfNamaMhs = new TextField();
        tfNamaMhs.setPromptText("Nama Mahasiswa");
        tfNamaMhs.setPrefWidth(120);

        TextField tfNimMhs = new TextField();
        tfNimMhs.setPromptText("NIM");
        tfNimMhs.setPrefWidth(120);

        Button btnTambahMhs = new Button("Tambahkan");
        btnTambahMhs.setOnAction(e -> {
            String nama = tfNamaMhs.getText().trim();
            String nim = tfNimMhs.getText().trim();
            if (!nama.isEmpty() && !nim.isEmpty()) {
                users.Mahasiswa baru = new users.Mahasiswa(nama, nim, nim);
                DataStore.mahasiswaList.add(baru);
                mahasiswaList.setAll(DataStore.mahasiswaList);
                tfNamaMhs.clear();
                tfNimMhs.clear();
            }
        });

        Button btnHapusMhs = new Button("Hapus");
        btnHapusMhs.setOnAction(e -> {
            Mahasiswa selected = tableMhs.getSelectionModel().getSelectedItem();
            if (selected != null) {
                DataStore.mahasiswaList.remove(selected);
                mahasiswaList.setAll(DataStore.mahasiswaList);
            }
        });

        HBox formMhs = new HBox(5, tfNamaMhs, tfNimMhs, btnTambahMhs, btnHapusMhs);
        formMhs.setAlignment(Pos.CENTER_LEFT);

        VBox laporanBox = new VBox(new Label("Laporan Barang"), tableLaporan, btnClaimed);
        VBox mhsBox = new VBox(new Label("Data Mahasiswa"), tableMhs, formMhs);
        laporanBox.setSpacing(5);
        mhsBox.setSpacing(5);

        HBox hBox = new HBox(20, laporanBox, mhsBox);

        Button btnLogout = new Button("Logout");
        btnLogout.setOnAction(e -> logoutCallback.onLogout());

        getChildren().addAll(greet, hBox, btnLogout);
    }
}
