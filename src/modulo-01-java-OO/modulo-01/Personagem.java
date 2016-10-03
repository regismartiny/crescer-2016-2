public class Personagem
{
   protected String nome;
   protected int experiencia;
   protected Status status;
   protected Inventario inventario;
   
   public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
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
    
     public void adicionarItem(Item item) {
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        inventario.removerItem(item);
    }
}
