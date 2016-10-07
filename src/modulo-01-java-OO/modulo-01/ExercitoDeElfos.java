import java.util.ArrayList;

public class ExercitoDeElfos implements Exercito
{
    private ArrayList<Elfo> elfos;
    
    public ExercitoDeElfos() {
        elfos = new ArrayList<>();
    }
    
    public void alistar(Elfo elfo) throws NaoPodeAlistarException{
        if (elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde) {
            elfos.add(elfo);
        }else {
            throw new NaoPodeAlistarException();
        }
    }
    
    public Elfo buscar(String nome) {
        // Java 8: return elfos.filter(elfo -> nome.equals(elfo.getNome()))[0];
        Elfo elfoBuscado = null;
        for(int i=0; i < elfos.size(); i++) {
            Elfo e = elfos.get(i);
            if (e.getNome().equals(nome)) {
                elfoBuscado = e;
                break;
            }
        }
        return elfoBuscado;
    }
    
    public Elfo[] buscarArray(Status status) {
        ArrayList<Elfo> elfosEncontrados = new ArrayList<>() ;
        for(Elfo e: elfos) {
            if (e.getStatus().equals(status)) {
                elfosEncontrados.add(e);
            }
        }
        return elfosEncontrados.size() > 0 ? elfosEncontrados.toArray(new Elfo[elfosEncontrados.size()]) : null;
    }
    
    public ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> elfosEncontrados = new ArrayList<>() ;
        for(Elfo e: elfos) {
            if (e.getStatus().equals(status)) {
                elfosEncontrados.add(e);
            }
        }
        return elfosEncontrados.size() > 0 ? elfosEncontrados : null;
    }
    
    public Elfo[] getContingente() {
        return elfos.toArray(new Elfo[elfos.size()]);
    }
    
    public void atacar() {
    }
}
