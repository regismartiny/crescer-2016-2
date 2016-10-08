import java.util.*;

public class LittleMumu implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) throws ContingenteDesproporcionalException {
        List<Elfo> listaDeAtaque = new ArrayList<>(), listaVivosComFlechas = new ArrayList<>();
        int nElfosValidos = 0;
        //contar elfos validos (vivos e com flechas)
        for(Elfo elfo : atacantes) {
            boolean temFlechas = elfo.getFlecha().getQuantidade() > 0;
            boolean estaVivo = Status.VIVO.equals(elfo.getStatus());
            if (estaVivo && temFlechas) {
                listaVivosComFlechas.add(elfo);
            }
        }
        //adicionar elfos à lista de ataque, considerando limite de 30% de elfos noturnos
        int nElfosNoturnos = 0, maxElfosNoturnos = (int)(listaVivosComFlechas.size() * 0.3);
        for(Elfo elfo : listaVivosComFlechas) {
            if (elfo instanceof ElfoNoturno) {
                if (nElfosNoturnos < maxElfosNoturnos) {
                    listaDeAtaque.add(elfo);
                    nElfosNoturnos++;
                }
            }
            else if(elfo instanceof ElfoVerde) {
                listaDeAtaque.add(elfo);
            }
        }
        ordenarPorQuantidadeFlechasDesc(listaDeAtaque);
        return listaDeAtaque;
    }
    
    private void ordenarPorQuantidadeFlechasDesc(List<Elfo> lista) {
        boolean posicoesSendoTrocadas;
        boolean ascendente = false;
        do {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < lista.size() - 1; j++) {
                Elfo atual = lista.get(j);
                Elfo proximo = lista.get(j + 1);

                boolean precisaTrocar = 
                    ascendente ? atual.getFlecha().getQuantidade() > proximo.getFlecha().getQuantidade() : atual.getFlecha().getQuantidade() < proximo.getFlecha().getQuantidade();

                if (precisaTrocar) {
                    lista.set(j, proximo);
                    lista.set(j + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
    }
   
}
