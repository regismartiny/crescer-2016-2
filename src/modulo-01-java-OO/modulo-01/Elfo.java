public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    private Status status;
    private Inventario inventario;

    public Elfo(String n) {
        // Chamando construtor de baixo
        this(n, 42);
    }
    
    public Elfo(String nome, int flechas){
        this.nome = nome;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", flechas >= 0 ? flechas : 42);
        status = Status.VIVO;
        inventario = new Inventario();
        inventario.adicionarItem(arco);
        inventario.adicionarItem(flecha);
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public Item getArco() {
        return arco;
    }
    
    public Item getFlecha() {
        return flecha;
    }
    
    public int getExperiencia() {
        return experiencia;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public Inventario getInventario() {
        return inventario;
    }

    public void atirarFlecha() {
        int qtdFlechas = flecha.getQuantidade();
        if (qtdFlechas > 0) {
            flecha.setQuantidade(qtdFlechas - 1);
            experiencia++;
        }
    }

    /*public void atirarFlechaRefactory() {
        experiencia++;
        flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
    
    public void atiraFlechaEmDwarf(Dwarf dwarf) {
        atirarFlecha();
        dwarf.levarFlechada();
    }
    
    public String toString() {
        boolean flechaNoSingular = flecha.getQuantidade() == 1;
        boolean expNoSingular = experiencia == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", 
            nome, 
            flecha.getQuantidade(), 
            flechaNoSingular?"flecha":"flechas",
            experiencia,
            expNoSingular?"nível":"níveis");
        
        /*return nome + " possui " + flecha.getQuantidade() + (flecha.getQuantidade()>1?" flechas e ":" flecha e ") + 
            experiencia + (experiencia>1?" níveis ":" nível ") + "  de experiência.";*/
    }
}


