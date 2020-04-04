package com.suacompra.api.repository;

import com.suacompra.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query(value = "SELECT * FROM produto WHERE ativo = true AND id_supermercado = ?1",nativeQuery = true)
    List<Produto> buscarProdutosSupermercado(Integer id);
}
