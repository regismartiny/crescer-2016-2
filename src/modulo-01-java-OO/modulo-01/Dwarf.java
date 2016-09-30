public class Dwarf
{
    private String nome;
    private int vida;
    private Status status;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    private Inventario inventario;
    
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
    
    public Status getStatus() {
        return status;
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
    
    public String getNome() {
        return nome;
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
    
    public void adicionarItem(Item item) {
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        inventario.removerItem(item);
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
    public boolean tentarSorte() {
        if(getNumeroSorte() == -3333.0){
            for(Item i: inventario.getLista()){
                i.setQuantidade(i.getQuantidade()+1000);
            }
            return true;
        }
        return false;
    }
}


