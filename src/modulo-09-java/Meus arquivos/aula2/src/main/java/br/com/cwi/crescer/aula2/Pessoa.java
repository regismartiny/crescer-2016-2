/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

/**
 *
 * @author regis.martiny
 */
public class Pessoa {
    private Long idPessoa;
    private String nmPessoa;

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }
    
}
