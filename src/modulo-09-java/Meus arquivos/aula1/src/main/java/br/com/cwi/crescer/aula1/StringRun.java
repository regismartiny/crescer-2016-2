/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author regis.martiny
 */
public class StringRun {
    public static void main(String[] args) {
        /*if ("A" == new String("A")) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }*/
        
        /*System.out.println("Insira a frase");
        Scanner s = new Scanner(System.in);
        
        String frase = s.next();
        
        int nVogais = contarVogais(frase);
        System.out.println("Número de vogais: " + nVogais);
        
        String fraseInvertida = inverterFrase(frase);
        System.out.println("Frase invertida: " + fraseInvertida);*/
        
        ArrayList<String> estados = ordenarEstados();
        System.out.println("Estados: " + concatenarArray(estados));
        
    }
    
    public static int contarVogais(String frase){
        int count = 0;
        String fraseLower = frase.toLowerCase();
        
        char[] vogais = {'a', 'e', 'i', 'o', 'u'};
        for(int i=0; i < fraseLower.length(); i++){
            char letra = fraseLower.charAt(i);
            for (int j=0; j < vogais.length; j++){
                if (vogais[j] == letra) count ++;
            }
        }
        return count;
    }
    
    public static String inverterFrase(String frase){
        return new StringBuilder(frase).reverse().toString();
    }
    
    
    
    public static ArrayList<String> ordenarEstados(){
        ArrayList<String> lista = new ArrayList<>();
        for(Estados e : Estados.values()){
            lista.add(e.getNome());
        }
        Collections.sort(lista, (a ,b) -> a.compareToIgnoreCase(b));
        return lista;
    }
    
    public static String concatenarArray(ArrayList<String> lista) {
        //Java 8
        //return String.join(", ", lista);
        String resultado = "";
        
        //StringBuffer sb = new StringBuffer(resultado);
        StringBuilder sb = new StringBuilder(resultado);
        int i = 0;
        for(String s : lista){
            if (i > 0) sb.append(", ");
            sb.append(s);
            i++;
        }
        return sb.toString();     
    }
}
