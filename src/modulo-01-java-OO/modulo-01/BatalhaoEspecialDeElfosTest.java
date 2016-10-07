import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class BatalhaoEspecialDeElfosTest
{
    @Test 
    public void alistarElfoNoBatalhaoEspecial() throws NaoPodeAlistarException { 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoVerde("Folluin Qindove"); 
        //Elfo recruta2 = new ElfoNoturno("Sinnafain Leothyra"); 
        batalhao.alistar(recruta1); 
        assertEquals(recruta1, batalhao.getContingente()[0]); 
    } 
 
    @Test 
    public void alistarDoisElfosNoBatalhaoEspecial() throws NaoPodeAlistarException { 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoVerde("Folluin Qindove"); 
        Elfo recruta2 = new ElfoNoturno("Sinnafain Leothyra"); 
        batalhao.alistar(recruta1); 
        batalhao.alistar(recruta2); 
        Elfo[] elfos = batalhao.getContingente(); 
        assertTrue(contem(elfos, recruta1)); 
        assertTrue(contem(elfos, recruta2)); 
    } 
 
    @Test(expected=NaoPodeAlistarException.class)
    public void alistarDoisElfosValidosEUmInvalidoNoBatalhaoEspecial() throws NaoPodeAlistarException { 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoVerde("Folluin Qindove"); 
        Elfo recruta2 = new ElfoNoturno("Sinnafain Leothyra"); 
        batalhao.alistar(recruta1); 
        batalhao.alistar(new Elfo("Taredd Oriwraek")); 
        batalhao.alistar(recruta2); 
        Elfo[] elfos = batalhao.getContingente(); 
        assertEquals(2, elfos.length); 
        assertTrue(contem(elfos, recruta1)); 
        assertTrue(contem(elfos, recruta2)); 
    } 
 
    @Test(expected=NaoPodeAlistarException.class)
    public void buscarElfoQueNaoFoiAlistado() throws NaoPodeAlistarException{ 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoVerde("Folluin Qindove"); 
        Elfo recruta2 = new ElfoNoturno("Sinnafain Leothyra"); 
        batalhao.alistar(recruta1); 
        batalhao.alistar(new Elfo("Taredd Oriwraek")); 
        batalhao.alistar(recruta2); 
        assertNull(batalhao.buscar("Taredd Oriwraek")); 
    } 
 
    @Test 
    public void buscarElfoAlistado() throws NaoPodeAlistarException{ 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoVerde("Folluin Qindove"); 
        Elfo recruta2 = new ElfoNoturno("Zezinho de Valfenda"); 
        batalhao.alistar(recruta1); 
        batalhao.alistar(recruta2); 
        assertEquals(recruta2, batalhao.buscar("Zezinho de Valfenda")); 
    } 
 
    @Test 
    public void buscarElfoAlistadoComNomeDuplicado() throws NaoPodeAlistarException{ 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoVerde("Folluin Qindove"); 
        Elfo recruta2 = new ElfoNoturno("Zezinho de Valfenda", 1); 
        Elfo recruta3 = new ElfoNoturno("Zezinho de Valfenda", 2); 
        batalhao.alistar(recruta1); 
        batalhao.alistar(recruta2); 
        batalhao.alistar(recruta3); 
        assertEquals(recruta2, batalhao.buscar("Zezinho de Valfenda")); 
    } 
 
    @Test 
    public void alistarDoisElfosVivos() throws NaoPodeAlistarException{ 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoVerde("Folluin Qindove"); 
        Elfo recruta2 = new ElfoNoturno("Zezinho de Valfenda", 1); 
        batalhao.alistar(recruta1); 
        batalhao.alistar(recruta2); 
        batalhao.agruparPorStatus(); 
        ArrayList<Elfo> resultado = batalhao.buscar(Status.VIVO); 
        assertEquals(2, resultado.size()); 
        assertTrue(resultado.contains(recruta1)); 
        assertTrue(resultado.contains(recruta2)); 
    } 
 
    @Test 
    public void alistarDoisElfosMortos() throws NaoPodeAlistarException{ 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoVerde("Folluin Qindove"); 
        Elfo recruta2 = criarElfoNoturnoEMatalo(); 
        Elfo recruta3 = criarElfoNoturnoEMatalo(); 
        batalhao.alistar(recruta1); 
        batalhao.alistar(recruta2); 
        batalhao.alistar(recruta3); 
        batalhao.agruparPorStatus(); 
        ArrayList<Elfo> resultado = batalhao.buscar(Status.MORTO); 
        assertEquals(2, resultado.size()); 
        assertTrue(resultado.contains(recruta2)); 
        assertTrue(resultado.contains(recruta3)); 
    } 
 
    @Test 
    public void alistarUmElfoVivoEDepoisMatalo() throws NaoPodeAlistarException{ 
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos(); 
        Elfo recruta1 = new ElfoNoturno("Folluin Qindove", 91); 
        Elfo recruta2 = new ElfoVerde("Phaendar Holabanise"); 
        batalhao.alistar(recruta1); 
        batalhao.agruparPorStatus();         
        ArrayList<Elfo> resultado = batalhao.buscar(Status.VIVO); 
        batalhao.alistar(recruta2); 
        for (int i = 0; i < 91; i++) recruta1.atirarFlecha(new Dwarf()); 
        ArrayList<Elfo> buscaAposMorte = batalhao.buscar(Status.VIVO); 
        assertEquals(1, buscaAposMorte.size()); 
        assertEquals(recruta2, buscaAposMorte.get(0)); 
    } 
 
    private boolean contem(Elfo[] elfos, Elfo elfo) { 
        // correto: length 
        // errado: lenght 
        for (int i = 0; i < elfos.length; i++) { 
            if (elfos[i].equals(elfo)) { 
                return true; 
            } 
        } 
        return false; 
    } 
 
    private ElfoNoturno criarElfoNoturnoEMatalo() { 
        ElfoNoturno suicida = new ElfoNoturno("Elfo kamikaze", 90); 
        for (int i = 0; i < 90; i++) 
            suicida.atirarFlecha(new Dwarf()); 
        return suicida; 
    } 
}
