package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entity.Genero;
import br.com.cwi.crescer.aula9.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class GeneroService {

    @Autowired
    GeneroRepository repository;

    public Page<Genero> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Genero> findAll() {
        return repository.findAll();
    }

    public Genero save(Genero p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Genero findOne(Long id) {
        return repository.findOne(id);
    }

}
