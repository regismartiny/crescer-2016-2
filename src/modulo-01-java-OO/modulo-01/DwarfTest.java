

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void levarFlechada() {
        // Assert
        Dwarf dwarf = new Dwarf();
        int vida = dwarf.getVida();
        dwarf.levarFlechada();
        // Assert
        assertEquals(vida - 10, dwarf.getVida());        
    }
    
    @Test
    public void dwarfMortoNaoPerdeVida() {
        //
        Dwarf dwarf = new Dwarf();
        int vida = dwarf.getVida();
        while(dwarf.getVida() > 0){
            dwarf.levarFlechada();
        }
        dwarf.levarFlechada();
        assertEquals(0, dwarf.getVida());
    }
}
