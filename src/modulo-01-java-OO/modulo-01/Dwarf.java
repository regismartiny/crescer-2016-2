public class Dwarf
{
    private int vida;

    public Dwarf()
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
        if (getVida() >= 10){
            setVida(getVida() - 10);
        }
        else{
            System.out.println("Dwarf já está morto!");
        }
    }
}


