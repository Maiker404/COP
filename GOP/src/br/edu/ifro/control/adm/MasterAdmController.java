package br.edu.ifro.control.adm;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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
//        } catch (IOException ex) {
//            Logger.getLogger(MasterAdmController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            this.user=FXMLLoader.load(getClass().getResource("CadastroUsuario.fxml"));
//        } catch (IOException ex) {
//            Logger.getLogger(MasterAdmController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    /*Metodo para carregar as telas visiveis*/
    private void loadPane(int s){
    
    }
    @FXML
    private void loadDash(MouseEvent event) {
        this.loadPane(1);
    }

    @FXML
    private void loadProject(MouseEvent event) {
    }

    @FXML
    private void loadUser(MouseEvent event) {
    }
    @FXML
    private void minimizeWindow(ActionEvent event) {
    }

    @FXML
    private void closeWindow(ActionEvent event) {
    }

    @FXML
    private void CloseWindow(MouseEvent event) {
    }
}