package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MeuCalendarioUtil {

    public static void main(String[] args) {
        System.out.println("--MeuStringUtil--");
        Scanner s = new Scanner(System.in);
        int entrada = -1;
        while (entrada != 0) {
            String str;
            System.out.println("Insira a data(dd/mm/yyyy):");
            str = s.next();
            System.out.println("Escolha uma operação:");
            System.out.println("1) getDiaSemana");
            System.out.println("2) getTempoDecorridoAteDataAtual");
            System.out.println("0) Sair");
            entrada = s.nextInt();
            String resposta = null;
            switch (entrada) {
                case 1:
                    resposta = getDiaSemana(str) + "";
                    break;
                case 2:
                    resposta = getTempoDecorridoAteDataAtual(str) + "";
                    break;
                default:
                    resposta = "Saiu";
                    break;
            }
            System.out.println("Resultado: " + resposta);
        }

    }

    public static String getDiaSemana(String strData) {
        Date date;
        date = interpretarData(strData);
        DateFormat diaSemana = new SimpleDateFormat("EEEE");
        String diaDaSemana = diaSemana.format(date);
        return diaDaSemana;
    }

    public static String getTempoDecorridoAteDataAtual(String strData) {
        String resultado = null;
        boolean decMes = false, decAno = false;
        Date data = interpretarData(strData);
        Calendar a = getCalendar(data);
        Calendar b = getCalendar(null);
        int diaAtual = b.get(Calendar.DAY_OF_MONTH);
        int dia = a.get(Calendar.DAY_OF_MONTH);
        int dias = Math.abs(diaAtual - dia);
        if (diaAtual < dia) {
            dias = Math.abs(dias - 30);
            decMes = true;
        }

        int mesAtual = b.get(Calendar.MONTH);
        int mes = a.get(Calendar.MONTH);
        int meses = Math.abs(mesAtual - mes);
        if (mesAtual < mes) {
            meses = Math.abs(meses - 12);
            decAno = true;
        }
        if (decMes) {
            meses--;
        }

        int anoAtual = b.get(Calendar.YEAR);
        int ano = a.get(Calendar.YEAR);
        int anos = anoAtual - ano;
        if (ano > anoAtual) {
            anos--;
        }
        if (decAno) {
            anos--;
        }

        resultado = anos + " ano(s), " + meses + " mes(es), " + dias + " dia(s).";
        return resultado;
    }

    public static Date interpretarData(String strData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = simpleDateFormat.parse(strData);
            return date;
        } catch (ParseException e) {
            System.out.println("A data inserida não pôde ser interpretada.");
        }
        return null;
    }

    private static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal;
    }

}
