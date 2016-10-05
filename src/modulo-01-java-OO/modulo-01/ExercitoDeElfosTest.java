import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ExercitoDeElfosTest
{
    @Test
    public void criarExercitoAlistarElfoVerde() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoVerde ev = new ElfoVerde("Legolas");
        ee.alistar(ev);
        
        assertEquals(ev, ee.getElfosArray()[0]);        
    }
    
    @Test
    public void criarExercitoAlistarElfoNoturno() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ee.alistar(en);
        
        assertEquals(en, ee.getElfosArray()[0]);        
    }
    
    @Test
    public void criarExercitoAlistarElfoVerdeBuscarElfoVerde() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoVerde ev = new ElfoVerde("Legolas");
        ee.alistar(ev);
        
        assertEquals(ev, ee.buscar("Legolas"));        
    }
    
    @Test
    public void criarExercitoAlistarElfoNoturnoBuscarElfoNoturno() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ee.alistar(en);
        
        assertEquals(en, ee.buscar("Nocturn"));        
    }
    
    @Test
    public void criarExercitoAlistarElfoNoturnoBuscarElfoVerde() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ee.alistar(en);
        
        assertFalse(en.equals(ee.buscar("Legolas")));        
    }
    
    @Test
    public void criarExercitoNaoAlistarElfoBuscarElfoVerde() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        
        assertEquals(null, ee.buscar("Legolas"));        
    }
}
