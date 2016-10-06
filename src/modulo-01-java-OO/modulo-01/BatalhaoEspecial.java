import java.util.ArrayList;
import java.util.HashMap;

public class BatalhaoEspecial
{
    private HashMap<String,Elfo> contingente;
    private HashMap<Status,ArrayList<Elfo>> statusArrayElfos;
    private ArrayList<Elfo> vivos, mortos;
    
    public BatalhaoEspecial() {
        contingente = new HashMap<>();
        statusArrayElfos = new HashMap<>();
        vivos = new ArrayList<>();
        mortos = new ArrayList<>();
        statusArrayElfos.put(Status.VIVO, vivos);
        statusArrayElfos.put(Status.MORTO, mortos);
    }
    
    Elfo[] getContingente() {
        return contingente.values().toArray(new Elfo[contingente.size()]);
    }

    void alistar(Elfo elfo) {
        if (elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde) {
            contingente.put(elfo.getNome(), elfo);
        }
        if (elfo.getStatus().equals(Status.VIVO)) {
            vivos.add(elfo);
        }
        else{
            mortos.add(elfo);
        }
    }
    
    Elfo buscar(String nome) {
        return contingente.get(nome);
    }
    
    ArrayList<Elfo> buscar(Status status) {
        return statusArrayElfos.get(status);
    }
}
