import java.util.*;

public class AtaqueIntercalado implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) throws ContingenteDesproporcionalException {
        List lista = new ArrayList<Elfo>();
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
    
    
    private List ordernarListaTiposIntercalados(List lista) {
        List<Object> listaIntercalada = new ArrayList<>();
        for(int i=0; i < lista.size() - 1; i++) {
            Object atual = lista.get(i);
            Object proximo = lista.get(i+1);
            listaIntercalada.add(atual);
            boolean ehDoMesmoTipo = atual.getClass() == proximo.getClass();
            if (ehDoMesmoTipo) {
                for(int j=i+2; j < lista.size(); j++) {
                    Object proximo2 = lista.get(j);
                    boolean aindaEhDoMesmoTipo = proximo.getClass() == proximo2.getClass();
                    if (aindaEhDoMesmoTipo) {
                        continue;
                    }
                    else {
                        lista.set(i+1, proximo2);
                        lista.set(j, proximo);
                        listaIntercalada.add(proximo2);
                    }
                }
            }
            else{
                listaIntercalada.add(proximo);
            }
        }
        return listaIntercalada;
    }
    
}