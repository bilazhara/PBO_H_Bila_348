package gui;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.LoginSystem;
import users.*;

public class LoginPane extends VBox {
    public interface LoginCallback {
        void onLoginSuccess(User user, String role);
    }

    public LoginPane(LoginCallback callback) {
        setSpacing(15);
        setPadding(new Insets(32, 32, 32, 32));
        setAlignment(Pos.CENTER);

        Label title = new Label("Login Sistem Lost & Found");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        ComboBox<String> cbRole = new ComboBox<>();
        cbRole.getItems().addAll("Mahasiswa", "Admin");
        cbRole.setValue("Mahasiswa");
        cbRole.setPrefWidth(240);

        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama Mahasiswa / Username Admin");
        tfNama.setPrefWidth(240);

        TextField tfNimOrPass = new TextField();
        tfNimOrPass.setPromptText("NIM Mahasiswa / Password Admin");
        tfNimOrPass.setPrefWidth(240);

        Button btnLogin = new Button("Login");
        btnLogin.setPrefWidth(100);

        Button btn1 = new Button("btn1");

        Label lblStatus = new Label();
        lblStatus.setStyle("-fx-text-fill: #b22222;");

        btnLogin.setOnAction(e -> {
            String role = cbRole.getValue();
            String nama = tfNama.getText().trim();
            String nimOrPass = tfNimOrPass.getText().trim();
            User user = LoginSystem.login(role, nama, nimOrPass);
            if (user != null) {
                lblStatus.setText("");
                callback.onLoginSuccess(user, role);
            } else {
                lblStatus.setText("Login gagal. Cek nama dan NIM/password.");
            }
        });

        VBox form = new VBox(10, cbRole, tfNama, tfNimOrPass, btnLogin, lblStatus, btn1);
        form.setAlignment(Pos.CENTER);

        getChildren().addAll(title, form);
    }
}
