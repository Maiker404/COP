package br.edu.ifro.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void onProjetos(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/PesquisaProjeto.fxml"));
            Scene scene = new Scene(root);
            Stage janela = new Stage();
            janela.setScene(scene);
            janela.setResizable(false);
            janela.setAlwaysOnTop(true);
            janela.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void onUsuarios(ActionEvent event) {
    }

    @FXML
    private void onTarefas(ActionEvent event) {
    }

    @FXML
    private void onCriarTarefa(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/CadastroTarefa.fxml"));
            Scene scene = new Scene(root);
            Stage janela = new Stage();
            janela.setScene(scene);
            janela.setResizable(false);
            janela.setAlwaysOnTop(true);
            janela.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void onCadastrarUsuario(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/CadastroUsuario.fxml"));
            Scene scene = new Scene(root);
            Stage janela = new Stage();
            janela.setScene(scene);
            janela.setResizable(false);
            janela.setAlwaysOnTop(true);
            janela.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void onCriarProjeto(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/CadastroProjeto.fxml"));
            Scene scene = new Scene(root);
            Stage janela = new Stage();
            janela.setScene(scene);
            janela.setResizable(false);
            janela.setAlwaysOnTop(true);
            janela.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void onRelatorio(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/Relatorio.fxml"));
            Scene scene = new Scene(root);
            Stage janela = new Stage();
            janela.setScene(scene);
            janela.setResizable(false);
            janela.setAlwaysOnTop(true);
            janela.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void onSair(ActionEvent event) {
//        Stage stage=(Stage) this.getScene().getWindow();;
//        stage.close();
    }
}
