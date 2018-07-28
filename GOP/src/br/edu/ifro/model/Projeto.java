package br.edu.ifro.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Projeto {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idProjeto;
   private Integer idUsuario;
   private String idTarefa;

    
    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(String idTarefa) {
        this.idTarefa = idTarefa;
    }
}

