public class Dwarf
{
    private int vida;
    private String status;
    
    // Java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
        status = "VIVO";
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


