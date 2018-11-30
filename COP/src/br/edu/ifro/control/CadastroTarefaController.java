/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Projeto;
import br.edu.ifro.model.Tarefa;
import br.edu.ifro.model.Usuario;
import br.edu.ifro.utils.PersistenceProperties;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 01901822290
 */
public class CadastroTarefaController implements Initializable {

    private EntityManager em;
    @FXML
    private JFXButton btnSalvaTarefa;
    @FXML
    private JFXButton btnNovoTarefa;
    @FXML
    private JFXButton btnCancelaTarefa;
    @FXML
    private JFXComboBox<Projeto> cbxProjeto;
    @FXML
    private JFXTextArea txtDescricao;
    @FXML
    private JFXComboBox<Usuario> cbxEncarregado;
    @FXML
    private JFXButton btnNovoTarefa1;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private DatePicker dataFinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("COP", new PersistenceProperties().get());
        Thread t = new Thread(() -> {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT p FROM Projeto as p");
            List<Projeto> user = query.getResultList();
            ObservableList ob = FXCollections.observableList(user);
            cbxProjeto.setItems(ob);
        });
        t.start();
    }

    @FXML
    private void salvarTarefa(ActionEvent event) {
        em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Projeto as p WHERE p.idProjeto=:id");
            query.setParameter("id", this.cbxProjeto.getValue().getIdProjeto());
            Projeto p;
            p = (Projeto) query.getSingleResult();
            List<Tarefa> t=p.getTarefas();
            Tarefa tare=new Tarefa();
            tare.setDataExp(dataFinal.getValue());
                Date input = new Date();
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            tare.setDataLanc(date);
            tare.setNome(txtNome.getText());
            tare.setDescri(txtDescricao.getText());
            tare.setUsuario(cbxEncarregado.getValue());
            t.add(tare);
            p.setTarefas(t);
            em.persist(p);
        em.getTransaction().commit();
    }

    @FXML
    private void novoTarefa(ActionEvent event) {
        this.dataFinal.setValue(LocalDate.now());
        this.txtDescricao.setText("");
        this.txtNome.setText("");
    }

    @FXML
    private void onExcluir(ActionEvent event) {
    }

    @FXML
    private void onEditar(ActionEvent event) {
    }

    @FXML
    private void onHome(ActionEvent event) {
    }

    @FXML
    private void onLoadUser(ActionEvent event) {
        Projeto p=this.cbxProjeto.getSelectionModel().getSelectedItem();
        ObservableList ob = FXCollections.observableList(p.getEquipe());
        cbxEncarregado.setItems(ob);
    }


}
