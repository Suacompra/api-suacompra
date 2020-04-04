package com.suacompra.api.controller;

import com.suacompra.api.model.Produto;
import com.suacompra.api.model.Supermercado;
import com.suacompra.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Value("${cdn.images}")
    private String cdnImages;

    @GetMapping("/get-one/{id}")
    ResponseEntity getOneProduto(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(produtoRepository.getOne(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar-produtos-ofertas/{id}")
    ResponseEntity buscarProduto(@PathVariable Integer id){
        try {
            List<Produto> produtoList = produtoRepository.buscarProdutosSupermercado(id);
            List<Produto> produtos = new ArrayList<>();
            if(produtoList!=null && produtoList.size()>0){
                for(Produto produto: produtoList){
                    produto.setImagemProduto1(cdnImages+produto.getImagemProduto1());
                    produto.setImagemProduto2(cdnImages+produto.getImagemProduto2());
                    produto.setImagemProduto3(cdnImages+produto.getImagemProduto3());
                    produtos.add(produto);
                }
            }
            return new ResponseEntity<>(produtos,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
