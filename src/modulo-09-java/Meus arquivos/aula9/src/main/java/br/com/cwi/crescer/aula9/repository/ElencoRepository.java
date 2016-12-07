package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entity.Elenco;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface ElencoRepository extends PagingAndSortingRepository<Elenco, Long>{

    List<Elenco> findByNome(String nome);
    
}
