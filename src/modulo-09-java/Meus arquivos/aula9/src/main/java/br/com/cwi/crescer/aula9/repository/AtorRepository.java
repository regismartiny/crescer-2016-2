package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entity.Ator;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface AtorRepository extends PagingAndSortingRepository<Ator, Long>{

    List<Ator> findByNome(String nome);
    
}
