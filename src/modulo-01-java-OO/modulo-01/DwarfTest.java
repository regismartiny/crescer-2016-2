

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
}
