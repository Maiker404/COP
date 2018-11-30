package br.edu.ifro.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tarefa implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarefa;
    @Column  
    private Usuario Usuario;
    @Column  
    private String nome;
    @Column  
    private String descri;
    @Column  
    private LocalDate dataLanc;
    @Column  
    private LocalDate dataExp;

    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public LocalDate getDataLanc() {
        return dataLanc;
    }

    public void setDataLanc(LocalDate dataLanc) {
        this.dataLanc = dataLanc;
    }

    public LocalDate getDataExp() {
        return dataExp;
    }

    public void setDataExp(LocalDate dataExp) {
        this.dataExp = dataExp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

