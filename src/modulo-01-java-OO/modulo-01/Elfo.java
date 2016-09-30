public class Elfo {
    private String nome;
    private int experiencia;
    private Status status;
    private Inventario inventario;

    public Elfo(String n) {
        // Chamando construtor de baixo
        this(n, 42);
    }
    
    public Elfo(String nome, int flechas){
        this.nome = nome;
        Item arco = new Item("Arco", 1);
        Item flecha = new Item("Flechas", flechas >= 0 ? flechas : 42);
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
        return inventario.getLista().get(0);
    }
    
    public Item getFlecha() {
        return inventario.getLista().get(1);
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
        int qtdFlechas = getFlecha().getQuantidade();
        if (qtdFlechas > 0) {
            getFlecha().setQuantidade(qtdFlechas - 1);
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


