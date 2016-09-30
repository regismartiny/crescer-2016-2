import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
    @Test
    public void hobbitCalculaDiferenca3Pares() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);
        // diferenca é 840
        assertEquals(840, diferenca);
    }
    
    @Test
    public void hobbitCalculaDiferenca2Pares() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(2, 4)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 8)));

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);

        assertEquals(28, diferenca);
    }
    
    @Test
    public void hobbitCalculaDiferenca1Par() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(2, 4)));

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);

        assertEquals(4, diferenca);
    }
}
