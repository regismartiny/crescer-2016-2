

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
        assertEquals("VIVO", dwarf.getStatus());
    }
    
    @Test
    public void dwarfMorto() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getStatus() == "VIVO") {
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
        while(dwarf.getStatus() == "VIVO") {
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
        assertEquals(0, dwarf.getVida());
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
        assertEquals(0, dwarf.getVida());
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
    
    public void dwarfNascidoDia10Mes12Ano4000() {
        // Act
        Dwarf dwarf = new Dwarf("Frodo", new DataTerceiraEra(1,2,4000));
        // Assert
        assertEquals(10, dwarf.getDataNascimento().getDia());
        assertEquals(12, dwarf.getDataNascimento().getMes());
        assertEquals(4000, dwarf.getDataNascimento().getAno());
    }
    
    public void dwarfComNomeNascidoDia15Mes11Ano3000() {
        // Act
        Dwarf dwarf = new Dwarf("Frodo", new DataTerceiraEra(15,11,3000));
        // Assert
        assertEquals("Frodo", dwarf.getNome());
        assertEquals(15, dwarf.getDataNascimento().getDia());
        assertEquals(11, dwarf.getDataNascimento().getMes());
        assertEquals(3000, dwarf.getDataNascimento().getAno());
    }
    
    public void dwarfComNomeNascidoDia10Mes2Ano3201() {
        // Act
        Dwarf dwarf = new Dwarf("Anão", new DataTerceiraEra(10,2,3201));
        // Assert
        assertEquals("Anão", dwarf.getNome());
        assertEquals(10, dwarf.getDataNascimento().getDia());
        assertEquals(2, dwarf.getDataNascimento().getMes());
        assertEquals(3201, dwarf.getDataNascimento().getAno());
    }
}
