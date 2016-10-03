public class ElfoNoturno extends Elfo
{
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public void atirarFlecha() {
        int qtdFlechas = getFlecha().getQuantidade();
        if (qtdFlechas > 0) {
            getFlecha().setQuantidade(qtdFlechas - 1);
            experiencia+=3;
        }
        vida -= vida*0.05;
    }
    
}
