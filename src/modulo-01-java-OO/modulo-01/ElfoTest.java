

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
   @Test
   public void elfoNasceComNome() {
       // Arrange
       String nomeEsperado = "Bruce Wayne";
       // Act
       Elfo elfoDoTeste = new Elfo(nomeEsperado);
       // Assert
       assertEquals(nomeEsperado, elfoDoTeste.getNome());
    }
    
    @Test
    public void elfoNasceComArco() {
       // Act
       Elfo elfoDoTeste = new Elfo("Elrond");
       // Assert
       assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
       assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlechas() {
       // Act
       Elfo elfoDoTeste = new Elfo("Elrond");
       // Assert
       assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
       assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraUmaFlecha() {
        // Act
        Elfo elfo = new Elfo("legolas");
        int flechasAntes = elfo.getFlecha().getQuantidade();
        int expAntes = elfo.getExperiencia();
        elfo.atirarFlecha();
        int flechasDepois = elfo.getFlecha().getQuantidade();
        int expDepois = elfo.getExperiencia();
        // Assert
        assertEquals(flechasAntes-1, flechasDepois);
        assertEquals(expAntes+1, expDepois);
    }
    
    @Test
    public void elfoAtiraTresFlechas() {
        // Act
        Elfo elfo = new Elfo("legolas");
        int flechasAntes = elfo.getFlecha().getQuantidade();
        int expAntes = elfo.getExperiencia();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        int flechasDepois = elfo.getFlecha().getQuantidade();
        int expDepois = elfo.getExperiencia();
        // Assert
        assertEquals(flechasAntes-3, flechasDepois);
        assertEquals(expAntes+3, expDepois);
    }
    
    @Test
    public void superavitFlechas() {
        // Act
        Elfo elfo = new Elfo("legolas");
        while(elfo.getFlecha().getQuantidade() > 0){
            elfo.atirarFlecha();
        }
        elfo.atirarFlecha();
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
    }
    
}
