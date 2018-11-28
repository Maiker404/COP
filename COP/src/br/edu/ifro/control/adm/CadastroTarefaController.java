/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control.adm;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 01901822290
 */
public class CadastroTarefaController implements Initializable {

    @FXML
    private JFXTextField txtDataEntrega;
    @FXML
    private JFXComboBox<?> cbxProjeto;
    @FXML
    private JFXTextArea txtDescricao;
    @FXML
    private JFXButton btnSalvaTarefa;
    @FXML
    private JFXButton btnNovoTarefa;
    @FXML
    private JFXButton btnCancelaTarefa;
    @FXML
    private JFXComboBox<?> cbxEncarregado;
    @FXML
    private JFXButton btnNovoTarefa1;
    @FXML
    private JFXTextField txtNome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSalvar(MouseEvent event) {
    }

    @FXML
    private void salvarTarefa(ActionEvent event) {
    }

    @FXML
    private void onNovo(MouseEvent event) {
    }

    @FXML
    private void novoTarefa(ActionEvent event) {
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
    
}
