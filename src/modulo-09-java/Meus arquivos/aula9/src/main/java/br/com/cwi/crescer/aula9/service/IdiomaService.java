package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entity.Idioma;
import br.com.cwi.crescer.aula9.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class IdiomaService {

    @Autowired
    IdiomaRepository repository;

    public Page<Idioma> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Idioma> findAll() {
        return repository.findAll();
    }

    public Idioma save(Idioma p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Idioma findOne(Long id) {
        return repository.findOne(id);
    }

}
