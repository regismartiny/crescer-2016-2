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
   
   public ArrayList<Item> getLista() {
       return lista;
   }
   
   public Item getItemMaisPopular() {
       Item itemMaisPopular = lista.get(0);
       int maiorQuantidade = 0;
       for(Item i: lista){
           int quant = i.getQuantidade();
           if(quant > maiorQuantidade){
               maiorQuantidade = quant;
               itemMaisPopular = i;
           }
       }
       return itemMaisPopular;
   }
}
