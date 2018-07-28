package br.edu.ifro.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
//@Transient
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String senha;
    @Column(unique=true)
    private String user;
    @Column
    private String permisao;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private String funcao;
    
    public String getPermisao() {
        return permisao;
    }
    public void setPermisao(String permisao) {
        this.permisao = permisao;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}