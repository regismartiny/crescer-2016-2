/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author regis
 */
public class MeuReaderUtils {

    public static String[] lerArquivo(String caminhoArquivo, String extensao) {
        if (extensao == null) extensao = "txt";
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            if (arquivo.isFile()) {
                if (!arquivo.getName().split("\\.")[1].equalsIgnoreCase(extensao)) {
                    System.out.println("Arquivo incompativel!");
                } else {
                    return lerConteudo(arquivo);
                }
            } else {
                System.out.println("Nao e um arquivo!");
            }
        } else {
            System.out.println("O arquivo nao existe!");
        }
        return null;
    }

    public static String[] lerConteudo(File arquivo) {
        ArrayList<String> conteudo = new ArrayList<>();
        try (   
            final Reader reader = new FileReader(arquivo);
            final BufferedReader bufferReader = new BufferedReader(reader);
        ) {
            bufferReader.lines()
                    .forEach(conteudo::add);
        } catch (IOException ex) {
            Logger.getLogger(MeuReaderUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conteudo.toArray(new String[0]);
    }
}
