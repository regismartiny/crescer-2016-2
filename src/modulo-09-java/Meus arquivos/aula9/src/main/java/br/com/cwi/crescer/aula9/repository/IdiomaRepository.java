package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entity.Idioma;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface IdiomaRepository extends PagingAndSortingRepository<Idioma, Long>{

    List<Idioma> findByNome(String nome);
    
}
