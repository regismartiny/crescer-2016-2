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
   
   public String getDescricoesItens() {
       String resultado = "";
       for(int i=0; i < lista.size(); i++){
           if (i>0) resultado += ",";
           resultado += lista.get(i).getDescricao(); 
       }
       return resultado;
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
