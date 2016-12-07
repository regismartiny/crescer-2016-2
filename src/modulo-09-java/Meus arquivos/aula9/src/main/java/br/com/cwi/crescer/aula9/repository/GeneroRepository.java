package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entity.Genero;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface GeneroRepository extends PagingAndSortingRepository<Genero, Long>{

    List<Genero> findByDescricao(String descricao);
    
}
