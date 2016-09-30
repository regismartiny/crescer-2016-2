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
       Item itemMaisPopular = null;
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
   
   public void aumentar1000UnidadesDosItens() {
       for(Item i: lista){
           i.setQuantidade(i.getQuantidade()+1000);
       }
   }
   
   public void ordenarItens() {
       boolean troca = true;
       while(troca) {
           troca = false;
           for(int i=0; i < lista.size() - 1; i++) {
               if (lista.get(i).getQuantidade() > lista.get(i+1).getQuantidade()) {
                   Item tmp = lista.get(i);
                   lista.set(i, lista.get(i+1));
                   lista.set(i+1, tmp);
                   troca = true;
               }
           }
       }
   }
   
   public void ordenarItensDesc() {
       boolean troca = true;
       while(troca) {
           troca = false;
           for(int i=lista.size()-1; i > 0; i--) {
               if (lista.get(i).getQuantidade() > lista.get(i-1).getQuantidade()) {
                   Item tmp = lista.get(i);
                   lista.set(i, lista.get(i-1));
                   lista.set(i-1, tmp);
                   troca = true;
               }
           }
       }
   }
   
   public void aumentar1000VezesASomaUnidadesDosItens() {
       for (Item i: lista) {
           int quant = i.getQuantidade();
           int quantParaSoma = quant < 0? quant * -1: quant;
           int soma = getSoma(quantParaSoma);
           i.setQuantidade(quant + 1000 * soma);
       }
   }
   
   private int getSoma(int num) {
       if (num <= 0) {
            return 0;
        } else {
            return getSoma(num - 1) + num;
        }
   }
   
   public void ordenarItens(TipoOrdenacao ord) {
       if(TipoOrdenacao.ASCENDENTE == ord) {
           ordenarItens();
       }else{
           ordenarItensDesc();
       }
   }
}
