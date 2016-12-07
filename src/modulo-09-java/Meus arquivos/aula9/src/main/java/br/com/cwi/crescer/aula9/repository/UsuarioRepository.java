package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entity.Pessoa;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>{

    List<Pessoa> findByNome(String nome);
    
}
