public class Item {
    private String descricao;
    private int quantidade;
    
    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }
    
    public void aumentarUnidades(int unidades) {
        quantidade += unidades;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item)) {
            return false;
        }
        Item i = (Item)o;
        return (this.descricao == i.descricao && this.quantidade == i.quantidade);
    }
}







