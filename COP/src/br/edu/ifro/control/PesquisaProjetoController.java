/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Projeto;
import br.edu.ifro.utils.PersistenceProperties;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 01901822290
 */
public class PesquisaProjetoController implements Initializable {
private EntityManager em;
    @FXML
    private JFXTextField txtPesquisa;
    @FXML
    private JFXListView<Projeto> listView;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("COP", new PersistenceProperties().get());
        Thread t = new Thread(() -> {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT p FROM Projeto as p");
            List<Projeto> user = query.getResultList();
            ObservableList ob = FXCollections.observableList(user);
            this.listView.setItems(ob);
        });
        t.start();
    }    
    @FXML
    private void onPesquisar(ActionEvent event) {
    }

    @FXML
    private void onHome(ActionEvent event) {
    }
    
}
