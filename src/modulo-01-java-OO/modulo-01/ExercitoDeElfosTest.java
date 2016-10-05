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
    
    @Test
    public void criarExercitoAlistar2ElfosVivosBuscarElfosVivos() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ElfoVerde ev = new ElfoVerde("Legolas");
        ee.alistar(en);
        ee.alistar(ev);
        
        Elfo[] elfos = ee.buscar(Status.VIVO);
        
        assertEquals(en, elfos[0]);     
        assertEquals(ev, elfos[1]);   
    }
    
    @Test
    public void criarExercitoAlistar1ElfoVivoE1ElfoMortoBuscarElfosVivos() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        for(int i=0; i < 1000; i++) {
            en.atirarFlecha(new Dwarf());
        }
        ee.alistar(en);
        ee.alistar(ev);
        
        Elfo[] elfos = ee.buscar(Status.VIVO);
        
        assertEquals(ev, elfos[0]);
        assertEquals(1, elfos.length);   
    }
    
    @Test
    public void criarExercitoAlistar1ElfoVivoE1ElfoMortoBuscarElfosMortos() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        for(int i=0; i < 1000; i++) {
            en.atirarFlecha(new Dwarf());
        }
        ee.alistar(en);
        ee.alistar(ev);
        
        Elfo[] elfos = ee.buscar(Status.MORTO);
        
        assertEquals(en, elfos[0]);
        assertEquals(1, elfos.length);   
    }
    
    @Test
    public void criarExercitoAlistar2ElfosVivosBuscarElfosMortos() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        ee.alistar(en);
        ee.alistar(ev);
        
        Elfo[] elfos = ee.buscar(Status.MORTO);
        
        assertEquals(0, elfos.length);   
    }
    
    @Test
    public void criarExercitoNaoAlistarElfosBuscarElfosVivos() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        
        Elfo[] elfos = ee.buscar(Status.VIVO);
        
        assertEquals(0, elfos.length);   
    }
}
