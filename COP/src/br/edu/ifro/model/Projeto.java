package br.edu.ifro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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
    private LocalDate dataFinal;
    @Column
    private LocalDate dataInicial;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    @ManyToMany
    private List<Usuario> equipe;
    @Column
    @OneToMany
    private List<Tarefa> tarefas;

    @Override
    public String toString() {
        return "Codigo: "+this.getIdProjeto() + " - Nome: " + this.getNome()+" - Equipe: "+this.getEquipe().size()+" pessoas - Tarefas: "+this.getTarefas().size();
    }

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

    public List<Usuario> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Usuario> equipe) {
        this.equipe = equipe;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }
}
