package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entity.Usuario;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{

    List<Usuario> findByNome(String nome);
    List<Usuario> findByEmail(String email);
}
