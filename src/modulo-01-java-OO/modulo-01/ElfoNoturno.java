public class ElfoNoturno extends Elfo
{
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public ElfoNoturno(String nome, int quantFlechas) {
        super(nome, quantFlechas);
    }
    
    private void setVida(double vida) {
        if (vida < 1.0) {
            vida = 0.0;
            status = Status.MORTO;
        }else {
            this.vida = vida;
        }
    }
    
    public void atirarFlecha(Dwarf dwarf) {
       if (status == Status.VIVO && getFlecha().getQuantidade() > 0) {
           super.atirarFlechas(dwarf, 3);
           setVida(vida * 0.95);
        }
    }
    
}
