/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control.adm;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author 01901822290
 */
public class CadastroUsuarioController implements Initializable {

    @FXML
    private StackPane stackP;
    @FXML
    private Pane painel;
    @FXML
    private JFXTextField txtFuncao;
    @FXML
    private JFXComboBox<?> cbxPerm;
    @FXML
    private JFXTextField txtPass;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtSobrenome;
    @FXML
    private JFXTextField txtCpf;
    @FXML
    private JFXTextField txtDataNasc;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtRua;
    @FXML
    private JFXTextField txtEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastro(ActionEvent event) {
        //salvar
    }

    @FXML
    private void novo(ActionEvent event) {
        //limpa todos os dados
        //indisponivel em acesso por pesquisa
        
    }

    @FXML
    private void excluir(ActionEvent event) {
        //deleta o usuario
    }

    @FXML
    private void onEditar(ActionEvent event) {
        //torna os txt editaveis
    }

    @FXML
    private void onHome(ActionEvent event) {
        //retorna para menu principal
    }
    
}
