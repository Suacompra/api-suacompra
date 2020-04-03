package com.suacompra.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.jnlp.IntegrationService;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "consumidor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consumidor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "senha")
    private String senha;
    @Column(name = "cpf")
    private String cpf;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    public Consumidor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }
}
