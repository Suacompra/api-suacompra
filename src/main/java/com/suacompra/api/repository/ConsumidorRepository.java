package com.suacompra.api.repository;

import com.suacompra.api.model.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsumidorRepository extends JpaRepository<Consumidor, Integer> {

    @Query(value = "SELECT * FROM consumidor WHERE telefone = ?",nativeQuery = true)
    Consumidor findConsumidorByTelefone(String telefone);

    @Query(value = "SELECT * FROM consumidor WHERE telefone = ? AND senha = ?",nativeQuery = true)
    Consumidor login(String telefone, String senha);
}
