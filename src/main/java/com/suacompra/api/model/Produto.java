package com.suacompra.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "marca")
    private String marca;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private Double preco;
    @Column(name = "preco_promocao")
    private Double precoPromocao;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "cod_barras")
    private String codBarras;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "estoque")
    private Integer estoque;
    @Column(name = "conteudo")
    private String conteudo;
    @Column(name = "imagem_produto_1")
    private String imagemProduto1;
    @Column(name = "imagem_produto_2")
    private String imagemProduto2;
    @Column(name = "imagem_produto_3")
    private String imagemProduto3;

    @Transient
    private String textoAtivo;

    @ManyToOne
    @JoinColumn(name = "id_supermercado")
    private Supermercado supermercado;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPrecoPromocao() {
        return precoPromocao;
    }

    public void setPrecoPromocao(Double precoPromocao) {
        this.precoPromocao = precoPromocao;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getImagemProduto1() {
        return imagemProduto1;
    }

    public void setImagemProduto1(String imagemProduto1) {
        this.imagemProduto1 = imagemProduto1;
    }

    public String getImagemProduto2() {
        return imagemProduto2;
    }

    public void setImagemProduto2(String imagemProduto2) {
        this.imagemProduto2 = imagemProduto2;
    }

    public String getImagemProduto3() {
        return imagemProduto3;
    }

    public void setImagemProduto3(String imagemProduto3) {
        this.imagemProduto3 = imagemProduto3;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTextoAtivo() {
        return textoAtivo;
    }

    public void setTextoAtivo(String textoAtivo) {
        this.textoAtivo = textoAtivo;
    }
}
