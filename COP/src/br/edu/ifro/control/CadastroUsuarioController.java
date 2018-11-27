package br.edu.ifro.control;

import br.edu.ifro.model.Usuario;
import br.edu.ifro.utils.PersistenceProperties;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroUsuarioController implements Initializable {

    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXTextField txtPass;
    @FXML
    private JFXComboBox<?> cbxPerm;
    @FXML
    private Pane painel;
    @FXML
    private StackPane stackP;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtSobrenome;
    @FXML
    private JFXTextField txtFuncao;
    @FXML
    private JFXTextField txtCpf;
    @FXML
    private JFXTextField txtDataNasc;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtRua;
    @FXML
    private JFXTextField txtNumero;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> valores = new ArrayList<>();
        valores.add(0, "Adminstrador");
        valores.add(1, "Gerenciador");
        valores.add(2, "Comum");
        ObservableList ob = FXCollections.observableArrayList(valores);
        this.cbxPerm.setItems(ob);
    }

    @FXML
    private void cadastro(ActionEvent event) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("COP",new PersistenceProperties().get());
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        u.setUser(txtUser.getText());
        u.setCpf(txtCpf.getText());
        u.setDatanasc(txtDataNasc.getText());
        u.setSenha(txtPass.getText());
        u.setPermisao(cbxPerm.getSelectionModel().getSelectedItem().toString());
        u.setNome(txtNome.getText());
        u.setSobrenome(txtSobrenome.getText());
        u.setFuncao(txtFuncao.getText());
        u.setRua(txtRua.getText());
        u.setBairro(txtBairro.getText());
        u.setCep(txtCep.getText());
        u.setNumero(txtNumero.getText());
        em.getTransaction().begin();
        JFXDialogLayout content = new JFXDialogLayout();
        Label body=new Label();
        try {
            em.persist(u);
            body.setText("Cadastro realizado!");
            body.setStyle("-fx-text-color:grenn;");
            content.setStyle("-fx-background-color: #353535;");
            content.setBody(body);
        } catch (Exception ex) {
            body.setStyle("-fx-text-color:red;");
            body.setText("Usuario já existe no sistema!");
            content.setBody(body);
        }
        try {em.getTransaction().commit();} catch (Exception ex) {}
        JFXDialog diag = new JFXDialog(this.stackP, content, JFXDialog.DialogTransition.TOP);
        diag.show();
    }

    @FXML
    private void novo(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
    }
}
