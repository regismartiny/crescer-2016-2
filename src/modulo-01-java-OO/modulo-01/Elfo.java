public class Elfo extends Personagem{
    protected double vida;
    

    public Elfo(String n) {
        // Chamando construtor de baixo
        this(n, 42);
    }
    
    public Elfo(String nome, int flechas){
        super(nome);
        Item arco = new Item("Arco", 1);
        Item flecha = new Item("Flechas", flechas >= 0 ? flechas : 42);
        this.adicionarItem(arco);
        this.adicionarItem(flecha);
        vida = 100;
    }
    
    public Item getArco() {
        return inventario.getLista().get(0);
    }
    
    public Item getFlecha() {
        return inventario.getLista().get(1);
    }
    
    public double getVida() {
        return vida;
    }
    
   
    /*public void atirarFlechaRefactory() {
        experiencia++;
        flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
    
    public void atirarFlecha(Dwarf dwarf) {
        atirarFlechas(dwarf, 1);
    }
    
    public void atirarFlechas(Dwarf dwarf, int quantExp) {
        int qtdFlechas = getFlecha().getQuantidade();
        if (qtdFlechas > 0) {
            getFlecha().setQuantidade(qtdFlechas - 1);
            experiencia+=quantExp;
        }
        dwarf.levarFlechada();
    }
    
    public String toString() {
        boolean flechaNoSingular = getFlecha().getQuantidade() == 1;
        boolean expNoSingular = experiencia == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", 
            nome, 
            getFlecha().getQuantidade(), 
            flechaNoSingular?"flecha":"flechas",
            experiencia,
            expNoSingular?"nível":"níveis");
    }
}


