/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author regis.martiny
 */
public class ExDatas {
    
    public static void main(String[] args){
        System.out.println("Data atual: " + getDataAtual());
        System.out.println("Insira sua data de nascimento(dd/MM/yyyy): ");
        Scanner s = new Scanner(System.in);
        String dataNascimento = s.next();
        System.out.println("Dia da semana do nascimento: " + getDiaSemana(dataNascimento));
    }
    
    public static String getDataAtual() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String data = simpleDateFormat.format(date);
        return data;
    }
    
    public static String getDiaSemana(String data){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date date = simpleDateFormat.parse(data);
            DateFormat diaSemana = new SimpleDateFormat("EEEE");
            String diaDaSemana = diaSemana.format(date);
            return diaDaSemana;
        }catch(ParseException e){
            System.out.println("A data inserida não pôde ser interpretada.");
        }
        return null;
    }
    
}
