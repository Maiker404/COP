package br.edu.ifro.control.adm;
import br.edu.ifro.model.Projeto;
import br.edu.ifro.model.Usuario;
import br.edu.ifro.utils.Gerador;
import br.edu.ifro.utils.PersistenceProperties;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import static javax.management.Query.value;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class CadastroProjetoController implements Initializable {

    @FXML
    private StackPane stackP;
    @FXML
    private JFXTextField nome;
    @FXML
    private JFXTextField dataFinal;
    @FXML
    private JFXTextArea desc;
    @FXML
    private JFXListView<Usuario> viewTime;
    @FXML
    private JFXListView<Usuario> viewUsers;
    @FXML
    private JFXTextField dataIncial;
    @FXML
    private JFXTextField textTime;
    @FXML
    private JFXTextField txtUser;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadUsers();
    }
    private void loadUsers(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("COP",new PersistenceProperties().get());
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario as u");
        List<Usuario> user = query.getResultList();
        ObservableList users = FXCollections.observableArrayList(user);
        this.viewUsers.setItems(users);
    }
    @FXML
    private void onLimpar(ActionEvent event) {
        this.dataFinal.setText("");
        this.dataIncial.setText("");
        this.desc.setText("");
        this.nome.setText("");
        for(int i=0;i<this.viewTime.getItems().size();i++){
            this.viewUsers.getItems().add(this.viewTime.getItems().get(i));
        }
        this.viewTime.getItems().removeAll(this.viewTime.getItems());
    }
    @FXML
    private void onSalvar(ActionEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        Label body=new Label();
        if(this.viewTime.getItems().isEmpty()){ 
            Pane p=new Gerador().headPane("ERRO","/br/edu/ifro/image/alerta.png","-fx-text-color:black;", "-fx-background-color:white;");
            content.setHeading(p);
            body.setStyle("-fx-text-fill:#ff1a1a");
            body.setText("Coloque um usuario pelo menos no projeto!");
            content.setStyle("-fx-background-color: #353535;");
            content.setBody(body);
        }else{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("COP",new PersistenceProperties().get());
            EntityManager em = emf.createEntityManager();
            Projeto pro = new Projeto();
            pro.setDataFinal(dataFinal.getText());
            pro.setDataInicial(dataIncial.getText());
            pro.setDescricao(desc.getText());
            pro.setNome(nome.getText());
            List<Usuario> eq= this.viewTime.getItems().subList(0, this.viewTime.getItems().size());
            pro.setEquipe(eq);
            em.getTransaction().begin();
            try {
                em.persist(pro);
                body.setText("Cadastro realizado!");
                body.setStyle("-fx-text-fill:#00b300");
                content.setStyle("-fx-background-color: #353535;");
                content.setBody(body);
            } catch (Exception ex) {
                Pane p=new Gerador().headPane("ERRO","/br/edu/ifro/image/alerta.png","-fx-text-color:black;", "-fx-background-color:white;");
                content.setHeading(p);
                body.setStyle("-fx-text-fill:#ff1a1a");
                body.setText("Usuario já existe no sistema!");
                content.setStyle("-fx-background-color: #353535;");
                content.setBody(body);
            }
            try {em.getTransaction().commit();} catch (Exception ex) {} 
        }
        JFXDialog diag = new JFXDialog(this.stackP, content, JFXDialog.DialogTransition.TOP);
        diag.show();
    }

    @FXML
    private void searchTime(ActionEvent event) {
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        if(!this.viewTime.getSelectionModel().isEmpty()){   
            this.viewUsers.getItems().add(this.viewTime.getSelectionModel().getSelectedItem());
            this.viewTime.getItems().remove(this.viewTime.getSelectionModel().getSelectedIndex());
        }else{
            JFXDialogLayout content = new JFXDialogLayout();
            Label body=new Label();
                body.setText("Nenhum usuario selecionado!");
                body.setStyle("-fx-text-fill:#ff1a1a");
                content.setStyle("-fx-background-color: #353535;");
                content.setBody(body);
            JFXDialog diag = new JFXDialog(this.stackP, content, JFXDialog.DialogTransition.TOP);
            diag.show();
        }
    }

    @FXML
    private void addUser(ActionEvent event) {
        if(!this.viewUsers.getSelectionModel().isEmpty()){   
            this.viewTime.getItems().add(this.viewUsers.getSelectionModel().getSelectedItem());
            this.viewUsers.getItems().remove(this.viewUsers.getSelectionModel().getSelectedIndex());
        }else{
            JFXDialogLayout content = new JFXDialogLayout();
            Label body=new Label();
                body.setText("Nenhum usuario selecionado!");
                body.setStyle("-fx-text-fill:#ff1a1a");
                content.setStyle("-fx-background-color: #353535;");
                content.setBody(body);
            JFXDialog diag = new JFXDialog(this.stackP, content, JFXDialog.DialogTransition.TOP);
            diag.show();
        }
    }

    @FXML
    private void Searchuser(ActionEvent event) {
    }
}