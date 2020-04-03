package com.suacompra.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "localidade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_localidade")
    private Integer id;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "numero")
    private String numero;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "estado")
    private String estado;
    @Column(name = "referencia")
    private String referencia;


    public Localidade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
