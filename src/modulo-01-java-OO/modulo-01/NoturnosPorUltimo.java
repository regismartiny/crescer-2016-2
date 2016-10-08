import java.util.*;

public class NoturnosPorUltimo implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) {
        List<Elfo> elfosNoturnos = new ArrayList<>();
        List<Elfo> elfosVerdes = new ArrayList<>();
        List<Elfo> lista = new ArrayList<>();
        for(Elfo elfo: atacantes) {
            if (Status.VIVO.equals(elfo.getStatus())) {
                if (elfo instanceof ElfoNoturno) {
                    elfosNoturnos.add(elfo);
                } else if (elfo instanceof ElfoVerde) {
                    elfosVerdes.add(elfo);
                }
            }
        }
        lista.addAll(elfosVerdes);
        lista.addAll(elfosNoturnos);
        return lista;
    }
    
    
}
