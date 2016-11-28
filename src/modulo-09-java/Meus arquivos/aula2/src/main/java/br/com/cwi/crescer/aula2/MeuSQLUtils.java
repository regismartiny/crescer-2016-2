/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author regis
 */
public class MeuSQLUtils {

    public static void executarArquivoSQL(String caminhoArquivo) {
        boolean valido = validarArquivo(caminhoArquivo, "sql");
        if (valido) {
            carregarEExecutarSQL(caminhoArquivo);
        }
    }

    public static void importarCSV(String caminhoArquivo) {
        boolean valido = validarArquivo(caminhoArquivo, "csv");
        if (valido) {
            carregarEImportarCSV(caminhoArquivo);
        }
    }

    public static void exportarCSV(String caminhoArquivo) {

    }

    public static boolean validarArquivo(String caminhoArquivo, String extensao) {
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            if (arquivo.isFile()) {
                if (!arquivo.getName().split("\\.")[1].equalsIgnoreCase(extensao)) {
                    System.out.println("Arquivo incompativel!");
                } else {
                    return true;
                }
            } else {
                System.out.println("Nao e um arquivo!");
            }
        } else {
            System.out.println("O arquivo nao existe!");
        }
        return false;
    }

    private static String carregarEExecutarSQL(String caminhoArquivo) {
        String[] conteudo = MeuReaderUtils.lerArquivo(caminhoArquivo);
        return executarSQL(String.join("\n", conteudo));
    }

    public static String executarSQL(final String query) {
        final String result;
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            try (final ResultSet resultSet = statement.executeQuery(query)) {

                result = resultSet.toString();
                return result;

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return null;
    }

    private static void carregarEImportarCSV(String caminhoArquivo) {
        String[] conteudo = MeuReaderUtils.lerArquivo(caminhoArquivo);
        importarConteudoCSV(conteudo);
    }

    private static void importarConteudoCSV(String[] conteudo) {

    }

}
