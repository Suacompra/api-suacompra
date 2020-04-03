package com.suacompra.api.controller;

import com.suacompra.api.model.Consumidor;
import com.suacompra.api.repository.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "consumidor")
public class ConsumidorController {

    @Autowired
    ConsumidorRepository consumidorRepository;

    @GetMapping("/get-one/{id}")
    ResponseEntity getOneConsumidor(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(consumidorRepository.getOne(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cadastrar")
    ResponseEntity saveConsumidor(@RequestBody Consumidor consumidor){
        try {
            Consumidor oldConsumidor = consumidorRepository.findConsumidorByTelefone(consumidor.getTelefone());
            if(oldConsumidor==null){
                return new ResponseEntity<>(consumidorRepository.save(consumidor), HttpStatus.OK);
            }else{
                oldConsumidor = new Consumidor();
                oldConsumidor.setId(0);
                return new ResponseEntity<>(oldConsumidor, HttpStatus.OK);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/login/{telefone}/{senha}")
    ResponseEntity loginConsumidor(@PathVariable String telefone, @PathVariable String senha) {
        try {
            Consumidor consumidor = consumidorRepository.login(telefone,senha);
            if(consumidor==null){
                consumidor = new Consumidor();
            }
            return new ResponseEntity<>(consumidor, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}