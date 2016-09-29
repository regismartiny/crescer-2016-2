public class Dwarf
{
    private String nome;
    private int vida;
    private String status;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    
    // Java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }
    
    public Dwarf() {
        this(null, new DataTerceiraEra(1,1,1));
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
        if (getNumeroSorte() < 0){
             experiencia += 2;
        }
        //else if(!(getNumeroSorte() >= 0 && getNumeroSorte() <= 100)){
        //}
        else{
            setVida(getVida() - 10);
        }
    }
    
    public DataTerceiraEra getDataNascimento() {
        return dataNascimento;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getNumeroSorte() {
        double value = 101.0;
        boolean ehBissexto = this.getDataNascimento().ehBissexto();
        if(ehBissexto && this.getVida() >= 80 && this.getVida() <= 90){
            value *= -33;
        }
        else if(!ehBissexto && ("Seixas".equals(this.getNome()) || "Meireles".equals(this.getNome()))){
            value = (value * 33)%100;
        }
        return value;
    }
}


