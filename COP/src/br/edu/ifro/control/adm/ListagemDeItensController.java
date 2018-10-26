package br.edu.ifro.control.adm;
import br.edu.ifro.model.Usuario;
import br.edu.ifro.utils.PersistenceProperties;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class ListagemDeItensController implements Initializable {
    private String chamada;
    @FXML
    private StackPane stackPane;
    @FXML
    private JFXListView<?> listSelect;
    public void onCall(String c){
        this.chamada=c;
        System.out.println("Call "+this.chamada);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ini "+this.chamada);
        Thread thread = new Thread(() -> {
            this.buscar();
        });
        thread.start();
    }    
    private void buscar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("COP", new PersistenceProperties().get());
        EntityManager em = emf.createEntityManager();
        Query query = null;
        switch(this.chamada){
            case "Projeto":
                query = em.createQuery("SELECT b FROM Projeto as b");
                break;
            case "Usuario":
                query = em.createQuery("SELECT b FROM Usuario as b");
                break;
        }
        List<Usuario> user = query.getResultList();
        ObservableList users = FXCollections.observableArrayList(user);
        this.listSelect.setItems(users);
    }
    @FXML
    private void onCancel(ActionEvent event) {
        Stage g=(Stage)this.stackPane.getScene().getWindow();
        g.close();
    }

    @FXML
    private void onSelect(ActionEvent event) {
    }
}
