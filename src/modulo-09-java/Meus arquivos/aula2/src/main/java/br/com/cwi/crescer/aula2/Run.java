/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author regis.martiny
 */
public class Run {

    public static void main(String[] args) {
        /*
        final String query = "SELECT * FROM REGIS";
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()) {
            try (final ResultSet resultSet = statement.executeQuery(query)) {
                while(resultSet.next()){
                    final long aLong = resultSet.getLong("ID_PESSOA");
                    final String nmPessoa = resultSet.getString("NM_PESSOA");
                    System.out.format("ID: %s NOME: %s", aLong, nmPessoa);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }*/
        
        /*MeuFileUtils mfu = new MeuFileUtils();
        System.out.println("==Prompt de comandos==");
        while(true){
            try {
                mfu.executarComando(mfu.lerComando());
            } catch (Exception ex) {
                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
        String[] linhas = MeuReaderUtils.lerArquivo("teste.txt");
        for(String linha : linhas){
            System.out.println(linha);
        }
        
        List<String> conteudo = Arrays.asList(new String[]{"one", "two", "three"});
        MeuWriterUtils.gravarArquivo("teste.txt", conteudo, false);
    }

}
