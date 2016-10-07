import java.util.*;

public interface Exercito
{
   Elfo[] getContingente();
   
   void alistar(Elfo elfo) throws NaoPodeAlistarException;
   
   Elfo buscar(String nome);
   
   ArrayList<Elfo> buscar(Status status);
   
   void atacar();
}
