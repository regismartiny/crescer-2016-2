/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import java.util.List;

/**
 *
 * @author regis.martiny
 * @param <T>
 * @param <ID>
 */
public interface IDAO<T, ID> {
    void insert(T t);
    void delete(T t);
    T find(ID id);
    List<T> findAll();
}
