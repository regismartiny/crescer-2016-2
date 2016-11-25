package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parcelator {

    public static void main(String[] args) {
        System.out.println(getParcelas(1000, 10, 10, "20/10/2016"));

    }

    public static String getParcelas(double valor, double txJuros, int parcelas, String strDataVencimento) {
        Date dataVencimento = MeuCalendarioUtil.interpretarData(strDataVencimento);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataVencimento);
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat formatoValor = NumberFormat.getCurrencyInstance();

        String resultado = "";
        for (int i = 0; i < parcelas; i++) {
            Date data = cal.getTime();

            String strData = formatoData.format(data);
            double valorParcela = valor / parcelas + valor / parcelas * txJuros / 100;
            String strValor = formatoValor.format(valorParcela);

            resultado += i + ". " + strData + " - " + strValor + "\n";

            cal.add(Calendar.MONTH, 1);
        }
        return resultado;
    }

}
