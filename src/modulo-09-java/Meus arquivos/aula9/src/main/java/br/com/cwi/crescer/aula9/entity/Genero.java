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
@Table(name = "GENERO")
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_GENERO")
    private Long idGenero;

    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
       
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) obj;
        if (idGenero == null) {
            if (other.idGenero != null) {
                return false;
            }
        } else if (!idGenero.equals(other.idGenero)) {
            return false;
        }
        return true;
    }
}
