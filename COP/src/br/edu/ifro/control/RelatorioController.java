/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author 01901822290
 */
public class RelatorioController implements Initializable {

    @FXML
    private JFXComboBox<String> cbxTipo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> valores = new ArrayList<>();
        valores.add(0, "Projeto");
        valores.add(1, "Tarefa");
        valores.add(2, "Usuario");
        ObservableList ob = FXCollections.observableArrayList(valores);
        this.cbxTipo.setItems(ob);
    }    


    @FXML
    private void onHome(ActionEvent event) {
        //retorna menu inicial
        
    }

    @FXML
    private void cadastro(ActionEvent event) {
    }
    
}
