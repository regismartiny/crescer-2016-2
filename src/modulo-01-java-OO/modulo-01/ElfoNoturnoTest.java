

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoNoturnoTest
{
    @Test 
    public void elfoNoturnoAtira1FlechaGanha3DeExperienciaPerde5PorcentoDeVida() {
        ElfoNoturno en = new ElfoNoturno("Noturno");
        en.atirarFlecha(new Dwarf());
        
        assertEquals(3, en.getExperiencia());
        assertTrue(95. == en.getVida());        
    }
    
    @Test
    public void elfoNoturnoAtira2FlechasGanha6DeExperienciaPerde2x5PorcentoDeVida() {
        ElfoNoturno en = new ElfoNoturno("Noturno");
        en.atirarFlecha(new Dwarf());
        en.atirarFlecha(new Dwarf());
        
        assertEquals(6, en.getExperiencia());
        assertTrue(90.25 == en.getVida());        
    }
    
    @Test
    public void elfoNoturnoNaoAtiraFlechasNaoGanhaExperienciaNemPerdeVida() {
        ElfoNoturno en = new ElfoNoturno("Noturno");
        
        assertEquals(0, en.getExperiencia());
        assertTrue(100. == en.getVida());        
    }
    
    @Test //Atualmente(5.2) elfoNoturno nao morre atirando flechas, pois nao há funcionalidade para "matá-lo" quando a vida chegar em 0.
    public void elfoNoturnoNaoMorreAtirandoFlechas() {
        ElfoNoturno en = new ElfoNoturno("Noturno");
        for(int i=0; i < 42; i++) {
            en.atirarFlecha(new Dwarf());
        }
        
        assertEquals(Status.VIVO, en.getStatus());
        //assertTrue(en.getVida() <= 0.0); 
    }
    
    @Test
    public void elfoNoturnoMorreAtirandoFlechas() {
        ElfoNoturno en = new ElfoNoturno("Noturno", 1000);
        for(int i=0; i < 1000; i++) {
            en.atirarFlecha(new Dwarf());
        }
        
        assertEquals(Status.MORTO, en.getStatus());
        assertEquals(0.0, en.getVida(), 2); 
    }
    
    @Test
    public void elfoNoturnoNaoAtiraFlechasSeMorto() {
        ElfoNoturno en = new ElfoNoturno("Noturno", 1000);
        for(int i=0; i < 90; i++) {
            en.atirarFlecha(new Dwarf());
        }
        
        assertEquals(Status.MORTO, en.getStatus());
        assertEquals(270, en.getExperiencia()); 
    }
}
