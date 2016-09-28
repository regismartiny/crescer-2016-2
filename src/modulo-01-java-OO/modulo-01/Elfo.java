public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;

    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 42);
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public Item getArco(){
        return arco;
    }
    
    public Item getFlecha(){
        return flecha;
    }
    
    public int getExperiencia() {
        return experiencia;
    }

    public void atirarFlecha() {
        int qtdFlechas = flecha.getQuantidade();
        if(qtdFlechas > 0){
            flecha.setQuantidade(qtdFlechas - 1);
            experiencia++;
        }
    }

    /*public void atirarFlechaRefactory() {
        experiencia++;
        flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
    
    public void atiraFlechaEmDwarf(Dwarf dwarf) {
        dwarf.levarFlechada();
    }
}


