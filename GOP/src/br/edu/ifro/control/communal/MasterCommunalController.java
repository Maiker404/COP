package br.edu.ifro.control.communal;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
public class MasterCommunalController implements Initializable {
    @FXML
    private Pane painel;
    @FXML
    private JFXDrawer nav;
    @FXML
    private JFXHamburger hamburg;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VBox vBox;
        Pane panel;
        try {
            panel = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/communal/PainelTarefa.fxml"));
            this.painel.getChildren().add(panel);
            vBox = FXMLLoader.load(getClass().getResource("/br/edu/ifro/viewer/communal/FloatingMenuCommunal.fxml"));
            this.load(vBox);
            nav.setSidePane(vBox);
            nav.setOverLayVisible(true);
            HamburgerBackArrowBasicTransition hmbTrans = new HamburgerBackArrowBasicTransition(hamburg);
            hmbTrans.setRate(-1);
            hamburg.addEventHandler(MouseDragEvent.MOUSE_CLICKED, (e) -> {
                if (nav.isShown()) {
                    hmbTrans.setRate(-1);
                    hmbTrans.play();
                    nav.close();
                    boolean close = false;
                    while (close == false) {
                        if (nav.isShown() == false) {
                            close = true;
                        }
                    }
                    nav.setLayoutX(-250);
                } else {
                    hmbTrans.setRate(1);
                    hmbTrans.play();
                    nav.setLayoutX(0);
                    nav.open();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(MasterCommunalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void load(VBox box) {
        for (int i = 0; i < box.getChildren().size(); i++) {
            if (null != box.getChildren().get(i).getId()) {
                switch (box.getChildren().get(i).getId()) {
                    case "btnInicio":
                        box.getChildren().get(i).addEventHandler(MouseDragEvent.MOUSE_RELEASED, (e) -> {
                            painel.setBackground(new Background(new BackgroundFill(Paint.valueOf("#dddddd"), CornerRadii.EMPTY, Insets.EMPTY)));
                        });
                        break;
                    case "btnProjetos":
                        box.getChildren().get(i).addEventHandler(MouseDragEvent.MOUSE_RELEASED, (e) -> {
                            painel.setBackground(new Background(new BackgroundFill(Paint.valueOf("#222222"), CornerRadii.EMPTY, Insets.EMPTY)));
                        });
                        break;
                    case "btnTarefas":
                        box.getChildren().get(i).addEventHandler(MouseDragEvent.MOUSE_RELEASED, (e) -> {
                            painel.setBackground(new Background(new BackgroundFill(Paint.valueOf("#777777"), CornerRadii.EMPTY, Insets.EMPTY)));
                        });
                        break;
                    case "btnPerfil":
                        box.getChildren().get(i).addEventHandler(MouseDragEvent.MOUSE_RELEASED, (e) -> {
                            painel.setBackground(new Background(new BackgroundFill(Paint.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
                        });
                        break;
                    case "btnExit":
                        box.getChildren().get(i).addEventHandler(MouseDragEvent.MOUSE_RELEASED, (e) -> {
                            Stage stage = (Stage) painel.getScene().getWindow();
                            stage.close();
                        });
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
