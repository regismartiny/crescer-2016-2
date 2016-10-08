import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class LittleMumuTest
{
    @Test //Elfos nascem com 42 flechas
    public void elfosVivosComFlechas7Verdes3Noturnos() throws ContingenteDesproporcionalException{
        List<Elfo> lista = gerarListaElfos(7, 3);
        elfoAtiraFlechas(lista.get(0), 9);
        elfoAtiraFlechas(lista.get(1), 8);
        elfoAtiraFlechas(lista.get(2), 7);
        elfoAtiraFlechas(lista.get(3), 6);
        elfoAtiraFlechas(lista.get(4), 5);
        elfoAtiraFlechas(lista.get(5), 4);
        elfoAtiraFlechas(lista.get(6), 3);
        elfoAtiraFlechas(lista.get(7), 2);
        elfoAtiraFlechas(lista.get(8), 1);
        //elfoAtiraFlechas(lista.get(9), 0);
        
        LittleMumu lm = new LittleMumu();
        List<Elfo> listaDeAtaque = lm.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
        
        for(int i=0; i < 10; i++) {
            Elfo e = listaDeAtaque.get(i);
            assertEquals(42-i, e.getFlecha().getQuantidade());
        }
    
    }
    
    @Test //Elfos nascem com 42 flechas
    public void elfosVivosComFlechas7Verdes4Noturnos() throws ContingenteDesproporcionalException{
        List<Elfo> lista = gerarListaElfos(7, 4);
        elfoAtiraFlechas(lista.get(0), 10);
        elfoAtiraFlechas(lista.get(1), 9);
        elfoAtiraFlechas(lista.get(2), 8);
        elfoAtiraFlechas(lista.get(3), 7);
        elfoAtiraFlechas(lista.get(4), 6);
        elfoAtiraFlechas(lista.get(5), 5);
        elfoAtiraFlechas(lista.get(6), 4);
        elfoAtiraFlechas(lista.get(7), 3); //noturno
        elfoAtiraFlechas(lista.get(8), 2); //noturno
        elfoAtiraFlechas(lista.get(9), 1); //noturno
        //elfoAtiraFlechas(lista.get(10), 0); //noturno
        
        LittleMumu lm = new LittleMumu();
        List<Elfo> listaDeAtaque = lm.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
        
        assertEquals(10, listaDeAtaque.size());
        assertTrue(listaDeAtaque.get(0) instanceof ElfoNoturno);
        assertTrue(listaDeAtaque.get(1) instanceof ElfoNoturno);
        assertTrue(listaDeAtaque.get(2) instanceof ElfoNoturno);
        assertTrue(listaDeAtaque.get(3) instanceof ElfoVerde);
        assertTrue(listaDeAtaque.get(4) instanceof ElfoVerde);
        assertTrue(listaDeAtaque.get(5) instanceof ElfoVerde);
        assertTrue(listaDeAtaque.get(6) instanceof ElfoVerde);
        assertTrue(listaDeAtaque.get(7) instanceof ElfoVerde);
        assertTrue(listaDeAtaque.get(8) instanceof ElfoVerde);
        assertTrue(listaDeAtaque.get(9) instanceof ElfoVerde);
    
    }
    
    @Test //Elfos nascem com 42 flechas
    public void elfosVivosSemFlechas7Verdes4Noturnos() throws ContingenteDesproporcionalException{
        List<Elfo> lista = gerarListaElfos(7, 4);
        elfoAtiraFlechas(lista.get(0), 42);
        elfoAtiraFlechas(lista.get(1), 42);
        elfoAtiraFlechas(lista.get(2), 42);
        elfoAtiraFlechas(lista.get(3), 42);
        elfoAtiraFlechas(lista.get(4), 42);
        elfoAtiraFlechas(lista.get(5), 42);
        elfoAtiraFlechas(lista.get(6), 42);
        elfoAtiraFlechas(lista.get(7), 42); //noturno
        elfoAtiraFlechas(lista.get(8), 42); //noturno
        elfoAtiraFlechas(lista.get(9), 42); //noturno
        elfoAtiraFlechas(lista.get(10), 42); //noturno
        
        LittleMumu lm = new LittleMumu();
        List<Elfo> listaDeAtaque = lm.getOrdemDeAtaque(lista, new ArrayList<Dwarf>());
        
        assertEquals(0, listaDeAtaque.size());    
    }
    
    
    private void elfoAtiraFlechas(Elfo e, int quantidade) {
        Dwarf d = new Dwarf();
        for (int i=0; i < quantidade; i++) {
            e.atirarFlecha(d);
        }
    }
    
    private List<Elfo> gerarListaElfos(int qtdVerdes, int qtdNoturnos) {
        List<Elfo> lista = new ArrayList<>();
        for(int i = 0; i < qtdVerdes; i++) {
            lista.add(new ElfoVerde("Elfo Verde " + i));
        }
        for(int i = 0; i < qtdNoturnos; i++) {
            lista.add(new ElfoNoturno("Elfo Noturno " + i));
        }
        return lista;
    }
    
}
