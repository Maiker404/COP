package br.edu.ifro.model;
import com.google.common.hash.Hashing;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
//@Transient
public class Usuario implements Serializable {

    @ManyToMany(mappedBy = "equipe")
    private List<Projeto> projetos;
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
    @Column
    private String cpf;
    @Column
    private String datanasc;
    @Column
    private String rua;
    @Column
    private String bairro;
    @Column
    private String cep;
    @Column
    private String numero;
    @Override
    public String toString(){
        return this.id+" - "+this.user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return Hashing.sha256().hashString(senha, StandardCharsets.UTF_8).toString();
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

    public String getPermisao() {
        return permisao;
    }

    public void setPermisao(String permisao) {
        this.permisao = permisao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}