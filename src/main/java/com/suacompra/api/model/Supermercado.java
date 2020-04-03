package com.suacompra.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supermercado")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supermercado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_supermercado")
    private Integer id;
    @Column(name = "id_rede")
    private Integer idRede;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @Column(name = "logo_supermercado")
    private String logoSupermercado;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    public Supermercado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRede() {
        return idRede;
    }

    public void setIdRede(Integer idRede) {
        this.idRede = idRede;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public String getLogoSupermercado() {
        return logoSupermercado;
    }

    public void setLogoSupermercado(String logoSupermercado) {
        this.logoSupermercado = logoSupermercado;
    }

}
