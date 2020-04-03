package com.suacompra.api.controller;

import com.suacompra.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/get-one/{id}")
    ResponseEntity getOneProduto(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(produtoRepository.getOne(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
