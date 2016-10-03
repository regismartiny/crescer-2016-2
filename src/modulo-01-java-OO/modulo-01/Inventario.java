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

    public void ordenarItens() { 
        ordenarItens(TipoOrdenacao.ASCENDENTE); 
    } 
 
    public void ordenarItens(TipoOrdenacao tipoOrdenacao) {
        // Versão mais estável do Bubblesort - Melhor caso O(n), Pior caso O(n^2)
        // homenagem ao do-while: para forçar entrada na lógica
        boolean posicoesSendoTrocadas;
        boolean ascendente = tipoOrdenacao == TipoOrdenacao.ASCENDENTE;
        do {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < this.lista.size() - 1; j++) {
                Item itemAtual = this.lista.get(j);
                Item proximo = this.lista.get(j + 1);

                boolean precisaTrocar = 
                    ascendente ? itemAtual.getQuantidade() > proximo.getQuantidade() : itemAtual.getQuantidade() < proximo.getQuantidade();

                if (precisaTrocar) {
                    this.lista.set(j, proximo);
                    this.lista.set(j + 1, itemAtual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);

    }
}
