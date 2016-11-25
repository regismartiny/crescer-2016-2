/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author regis.martiny
 */
public class PessoaFactory {

    public static void main(String[] args) {
        final String ddl = "CREATE TABLE REGIS ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                statement.executeUpdate(ddl);
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void insert(Pessoa p) {
        final String insert = "INSERT INTO REGIS("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES (?, ?)";
        try (final PreparedStatement preparedStatement = ConnectionUtils.getConnection().prepareStatement(insert)) {
            for (int i = 1; i <= 10; i++) {
                preparedStatement.setLong(1, p.getIdPessoa());
                preparedStatement.setString(2, p.getNmPessoa());
                preparedStatement.executeUpdate();
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
    public List<Pessoa> findAll(){
        List<Pessoa> pessoas = new ArrayList<>();
        final String query = "SELECT * FROM REGIS";
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()) {
            try (final ResultSet resultSet = statement.executeQuery(query)) {
                while(resultSet.next()){
                    Pessoa p = new Pessoa();
                    p.setIdPessoa(resultSet.getLong("ID_PESSOA"));
                    p.setNmPessoa(resultSet.getString("NM_PESSOA"));
                    pessoas.add(p);
                }
                return pessoas;
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return null;
    }
    
    

}
