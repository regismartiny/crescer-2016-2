

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @After // Executa após cada cenário de testes.
    public void tearDown() {
       System.gc();
    }
   
    @Test
    public void elfoAtira0FlechaEGanha0deExp() {
        ElfoVerde e = new ElfoVerde("Elfo");
        
        assertEquals(0, e.getExperiencia());
    }
    
    @Test
    public void elfoAtira1FlechaEGanha2deExp() {
        ElfoVerde e = new ElfoVerde("Elfo");
        Item i1 = new Item("Arco e Flecha de Vidro", 1);
        e.adicionarItem(i1);
        e.atirarFlecha(new Dwarf());
        
        assertEquals(2, e.getExperiencia());
    }
    
    @Test
    public void elfoAtira2FlechasEGanha4deExp() {
        ElfoVerde e = new ElfoVerde("Elfo");
        Item i1 = new Item("Arco e Flecha de Vidro", 2);
        e.adicionarItem(i1);
        e.atirarFlecha(new Dwarf());
        e.atirarFlecha(new Dwarf());
        
        assertEquals(4, e.getExperiencia());
    }
    
    @Test
    public void elfoGanhaItemValido() {
        ElfoVerde e = new ElfoVerde("Elfo");
        Item i1 = new Item("Espada de aço valiriano", 5);
        e.adicionarItem(i1);
 
        assertEquals(i1, e.getInventario().getLista().get(2));
    }
    
    @Test
    public void elfoNaoGanhaItemInvalido() {
        ElfoVerde e = new ElfoVerde("Elfo");
        Item i1 = new Item("Espada de ferro", 1);
        e.adicionarItem(i1);
        
        assertEquals(2, e.getInventario().getLista().size());
    }
    
   @Test
   public void elfoVerdeNasceCom100DeVida() {
       ElfoVerde ev = new ElfoVerde("Elfo");
       // Assert
       assertTrue(100.0 == ev.getVida());
    }
    
   @Test
   public void elfoVerdeNasceCom2Itens() {
       ElfoVerde ev = new ElfoVerde("Elfo");
       // Assert
       assertEquals(2, ev.getInventario().getLista().size());
    }

}
