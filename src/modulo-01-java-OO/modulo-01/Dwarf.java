public class Dwarf
{
    private String nome;
    private int vida;
    private String status;
    private DataTerceiraEra dataNascimento;
    
    // Java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
        status = "VIVO";
    }
    
    public Dwarf() {
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    
    public int getVida() {
        return vida;
    }
    
    private void setVida(int vida) {
        if (vida < 0) {
            vida = 0;
        }else {
            this.vida = vida;
        }
        if (vida == 0) {
            status = "MORTO";
        }
    }
    
    public String getStatus() {
        return status;
    }
    
    
    public void levarFlechada(){
        setVida(getVida() - 10);
    }
}


