package br.edu.ifro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class App extends Application {
    private double x,y;
    @Override
    public void start(final Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
