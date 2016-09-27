

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
}
