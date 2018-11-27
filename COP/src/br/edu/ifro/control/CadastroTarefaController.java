/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author 01901822290
 */
public class CadastroTarefaController implements Initializable {

    @FXML
    private JFXButton btnSalvaTarefa;
    @FXML
    private JFXButton btnNovoTarefa;
    @FXML
    private JFXButton btnCancelaTarefa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvarTarefa(ActionEvent event) {
    }

    @FXML
    private void novoTarefa(ActionEvent event) {
    }

    @FXML
    private void cancelaTarefa(ActionEvent event) {
    }
    
}
