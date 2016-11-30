/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios;

import br.com.cwi.crescer.aula2.ConnectionUtils;
import br.com.cwi.crescer.aula2.MeuReaderUtils;
import br.com.cwi.crescer.aula2.MeuWriterUtils;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author regis
 */
public class ExportadorCSV {

    public static void exportarCSV(String caminhoArquivo, String nomeTabela) {
        List<String> conteudo = new ArrayList<>();
        String query = "SELECT * FROM " + nomeTabela.toUpperCase();
        String[][] lista = executarSQL(query);
        for (String[] l : lista) {
            String linha = String.join(";", l);
            conteudo.add(linha);
        }
        try {
            File arquivo = new File(caminhoArquivo);
            arquivo.createNewFile();
            MeuWriterUtils.gravarConteudo(arquivo, conteudo, false);
        } catch (IOException ex) {
            Logger.getLogger(ExportadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String[][] executarSQL(String query) {
        final ArrayList<String[]> result = new ArrayList<>();
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            try (final ResultSet resultSet = statement.executeQuery(query)) {

                int i = 0;
                while (resultSet.next()) {
                    String[] linha = resultSet.getArray(i);
                    result.add(linha);
                    i++;
                }
                return result.toArray(new String[0][0]);

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return null;
    }

}
