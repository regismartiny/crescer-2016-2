public class IrishDwarf extends Dwarf
{    
    // Java type initializer
    // vai ser replicado para cada construtor
    {
    }
    
    public IrishDwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        this.vida = 110;
        this.status = Status.VIVO;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.inventario = new Inventario();
    }
    
    
    public boolean tentarSorte() {
        boolean temSorte = getNumeroSorte() == -3333.0;
        if(temSorte){
            inventario.aumentar1000VezesASomaUnidadesDosItens();
            return true;
        }
        return false;
    }
}
