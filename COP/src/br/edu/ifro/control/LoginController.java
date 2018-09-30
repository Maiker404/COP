package br.edu.ifro.control;
import br.edu.ifro.model.Usuario;
import  javafx.fxml.FXMLLoader ;
import  javafx.scene.Scene ;
import  javafx.stage.Stage ;
import  java.io.IOException ;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class LoginController implements Initializable {
    @FXML
    private JFXPasswordField txtPass;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private Label infoPass;
    @FXML
    private Label infoUser;
    
    private String type;
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    @FXML
    private void autenticar(ActionEvent event) {
        if(this.login()){
            try {
                Parent root = FXMLLoader.load(getClass().getResource(this.type));
                Scene scene = new Scene(root);
                Stage janela = new Stage();
                janela.setTitle("Gestor e Organizador de Projetos");
                janela.setScene(scene);
                janela.setResizable(false);
                janela.show();
                Stage stage = (Stage) txtUser.getScene().getWindow();
                stage.close();
            } catch (IOException ex) {}
        }
    }
    @FXML
    private void exitSoft(ActionEvent event) {
        Stage stage = (Stage) txtUser.getScene().getWindow();
        stage.close();
    }
    private boolean login(){
        boolean log=false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gop");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario as u WHERE u.user = :name");
        query.setParameter("name", this.txtUser.getText());
        List<Usuario> user = query.getResultList();
        if(user.isEmpty()==false){
            this.txtUser.setStyle("-fx-prompt-text-fill:green;-fx-text-fill:white;-jfx-focus-color:green;-jfx-unfocus-color:green;");
            this.infoUser.setText("Sucess!");
            this.infoUser.setStyle("-fx-text-fill:green;");
            if(user.get(0).getSenha().equals(this.txtPass.getText())){
                if(user.get(0).getPermisao().equals("Adminstrador")){
                    this.type="/br/edu/ifro/viewer/adm/MasterAdm.fxml";
                }else{
                     this.type="/br/edu/ifro/viewer/communal/MasterCommunal.fxml";
                }
                this.txtPass.setStyle("-fx-prompt-text-fill:green;-fx-text-fill:white;-jfx-focus-color:green;-jfx-unfocus-color:green;");
                this.infoPass.setText("Sucess!");
                this.infoPass.setStyle("-fx-text-fill:green;");
                log=true;
            }else{
                this.txtPass.setStyle("-fx-prompt-text-fill:red;-fx-text-fill:white;-jfx-focus-color:red;-jfx-unfocus-color:red;");
                this.infoPass.setText("Senha incorreta!");
                this.infoPass.setStyle("-fx-text-fill:red;");
            }
        }else{
            this.txtPass.setStyle("-fx-prompt-text-fill:white;-fx-text-fill:white;-jfx-focus-color:black;-jfx-unfocus-color:white;");
            this.infoPass.setText("");
            this.infoPass.setStyle("-fx-text-fill:white;");
            this.txtUser.setStyle("-fx-prompt-text-fill:red;-fx-text-fill:white;-jfx-focus-color:red;-jfx-unfocus-color:red;");
            this.infoUser.setText("Usuario não encontrado!");
            this.infoUser.setStyle("-fx-text-fill:red;");
        }
        em.close();
        emf.close();
        return log;
    }
}