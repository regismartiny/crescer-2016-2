import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest
{
   @Test 
   public void listaProporcionalDeElfosVivos() throws ContingenteDesproporcionalException {
       List<Elfo> lista = new ArrayList<>();
       Elfo en1 = new ElfoNoturno("");
       Elfo en2 = new ElfoNoturno("");
       Elfo ev1 = new ElfoVerde("");
       Elfo ev2 = new ElfoVerde("");
       
       lista.add(en1);
       lista.add(en2);
       lista.add(ev1);
       lista.add(ev2);
       
       AtaqueIntercalado estrat = new AtaqueIntercalado();
       List listaDepois = estrat.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
       
       assertEquals(en1, listaDepois.get(0));
       assertEquals(ev1, listaDepois.get(1));
       assertEquals(en2, listaDepois.get(2));
       assertEquals(ev2, listaDepois.get(3));
   }
   
   @Test(expected=ContingenteDesproporcionalException.class)
   public void listaDeproporcional() throws ContingenteDesproporcionalException {
       List<Elfo> lista = new ArrayList<>();
       Elfo en1 = new ElfoNoturno("");
       Elfo en2 = new ElfoNoturno("");
       Elfo en3 = new ElfoNoturno("");
       Elfo ev1 = new ElfoVerde("");
       
       lista.add(en1);
       lista.add(en2);
       lista.add(en3);
       lista.add(ev1);
       
       AtaqueIntercalado estrat = new AtaqueIntercalado();
       List listaDepois = estrat.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
   }
}
