public class NaoPodeAlistarException extends Exception
{
    
    public NaoPodeAlistarException() {
        super("Não foi possível alistar o Elfo, pois apenas Elfos Verdes e Noturnos são aceitos.");
    }
   
    public NaoPodeAlistarException(String erro) {}
}
