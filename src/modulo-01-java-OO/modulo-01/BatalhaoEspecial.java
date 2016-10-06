import java.util.ArrayList;
import java.util.HashMap;

public class BatalhaoEspecial
{
    private HashMap<String,Elfo> contingente;
    
    public BatalhaoEspecial() {
        contingente = new HashMap<>();
    }
    
    Elfo[] getContingente() {
        return contingente.values().toArray(new Elfo[contingente.size()]);
    }

    void alistar(Elfo elfo) {
        if (elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde) {
            contingente.put(elfo.getNome(), elfo);
        }
    }
    
    Elfo buscar(String nome) {
        return contingente.get(nome);
    }
    
    ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> encontrados = new ArrayList<>();
        for(Elfo e: contingente.values()) {
            if (status.equals(e.getStatus())) {
                encontrados.add(e);
            }
        }
        return encontrados;
    }
}
