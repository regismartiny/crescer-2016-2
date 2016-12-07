package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entity.Classificacao;
import br.com.cwi.crescer.aula9.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class ClassificacaoService {

    @Autowired
    ClassificacaoRepository repository;

    public Page<Classificacao> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Classificacao> findAll() {
        return repository.findAll();
    }

    public Classificacao save(Classificacao p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Classificacao findOne(Long id) {
        return repository.findOne(id);
    }

}
