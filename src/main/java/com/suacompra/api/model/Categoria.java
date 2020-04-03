package com.suacompra.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categoria")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public Categoria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
