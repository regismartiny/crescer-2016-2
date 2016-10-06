import java.util.*;

public class ComparadorDePerformance
{
   public void compararPesquisaArrayListHashMap() {
   
       ArrayList<Elfo> arrayListElfos = new ArrayList<>();
       HashMap<String, Elfo> hashElfos = new HashMap<>();
       
       for (int i=0; i < 10000; i++) {
           String nome = "Elfo " + i;
           Elfo elfo = new Elfo(nome);
           arrayListElfos.add(elfo);
           hashElfos.put(nome, elfo);
        }
       
       long m1Inicio = System.currentTimeMillis();
       Elfo elfoArr = pesquisarElfoArr(arrayListElfos, "Elfo 5000");
       long m1Fim = System.currentTimeMillis();
       
       long m2Inicio = System.currentTimeMillis();
       Elfo elfoHash = pequisarElfoHash(hashElfos, "Elfo 5000");
       long m2Fim = System.currentTimeMillis();
       
       System.out.println(String.format("ArrayList: %d", (m1Fim-m1Inicio)/1000));
       System.out.println(String.format("HashMap: %d",(m2Fim-m2Inicio)/1000));
   }
   
   private Elfo pesquisarElfoArr(ArrayList<Elfo> elfos, String nome) {
       for (Elfo elfo: elfos) {
           if (elfo.getNome().equals(nome)) {
               return elfo;
           }
       }
       return null;  
   }
   
   private Elfo pequisarElfoHash(HashMap<String, Elfo> elfos, String nome) {
       return elfos.get(nome);  
   }
}
