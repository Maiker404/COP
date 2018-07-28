package br.edu.ifro.utils;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
public class Gerador {
    public Pane headPane(String t, String i,String csst,String cssf) {
        Pane p = new Pane();
        Label l = new Label(t);
        ImageView icon = new ImageView(i);
        return p;
    }
    public Pane bodyPane(String t, String i) {
        Pane p = new Pane();
        Text l = new Text(t);
        ImageView icon = new ImageView(i);
        return p;
    }
}