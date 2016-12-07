package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entity.Pessoa;
import br.com.cwi.crescer.aula9.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Page<Pessoa> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa save(Pessoa p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Pessoa findOne(Long id) {
        return repository.findOne(id);
    }

}
