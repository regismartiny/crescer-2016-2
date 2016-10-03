

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
       // Arrange
       Elfo elfoDoTeste = new Elfo("Elrond");
       // Assert
       assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
       assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoNaoAtiraFlecha() {
        // Arrange
        Elfo elfo = new Elfo("legolas");
        // Assert
        assertEquals(42, elfo.getFlecha().getQuantidade());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void elfoAtiraUmaFlecha() {
        // Arrange
        Elfo elfo = new Elfo("legolas");
        // Act
        elfo.atirarFlecha();
        // Assert
        assertEquals(41, elfo.getFlecha().getQuantidade());
        assertEquals(1, elfo.getExperiencia());
    }
    
    @Test
    public void elfoAtiraTresFlechas() {
        // Arrange
        Elfo elfo = new Elfo("legolas");
        // Act
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        // Assert
        assertEquals(39, elfo.getFlecha().getQuantidade());
        assertEquals(3, elfo.getExperiencia());
    }
    
     @Test
    public void elfoAtira42Flechas() {
        // Arrange
        Elfo elfo = new Elfo("legolas");
        //Act
        for(int i=0; i < 42; i++) {
            elfo.atirarFlecha();
        }
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
        assertEquals(42, elfo.getExperiencia());
    }
    
    @Test
    public void superavitFlechas() {
        // Arrange
        Elfo elfo = new Elfo("legolas");
        // Act
        while(elfo.getFlecha().getQuantidade() > 0){
            elfo.atirarFlecha();
        }
        elfo.atirarFlecha();
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlechaEmUmDwarf() {
        // Arrange
        Elfo elfo = new Elfo("legolas");
        int flechas = elfo.getFlecha().getQuantidade();
        int exp = elfo.getExperiencia();
        Dwarf dwarf = new Dwarf();
        int vida = dwarf.getVida();
        // Act
        elfo.atiraFlechaEmDwarf(dwarf);
        // Assert
        assertEquals(flechas - 1, elfo.getFlecha().getQuantidade());
        assertEquals(exp + 1, elfo.getExperiencia());
        assertEquals(vida - 10, dwarf.getVida());
    }
    
    @Test
    public void elfoToString() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        // Assert
        assertEquals("Legolas possui 42 flechas e 0 níveis de experiência.", elfo.toString());
    }
    
    @Test
    public void elfoExperienteToString() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        elfo.atirarFlecha();
        // Assert
        assertEquals("Legolas possui 41 flechas e 1 nível de experiência.", elfo.toString());
    }
    
    @Test
    public void elfoComNomeE2Flechas() {
        // Act
        Elfo elfo = new Elfo("Legolas", 2);
        // Assert
        assertEquals("Legolas", elfo.getNome());
        assertEquals(2, elfo.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoComNomeE100Flechas() {
        // Act
        Elfo elfo = new Elfo("Batman", 100);
        // Assert
        assertEquals("Batman", elfo.getNome());
        assertEquals(100, elfo.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoComFlechasNegativas() {
        // Act
        Elfo elfo = new Elfo("Superman", -52);
        // Assert
        assertEquals(42, elfo.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoCom0Flechas() {
        // Act
        Elfo elfo = new Elfo("Superman", 0);
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoComNomeE100FlechasToString() {
        // Act
        Elfo elfo = new Elfo("Batman", 100);
        // Assert
        assertEquals("Batman", elfo.getNome());
        assertEquals(100, elfo.getFlecha().getQuantidade());
        assertEquals("Batman possui 100 flechas e 0 níveis de experiência.", elfo.toString());
    }
    
    @Test
    public void elfoComNomeE100FlechasExperienteToString() {
        // Act
        Elfo elfo = new Elfo("Batman", 100);
        elfo.atirarFlecha();
        // Assert
        assertEquals("Batman", elfo.getNome());
        assertEquals(99, elfo.getFlecha().getQuantidade());
        assertEquals(1, elfo.getExperiencia());
        assertEquals("Batman possui 99 flechas e 1 nível de experiência.", elfo.toString());
    }
    
    @Test
    public void elfoNasceVivo() {
        Elfo e = new Elfo("Legolas");
        assertEquals(Status.VIVO, e.getStatus());
    }
    
    @Test 
    public void elfoNasceComArcoEFlechasNoInventario() {
        Elfo e = new Elfo("Legolas", 5);
        Inventario i = e.getInventario();
        
        assertTrue(i.getLista().contains(e.getArco()));
        assertTrue(i.getLista().contains(e.getFlecha()));
    }
    
   @Test
   public void elfoNasceCom100DeVida() {
       Elfo e = new Elfo("Elfo");
       // Assert
       assertTrue(100.0 == e.getVida());
    }
}
