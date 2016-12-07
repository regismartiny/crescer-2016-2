package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entity.Filme;
import br.com.cwi.crescer.aula9.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class FilmeService {

    @Autowired
    FilmeRepository repository;

    public Page<Filme> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Filme> findAll() {
        return repository.findAll();
    }

    public Filme save(Filme p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Filme findOne(Long id) {
        return repository.findOne(id);
    }

}
