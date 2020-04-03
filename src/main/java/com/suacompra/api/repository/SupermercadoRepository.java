package com.suacompra.api.repository;

import com.suacompra.api.model.Supermercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer> {

    @Query(value = "SELECT s.* FROM supermercado AS s INNER JOIN localidade AS l ON s.id_localidade = l.id_localidade WHERE l.cep = ?1",nativeQuery = true)
    List<Supermercado> listarPorCep(String cep);
}
