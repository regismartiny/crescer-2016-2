/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.dao.PessoaDAO;
import br.com.cwi.crescer.aula3.entity.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author regis.martiny
 */
public class Run {

    public static void main(String[] args) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();
        
        final PessoaDAO pessoaDAO = new PessoaDAO(em);
        Pessoa pessoa = new Pessoa();
        //pessoa.setIdPessoa(1l);
        pessoa.setNmPessoa("RÉGIS");
        pessoaDAO.insert(pessoa);
        
        //final Pessoa p = pessoaDAO.find(1l);
        //System.out.println(p.getNmPessoa());
        
        pessoaDAO.findAll().forEach(p -> System.out.println(p.getNmPessoa()));
        
        //pessoaDAO.delete(p);
        
        em.close();
        emf.close();
    }
}
