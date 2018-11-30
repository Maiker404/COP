/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 76220842200
 */
public class CadastroProjetoController implements Initializable {

    private EntityManager em;
    @FXML
    private StackPane stackP;
    @FXML
    private JFXTextField nome;
    @FXML
    private DatePicker dataFinal;
    @FXML
    private JFXTextArea desc;
    @FXML
    private JFXListView<Usuario> viewTime;
    @FXML
    private JFXListView<Usuario> viewUsers;
    @FXML
    private JFXTextField textTime;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXButton btnNovoTarefa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("COP");
        Thread t = new Thread(() -> {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT u FROM Usuario as u");
            List<Usuario> user = query.getResultList();
            ObservableList ob=FXCollections.observableList(user);
            viewUsers.setItems(ob);
        });
        t.start();
    }

    @FXML
    private void onExcluir(ActionEvent event) {
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
            pro.setDataFinal(dataFinal.getValue());
                Date input = new Date();
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            pro.setDataInicial(date);
            pro.setDescricao(desc.getText());
            pro.setNome(nome.getText());
            List<Usuario> eq = (List<Usuario>) this.viewTime.getItems().subList(0, this.viewTime.getItems().size());
            pro.setEquipe(eq);
            em.getTransaction().begin();
            try {
                em.persist(pro);
                body.setText("Cadastro realizado!");
                body.setStyle("-fx-text-fill:#00b300");
                content.setStyle("-fx-background-color: #353535;");
                content.setBody(body);
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
            this.viewUsers.getItems().add( this.viewTime.getSelectionModel().getSelectedItem());
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
    private void onEditar(ActionEvent event) {
    }

    @FXML
    private void onNovo(MouseEvent event) {
    }

    @FXML
    private void novoTarefa(ActionEvent event) {
    }

    @FXML
    private void onHome(ActionEvent event) {
    } 

}
