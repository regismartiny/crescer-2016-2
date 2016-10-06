
public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome) {
        super(nome);
    }
   

    public Item getFlecha() {
        Item flecha = null;
        for (Item i: inventario.getLista()) {
            if ("Flecha de Vidro".equals(i.getDescricao())) {
                flecha = i;
            }
        }
        return flecha;
    }

    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlechas(dwarf, 2);
    }

    public void adicionarItem(Item item) { 
        String descricao = item.getDescricao();
        if ("Espada de aço valiriano".equals(descricao) || "Arco de Vidro".equals(descricao) || "Flecha de Vidro".equals(descricao) ) {
            boolean encontrado = false;
            for (Item i: inventario.getLista()) {
                if (item.getDescricao().equals(i.getDescricao())) {
                    i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                    encontrado = true;
                }
            }
            if(!encontrado) {
                super.adicionarItem(item);
            }
        }

    }
    
     protected void inicializarInventario(int quantFlechas) {
        Item arco = new Item("Arco de Vidro", 1);
        Item flecha = new Item("Flecha de Vidro", quantFlechas >= 0 ? quantFlechas : 42);
        this.adicionarItem(arco);
        this.adicionarItem(flecha);
    }

}
