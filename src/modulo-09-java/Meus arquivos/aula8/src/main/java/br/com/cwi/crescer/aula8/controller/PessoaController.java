/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.dto.PessoaDto;
import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author regis.martiny
 */
@RestController
public class PessoaController {

    @Autowired
    PessoaService service;

    @RequestMapping(value = "/pessoa.json", method = RequestMethod.GET)
    public Iterable<Pessoa> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST)
    public Iterable<Pessoa> add(@RequestBody Pessoa p) {
        p.setDtNascimento(new Date());
        service.add(p);
        return service.listAll();
    }
    
    @RequestMapping(value = "/pessoa.json", method = RequestMethod.DELETE)
    public Iterable<Pessoa> delete(long id) {
        Pessoa p = service.findById(id);
        if (p != null)
            service.delete(p);
        return service.listAll();
    }

}
