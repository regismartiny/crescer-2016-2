import java.util.ArrayList;

public class HobbitContador
{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arr) {
        int somaDasDiferencas = 0;
        //calcular a soma da diferença entre o produto e o mínimo múltiplo comum de cada par
        for (ArrayList<Integer> par : arr) {
            int produto = par.get(0) * par.get(1);
            int mmc = MMC(par.get(0), par.get(1));
            int diferenca = produto - mmc;
            somaDasDiferencas += diferenca;
        }

        return somaDasDiferencas;
    }

    private int MMC(int num1, int num2)
    {
        int x,y,r,mmc;

        x = num1;
        y = num2;
        do
        {
            r = x % y;
            x = y;
            y = r;
        } 
        while (r != 0);

        mmc = (num1 * num2) / x;

        return mmc;
    }
}
