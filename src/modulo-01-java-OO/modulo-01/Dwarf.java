public class Dwarf
{
    private int vida;
    
    // Java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }

    
    public int getVida() {
        return vida;
    }
    
    private void setVida(int vida) {
        this.vida = vida;
    }
    
    public void levarFlechada(){
        setVida(getVida() - 10);
    }
}


