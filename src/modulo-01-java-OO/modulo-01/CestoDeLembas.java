public class CestoDeLembas
{
    private int paes;

    /**
     * COnstrutor para objetos da classe CestoDeLembas
     */
    public CestoDeLembas(int paes)
    {
       if(paes >= 1 && paes <= 100){
           this.paes = paes;
       }
       else{
           this.paes = 0;
           System.out.println("Número de pães deve estar entre 1 e 100");
        }
    }

    public boolean podeDividirEmPares()
    {
        return (paes%2) == 0;
    }
    
    public int getPaes() {
        return paes;
    }
}
