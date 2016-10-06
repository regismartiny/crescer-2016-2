import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class BatalhaEspecialTest
{
    @Test
    public void criarBatalhaoEspecialAlistarElfoVerde() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoVerde ev = new ElfoVerde("Legolas");
        be.alistar(ev);
        
        assertEquals(ev, be.getContingente()[0]);        
    }
    
    @Test
    public void criarBatalhaoEspecialAlistarElfoNoturno() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        be.alistar(en);
        
        assertEquals(en, be.getContingente()[0]);        
    }
    
    @Test
    public void criarBatalhaoEspecialAlistarElfoVerdeBuscarElfoVerde() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoVerde ev = new ElfoVerde("Legolas");
        be.alistar(ev);
        
        assertEquals(ev, be.buscar("Legolas"));        
    }
    
    @Test
    public void criarBatalhaoEspecialAlistarElfoNoturnoBuscarElfoNoturno() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        be.alistar(en);
        
        assertEquals(en, be.buscar("Nocturn"));        
    }
    
    @Test
    public void criarBatalhaoEspecialAlistarElfoNoturnoBuscarElfoVerde() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        be.alistar(en);
        
        assertFalse(en.equals(be.buscar("Legolas")));        
    }
    
    @Test
    public void criarBatalhaoEspecialTentarAlistarElfo() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        Elfo e = new Elfo("Elf");
        be.alistar(e);
        
        assertEquals(0, be.getContingente().length);        
    }
    
    @Test
    public void criarBatalhaoEspecialNaoAlistarElfoBuscarElfoVerde() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        
        assertEquals(null, be.buscar("Legolas"));        
    }
    
    @Test
    public void criarBatalhaoEspecialVazioBuscarPorNome() {
        assertNull(new BatalhaoEspecial().buscar("Nenhum"));
    }
    
    @Test
    public void criarBatalhaoEspecialVazioBuscarElfosVivos() {
        assertTrue(new BatalhaoEspecial().buscar(Status.VIVO).isEmpty());
    }
    
    @Test
    public void criarBatalhaoEspecialAlistar2ElfosVivosBuscarElfosVivos() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ElfoVerde ev = new ElfoVerde("Legolas");
        be.alistar(en);
        be.alistar(ev);
        
        ArrayList<Elfo> elfos = be.buscar(Status.VIVO);
        
        assertEquals(en, elfos.get(0));     
        assertEquals(ev, elfos.get(1));   
    }
    
    @Test
    public void criarBatalhaoEspecialAlistar1ElfoVivoE1ElfoMortoBuscarElfosVivos() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        for(int i=0; i < 1000; i++) {
            en.atirarFlecha(new Dwarf());
        }
        be.alistar(en);
        be.alistar(ev);
        
        ArrayList<Elfo> elfos = be.buscar(Status.VIVO);
        
        assertEquals(ev, elfos.get(0));
        assertEquals(1, elfos.size());   
    }
    
    @Test
    public void criarBatalhaoEspecialAlistar1ElfoVivoE1ElfoMortoBuscarElfosMortos() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        for(int i=0; i < 1000; i++) {
            en.atirarFlecha(new Dwarf());
        }
        be.alistar(en);
        be.alistar(ev);
        
        ArrayList<Elfo> elfos = be.buscar(Status.MORTO);
        
        assertEquals(en, elfos.get(0));
        assertEquals(1, elfos.size());   
    }
    
    @Test
    public void criarBatalhaoEspecialAlistar2ElfosVivosBuscarElfosMortos() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        be.alistar(en);
        be.alistar(ev);
        
        assertTrue(be.buscar(Status.MORTO).isEmpty());   
    }
    
    @Test
    public void criarBatalhaoEspecialNaoAlistarElfosBuscarElfosVivos() {
        BatalhaoEspecial be = new BatalhaoEspecial();
        
        assertTrue(be.buscar(Status.VIVO).isEmpty());   
    }
    
    
    @Test
    public void criarBatalhaoEspecialBuscarPorNomeTendoApenasUmComAqueleNome() {
        BatalhaoEspecial e = new BatalhaoEspecial();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta 1");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        e.alistar(recruta1);
        e.alistar(recruta2);
        e.alistar(recruta3);
        
        assertEquals(recruta2, e.buscar("Elfo Recruta 2"));
    }
    
    @Test
    public void criarBatalhaoEspecialBuscarPorNomeTendoVariosComAqueleNome() {
        BatalhaoEspecial e = new BatalhaoEspecial();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        e.alistar(recruta1);
        e.alistar(recruta2);
        e.alistar(recruta3);
        
        assertEquals(recruta1, e.buscar("Elfo Recruta"));
    }
}
