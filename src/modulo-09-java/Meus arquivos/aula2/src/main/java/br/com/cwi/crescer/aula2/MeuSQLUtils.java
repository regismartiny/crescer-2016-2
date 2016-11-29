/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author regis
 */
public class MeuSQLUtils {

    public static void executarArquivoSQL(String caminhoArquivo) {
        carregarEExecutarSQL(caminhoArquivo);
    }

    public static void importarCSV(String caminhoArquivo) {
        carregarEImportarCSV(caminhoArquivo);
    }

    public static void exportarCSV(String caminhoArquivo) {
        List<String> conteudo = new ArrayList<>();
        String query = "SELECT * FROM PESSOA";
        Pessoa[] pessoas = executarSQL(query);
        for (Pessoa p : pessoas) {
            String linha = p.getIdPessoa() + ";" + p.getNmPessoa();
            conteudo.add(linha);
        }
        try {
            File arquivo = new File(caminhoArquivo);
            arquivo.createNewFile();
            MeuWriterUtils.gravarConteudo(arquivo, conteudo, false);
        } catch (IOException ex) {
            Logger.getLogger(MeuSQLUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void carregarEExecutarSQL(String caminhoArquivo) {
        String[] conteudo = MeuReaderUtils.lerArquivo(caminhoArquivo, "sql");
        executarSQL(String.join("\n", conteudo));
    }

    public static Pessoa[] executarSQL(String query) {
        final ArrayList<Pessoa> result = new ArrayList<>();
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            try (final ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    final long idPessoa = resultSet.getLong("ID_PESSOA");
                    final String nmPessoa = resultSet.getString("NM_PESSOA");

                    Pessoa p = new Pessoa();
                    p.setIdPessoa(idPessoa);
                    p.setNmPessoa(nmPessoa);

                    result.add(p);

                    System.out.format("ID: %s NOME: %s\n", idPessoa, nmPessoa);
                }
                return result.toArray(new Pessoa[0]);

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return null;
    }

    private static void carregarEImportarCSV(String caminhoArquivo) {
        String[] conteudo = MeuReaderUtils.lerArquivo(caminhoArquivo, "csv");
        importarConteudoCSV(conteudo);
    }

    private static void importarConteudoCSV(String[] conteudo) {

        final String insert = "INSERT INTO PESSOA("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES (?, ?)";
        try (final Connection connection = ConnectionUtils.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            for (int i = 0; conteudo.length > i; i++) {
                String[] linhas = conteudo[i].split(";");
                Long id = Long.parseLong(linhas[0]);
                String nome = linhas[1];
                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, nome);
                preparedStatement.executeUpdate();
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

}
