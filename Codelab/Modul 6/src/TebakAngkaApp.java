import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TebakAngkaApp extends Application {

    private int angkaRahasia;
    private int jumlahPercobaan;
    private Random random;

    private TextField inputField;
    private Button tombolCoba;
    private Label labelFeedback;
    private Label labelPercobaan;

    @Override
    public void start(Stage primaryStage) {
        random = new Random();
        generateAngkaBaru();

        initializeComponents();

        VBox mainLayout = createMainLayout();

        Scene scene = new Scene(mainLayout, 400, 300);

        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setMaximized(false);

        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);

        primaryStage.show();

        inputField.requestFocus();
    }

    private void initializeComponents() {

        Label labelJudul = new Label("🎯 Tebak Angka 1-100");
        labelJudul.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c5aa0;");

        Label labelInstruksi = new Label("Masukkan tebakanmu!");
        labelInstruksi.setStyle("-fx-font-size: 12px; -fx-text-fill: #666666;");

        inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(200);
        inputField.setStyle("-fx-font-size: 12px;");

        tombolCoba = new Button("Coba Tebak!");
        tombolCoba.setStyle("-fx-background-color: #5cb85c; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5 15 5 15;");

        labelFeedback = new Label("");
        labelFeedback.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");

        labelPercobaan = new Label("Jumlah percobaan: " + jumlahPercobaan);
        labelPercobaan.setStyle("-fx-font-size: 11px; -fx-text-fill: #666666;");

        tombolCoba.setOnAction(e -> handleTebakan());

        inputField.setOnAction(e -> handleTebakan());
    }

    private VBox createMainLayout() {

        Label labelJudul = new Label("🎯 Tebak Angka 1-100");
        labelJudul.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c5aa0;");

        Label labelInstruksi = new Label("Masukkan tebakanmu!");
        labelInstruksi.setStyle("-fx-font-size: 12px; -fx-text-fill: #666666;");

        HBox inputBox = new HBox(10);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().addAll(inputField, tombolCoba);

        VBox gameContent = new VBox(15);
        gameContent.setAlignment(Pos.CENTER);
        gameContent.setPadding(new Insets(20));
        gameContent.setStyle("-fx-background-color: #f0f8ff; -fx-border-color: #cccccc; -fx-border-width: 1; -fx-border-radius: 10; -fx-background-radius: 10;");
        gameContent.setMaxWidth(400);
        gameContent.setMaxHeight(250);

        gameContent.getChildren().addAll(
                labelJudul,
                labelInstruksi,
                inputBox,
                labelFeedback,
                labelPercobaan
        );

        VBox mainContainer = new VBox();
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(20));
        mainContainer.setStyle("-fx-background-color: #f5f5f5;");
        mainContainer.getChildren().add(gameContent);

        VBox.setVgrow(mainContainer, Priority.ALWAYS);

        return mainContainer;
    }

    private void handleTebakan() {

        if (tombolCoba.getText().equals("Main Lagi")) {
            generateAngkaBaru();
            labelFeedback.setText("");
            tombolCoba.setText("Coba Tebak!");
            tombolCoba.setStyle("-fx-background-color: #5cb85c; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5 15 5 15;");
            inputField.clear();
            inputField.requestFocus();
            return;
        }

        try {
            String inputText = inputField.getText().trim();

            if (inputText.isEmpty()) {
                return;
            }

            int tebakan = Integer.parseInt(inputText);

            if (tebakan < 1 || tebakan > 100) {
                labelFeedback.setText("❌ Masukkan angka antara 1-100!");
                labelFeedback.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #d9534f;");
                return;
            }

            jumlahPercobaan++;
            updateLabelPercobaan();

            if (tebakan == angkaRahasia) {

                labelFeedback.setText("✅ Tebakan benar!");
                labelFeedback.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #5cb85c;");

                tombolCoba.setText("Main Lagi");
                tombolCoba.setStyle("-fx-background-color: #5bc0de; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5 15 5 15;");

            } else if (tebakan > angkaRahasia) {

                labelFeedback.setText("▲ Terlalu besar!");
                labelFeedback.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #f0ad4e;");

            } else {

                labelFeedback.setText("▼ Terlalu kecil!");
                labelFeedback.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #f0ad4e;");
            }

            inputField.clear();
            inputField.requestFocus();

        } catch (NumberFormatException e) {
            labelFeedback.setText("❌ Masukkan angka yang valid!");
            labelFeedback.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #d9534f;");
        }
    }

    private void generateAngkaBaru() {
        angkaRahasia = random.nextInt(100) + 1;
        jumlahPercobaan = 0;
        updateLabelPercobaan();

        if (labelFeedback != null) {
            labelFeedback.setText("");
        }

        if (tombolCoba != null) {
            tombolCoba.setText("Coba Tebak!");
            tombolCoba.setStyle("-fx-background-color: #5cb85c; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5 15 5 15;");
        }

        System.out.println("Angka rahasia baru: " + angkaRahasia);
    }

    private void updateLabelPercobaan() {
        if (labelPercobaan != null) {
            labelPercobaan.setText("Jumlah percobaan: " + jumlahPercobaan);
        }
    }

    public static void main(String[] args) {
        Scanner
        launch(args);
    }
}