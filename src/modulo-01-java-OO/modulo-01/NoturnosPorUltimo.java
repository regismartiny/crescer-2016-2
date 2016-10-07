import java.util.*;

public class NoturnosPorUltimo implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) {
        ArrayList<Elfo> elfosNoturnos = new ArrayList<>();
        ArrayList<Elfo> elfosVerdes = new ArrayList<>();
        List lista = new ArrayList<Elfo>();
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
