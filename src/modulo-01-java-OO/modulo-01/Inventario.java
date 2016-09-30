import java.util.ArrayList;

public class Inventario
{
   private ArrayList<Item> lista;
   
   public Inventario() {
       lista = new ArrayList<>();
   }
    
   public void adicionarItem(Item item) {
       lista.add(item);
   }
   
   public void removerItem(Item item) {
       lista.remove(item);
   }
   
   public boolean temItem(Item item) {
       return lista.contains(item);
   }
   
   public String getDescricoesItens() {
       String print = "";
       for(int i=0; i < lista.size(); i++){
           if (i>0) print += ",";
           print += lista.get(i).getDescricao(); 
       }
       System.out.println(print);
       return print;
   }
}
