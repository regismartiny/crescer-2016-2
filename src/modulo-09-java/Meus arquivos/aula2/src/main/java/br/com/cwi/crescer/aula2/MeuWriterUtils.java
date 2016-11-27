/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author regis
 */
public class MeuWriterUtils {

    public static void gravarArquivo(String caminhoArquivo, List<String> conteudo, boolean append) {
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            if (arquivo.isFile()) {
                if (!arquivo.getName().split("\\.")[1].equalsIgnoreCase("txt")) {
                    System.out.println("Arquivo incompativel!");
                } else {
                    gravarConteudo(arquivo, conteudo, append);
                }
            } else {
                System.out.println("Nao e um arquivo!");
            }
        } else {
            System.out.println("O arquivo nao existe!");
        }
    }

    private static void gravarConteudo(File arquivo, List<String> conteudo, boolean append) {
        try (
                final Writer writer = new FileWriter(arquivo, append);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) 
        {
            for (int i=0; i < conteudo.size(); i++) {
                if (i > 0)
                    bufferedWriter.newLine();
                bufferedWriter.append(conteudo.get(i));
            }

            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
