package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entity.Usuario;
import br.com.cwi.crescer.aula9.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Page<Usuario> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario save(Usuario p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Usuario findOne(Long id) {
        return repository.findOne(id);
    }
    
    public List<Usuario> findByEmail(String email){
        return repository.findByEmail(email);
    }

}
