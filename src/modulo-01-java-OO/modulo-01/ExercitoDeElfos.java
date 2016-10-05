import java.util.ArrayList;

public class ExercitoDeElfos
{
    private ArrayList<Elfo> elfos;
    
    public ExercitoDeElfos() {
        elfos = new ArrayList<>();
    }
    
    public void alistar(Elfo elfo) {
        elfos.add(elfo);
    }
    
    public Elfo buscar(String nome) {
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
    
    public Elfo[] buscar(Status status) {
        ArrayList<Elfo> elfosEncontrados = new ArrayList<>() ;
        for(Elfo e: elfos) {
            if (e.getStatus().equals(status)) {
                elfosEncontrados.add(e);
            }
        }
        return elfosEncontrados.toArray(new Elfo[elfosEncontrados.size()]);
    }
    
    public Elfo[] getElfosArray() {
        return elfos.toArray(new Elfo[elfos.size()]);
    }
}
