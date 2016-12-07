package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entity.Classificacao;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface ClassificacaoRepository extends PagingAndSortingRepository<Classificacao, Long>{

    List<Classificacao> findByDescricao(String descricao);
    
}
