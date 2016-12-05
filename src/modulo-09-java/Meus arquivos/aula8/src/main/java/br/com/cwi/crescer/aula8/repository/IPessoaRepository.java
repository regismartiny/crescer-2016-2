/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.repository;

import br.com.cwi.crescer.aula8.dto.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author regis.martiny
 */
public interface IPessoaRepository extends CrudRepository<Pessoa, Long> {
    Pessoa findById(int id);
    Iterable<Pessoa> findByNome(String nome);
}
