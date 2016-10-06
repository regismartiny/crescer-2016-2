import java.util.*;

public class BatalhaoEspecialDeElfos
{
    private HashMap<String,ArrayList<Elfo>> contingente;
    private HashMap<Status,ArrayList<Elfo>> statusArrayElfos;
    
    public BatalhaoEspecialDeElfos() {
        contingente = new HashMap<>();
        statusArrayElfos = new HashMap<>();
    }
    
    public Elfo[] getContingente() {
        ArrayList<Elfo> resultado = new ArrayList<>();
        for (ArrayList<Elfo> listas : contingente.values()) {
            resultado.addAll(listas);
        }
        return resultado.toArray(new Elfo[resultado.size()]);
    }

    public void alistar(Elfo elfo) {
        if (elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde) {
            ArrayList<Elfo> arr = contingente.get(elfo.getNome());
            if (arr == null) {
                arr = new ArrayList<>();
                contingente.put(elfo.getNome(), arr);
            }
            arr.add(elfo);
        }
    }
    
    public Elfo buscar(String nome) {
        return contingente.containsKey(nome) ? contingente.get(nome).get(0) : null;
    }
    
    public ArrayList<Elfo> buscar(Status status) {
        agruparPorStatus(); 
        return statusArrayElfos.get(status);
    }
    
    public void agruparPorStatus() {
        statusArrayElfos.clear();
        for (Map.Entry<String, ArrayList<Elfo>> par: contingente.entrySet()) {
            ArrayList<Elfo> elfos = par.getValue();
            for (Elfo elfo : elfos) {
                Status status = elfo.getStatus();
                ArrayList<Elfo> elfoDoStatus = statusArrayElfos.get(status);
                boolean aindaNaoAgrupeiPorEsteStatus = elfoDoStatus == null;
                if (aindaNaoAgrupeiPorEsteStatus) {
                    elfoDoStatus = new ArrayList<>();
                    statusArrayElfos.put(status, elfoDoStatus);
                }
                elfoDoStatus.add(elfo);                
            }           
        }
    }
}
