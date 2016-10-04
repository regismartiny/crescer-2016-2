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
        }else {
            this.vida = vida;
        }
        if (vida == 0.0) {
            status = Status.MORTO;
        }
    }
    
    public void atirarFlecha() {
        int qtdFlechas = getFlecha().getQuantidade();
        if (qtdFlechas > 0) {
            getFlecha().setQuantidade(qtdFlechas - 1);
            experiencia+=3;
            setVida(vida - vida*0.05);
        }
    }
    
}
