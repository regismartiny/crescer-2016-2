package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entity.Filme;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface FilmeRepository extends PagingAndSortingRepository<Filme, Long>{

    List<Filme> findByTitulo(String titulo);
    
}
