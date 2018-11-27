package br.edu.ifro.control;

import br.edu.ifro.model.Projeto;
import br.edu.ifro.model.Usuario;
import br.edu.ifro.utils.PersistenceProperties;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CadastroProjetoController implements Initializable {
    private EntityManager em;
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
        this.em=Persistence.createEntityManagerFactory("COP", new PersistenceProperties().get()).createEntityManager();
        Thread thread = new Thread(() -> {
            this.loadUsers();
        });
        thread.start();
    }

    private void loadUsers() {
        Query query = em.createQuery("SELECT u FROM Usuario as u");
        List<Usuario> user = query.getResultList();
        em.clear();
        ObservableList users = FXCollections.observableArrayList(user);
        this.viewUsers.setItems(users);
    }

    @FXML
    private void onLimpar(ActionEvent event) {
        this.dataFinal.setText("");
        this.dataIncial.setText("");
        this.desc.setText("");
        this.nome.setText("");
        for (int i = 0; i < this.viewTime.getItems().size(); i++) {
            this.viewUsers.getItems().add(this.viewTime.getItems().get(i));
        }
        this.viewTime.getItems().removeAll(this.viewTime.getItems());
    }

    @FXML
    private void onSalvar(ActionEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        Label body = new Label();
        if (this.viewTime.getItems().isEmpty()) {
           
            body.setStyle("-fx-text-fill:#ff1a1a");
            body.setText("Coloque um usuario pelo menos no projeto!");
            content.setStyle("-fx-background-color: #353535;");
            content.setBody(body);
        } else {
            Projeto pro = new Projeto();
            pro.setDataFinal(dataFinal.getText());
            pro.setDataInicial(dataIncial.getText());
            pro.setDescricao(desc.getText());
            pro.setNome(nome.getText());
            List<Usuario> eq = this.viewTime.getItems().subList(0, this.viewTime.getItems().size());
            pro.setEquipe(eq);
            em.getTransaction().begin();
            try {
                em.persist(pro);
                body.setText("Cadastro realizado!");
                body.setStyle("-fx-text-fill:#00b300");
                content.setStyle("-fx-background-color: #353535;");
                content.setBody(body);
                this.onLimpar(event);
            } catch (Exception ex) {
                
                body.setStyle("-fx-text-fill:#ff1a1a");
                body.setText("Projeto já existe no sistema!");
                content.setStyle("-fx-background-color: #353535;");
                content.setBody(body);
            }
            try {
                em.getTransaction().commit();
                em.clear();
            } catch (Exception ex) {
            }
        }
        JFXDialog diag = new JFXDialog(this.stackP, content, JFXDialog.DialogTransition.TOP);
        diag.show();
    }

    @FXML
    private void searchTime(ActionEvent event) {
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        if (!this.viewTime.getSelectionModel().isEmpty()) {
            this.viewUsers.getItems().add(this.viewTime.getSelectionModel().getSelectedItem());
            this.viewTime.getItems().remove(this.viewTime.getSelectionModel().getSelectedIndex());
        } else {
            JFXDialogLayout content = new JFXDialogLayout();
            Label body = new Label();
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
        if (!this.viewUsers.getSelectionModel().isEmpty()) {
            this.viewTime.getItems().add(this.viewUsers.getSelectionModel().getSelectedItem());
            this.viewUsers.getItems().remove(this.viewUsers.getSelectionModel().getSelectedIndex());
        } else {
            JFXDialogLayout content = new JFXDialogLayout();
            Label body = new Label();
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

    @FXML
    private void onProcurar(ActionEvent event) throws IOException {
        Query query = em.createQuery("SELECT p FROM Projeto as p");
        List<Projeto> projs = query.getResultList();
        em.clear();
        ObservableList lista = FXCollections.observableArrayList(projs);
        JFXListView<Projeto> list=new JFXListView<>();
        JFXButton btn=new JFXButton("Selecionar");
        list.setPrefSize(800, 300);
        list.setItems(lista);
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog diag = new JFXDialog(this.stackP, content, JFXDialog.DialogTransition.TOP);
        btn.setOnAction((e) -> {
            this.localizarProj(list.getSelectionModel().getSelectedItem().getIdProjeto());
            diag.close();
        });
        content.setBody(list);
        content.setActions(btn);
        diag.show();
    }
    private void localizarProj(int v){
        new Thread(() -> {
            Query query = em.createQuery("SELECT p FROM Projeto as p where p.idProjeto=:id");
            query.setParameter("id", v);
            Projeto p = (Projeto) query.getSingleResult();
            em.clear();
            this.dataFinal.setText(p.getDataFinal());
            this.dataIncial.setText(p.getDataInicial());
            this.nome.setText(p.getNome());
            this.desc.setText(p.getDescricao());
        }).start();
    }
}
