import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ExercitoDeElfosTest
{
    @After // Executa após cada cenário de testes.
    public void tearDown() {
        System.gc();
    }
   
    @Test
    public void criarExercitoAlistarElfoVerde() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoVerde ev = new ElfoVerde("Legolas");
        try{
            ee.alistar(ev);
        }catch(NaoPodeAlistarException e){
            System.out.println(e.getMessage() + e.getStackTrace());
        }
        
        assertEquals(ev, ee.getContingente()[0]);        
    }
    
    @Test
    public void criarExercitoAlistarElfoNoturno() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ee.alistar(en);
        
        assertEquals(en, ee.getContingente()[0]);        
    }
    
    @Test
    public void criarExercitoAlistarElfoVerdeBuscarElfoVerde() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoVerde ev = new ElfoVerde("Legolas");
        ee.alistar(ev);
        
        assertEquals(ev, ee.buscar("Legolas"));        
    }
    
    @Test
    public void criarExercitoAlistarElfoNoturnoBuscarElfoNoturno() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ee.alistar(en);
        
        assertEquals(en, ee.buscar("Nocturn"));        
    }
    
    @Test
    public void criarExercitoAlistarElfoNoturnoBuscarElfoVerde() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ee.alistar(en);
        
        assertFalse(en.equals(ee.buscar("Legolas")));        
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void criarExercitoTentarAlistarElfo() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        Elfo e = new Elfo("Elf");
        ee.alistar(e);
        
        assertEquals(0, ee.getContingente().length);        
    }
    
    @Test
    public void criarExercitoNaoAlistarElfoBuscarElfoVerde() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        
        assertEquals(null, ee.buscar("Legolas"));        
    }
    
    @Test
    public void criarExercitoVazioBuscarPorNome() {
        assertNull(new ExercitoDeElfos().buscar("Nenhum"));
    }
    
    @Test
    public void criarExercitoVazioBuscarElfosVivos() {
        assertNull(new ExercitoDeElfos().buscar(Status.VIVO));
    }
    
    @Test
    public void criarExercitoAlistar2ElfosVivosBuscarElfosVivos() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn");
        ElfoVerde ev = new ElfoVerde("Legolas");
        ee.alistar(en);
        ee.alistar(ev);
        
        Elfo[] elfos = ee.buscarArray(Status.VIVO);
        
        assertEquals(en, elfos[0]);     
        assertEquals(ev, elfos[1]);   
    }
    
    @Test
    public void criarExercitoAlistar1ElfoVivoE1ElfoMortoBuscarElfosVivos() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        for(int i=0; i < 1000; i++) {
            en.atirarFlecha(new Dwarf());
        }
        ee.alistar(en);
        ee.alistar(ev);
        
        Elfo[] elfos = ee.buscarArray(Status.VIVO);
        
        assertEquals(ev, elfos[0]);
        assertEquals(1, elfos.length);   
    }
    
    @Test
    public void criarExercitoAlistar1ElfoVivoE1ElfoMortoBuscarElfosMortos() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        for(int i=0; i < 1000; i++) {
            en.atirarFlecha(new Dwarf());
        }
        ee.alistar(en);
        ee.alistar(ev);
        
        Elfo[] elfos = ee.buscarArray(Status.MORTO);
        
        assertEquals(en, elfos[0]);
        assertEquals(1, elfos.length);   
    }
    
    @Test
    public void criarExercitoAlistar2ElfosVivosBuscarElfosMortos() throws NaoPodeAlistarException {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        ElfoNoturno en = new ElfoNoturno("Nocturn", 1000);
        ElfoVerde ev = new ElfoVerde("Legolas");
        ee.alistar(en);
        ee.alistar(ev);
        
        assertNull(ee.buscar(Status.MORTO));   
    }
    
    @Test
    public void criarExercitoNaoAlistarElfosBuscarElfosVivos() {
        ExercitoDeElfos ee = new ExercitoDeElfos();
        
        assertNull(ee.buscar(Status.VIVO));   
    }
    
    
    @Test
    public void criarExercitoBuscarPorNomeTendoApenasUmComAqueleNome() throws NaoPodeAlistarException {
        ExercitoDeElfos e = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta 1");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        e.alistar(recruta1);
        e.alistar(recruta2);
        e.alistar(recruta3);
        
        assertEquals(recruta2, e.buscar("Elfo Recruta 2"));
    }
    
    @Test
    public void criarExercitoBuscarPorNomeTendoVariosComAqueleNome() throws NaoPodeAlistarException {
        ExercitoDeElfos e = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        e.alistar(recruta1);
        e.alistar(recruta2);
        e.alistar(recruta3);
        
        assertEquals(recruta1, e.buscar("Elfo Recruta"));
    }
}
