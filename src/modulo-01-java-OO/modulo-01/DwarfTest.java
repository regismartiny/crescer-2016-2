

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNascemCom110DeVida() {
        // Act
        Dwarf dwarf = new Dwarf();
        // Assert
        assertEquals(110, dwarf.getVida());
    }
    
    @Test
    public void dwarfLevaFlechada() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        int vida = dwarf.getVida();
        // Act
        dwarf.levarFlechada();
        // Assert
        assertEquals(vida - 10, dwarf.getVida());        
    }
    
    @Test
    public void dwarfMachucadoMasVivo() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        dwarf.levarFlechada();
        // Assert
        assertTrue("MORTO" != dwarf.getStatus());
    }
    
    @Test
    public void dwarfMorto() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getStatus() != "MORTO") {
            dwarf.levarFlechada();
        }
        // Assert
        assertEquals("MORTO", dwarf.getStatus());
    }
    
    @Test
    public void dwarfAlvejadoAposMortoContinuaMorto() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getStatus() != "MORTO") {
            dwarf.levarFlechada();
        }
        dwarf.levarFlechada();
        // Assert
        assertEquals("MORTO", dwarf.getStatus());
    }
    
    @Test
    public void dwarfAlvejadoUmaVezAposMortoTemVida0() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getVida() > 0) {
            dwarf.levarFlechada();
        }
        dwarf.levarFlechada();
        // Assert
        assertEquals(-10, dwarf.getVida());
    }
    
    @Test
    public void dwarfAlvejado5VezesAposMortoTemVida0() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getVida() > 0) {
            dwarf.levarFlechada();
        }
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertEquals(-50, dwarf.getVida());
    }
    
    @Test
    public void dwarfNascidoDia1Mes2Ano3000() {
        // Act
        Dwarf dwarf = new Dwarf("Frodo", new DataTerceiraEra(1,2,3000));
        // Assert
        assertEquals(1, dwarf.getDataNascimento().getDia());
        assertEquals(2, dwarf.getDataNascimento().getMes());
        assertEquals(3000, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfNascidoDia10Mes12Ano4000() {
        // Act
        Dwarf dwarf = new Dwarf("Frodo", new DataTerceiraEra(1,2,4000));
        // Assert
        assertEquals(1, dwarf.getDataNascimento().getDia());
        assertEquals(2, dwarf.getDataNascimento().getMes());
        assertEquals(4000, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfComNomeNascidoDia15Mes11Ano3000() {
        // Act
        Dwarf dwarf = new Dwarf("Frodo", new DataTerceiraEra(15,11,3000));
        // Assert
        assertEquals("Frodo", dwarf.getNome());
        assertEquals(15, dwarf.getDataNascimento().getDia());
        assertEquals(11, dwarf.getDataNascimento().getMes());
        assertEquals(3000, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfComNomeNascidoDia10Mes2Ano3201() {
        // Act
        Dwarf dwarf = new Dwarf("Anão", new DataTerceiraEra(10,2,3201));
        // Assert
        assertEquals("Anão", dwarf.getNome());
        assertEquals(10, dwarf.getDataNascimento().getDia());
        assertEquals(2, dwarf.getDataNascimento().getMes());
        assertEquals(3201, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfNascidoAno3000Vida80() { // ano nao bissexto - 101.0
        // Act
        Dwarf dwarf = new Dwarf("Anão", new DataTerceiraEra(1,1,3000));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertFalse(dwarf.getDataNascimento().ehBissexto());
        assertEquals("Anão", dwarf.getNome());
        assertTrue(101.0 == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNascidoAno3200Vida90() { // ano bissexto - 101*-33
        // Act
        Dwarf dwarf = new Dwarf("Anão", new DataTerceiraEra(1,1,3200));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertTrue(dwarf.getDataNascimento().ehBissexto());
        assertEquals(90, dwarf.getVida());
        assertTrue((101.0*-33) == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNomeSeixasNascidoAno3200Vida100() { // ano bissexto - 101.0
        // Act
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,1,3200));
        dwarf.levarFlechada();
        // Assert
        assertTrue(dwarf.getDataNascimento().ehBissexto());
        assertFalse(dwarf.getVida() >= 80 && dwarf.getVida() <= 90);
        assertTrue((101.0) == dwarf.getNumeroSorte());
    } 
    
    
    @Test
    public void dwarfNomeSeixasNascidoAno3000Vida80() { // (101*33)%100
        // Act
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,1,3000));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertFalse(dwarf.getDataNascimento().ehBissexto());
        assertEquals(80, dwarf.getVida());
        assertTrue((101.0*33)%100 == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNomeMeirelesNascidoAno3200Vida90() { //ano bissexto - 101*-33
        // Act
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(1,1,3200));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertTrue(dwarf.getDataNascimento().ehBissexto());
        //assertEquals(90, dwarf.getVida());
        assertTrue((101.0*-33) == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNomeMeirelesNascidoAno3200Vida90NumeroDaSorte() { // numero < 0, sem flechada, exp += 2
        // Act
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(1,1,3200));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertTrue(dwarf.getDataNascimento().ehBissexto());
        assertEquals(90, dwarf.getVida());
        assertTrue((101.0*-33) == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNomeSeixasNascidoAno3000Vida110NumeroDaSorte() { // // numero entre 0 e 100, sem flechada, sem exp
        // Act
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,1,3000));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertFalse(dwarf.getDataNascimento().ehBissexto());
        assertEquals(110, dwarf.getVida());
        assertTrue((101.0*33)%100 == dwarf.getNumeroSorte());
    }
}
