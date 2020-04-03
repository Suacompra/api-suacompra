package com.suacompra.api.controller;

import com.suacompra.api.model.Supermercado;
import com.suacompra.api.repository.SupermercadoRepository;
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
@RequestMapping(value = "supermercado")
public class SupermercadoController {

    @Autowired
    SupermercadoRepository supermercadoRepository;

    @Value("${cdn.images}")
    private String cdnImages;

    @GetMapping("/get-one/{id}")
    ResponseEntity getOneSupermercado(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(supermercadoRepository.getOne(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/list-cep/{cep}")
    ResponseEntity listByCep(@PathVariable String cep){
        try {
            List<Supermercado> supermercadoList = supermercadoRepository.listarPorCep(cep);
            List<Supermercado> supermercados = new ArrayList<>();
            if(supermercadoList!=null && supermercadoList.size()>0){
                for(Supermercado supermercado: supermercadoList){
                    supermercado.setLogoSupermercado(cdnImages+supermercado.getLogoSupermercado());
                    supermercados.add(supermercado);
                }
            }
            return new ResponseEntity<>( supermercados,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
