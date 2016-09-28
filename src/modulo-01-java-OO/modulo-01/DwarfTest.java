

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
}
