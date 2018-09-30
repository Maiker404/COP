package br.edu.ifro.control.adm;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class EdicaoEquipeController implements Initializable {
    @FXML
    private AnchorPane anchor;
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void Mini(ActionEvent event) {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void Sair(ActionEvent event) {
        Stage stage = (Stage) this.anchor.getScene().getWindow();
        stage.close();
    }
}