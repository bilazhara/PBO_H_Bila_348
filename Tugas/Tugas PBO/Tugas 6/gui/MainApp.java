package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import users.*;

public class MainApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLogin();
        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.show();
    }

    private void showLogin() {
        LoginPane loginPane = new LoginPane((user, role) -> {
            if (role.equals("Mahasiswa")) {
                showMahasiswaDashboard((users.Mahasiswa) user);
            } else {
                showAdminDashboard((users.Admin) user);
            }
        });
        primaryStage.setScene(new Scene(loginPane, 370, 270));
    }

    private void showMahasiswaDashboard(users.Mahasiswa mhs) {
        MahasiswaDashboard dash = new MahasiswaDashboard(mhs, this::showLogin);
        primaryStage.setScene(new Scene(dash, 600, 400));
    }

    private void showAdminDashboard(users.Admin admin) {
        AdminDashboard dash = new AdminDashboard(admin, this::showLogin);
        primaryStage.setScene(new Scene(dash, 900, 420));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
