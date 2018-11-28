/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control.adm;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author 01901822290
 */
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
    private JFXListView<?> viewTime;
    @FXML
    private JFXListView<?> viewUsers;
    @FXML
    private JFXTextField textTime;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXButton btnNovoTarefa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onExcluir(ActionEvent event) {
    }

    @FXML
    private void onSalvar(ActionEvent event) {
    }

    @FXML
    private void searchTime(ActionEvent event) {
    }

    @FXML
    private void deleteUser(ActionEvent event) {
    }

    @FXML
    private void addUser(ActionEvent event) {
    }

    @FXML
    private void Searchuser(ActionEvent event) {
    }

    @FXML
    private void onProcurar(ActionEvent event) {
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
