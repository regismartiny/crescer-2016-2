

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoNoturnoTest
{
    @Test 
    public void elfoNoturnoAtira1FlechaGanha3DeExperienciaPerde5PorcentoDeVida() {
        ElfoNoturno en = new ElfoNoturno("Noturno");
        en.atirarFlecha();
        
        assertEquals(3, en.getExperiencia());
        assertTrue(95. == en.getVida());        
    }
    
    @Test
    public void elfoNoturnoAtira2FlechasGanha6DeExperienciaPerde2x5PorcentoDeVida() {
        ElfoNoturno en = new ElfoNoturno("Noturno");
        en.atirarFlecha();
        en.atirarFlecha();
        
        assertEquals(6, en.getExperiencia());
        assertTrue(90.25 == en.getVida());        
    }
    
    @Test
    public void elfoNoturnoNaoAtiraFlechasNaoGanhaExperienciaNemPerdeVida() {
        ElfoNoturno en = new ElfoNoturno("Noturno");
        
        assertEquals(0, en.getExperiencia());
        assertTrue(100. == en.getVida());        
    }
}
