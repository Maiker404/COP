package br.edu.ifro.control.adm;
import br.edu.ifro.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class MasterAdmController implements Initializable {
    private AnchorPane dash,project,user;
    @FXML
    private StackPane stackPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            this.dash=FXMLLoader.load(getClass().getResource("Dasboard.fxml"));
//        } catch (IOException ex) {
//            Logger.getLogger(MasterAdmController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            this.project=FXMLLoader.load(getClass().getResource("CadastroProjeto.fxml"));
//        } catch (IOException ex) {}
//        try {
//            this.user=FXMLLoader.load(getClass().getResource("CadastroUsuario.fxml"));
//        } catch (IOException ex) {}
    }
    /*Metodo para carregar as telas visiveis*/
    private void loadPane(int s){
    
    }
    private void loadDash(MouseEvent event) {
        this.loadPane(1);
    }

    @FXML
    private void minimizeWindow(ActionEvent event) {
        Stage stage = (Stage) stackPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) stackPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void openDash(ActionEvent event) {
    }

    @FXML
    private void openPro(ActionEvent event) {
    }

    @FXML
    private void openUser(ActionEvent event) {
    }

    @FXML
    private void openConfig(ActionEvent event) {
    }

    @FXML
    private void logoff(ActionEvent event) {
    }

    @FXML
    private void openTarefas(ActionEvent event) {
    }
}
