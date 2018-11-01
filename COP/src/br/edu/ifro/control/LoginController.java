package br.edu.ifro.control;
import br.edu.ifro.model.Usuario;
import br.edu.ifro.utils.PersistenceProperties;
import com.google.common.hash.Hashing;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import  javafx.stage.Stage ;
import  java.io.IOException ;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
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
    
    private boolean type;
    @FXML
    private StackPane stack;
    private double x,y;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void autenticar(ActionEvent event) {
        if(this.login()){
            try {
                Parent reroot;
                Stage estagio = (Stage) stack.getScene().getWindow();
                estagio.close();
                if(this.type==true){
                    reroot = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/adm/MasterAdm.fxml"));
                }else{
                    reroot = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/communal/MasterCommunal.fxml"));
                }
                Scene scene = new Scene(reroot);
                scene.setFill(Color.TRANSPARENT);
                Stage janela = new Stage();
                reroot.setOnMousePressed((MouseEvent e) -> {
                    x=e.getSceneX();
                    y=e.getSceneY();
                });
                reroot.setOnMouseDragged((MouseEvent e) -> {
                    janela.setX(e.getScreenX()-x);
                    janela.setY(e.getScreenY()-y);
                });
                janela.setScene(scene);
                janela.setResizable(false);
                janela.initStyle(StageStyle.TRANSPARENT);
                janela.show();
            } catch (IOException ex) {
                
            }
        }
    }
    @FXML
    private void exitSoft(ActionEvent event) {
        Stage stage = (Stage) stack.getScene().getWindow();
        stage.close();
    }
    private boolean login(){
        boolean log=false;
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("COP",new PersistenceProperties().get());
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario as u WHERE u.user = :name");
        query.setParameter("name", this.txtUser.getText());
        List<Usuario> user = query.getResultList();
        if(user.isEmpty()==false){
            this.txtUser.setStyle("-fx-prompt-text-fill:green;-fx-text-fill:white;-jfx-focus-color:green;-jfx-unfocus-color:green;");
            this.infoUser.setText("Sucess!");
            this.infoUser.setStyle("-fx-text-fill:green;");
            if(user.get(0).getSenha().equals(Hashing.sha256().hashString(this.txtPass.getText(), StandardCharsets.UTF_8).toString())){
                this.type = user.get(0).getPermisao().equals("Adminstrador");
                this.txtPass.setStyle("-fx-prompt-text-fill:green;-fx-text-fill:#353535;-jfx-focus-color:green;-jfx-unfocus-color:green;");
                this.infoPass.setText("Sucess!");
                this.infoPass.setStyle("-fx-text-fill:green;");
                log=true;
            }else{
                this.txtPass.setStyle("-fx-prompt-text-fill:#353535;-fx-text-fill:#353535;-jfx-focus-color:red;-jfx-unfocus-color:red;");
                this.infoPass.setText("Senha incorreta!");
                this.infoPass.setStyle("-fx-text-fill:red;");
            }
        }else{
            this.txtPass.setStyle("-fx-prompt-text-fill:#353535;-fx-text-fill:#353535;-jfx-focus-color:black;-jfx-unfocus-color:#353535;");
            this.infoPass.setText("");
            this.infoPass.setStyle("-fx-text-fill:#353535;");
            this.txtUser.setStyle("-fx-prompt-text-fill:red;-fx-text-fill:#353535;-jfx-focus-color:red;-jfx-unfocus-color:red;");
            this.infoUser.setText("Usuario não encontrado!");
            this.infoUser.setStyle("-fx-text-fill:red;");
        }
        em.close();
        emf.close();
        return log;
    }

    @FXML
    private void openConfigBD(ActionEvent event) {
        //Pane p=new Pane();
        Label body=new Label();
        JFXDialogLayout content = new JFXDialogLayout();
        body.setText("Teste de config!");
        body.setStyle("-fx-text-color:#353535;");
        content.setStyle("-fx-background-color: #dddddd;");
        content.setBody(body);
        JFXDialog dg=new JFXDialog(this.stack, content, JFXDialog.DialogTransition.TOP);
        dg.show();
    }
}