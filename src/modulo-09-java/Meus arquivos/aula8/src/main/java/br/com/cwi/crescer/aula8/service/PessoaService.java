/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.dto.Pessoa;
import br.com.cwi.crescer.aula8.repository.IPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author regis.martiny
 */
@Service
public class PessoaService {
    
    @Autowired
    IPessoaRepository pessoaRepository;

    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Carlos H. Nonnemacher");
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }

}
