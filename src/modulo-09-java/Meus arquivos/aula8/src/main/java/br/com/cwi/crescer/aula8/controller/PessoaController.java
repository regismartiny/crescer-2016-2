/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.dto.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    private List<Pessoa> pessoas;

    @RequestMapping(value = "/pessoa.json", method = RequestMethod.GET)
    public List<Pessoa> list() {
        return pessoas;
    }

    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST)
    public List<Pessoa> list(@RequestBody Pessoa p) {
        p.setNascimento(new Date());

        if (pessoas == null) {
            pessoas = new ArrayList<>();
        }
        pessoas.add(p);
        return Stream.of(p).collect(Collectors.toList());
    }

}
