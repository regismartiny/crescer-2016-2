package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entity.Ator;
import br.com.cwi.crescer.aula9.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class AtorService {

    @Autowired
    AtorRepository repository;

    public Page<Ator> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Ator> findAll() {
        return repository.findAll();
    }

    public Ator save(Ator p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Ator findOne(Long id) {
        return repository.findOne(id);
    }

}
