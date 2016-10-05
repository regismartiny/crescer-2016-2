public class Elfo extends Personagem{
    protected double vida;
    private static int contador = 0;
    

    public Elfo(String n) {
        // Chamando construtor de baixo
        this(n, 42);
    }
    
    public Elfo(String nome, int quantFlechas){
        super(nome);
        inicializarInventario(quantFlechas);
        vida = 100;
        Elfo.contador++;
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
    
    public static int getContador() {
        return Elfo.contador;
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
    
    protected void inicializarInventario(int quantFlechas) {
        Item arco = new Item("Arco", 1);
        Item flecha = new Item("Flechas", quantFlechas >= 0 ? quantFlechas : 42);
        this.adicionarItem(arco);
        this.adicionarItem(flecha);
    }
}


