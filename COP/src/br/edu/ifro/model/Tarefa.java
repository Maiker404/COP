package br.edu.ifro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarefa {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarefa;
    private Integer idUsuario;
    private String Descri,dataLanc,dataExp;
  
    public Integer getIdTarefa() {
        return idTarefa;
    }

   
    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }

   
    public String getDescri() {
        return Descri;
    }

   
    public void setDescri(String Descri) {
        this.Descri = Descri;
    }

   
    public String getDataLanc() {
        return dataLanc;
    }

    
    public void setDataLanc(String dataLanc) {
        this.dataLanc = dataLanc;
    }

    
    public String getDataExp() {
        return dataExp;
    }

    
    public void setDataExp(String dataExp) {
        this.dataExp = dataExp;
    }

    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}

