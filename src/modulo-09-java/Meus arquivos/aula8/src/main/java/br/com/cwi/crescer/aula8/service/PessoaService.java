/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Pessoa;
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

    public Iterable<Pessoa> listAll() {
        return pessoaRepository.findAll();
    }
    
    public void add(Pessoa p) {
        pessoaRepository.save(p);
    }
    
    public void delete(Pessoa p){
        pessoaRepository.delete(p);
    }
    
    public Pessoa findById(long id){
        return pessoaRepository.findById(id);
    }
}
