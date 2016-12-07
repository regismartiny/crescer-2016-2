/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula9.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author regis
 */
@Entity
@Table(name = "IDIOMA")
public class Idioma implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_IDIOMA")
    @SequenceGenerator(name = "SEQ_IDIOMA", sequenceName = "SEQ_IDIOMA", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_CLASSIFICACAO")
    private Long idIdioma;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) obj;
        if (idIdioma == null) {
            if (other.idIdioma != null) {
                return false;
            }
        } else if (!idIdioma.equals(other.idIdioma)) {
            return false;
        }
        return true;
    }
}
