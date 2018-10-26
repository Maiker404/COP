package br.edu.ifro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class App extends Application {
    private double x,y;
    @Override
    public void start(final Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("viewer/Login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("viewer/adm/CadastroProjeto.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("viewer/adm/CadastroUsuario.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("viewer/adm/ListagemDeItens.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        root.setOnMousePressed((MouseEvent event) -> {
            x=event.getSceneX();
            y=event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX()-x);
            stage.setY(event.getScreenY()-y);
        });
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
