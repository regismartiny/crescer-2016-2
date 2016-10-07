import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest
{
   @Test
   public void listaCom2ElfosNoturnosE2Verdes() {
       List<Elfo> lista = new ArrayList<>();
       Elfo en1 = new ElfoNoturno("");
       Elfo en2 = new ElfoNoturno("");
       Elfo ev1 = new ElfoVerde("");
       Elfo ev2 = new ElfoVerde("");
       
       lista.add(en1);
       lista.add(en2);
       lista.add(ev1);
       lista.add(ev2);
       
       NoturnosPorUltimo estrat = new NoturnosPorUltimo();
       List listaDepois = estrat.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
       
       assertEquals(ev1, listaDepois.get(0));
       assertEquals(ev2, listaDepois.get(1));
       assertEquals(en1, listaDepois.get(2));
       assertEquals(en2, listaDepois.get(3));
   }
   
   @Test
   public void listaCom1ElfoNoturno1Verde1ElfoNoturno1Verde() {
       List<Elfo> lista = new ArrayList<>();
       Elfo en1 = new ElfoNoturno("");
       Elfo en2 = new ElfoNoturno("");
       Elfo ev1 = new ElfoVerde("");
       Elfo ev2 = new ElfoVerde("");
       
       lista.add(en1);
       lista.add(ev1);
       lista.add(en2);
       lista.add(ev2);
       
       NoturnosPorUltimo estrat = new NoturnosPorUltimo();
       List listaDepois = estrat.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
       
       assertEquals(ev1, listaDepois.get(0));
       assertEquals(ev2, listaDepois.get(1));
       assertEquals(en1, listaDepois.get(2));
       assertEquals(en2, listaDepois.get(3));
   }
   
   @Test
   public void listaCom2ElfosVerdes() {
       List<Elfo> lista = new ArrayList<>();
       Elfo ev1 = new ElfoVerde("");
       Elfo ev2 = new ElfoVerde("");
       
       lista.add(ev1);
       lista.add(ev2);
       
       NoturnosPorUltimo estrat = new NoturnosPorUltimo();
       List listaDepois = estrat.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
       
       assertEquals(ev1, listaDepois.get(0));
       assertEquals(ev2, listaDepois.get(1));
   }
   
   @Test
   public void listaVazia() {
       List<Elfo> lista = new ArrayList<>();
       
       NoturnosPorUltimo estrat = new NoturnosPorUltimo();
       List listaDepois = estrat.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
       
       assertEquals(0, listaDepois.size());
   }
   
  
}
