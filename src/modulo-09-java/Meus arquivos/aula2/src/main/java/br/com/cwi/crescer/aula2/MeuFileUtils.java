/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author regis
 */
public class MeuFileUtils {

    private Scanner scan = new Scanner(System.in);

    public String[] lerComando() {
        String strCmd = scan.nextLine();
        String[] cmdList = strCmd.split(" ");
        return cmdList;
    }

    public void executarComando(String[] cmd) throws Exception {
        String action = cmd[0];
        switch (cmd.length) {
            case 1:
                if (action.equalsIgnoreCase("ls")) {
                    listarArquivoDiretorio(".");
                }
                break;
            case 2:
                String arquivoDir = cmd[1];
                if (action.equalsIgnoreCase("mk")) {
                    criarArquivoDiretorio(arquivoDir);
                } else if (action.equalsIgnoreCase("rm")) {
                    excluirArquivoDiretorio(arquivoDir);
                } else if (action.equalsIgnoreCase("ls")) {
                    listarArquivoDiretorio(arquivoDir);
                }
                break;
            case 3:
                String arquivoOrigem = cmd[1];
                String arquivoDestino = cmd[2];
                if (action.equalsIgnoreCase("mv")) {
                    moverArquivo(arquivoOrigem, arquivoDestino);
                }
                break;
            default:
                throw new Exception("Comando nao reconhecido!");
        }
    }

    private void criarArquivoDiretorio(String arquivoDir) throws Exception {
        try {
            String[] fileStr = arquivoDir.split("\\.");
            File arquivo;
            boolean isDir = false;
            int length = fileStr.length;
            if (length > 0 && length < 3) {
                if (length == 1) { //is directory
                    String nome = fileStr[0];
                    arquivo = new File(nome);
                    isDir = true;
                } else {//is file
                    String nome = fileStr[0];
                    String ext = fileStr[1];
                    arquivo = new File(nome + "." + ext);
                }
                //verifica se o arquivo existe
                if (!arquivo.exists()) {
                    // cria o arquivo
                    if (isDir){
                        arquivo.mkdir();
                    }
                    else
                        arquivo.createNewFile();
                }
            }else{
                throw new Exception("Nome de diretorio/arquivo invalido!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void excluirArquivoDiretorio(String arquivoDir) throws Exception {
        File arquivo = new File(arquivoDir);
        if (arquivo.isDirectory()) {
            throw new Exception("Arquivo invalido!");
        } else if (arquivo.isFile()) {
            final boolean b = new File(arquivoDir).delete();
        }

    }

    private void listarArquivoDiretorio(String arquivoDir) {
        File arquivo = new File(arquivoDir);
        if (arquivo.isDirectory()) {
            final String[] list = arquivo.list();
            for (String item : list) {
                System.out.println(item);
            }
        } else if (arquivo.isFile()) {
            final String path = arquivo.getAbsolutePath();
            System.out.println(path);
        }

    }

    private void moverArquivo(String arquivoOrigem, String arquivoDestino) throws Exception {
        File fileOrigem = new File(arquivoOrigem);
        File fileDestino = new File(arquivoDestino);
        if (fileOrigem.isDirectory()) {
            throw new Exception("Arquivo invalido!");
        } else if (fileOrigem.isFile()) {
            // copia os dados
            InputStream in;
            // escreve os dados
            OutputStream out;
            try {
                //verifica se o arquivo existe
                if (!fileDestino.exists()) {
                    //verifica se a pasta existe
                    if (!fileDestino.getParentFile().exists()) {
                        //cria a pasta
                        fileDestino.getParentFile().mkdir();
                    }
                    // cria o arquivo
                    fileDestino.createNewFile();
                }
                in = new FileInputStream(fileOrigem);
                out = new FileOutputStream(fileDestino);
                // buffer para transportar os dados
                byte[] buffer = new byte[1024];
                int length;
                // enquanto tiver dados para ler..
                while ((length = in.read(buffer)) > 0) {
                    // escreve no novo arquivo
                    out.write(buffer, 0, length);
                }

                in.close();
                out.close();
                //apaga o arquivo antigo
                fileOrigem.delete();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
