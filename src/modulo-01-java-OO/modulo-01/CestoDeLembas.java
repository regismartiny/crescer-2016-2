public class CestoDeLembas
{
    private int paes;

    /**
     * COnstrutor para objetos da classe CestoDeLembas
     */
    public CestoDeLembas(int paes)
    {
       this.paes = paes;
    }

    public boolean podeDividirEmPares()
    {
        boolean maiorQueDois = paes > 2;
        boolean ehPar = (paes%2) == 0;
        return ( ehPar && maiorQueDois && paes <= 100 );
    }
    
    public int getPaes() {
        return paes;
    }
}
