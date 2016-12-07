package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entity.Elenco;
import br.com.cwi.crescer.aula9.repository.ElencoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class ElencoService {

    @Autowired
    ElencoRepository repository;

    public Page<Elenco> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Elenco> findAll() {
        return repository.findAll();
    }

    public Elenco save(Elenco p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Elenco findOne(Long id) {
        return repository.findOne(id);
    }

}
