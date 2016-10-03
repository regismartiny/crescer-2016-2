public class Dwarf extends Personagem
{
    private int vida;
    private DataTerceiraEra dataNascimento;
    
    // Java type initializer
    // vai ser replicado para cada construtor
    {
    }
    
    public Dwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.vida = 110;
        this.status = Status.VIVO;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.inventario = new Inventario();
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
            status = Status.MORTO;
        }
    }
    
    
    public void levarFlechada(){
        if(status == Status.VIVO){
            double numero = getNumeroSorte();
            if (numero < 0){
                experiencia += 2;
            }
            else if(numero > 100){
               setVida(vida - 10);
            }
        }
    }
    
    public DataTerceiraEra getDataNascimento() {
        return dataNascimento;
    }
    
    
    public double getNumeroSorte() {
        double value = 101.0;
        boolean ehBissexto = this.getDataNascimento().ehBissexto();
        if(ehBissexto && this.getVida() >= 80 && this.getVida() <= 90){
            value *= -33;
        }
        else if(!ehBissexto && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome))){
            value = (value * 33)%100;
        }
        return value;
    }
    
    
    public boolean tentarSorte() {
        boolean temSorte = getNumeroSorte() == -3333.0;
        if(temSorte){
            inventario.aumentar1000UnidadesDosItens();
            return true;
        }
        return false;
    }
}


