package br.edu.ifro.control.adm;

import br.edu.ifro.model.Usuario;
import br.edu.ifro.utils.Gerador;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
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
import javafx.scene.layout.AnchorPane;
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
    private JFXListView<?> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> valores = new ArrayList<>();
        valores.add(0, "Adminstrador");
        valores.add(1, "Gerenciador");
        valores.add(2, "Comum");
        ObservableList ob = FXCollections.observableArrayList(valores);
        this.cbxPerm.setItems(ob);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gop");
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("SELECT u FROM Usuario as u");
//        List<Usuario> user = query.getResultList();
        List<AnchorPane> itens = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AnchorPane an=new AnchorPane();
            an.setPrefSize(320, 50);
            Pane pn=new Pane();
            pn.setPrefSize(320, 50);
            pn.setStyle("-fx-background-color:#797a7c;");
            Label l=new Label("Usuario "+i);
            l.setPrefSize(200, 50);
            l.setLayoutX(70);
            l.setLayoutY(0);
            //                ImageView i=new ImageView(new Image("/br/edu/ifro/image/Logo.png"));
            pn.getChildren().add(l);
            an.getChildren().add(pn);
            itens.add(an);
        }
        ObservableList us = FXCollections.observableArrayList(itens);
        CadastroUsuarioController.this.listView.setItems(us);
    }

    @FXML
    private void cadastro(ActionEvent event) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gop");
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        u.setUser(txtUser.getText());
        u.setSenha(txtPass.getText());
        u.setPermisao(cbxPerm.getSelectionModel().getSelectedItem().toString());
        u.setNome(txtNome.getText());
        u.setSobrenome(txtSobrenome.getText());
        u.setFuncao(txtFuncao.getText());
        em.getTransaction().begin();
        JFXDialogLayout content = new JFXDialogLayout();
        Label body=new Label();
        try {
            em.persist(u);
            body.setText("Cadastro realizado!");
            body.setStyle("-fx-text-color:#660066;");
            content.setBody(body);
        } catch (Exception ex) {
            Pane p=new Gerador().headPane("ERRO","/br/edu/ifro/image/alerta.png","-fx-text-color:black;", "-fx-background-color:white;");
            content.setHeading(p);
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
