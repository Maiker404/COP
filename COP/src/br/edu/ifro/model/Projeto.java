package br.edu.ifro.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.ObservableList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Projeto implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProjeto;
    @Column
    private String dataFinal;
    @Column
    private String dataInicial;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column    
    @ManyToMany
    private ObservableList<Usuario> equipe;
    @Column    
    @OneToMany
    private ArrayList<Tarefa> tarefas;

    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ObservableList<Usuario> getEquipe() {
        return equipe;
    }

    public void setEquipe(ObservableList<Usuario> equipe) {
        this.equipe = equipe;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }
}