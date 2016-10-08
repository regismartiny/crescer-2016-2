import java.util.*;

public class AtaqueIntercalado implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) throws ContingenteDesproporcionalException {
        List<Elfo> lista = new ArrayList<>();
        int nElfosVerdes = 0, nElfosNoturnos = 0;
        for(Elfo elfo : atacantes) {
            if (Status.VIVO.equals(elfo.getStatus())) {
                if (elfo instanceof ElfoNoturno) {
                    nElfosNoturnos++;
                    lista.add(elfo);
                }else if (elfo instanceof ElfoVerde) {
                    nElfosVerdes++;
                    lista.add(elfo);
                }
            }
        }
        if (nElfosVerdes != nElfosNoturnos) {
            throw new ContingenteDesproporcionalException();
        }
        return ordernarListaTiposIntercalados(lista);
    }
    
    
    private List<Elfo> ordernarListaTiposIntercalados(List<Elfo> lista) {
        List<Elfo> listaIntercalada = new ArrayList<>();
        for(int i=0; i < lista.size() - 1; i++) {
            Elfo atual = lista.get(i);
            Elfo proximo = lista.get(i+1);
            listaIntercalada.add(atual);
            boolean ehDoMesmoTipo = atual.getClass() == proximo.getClass();
            if (ehDoMesmoTipo) {
                for(int j=i+2; j < lista.size(); j++) {
                    Elfo proximo2 = lista.get(j);
                    boolean aindaEhDoMesmoTipo = proximo.getClass() == proximo2.getClass();
                    if (!aindaEhDoMesmoTipo) {
                        lista.set(i+1, proximo2);
                        lista.set(j, proximo);
                        listaIntercalada.add(proximo2);
                    }
                }
            }
        }
        return listaIntercalada;
    }
    
}